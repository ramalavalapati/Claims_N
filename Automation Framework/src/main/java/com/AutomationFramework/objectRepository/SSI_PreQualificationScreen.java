package com.AutomationFramework.objectRepository;

import com.AutomationFramework.SSI_Locators;

public class SSI_PreQualificationScreen {
	
	public static String[] allWrkInNJ = {"allWrkInNJ", SSI_Locators.XPATH.getName(), "//select[@id='preQualification.allWorkInNj']"};
	public static String[] anyWrkInNJ = {"anyWrkInNJ", SSI_Locators.XPATH.getName(), "//select[@id='preQualification.anyWorkInNj']"};
	
	public static String[] preQualificationContinueBtn = {"preQualificationContinueBtn", SSI_Locators.NAME.getName(), "processContinue"};
	
	public static String[] doNotHavePinAuthentication = {"doNotHavePinAuthentication", SSI_Locators.NAME.getName(), "processPinUnknown"};
}
