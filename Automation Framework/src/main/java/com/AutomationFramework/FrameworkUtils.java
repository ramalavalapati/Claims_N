package com.AutomationFramework;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.IOUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class FrameworkUtils {
	private static String browserName;	
	private static String url;
	private static String testdataPath;
	private static String ssiurl;
	private static String uatURL_Flag;
	
	/**
	 * @return the uatURL_Flag
	 */
	public static String getUatURL_Flag() {
		return uatURL_Flag;
	}

	/**
	 * @param uatURL_Flag the uatURL_Flag to set
	 */
	public static void setUatURL_Flag(String uatURL_Flag) {
		FrameworkUtils.uatURL_Flag = uatURL_Flag;
	}

	/**
	 * @return the url
	 */
	public static String getUrl() {
		return url;
	}
	
	/**
	 * @return the ssi url
	 */
	public static String getSSIUrl() {
		return ssiurl;
	}

	/**
	 * @param url the url to set
	 */
	public static void setUrl(String url) {
		FrameworkUtils.url = url;
	}
	
	/**
	 * @param url the ssiurl to set
	 */
	public static void setSSIUrl(String ssiurl) {
		FrameworkUtils.ssiurl = ssiurl;
	}

	/**
	 * @return the testdataPath
	 */
	public static String getTestdataPath() {
		return testdataPath;
	}

	/**
	 * @param testdataPath the testdataPath to set
	 */
	public static void setTestdataPath(String testdataPath) {
		FrameworkUtils.testdataPath = testdataPath;
	}

	
	private static final String testExecutionTime = setTestExecutionTime();
	
	public static String getBrowserName() {
		return browserName;
	}
	
	public static void setBrowserName(String browserName) {
		FrameworkUtils.browserName = browserName;
	}

	
	public static Properties getProp(String propFilePath) {
		Properties objProperties = new Properties();
		InputStream in = null;

		try {
			in = new FileInputStream(propFilePath);
			objProperties.load(in);
		} catch(IOException ioe) {
			ioe.printStackTrace();
		} finally {
			IOUtils.closeQuietly(in);
		}
		return objProperties;
	}
	
	private static String setTestExecutionTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm");
		return sdf.format(date);
	}
	
	public static String getTestExecutionTime() {
		return testExecutionTime;
	}
	
	public static String getCurrentDateWithTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss-SSSSSS");
		return sdf.format(date);
	}
	
	public static void initializeExtentReport(ExtentReports extentReport, Properties envProp, String suiteName, String reportLogLevel) {
		String extentReportFileName = envProp.getProperty("extentReportFilePath") + suiteName + "_" + testExecutionTime + ".html";
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(extentReportFileName);
		htmlReporter.config().setChartVisibilityOnOpen(false);
		htmlReporter.config().setDocumentTitle(suiteName);
		htmlReporter.config().setReportName(suiteName);
		htmlReporter.config().setLevel(Status.valueOf(reportLogLevel));
		extentReport.attachReporter(htmlReporter);		
	}
	
	
	
	

}
