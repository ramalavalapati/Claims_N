package com.AutomationFramework.objectRepository;

import com.AutomationFramework.Locators;

public class LoginScreen {
	public static String[] userid = {"userid", Locators.NAME.getName(),"mock-LDAP_USER_ID"};
	
	public static String[] UAT_userid = {"userid", Locators.NAME.getName(),"callback_0"};                             //JJB
	public static String[] UAT_password = {"password", Locators.NAME.getName(),"callback_1"};                         //JJB
	public static String[] UAT_submitBtn = {"submitBtn", Locators.XPATH.getName(), "//input[@value='Log in']"};       //JJB
	public static String[] clmsLink = {"clmsLink", Locators.XPATH.getName(), "//a[@href='../claims-web-rcc']"};   //JJB
	public static String[] searchFileAClaimLink(String data) {
		return new String[]{"searchFileAClaimLink", Locators.XPATH.getName(), "//a[normalize-space(text())='"+data+"']"};
	}
	
	public static String[] submitBtn = {"submitBtn", Locators.XPATH.getName(), "//input[@value='Submit']"};
	public static String[] ssnTextBox = {"ssnTextBox", Locators.NAME.getName(), "ssn"};
	public static String[] searchBtn = {"searchBtn", Locators.ID.getName(), "searchButton"};
	
	
	public static String[] questiontoSelect(String questionName, String optionToSelect) {
		return new String[] {"questiontoSelect-questionName", Locators.XPATH.getName(),
				"//label[contains(.,'"+questionName+"')]/ancestor::div[contains(@class,'fieldHeader')]//div/label[contains(text(),'"+optionToSelect+"')]/preceding-sibling::input[1]"};
	}
	
	

}
