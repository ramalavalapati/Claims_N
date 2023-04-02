package com.AutomationFramework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.AutomationFramework.Field;
import com.AutomationFramework.WebFunctions;

public class CertifySubmitPage extends BasePage{
	
	@FindBy(name="_eventId_finalsave")
	private WebElement certifySubmitFinal;
	
	private WebFunctions web;

	public CertifySubmitPage(WebDriver driver, WebFunctions webFunctions) {
		super(driver, webFunctions);
		this.web = webFunctions;
	}
	
	
	private WebElement getQuestionToSelect(String questionName, String optionToSelect) {
		//return driver.findElement(By.xpath("//label[contains(.,'"+questionName+"')]/../following-sibling::div/label[text()='"+optionToSelect+"']/preceding-sibling::input[1]"));
		return driver.findElement(LoginPage.getQuestionLocator(questionName, optionToSelect));
				
	}
	
	//public void dateOfClaim() {
		//web.clickOn(getQuestionToSelect(Field.DateOfClaim.getColumnName(), web.getData(Field.DateOfClaim.getColumnName())));
	//}
	
	
	/******* Certify/Submit*************/
	public void clickOnFinalCertifySubmit() {
		web.verifyElementIsEnabled(certifySubmitFinal, "Certify Submit button is enabled");
		web.clickOn(certifySubmitFinal);
	}

}
