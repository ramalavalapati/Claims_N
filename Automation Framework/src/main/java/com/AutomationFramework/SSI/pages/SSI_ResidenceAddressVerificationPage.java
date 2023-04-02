package com.AutomationFramework.SSI.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.AutomationFramework.ApplicationStaticData;
import com.AutomationFramework.SSI_Field;
import com.AutomationFramework.WebFunctions;
import com.AutomationFramework.objectRepository.SSI_ResidenceAddressVerificationScreen;
import com.AutomationFramework.pages.BasePage;

public class SSI_ResidenceAddressVerificationPage extends BasePage{
	
	private WebFunctions webFunctions;
	
	@FindBy (xpath = "//label[normalize-space(text())='I choose to keep the address as I entered it.']/ancestor::table[@class='editView']/tbody/tr/td[1]/p/label" )
	WebElement ChooseToKeepAddress;
	
	public SSI_ResidenceAddressVerificationPage(WebDriver driver, WebFunctions webFunctions) {
		super(driver, webFunctions);
		this.webFunctions = webFunctions;
	}
	
	public static By getQuestionResidenceAddressPage(String questionName, String optionToSelect) {
		return By.xpath("//label[contains(., '"+questionName+"')]/ancestor::table[@class='editView']/tbody/tr/td[2]/p/label[contains(text(),'"+optionToSelect+"')]");
	}
	
	private WebElement getQuestionToSelectResidenceAddressPage (String questionName, String optionToSelect) {
		return driver.findElement(getQuestionResidenceAddressPage(questionName, optionToSelect));
	}
	
	public void FillResidenceAddressDetails() throws Exception {
		webFunctions.enterText(SSI_ResidenceAddressVerificationScreen.AddressLine1TxtBox, webFunctions.getData(SSI_Field.EnterAddressLine1.getColumnName()));
		webFunctions.enterText(SSI_ResidenceAddressVerificationScreen.AddressCityTxtBox, webFunctions.getData(SSI_Field.EnterCity.getColumnName()));
		webFunctions.selectOptionByText(SSI_ResidenceAddressVerificationScreen.AddressStateDropDown, webFunctions.getData(SSI_Field.EnterState.getColumnName()));
		webFunctions.enterText(SSI_ResidenceAddressVerificationScreen.AddressZipCodeTxtBox, webFunctions.getData(SSI_Field.EnterZipCode.getColumnName()));
		webFunctions.clickOn(SSI_ResidenceAddressVerificationScreen.VerifyBtn);
		
		//Thread.sleep(5000);
		//Actions action = new Actions(driver);
		//action.click(ChooseToKeepAddress).perform();
		
		webFunctions.clickOn(SSI_ResidenceAddressVerificationScreen.ChooseToKeepAddress);
		
		
	}
	
	
	public void ClickOnResidenceAddressContinueBtn() {
		webFunctions.clickOn(SSI_ResidenceAddressVerificationScreen.ResidenceAddressContinuBtn);
	}
	
	public void ClickOnMailingAddYesOrNo() {
		webFunctions.waitTillElementclickable(getQuestionToSelectResidenceAddressPage(SSI_Field.MailingAddDifferentYesOrNo.getColumnName(), webFunctions.getData(SSI_Field.MailingAddDifferentYesOrNo.getColumnName())));
		
		if(webFunctions.getData(SSI_Field.MailingAddDifferentYesOrNo.getColumnName()).equalsIgnoreCase(ApplicationStaticData.YesText)) {
			
			
		}
		
	}
	
	public void ClickOnAddVerificationConContinueBtn() {
		
		webFunctions.clickOn(SSI_ResidenceAddressVerificationScreen.AddverificationConContinueBtn);
	}
	

}
