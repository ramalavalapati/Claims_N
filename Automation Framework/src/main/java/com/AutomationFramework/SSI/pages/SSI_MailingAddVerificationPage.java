package com.AutomationFramework.SSI.pages;

import org.openqa.selenium.WebDriver;

import com.AutomationFramework.SSI_Field;
import com.AutomationFramework.WebFunctions;
import com.AutomationFramework.objectRepository.SSI_MailingAddVerificationScreen;
import com.AutomationFramework.objectRepository.SSI_ResidenceAddressVerificationScreen;
import com.AutomationFramework.pages.BasePage;

public class SSI_MailingAddVerificationPage extends BasePage {
	
	private WebFunctions webFunctions;
	
	public SSI_MailingAddVerificationPage(WebDriver driver, WebFunctions webFunctions) {
		super(driver, webFunctions);
		this.webFunctions = webFunctions;
	}
	
	
	public void EnterMailingAddress() {
		webFunctions.enterText(SSI_MailingAddVerificationScreen.mailingAddressTxtBox, webFunctions.getData(SSI_Field.EnterMailingAddLine1.getColumnName()));
		webFunctions.enterText(SSI_MailingAddVerificationScreen.mailingAddressCity, webFunctions.getData(SSI_Field.EnterMailingCity.getColumnName()));
		webFunctions.selectOptionByText(SSI_MailingAddVerificationScreen.mailingAddressState, webFunctions.getData(SSI_Field.SelectMailingState.getColumnName()));
		webFunctions.enterText(SSI_MailingAddVerificationScreen.mailingAddressZipCode, webFunctions.getData(SSI_Field.EnterMailingZipCode.getColumnName()));
		
		webFunctions.clickOn(SSI_MailingAddVerificationScreen.mailingAddressVerifyBtn);
		
		//webFunctions.clickOn(SSI_MailingAddVerificationScreen.);
		
	}
	
	public void ClickOnMailingAddContinueBtn() {
		webFunctions.clickOn(SSI_MailingAddVerificationScreen.mailingAddContinueBtn);
	}

}
