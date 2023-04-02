package com.AutomationFramework.objectRepository;

import com.AutomationFramework.SSI_Locators;

public class SSI_ResidenceAddressVerificationScreen {
	
	public static String[] AddressLine1TxtBox = {"AddressLine1TxtBox", SSI_Locators.NAME.getName(), "enteredAddress.streetLine1"};
	public static String[] AddressCityTxtBox = {"AddressCityTxtBox", SSI_Locators.NAME.getName(), "enteredAddress.city"};
    public static String[] AddressStateDropDown = {"AddressStateDropDown", SSI_Locators.ID.getName(), "enteredAddress.state"};
    public static String[] AddressZipCodeTxtBox = {"AddressZipCodeTxtBox", SSI_Locators.NAME.getName(), "enteredAddress.zip"};
    public static String[] VerifyBtn = {"VerifyBtn", SSI_Locators.NAME.getName(), "processAddressVerification"};
    public static String[] ChooseToKeepAddress = {"ChooseToKeepAddress", SSI_Locators.XPATH.getName(),
    		"//label[normalize-space(text())='I choose to keep the address as I entered it.']/ancestor::table[@class='editView']/tbody/tr/td[2]/label"};
    
    public static String[] ResidenceAddressContinuBtn = {"ResidenceAddressContinuBtn", SSI_Locators.NAME.getName(), "processSaveAndContinue"};
    
    public static String[] AddverificationConContinueBtn = {"AddverificationConContinueBtn", SSI_Locators.NAME.getName(), "processSaveAndContinue"};

}
