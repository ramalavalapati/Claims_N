package com.AutomationFramework.objectRepository;

import com.AutomationFramework.SSI_Locators;

public class SSI_MailingAddVerificationScreen {
	
	public static String[] mailingAddressTxtBox = {"mailingAddressTxtBox", SSI_Locators.NAME.getName(), "enteredAddress.streetLine1"};
	public static String[] mailingAddressCity = {"mailingAddressCity", SSI_Locators.NAME.getName(), "enteredAddress.city"};
	public static String[] mailingAddressState = {"mailingAddressState", SSI_Locators.NAME.getName(), "enteredAddress.state"};
	public static String[] mailingAddressZipCode = {"mailingAddressZipCode", SSI_Locators.NAME.getName(), "enteredAddress.zip"};
	
	public static String[] mailingAddressVerifyBtn = {"mailingAddressVerifyBtn", SSI_Locators.NAME.getName(), "processAddressVerification"};
	
	public static String[] mailingAddChooseToKeepRadioBtn = {"mailingAddChooseToKeepRadioBtn", SSI_Locators.XPATH.getName(),
			"//label[normalize-space(text())='I choose to keep the address as I entered it.']/ancestor::table[@class = 'editView']/tbody/tr/td[1]/p/label"};
	
	public static String[] mailingAddContinueBtn = {"mailingAddContinueBtn", SSI_Locators.NAME.getName(), "processSaveAndContinue"};
	
	

}
