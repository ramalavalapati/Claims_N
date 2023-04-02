package com.AutomationFramework.SSI.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.AutomationFramework.ApplicationStaticData;
import com.AutomationFramework.BaseTest;
import com.AutomationFramework.Field;
import com.AutomationFramework.FrameworkUtils;
import com.AutomationFramework.WebFunctions;
import com.AutomationFramework.objectRepository.SSI_SignInScreen;
import com.AutomationFramework.pages.BasePage;

public class SSI_LoginPage extends BasePage{
	
	//@FindBy(name="email")
	@FindBy(id="idToken1")
	private WebElement SSI_usernameTxtBox;
	
	@FindBy(name="idToken2")
	private WebElement SSI_passwordTxtBox;
	
	
	private WebFunctions webFunctions;
	
	
	public SSI_LoginPage(WebDriver driver, WebFunctions webFunctions) {
		super(driver, webFunctions);
		this.webFunctions = webFunctions;
	}
	
	
	private void navigateToAPP(String URL) {
		webFunctions.navigateTo(URL);
	}
	
	public void loginToApp() {
		navigateToAPP(FrameworkUtils.getSSIUrl());
		webFunctions.enterText(SSI_SignInScreen.enterEmailAdd, webFunctions.getData(Field.SSI_USERNAME.getColumnName()));
		webFunctions.enterText(SSI_SignInScreen.password, webFunctions.getData(Field.SSI_PASSWORD.getColumnName()));
		webFunctions.clickOn(SSI_SignInScreen.loginBtn);
		
	}
	
	
	public void clickOnFileANewClaimLink() {
		webFunctions.clickOn(SSI_SignInScreen.fileANewClaimLink);
	}
	
	
	
	public void clikcOnFileAClaimBtn() {
		
		webFunctions.switchToWindowByIndex(2);
		webFunctions.getTitle();
		System.out.println(webFunctions.getTitle());

		webFunctions.clickOn(SSI_SignInScreen.fileAClaimBtn);
		
		webFunctions.clickOn(SSI_SignInScreen.fileAClaimHomeContinueBtn);
		
		

	}
	
	public void clickOnFileAClaimHomeContinueBtn() {
		webFunctions.clickOn(SSI_SignInScreen.fileAClaimBtnTipsForFiling);
	}
	
	
	
	public void verifySSN() {
		webFunctions.getData("SSNID");
	}
	
	
	

}
