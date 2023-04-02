package com.AutomationFramework;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

public class WebFunctions {
	
	private WebDriver driver;
	private BaseTest baseTest;
	private String charsNum = "123456789";
	private WebDriverWait waiter;
	public String screenshotPath;
	private int loggerCount =1;

	
	public WebFunctions(BaseTest baseTest) {
		driver = baseTest.getDriver();
		this.baseTest = baseTest;
	}

	public WebDriver getDriver() {
		return driver;
	}
	
	
	
	private WebElement getElement(String[] LocatorDetails) {
		WebElement targetElement = null;
		String locatorType = getLocatorType(LocatorDetails);
		String locatorValue = getLocatorValue(LocatorDetails);

		try{
			targetElement = driver.findElement(getBy(locatorType,locatorValue));
		}catch(InvalidSelectorException e){
			log(Status.FATAL,"FATAL --Locator not valid or syntax wrong. Object ::\""+LocatorDetails[0]+"\" . "+"Exception is- \""+e.getMessage()+"\"");			
		}catch(NoSuchElementException e){
			log(Status.FAIL,"Element is not availabe on the page. Object:: \""+LocatorDetails[0]+"\". "+"Exception is- \""+e.getMessage()+"\"");
			takeScreenshot();
		}catch(UnreachableBrowserException e){
			log(Status.FAIL,"Browser is not reachable.Object:: \""+LocatorDetails[0]+"\". "+"Exception is-\""+e.getMessage()+"\"");
			takeScreenshot();
		}catch(WebDriverException e){
			log(Status.FAIL,"Driver Exception.object :: \""+LocatorDetails[0]+"\". "+e.getMessage()+"\"");
			takeScreenshot();
		}catch(Exception e) {
			log(Status.FAIL, "Failed due to Exception-\""+e.getMessage()+"\"");
			takeScreenshot();
			//e.printStackTrace();
		}
		return targetElement;
	}
	
	private By getBy(String locatorType, String locatorValue){
		By by= null;
		switch (locatorType.toUpperCase()) {
		case "ID":
			by = By.id(locatorValue);
			break;			
		case "NAME":
			by = By.name(locatorValue);
			break;			
		case "XPATH":
			by = By.xpath(locatorValue);
			break;			
		case "CSSSELECTOR":
			by = By.cssSelector(locatorValue);
			break;			
		case "CLASSNAME":
			by = By.className(locatorValue);
			break;
		case "TAGNAME":
			by = By.tagName(locatorValue);
			break;
		case "LINKTEXT":
			by = By.linkText(locatorValue);
			break;
		case "PARTIALLINKTEXT":
			by = By.partialLinkText(locatorValue);
			break;
		default:
			log(Status.FATAL,"FATAL --LocatorType not Found. Entered locatorType is ::\""+locatorType+"\" .");
		}
		return by;
		
	}
	
	
	private String getLocatorName(String[] LocatorDetails) {
		String locatorReference = "";
		try {
			locatorReference = LocatorDetails[0];
		}catch(Exception e) {
			log(Status.FATAL, "Unable to retrieve locatorReference for the Object \""+LocatorDetails.toString()+"\". "+"Exception is-\""+e.getMessage()+"\"");
		}
		return locatorReference;
	}

	private String getLocatorType(String[] LocatorDetails) {
		String locatorType = "";
		try {
			locatorType = LocatorDetails[1];
		}catch(Exception e) {
			log(Status.FATAL, "Unable to retrieve locatorType for the Object \""+getLocatorName(LocatorDetails)+"\". "+"Exception is-\""+e.getMessage()+"\"");
		}
		return locatorType;
	}
	
	private String getLocatorValue(String[] LocatorDetails) {
		String locatorValue = "";
		try {
			locatorValue = LocatorDetails[2];
		}catch(Exception e) {
			log(Status.FATAL, "Unable to retrieve locatorValue for the Object \""+getLocatorName(LocatorDetails)+"\". " +"Exception is- \""+e.getMessage()+"\"");
		}
		return locatorValue;
	}

	
	private WebDriverWait getWaiter() {		 
		if(waiter==null) {
			waiter= new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(BaseTest.getEnvProp("EXTENDWAIT"))));
		}
		return waiter;
	}
	
	public void navigateTo(String url) {
		getDriver().get(url);		
	}
	

	public void enterText(WebElement element, String testdata) {
		try {
			element.sendKeys(testdata);
			log(Status.PASS, "Enter Text-\""+testdata+"\"");
		}catch (Exception e) {			
			log(Status.FAIL, "Failed to enter  Text-\""+testdata+"\"");
			takeScreenshot();
		}	
		
	}
	
	public void enterText(String[] locatorName, String testdata) {
		WebElement targetElement = getElement(locatorName);
		
		try {
			targetElement.sendKeys(testdata);
			log(Status.PASS, "Enter \""+testdata+"\" into object \""+getLocatorName(locatorName)+"\".");
		}catch (Exception e) {			
			log(Status.FAIL, "Failed to enter  Text-\""+testdata+"\" into object \""+getLocatorName(locatorName)+"\"");
			takeScreenshot();
		}	
		
	}
	
	
	public void enterUsingJS(String id, String testdata) {
		JavascriptExecutor jsrunner= (JavascriptExecutor)driver;
		jsrunner.executeScript("document.getElementById('"+id+"').value='"+testdata+"'");		
	}
	
	
	public void clickOn(WebElement element) {
		try {
			element.click();
			log(Status.PASS, "Click on element -");
		}catch (Exception e) {
			log(Status.FAIL, "Unable to click on element -");
		}	
	}
	
	public void clickOn(String [] locatorName) {
		WebElement targetElement = getElement(locatorName);
		try {
			targetElement.click();
			log(Status.PASS, "Able to click on Element \" "+getLocatorName(locatorName)+"\".");
		} catch (Exception e) {
			log(Status.FAIL, "Not able to click on Element \" "+getLocatorName(locatorName)+"\"");
			takeScreenshot();
		}
	}
	
	public void waitTillElementclickable(WebElement element) {
		//WebElement targetElement = getElement(locatorName);
		getWaiter().until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitTillElementclickable(String [] locatorName) {
		WebElement targetElement = getElement(locatorName);
		try {
			getWaiter().until(ExpectedConditions.elementToBeClickable(targetElement));
			log(Status.PASS, "Element is Clickable \" "+getLocatorName(locatorName)+"\".");
		} catch (Exception e) {
			log(Status.FAIL, "Element is not Clickable \" "+getLocatorName(locatorName)+"\"");
			takeScreenshot();
		}
	}
	
	
	public void waitTillElementVisible(WebElement element) {
		getWaiter().until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitTillElementVisible(String [] locatorName) {
		getWaiter().until(ExpectedConditions.visibilityOfElementLocated(getBy(locatorName[1],locatorName[2])));
	}

	
	public void selectOptionByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	public void selectOptionByValue(String [] locatorName, String value) {
		WebElement targetElement = getElement(locatorName);
				
		try {
			Select select = new Select(targetElement);
			select.selectByValue(value);
			log(Status.PASS, "Able To select value drop value \" "+getLocatorName(locatorName)+"\".");
		} catch (Exception e) {
			log(Status.FAIL, "Not able to select value drop value \" "+getLocatorName(locatorName)+"\"");
			takeScreenshot();
		}
	}
	
	public void selectOptionByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	public void selectOptionByIndex(String[] locatorName, int index) {
		WebElement targetElement = getElement(locatorName);
		
		try {
			Select select = new Select(targetElement);
			select.selectByIndex(index);
			log(Status.PASS, "Able To Select from dropdown by index\" "+getLocatorName(locatorName)+"\".");
		} catch (Exception e) {
			log(Status.FAIL, "Not Able To select from dropdown by index\" "+getLocatorName(locatorName)+"\".");
		} 
		
	}
	
	public void selectOptionByText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	public void selectOptionByText(String[] locatorName, String text) {
		WebElement targetElement = getElement(locatorName);
		
		try {
			Select select = new Select(targetElement);
			select.selectByVisibleText(text);
			log(Status.PASS, "Able To select text from dropdown text\" "+getLocatorName(locatorName)+"\".");
		} catch (Exception e) {
			log(Status.FAIL, "Not able to select text from dropdown text\""+getLocatorName(locatorName)+"\".");
			takeScreenshot();
		}
	}
	
	
	public String getText(WebElement element) {
		return element.getText();
	}
	
	public void verifyElementPresent(WebElement element, String message) {
		Assert.assertTrue(element.isDisplayed(), message);
		Assert.assertTrue(element.isEnabled(), message);
	}
	
	
	public void verifyElementIsEnabled(WebElement element, String message) {
		Assert.assertTrue(element.isEnabled(), message);
	}
	
	public void verifyElementPresent(String[] locator, String message) {
		Assert.assertTrue(getElement(locator).isDisplayed(), message);
		Assert.assertTrue(getElement(locator).isEnabled(), message);
	}
	
	
	
	public void verifyEquals( String actual, String expected, String message) {
		Assert.assertEquals(actual, expected, message);
	}
	
	public boolean verifyElementAvailableAndDisplayed(List<WebElement> element) {
		boolean flag = false;
		loadWaitersInAbsenceCase();
		if(element.size()>0 && element.get(0).isDisplayed()) {
			flag =  true;
		}
		baseTest.loadWaiters();
		return flag;
	}
	
	public void loadWaitersInAbsenceCase() {
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(BaseTest.getEnvProp("ABSENCEWAIT"))));		
	}
	
	
	
	public void takeScreenshot(String outputFileName) {
		File file = new File(screenshotPath + FrameworkUtils.getTestExecutionTime()+"/");		
		if(!file.exists()) {
			file.mkdirs();
		}
		String nameOfOutputFileWithExtension = screenshotPath + FrameworkUtils.getTestExecutionTime()+"/"+outputFileName + "." + "png";
	
		File destination = new File(nameOfOutputFileWithExtension);
		try {
			File screenshotSource =(( TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotSource, destination);
	    	log(Status.INFO, "Saved Screenshot path - " + nameOfOutputFileWithExtension +"<a href='"+nameOfOutputFileWithExtension.replaceAll("test-report/", "")+"'target=\"_blank\">-Click here to view the screenshot</a>");
	    	
    	 			
		} catch (IOException e) {
			log(Status.ERROR, "Unable to save Screenshot - " + nameOfOutputFileWithExtension);
		} 	
	}
	
	public void takeScreenshot() {
		baseTest.addScreenshotToLog();
	}
	
	public void switchToWindowByIndex(int windowNum) {
		int count = 1;
		Set<String> AllWindows = driver.getWindowHandles();

		for (String winHandle : AllWindows) {
			driver.switchTo().window(winHandle);

			if(count==windowNum) {
				break;
			}
			count ++;

		}

	}
	
	
	public String getTitle () {
		return driver.getTitle();
	}
	

	
	
	/*******************************Loggers***************************************************************************************/
	
	public void setReportFilePaths(String extentReportFilePath, String screenshotPath) {
		this.screenshotPath = screenshotPath;
	}
	
	
	public void createLogger(String mainLogName) {
		baseTest.createLogger(mainLogName);
	}
	
	public void log(Status status, String text,boolean validationFlag) {
		String message;
		if(status!=Status.INFO) {
			message=text.replaceAll("\\<.*?\\>", "");
		}else {
			message =text;
		}
		if(baseTest.getChildLogger() == null) {
			createLogger(this.getClass().getSimpleName());
		}
		
		if(validationFlag && status==Status.PASS) {
			baseTest.getChildLogger().log(status,"<font color=orange>" +loggerCount+". "+message+ "</font><br/>");
		}else {
			customizeLogColor(status, message);
		}			
		
		loggerCount++;
	}
	
	
	public void log(Status status, String text) {
		String message;
		if(status!=Status.INFO) {
			message=text.replaceAll("\\<.*?\\>", "");
		}else {
			message =text;
		}
		if(baseTest.getChildLogger() == null) {
			createLogger("Main Logger Not Found. Created Default Logger");
		}
		
		customizeLogColor(status, message);
		
		loggerCount++;
	}
	

	private void customizeLogColor(Status status, String message) {
		switch (status) {
			case PASS:
				baseTest.getChildLogger().log(status,"<font color=green>" +loggerCount+". "+message+ "</font><br/>");
				break;
			case FAIL:
				baseTest.getChildLogger().log(status,"<font color=red>" +loggerCount+". "+message+ "</font><br/>");
				break;
			case WARNING:
				baseTest.getChildLogger().log(status,"<font color=orange>" +loggerCount+". "+message+ "</font><br/>");
				break;
			case INFO:
				baseTest.getChildLogger().log(status,"<font color=blue>" +loggerCount+". "+message+ "</font><br/>");
				break;
			case FATAL:
				baseTest.getChildLogger().log(status,"<font color=brown>" +loggerCount+". "+message+ "</font><br/>");
				break;
			case SKIP:
				baseTest.getChildLogger().log(status,"<font color=yellow>" +loggerCount+". "+message+ "</font><br/>");
				break;
			default:
				baseTest.getChildLogger().log(status, loggerCount+". "+message);
				break;
		}
	}
	
	
	/*********************** Data Methods *****************************************************************/
	
	
	
	public String getData(String testDataName) {
		if(baseTest.getTestData().containsKey(testDataName)) {
			return (String) baseTest.getTestData().get(testDataName);
		}else {
			System.err.println("TestData not Found with Name -"+testDataName);
			return "TestDataNotFound";
		}		
	}
	
	
	public void storeData(String testDataName, String value) {
		baseTest.getTestData().put(testDataName, value);
	}
	
	
	public String generateRndmNumber(int len) {
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			sb.append(charsNum.charAt(rnd.nextInt(charsNum.length())));
		}
		return sb.toString();
	}

	public int getIntegerValue(String number) {
		return Integer.parseInt(number);
	}
	
}
