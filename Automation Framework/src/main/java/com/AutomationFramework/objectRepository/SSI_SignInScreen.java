package com.AutomationFramework.objectRepository;

import com.AutomationFramework.Locators;
import com.AutomationFramework.SSI_Locators;

public class SSI_SignInScreen {
	
	public static String[] enterEmailAdd = {"enterEmailAdd", SSI_Locators.ID.getName(), "idToken1"};
	public static String[] password = {"password", SSI_Locators.ID.getName(), "idToken2"};
	public static String[] loginBtn = {"loginBtn", SSI_Locators.ID.getName(), "loginButton_0"};
	public static String[] fileANewClaimLink = {"fileANewClaimLink", SSI_Locators.LINKTEXT.getName(), "File a New Claim OR Open an Existing Claim"};
	public static String[] fileAClaimBtn = {"fileAClaimBtn", SSI_Locators.XPATH.getName(), "//input[@value='File A Claim']"};
	public static String[] fileAClaimHomeContinueBtn = {"fileAClaimHomeContinueBtn", SSI_Locators.XPATH.getName(), "//input[@value='   Continue   ']"};
	public static String[] fileAClaimBtnTipsForFiling = {"fileAClaimBtnTipsForFiling", SSI_Locators.XPATH.getName(), "//input[@value='File a Claim']"};
	
	
	
	
	public static String[] questiontoSelect(String questionName, String optionToSelect) {
		return new String[] {"questiontoSelect-questionName", Locators.XPATH.getName(),
				//"//label[contains(., '"+questionName+"')]/ancestor::table[@class='editView']/tbody/tr/td[3]/p/label[contains(text(),'"+optionToSelect+"')]/preceding-sibling::input[1]"};
				"//label[contains(., '"+questionName+"')]/ancestor::table[@class='editView']/tbody/tr/td[3]/p/label[contains(text(),'"+optionToSelect+"')]"};
	}

}
