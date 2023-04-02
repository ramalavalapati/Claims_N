package com.AutomationFramework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AutomationFramework.WebFunctions;


public class BasePage {
	
	
	@FindBy(id="saveThisEmployerBtnValidation")          //(id="saveThisEmployerBtnValidation") name="_eventId_save" //saveThisEmployerBtnValidation
	private WebElement empSaveContinueButton;
	
	private WebFunctions web;
	protected WebDriver driver;
	public BasePage(WebDriver driver, WebFunctions webFunctions) {
		PageFactory.initElements(driver, this);	
		web = webFunctions;
		this.driver = driver;
	}
	
	protected WebDriver getDriver() {
		return driver;
	}
	

	/******* Save this Employer *************/
	public void clickOnSavethisEmp() {
		web.clickOn(empSaveContinueButton);
	}
	
	
	
	
	
	
	
	//this class can be used to maintain few base functionality related methods which can be used across all page classes
	//EX:login, logout
	
	

}