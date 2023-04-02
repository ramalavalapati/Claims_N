package com.AutomationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//comment the above line and uncomment below line to use Chrome
import org.openqa.selenium.chrome.ChromeDriver;

public class Basic_TestScript1 {
	
	public static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
				System.setProperty("webdriver.chrome.driver","C:\\Personal\\Software\\Drivers\\chromedriver.exe");
				//WebDriver driver = new ChromeDriver();
				driver = new ChromeDriver();
		    	
		        String baseUrl = "http://claims-dev3:8180/launch.html";
		        
		        driver.get(baseUrl);
		        
		        driver.findElement(By.name("mock-LDAP_USER_ID")).sendKeys("LAOALAV");;
		        
		        //driver.findElement(null)
		        
		        
		        
		        

	}

}
