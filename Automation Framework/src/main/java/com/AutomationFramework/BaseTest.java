package com.AutomationFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest {
	private static Properties envProp = FrameworkUtils.getProp("./src/test/resources/config/configurations.properties");
	private static ExtentReports report;
	private ExtentTest logger;
	private ExtentTest childLogger;
	private WebDriver driver;
	static Workbook workbook;
	private WebFunctions webFunctions;
	private static int testdataFileReaderCount=0;
	private Map<Object, Object> testcaseData;
	private static int testcaseCount =0;
	private static int screenshotCount=1;
	
	@DataProvider(name = "testdata",parallel=true) 
    public Object[][] loadTestData(ITestContext context){
		configureTestData(context);	
    	return  DataReader.fetchTCData(this.getClass().getSimpleName());
    }
	
	@Parameters({"reportLogLevel"})
	@BeforeSuite(alwaysRun = true)
	public void beforeSuite(ITestContext context, @Optional("INFO") String reportLogLevel) {
		setEnvironmentParameters(context);	
		report = new ExtentReports();
		FrameworkUtils.initializeExtentReport(report, envProp, context.getSuite().getName(), reportLogLevel);
		
	}

	@BeforeClass(alwaysRun = true)
	public void openBrowser() {		
		try {		
			loadBrowser();
			webFunctions = new WebFunctions(this);
			maximizeBrowser();
			loadWaiters();
			webFunctions.setReportFilePaths(getEnvProp("extentReportFilePath"), getEnvProp("screenshotPath"));
		}catch(Exception e) {
			createTest(this.getClass().getSimpleName());
			getLogger().log(Status.FATAL, "Error in Launching Browser");
			getLogger().log(Status.FATAL, "WebDriver Session not created.");
			getLogger().fail(e);
			e.printStackTrace();
		}		
	}
	
	
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(Method method) {
		try {
			createTest(this.getClass().getSimpleName());
			createLogger(method.getName());
		}catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	
	@AfterMethod(alwaysRun = true)
	public synchronized void analyzeAndSaveResult(ITestResult result) {
		String tcname = this.getClass().getSimpleName();
		try {						
			logStatusOfTC(result, tcname);
			addTestDataToExcel(this.getClass().getSimpleName());
		}catch (Exception e) {
			e.printStackTrace();
			getLogger().log(Status.INFO, "Test Result Analysis Failed.");
			getLogger().fail(e);
		}
	}
	

	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		try {
			driver.close();
			getChildLogger().info("Browser Closed Successfully.");
		}catch(Exception e) {
			getLogger().log(Status.INFO, "Failed to close Browser");
			getLogger().fail(e);
			e.printStackTrace();
		}finally {
			driver.quit();			
		}
	}
	
	


	@AfterSuite(alwaysRun = true)
	public void afterSuite() throws IOException {
		try {
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			saveHTMLReports();
		}
	}
	
	private void saveHTMLReports() throws IOException {
		report.flush();
	}
	
	private void setEnvironmentParameters(ITestContext context) {
		FrameworkUtils.setBrowserName(context.getCurrentXmlTest().getAllParameters().get("BrowserName"));
		FrameworkUtils.setUrl(context.getCurrentXmlTest().getAllParameters().get("URL"));
		FrameworkUtils.setTestdataPath(context.getCurrentXmlTest().getAllParameters().get("TDFilePath"));
		FrameworkUtils.setSSIUrl(context.getCurrentXmlTest().getAllParameters().get("SSIURL"));
		FrameworkUtils.setUatURL_Flag(context.getCurrentXmlTest().getAllParameters().get("UATURL_FLAG"));
	}
	
	private synchronized void createTest(String testcaseName) {		
		logger = report.createTest(++testcaseCount+". "+testcaseName+"("+webFunctions.getData("TestcaseID")+")");			
	}
	
	private ExtentTest getLogger() {
		return logger;
	}
	
	public synchronized String addScreenshotToLog() {
		
		String screenshotName = ++screenshotCount + "_" + FrameworkUtils.getCurrentDateWithTime();
		try {  
			webFunctions.takeScreenshot(screenshotName);
		} catch (Exception e) {
			getChildLogger().log(Status.WARNING, "Unable to add screenshot " + screenshotName);
		}
		return webFunctions.screenshotPath + FrameworkUtils.getTestExecutionTime()+"/"+screenshotName + "." + "png";		
	}
	
	
	
	
	private void createAnalyzerLogger(){
		if(childLogger == null) {
			createLogger("Analyzer");
		}	
	}


	private void logStatusOfTC(ITestResult result, String tcname) {
		switch (result.getStatus()) {
			case ITestResult.SUCCESS:
				createAnalyzerLogger();
				testcaseData.put("TestExecutionStatus", "PASSED");
				addScreenshotToLog();
				break;
				
			case ITestResult.FAILURE:
				testcaseData.put("TestExecutionStatus", "FAILED");
				createAnalyzerLogger();
				getChildLogger().log(Status.FAIL, childLogger.getModel().getName()+"-"+result.getThrowable().toString());
				webFunctions.log(Status.FAIL, childLogger.getModel().getName()+"-"+result.getThrowable().toString());
				addScreenshotToLog();
				break;
			case ITestResult.SKIP:
				testcaseData.put("TestExecutionStatus", "SKIPPED");
				createLogger(result.getMethod().getMethodName());
				getChildLogger().log(Status.SKIP, "Skip - Test skipped its execution for '" + childLogger.getModel().getName() + "'");
				addScreenshotToLog();
				break;
			default:
				testcaseData.put("TestExecutionStatus", "No Status to Log . Please check");
				createAnalyzerLogger();
				getChildLogger().log(Status.WARNING, "Test not able to complete its execution successfully for '" + childLogger.getModel().getName() + "'");
				addScreenshotToLog();
				break;
		}
	}
	
	

	
	private void configureTestData(ITestContext context) {
		
		if(testdataFileReaderCount == 0) {
			if(context.getCurrentXmlTest().getAllParameters().get("TDFilePath") == null || 
					context.getCurrentXmlTest().getAllParameters().get("TDFilePath").contains("${")) {
				readTestDataFileSheet(getEnvProp("TDFilePath"));
			}else {
				FrameworkUtils.setTestdataPath(context.getCurrentXmlTest().getAllParameters().get("TDFilePath"));
				readTestDataFileSheet(FrameworkUtils.getTestdataPath());
			}
			
			testdataFileReaderCount++;
		}
	}
	
	private void readTestDataFileSheet(String inputExcelDataPath){
		try {
			FileInputStream excelFile = new FileInputStream(new File(inputExcelDataPath).getAbsolutePath());
			workbook = new XSSFWorkbook(excelFile);
			excelFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
	

	private void addTestDataToExcel(String tcname) {
		try {
			String outExcelFilename = getEnvProp("OutputTDPath") +FrameworkUtils.getTestExecutionTime();
			File file = new File(outExcelFilename);
			if(!file.exists()) {
				file.mkdirs();
			}
			String outExcelFile = outExcelFilename+"/"+tcname+"_"+FrameworkUtils.getCurrentDateWithTime()+".xlsx";	
			DataReader.createOutputExcel(testcaseData, outExcelFile,tcname);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	protected WebFunctions getWebInstance() {
		return webFunctions;
	}
	
	public static String getEnvProp(String propertyName) {
		return envProp.getProperty(propertyName);
	}
	
	protected void setTestData(Map<Object, Object> testdataSet) {
		testcaseData = testdataSet;
	}
	
	public Map<Object, Object> getTestData() {
		return testcaseData;
	}
	
	private void setDefaultSettingsIfNotProvided() {
		if(FrameworkUtils.getBrowserName()==null || FrameworkUtils.getBrowserName().contains("${")) {
			FrameworkUtils.setBrowserName(getEnvProp("BrowserName"));
		}
		
		if(FrameworkUtils.getUrl()==null || FrameworkUtils.getUrl().contains("${")) {
			FrameworkUtils.setUrl(getEnvProp(Field.URL.getColumnName()));
		}
		
		if(FrameworkUtils.getSSIUrl()==null || FrameworkUtils.getSSIUrl().contains("${")) {
			FrameworkUtils.setSSIUrl(getEnvProp("SSIURL"));
		}
		
		if(FrameworkUtils.getUatURL_Flag()==null || FrameworkUtils.getUatURL_Flag().contains("${")) {
			FrameworkUtils.setUatURL_Flag(getEnvProp("UATURL_FLAG")); //UATURL_FLAG
		}
	}
	
	private void loadBrowser() {
		setDefaultSettingsIfNotProvided();
		
		switch (FrameworkUtils.getBrowserName().trim().toUpperCase()) {
			case BrowserConstants.CHROME:
				openChromeBrowser();
				break;
			case BrowserConstants.IE:
				openIEBrowser();
				break;				
			case BrowserConstants.FIREFOX:
				openFirefoxBrowser();
				break;					
			case BrowserConstants.EDGE:
				openEdgeBrowser();
				break;
			default:
				openChromeBrowser();
				break;
		}	
				
	}
	
	
	
	
	private void openEdgeBrowser() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver(getEdgeOptions());
		
	}

	private void openFirefoxBrowser() {	
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver(getFireFoxOptions());
		
	}	
	
	private void openIEBrowser() {
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver(getIEOptions());	
	}	
	
	private void openChromeBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(getChromeOptions());	
	}
	
	private void maximizeBrowser() {		
		getDriver().manage().window().maximize();
		
	}

	public void loadWaiters() {
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(envProp.getProperty("PAGELOADWAIT"))));
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(envProp.getProperty("DEFAULTWAIT"))));		
	}
	
	
	
	private FirefoxOptions getFireFoxOptions() {	
		
		FirefoxOptions options = new FirefoxOptions();
		options.setCapability("browser", "Firefox");
		options.setCapability("os", "Windows");
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		options.setCapability("excludeSwitches",Collections.singletonList("enable-automation"));   
		options.addArguments("--ignore-certificate-errors");
		options.addArguments("--disable-web-security");
		options.addArguments("--no-proxy-server");
		
		return options;
	}
	
	private InternetExplorerOptions getIEOptions() {

		InternetExplorerOptions options = new InternetExplorerOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		options.setCapability(InternetExplorerDriver.NATIVE_EVENTS, true);
		options.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		options.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS,true);
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		options.setCapability("ignoreProtectedModeSettings", true);
		options.setCapability("disable-popup-blocking", true);
		options.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		options.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, "accept"); 
		options.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
		return options;
	}
	
	private ChromeOptions getChromeOptions() {		
		ChromeOptions options = new ChromeOptions();
		options = (ChromeOptions) getOptions(options);
		return options;
	}

	private EdgeOptions getEdgeOptions() {		
		EdgeOptions options = new EdgeOptions();
		options = (EdgeOptions) getOptions(options);
		return options;
	}
	
	
	@SuppressWarnings("rawtypes")
	private ChromiumOptions getOptions(ChromiumOptions options) {
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation")); 
		options.setCapability("disable-popup-blocking", "true");
		options.addArguments("--ignore-certificate-errors","--disable-web-security","--no-proxy-server");		
		options.setAcceptInsecureCerts(true);
		options.addArguments("--remote-allow-origins=*");
		
		if(getEnvProp("headLessFlag").equalsIgnoreCase("true")) {
			options.addArguments("--headless=new","--disable-gpu","--disable-extensions","--no-sandbox","--disable-dev-shm-usage");
		}
		
		return options;
	}
	
	WebDriver getDriver() {
		return driver;
	}
	
	WebFunctions getWebFunctions() {
		return webFunctions;
	}

	public void createLogger(String mainLogName) {
		childLogger = logger.createNode(mainLogName);		
	}

	public ExtentTest getChildLogger() {
		// TODO Auto-generated method stub
		return childLogger;
	}
}
