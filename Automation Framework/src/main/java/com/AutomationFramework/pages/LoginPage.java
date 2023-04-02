package com.AutomationFramework.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.AutomationFramework.ApplicationStaticData;
import com.AutomationFramework.BaseTest;
import com.AutomationFramework.Field;
import com.AutomationFramework.FrameworkUtils;
import com.AutomationFramework.WebFunctions;
import com.AutomationFramework.objectRepository.LoginScreen;

public class LoginPage extends BasePage{
	
	@FindBy(name="mock-LDAP_USER_ID")
	private WebElement usernameTxtBox;
	
	@FindBy(name="pass")
	private WebElement passwordTxtBox;
	
	
	@FindBy(xpath="//input[@value='Submit']")
	private WebElement submitButton;
	
	@FindBy(name="ssn")
	private WebElement ssnTextBox;
	
	
	@FindBy(id="searchButton")
	private WebElement searchButton;
	
	@FindBy(id="fileClaimButton")
	private WebElement fileClaimButton;
	
	@FindBy(id="_eventId_save")
	private WebElement saveContinueButton;
	
	@FindBy(xpath="//div[@class='table-responsive']")
	//private boolean searchResultsTable;
	private WebElement searchResultsTable;
	
	@FindBy(xpath="//p[contains(text(), 'No results were found with the search criteria entered')]")
	private List<WebElement> noSearchResults;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered displayTable']/tbody/tr[1]/td[1]/a")
	private WebElement searchResultsFirstRecord;
	
	@FindBy(xpath = "//div[@class='modal-dialog']")
	private boolean takeOwnershipPopup;
	
	@FindBy(name ="yes")
	private WebElement OwnershipPopupYesButton;
	
	@FindBy(id="no")
	private WebElement OwnershipPopupNoButton;
	
	private WebFunctions webFunctions;
	
	public LoginPage(WebDriver driver, WebFunctions webFunctions) {
		super(driver, webFunctions);
		this.webFunctions = webFunctions;
	}
	
	
	private void navigateToAPP(String URL) {
		webFunctions.navigateTo(URL);
	}
	
	
	public void loginInternalApp() {                    
		
		navigateToAPP(FrameworkUtils.getUrl());
		if(FrameworkUtils.getUatURL_Flag().equalsIgnoreCase("TRUE"))  {
			webFunctions.enterText(LoginScreen.UAT_userid, webFunctions.getData(Field.USERNAME.getColumnName()));
			webFunctions.enterText(LoginScreen.UAT_password, webFunctions.getData(Field.PASSWORD.getColumnName()));
			webFunctions.clickOn(LoginScreen.UAT_submitBtn);
			webFunctions.verifyElementPresent(LoginScreen.searchFileAClaimLink(webFunctions.getData(Field.ClickOnSearchAFile.getColumnName())), "search/file a claim should be displayed");
			webFunctions.clickOn(LoginScreen.searchFileAClaimLink(webFunctions.getData(Field.ClickOnSearchAFile.getColumnName())));
		} else {
			webFunctions.enterText(LoginScreen.userid, webFunctions.getData(Field.USERNAME.getColumnName()));
			//webFunctions.enterText(passwordTxtBox, webFunctions.getData("password"));
			webFunctions.clickOn(LoginScreen.submitBtn);
		}
			
	}
	
	public void enterSSN() { 
		if(webFunctions.getData(Field.SSNNumber.getColumnName()).trim().isEmpty()) {
			webFunctions.storeData("SSNNumber", "100"+webFunctions.generateRndmNumber(6));
		}		
		
		webFunctions.enterText(LoginScreen.ssnTextBox, webFunctions.getData(Field.SSNNumber.getColumnName()));
	}
	
	
	/*************************************************
	 * Click on Search button
	 * click on first record from search 
	 * If no search results, clicks on 'File a Claim'
	 * ***********************************************/
	
	/*
	public void clickOnSearchButton() {
		webFunctions.waitTillElementclickable(searchButton);
		webFunctions.clickOn(searchButton);
		
		//if(!noSearchResults.isDisplayed()) {
		if(searchResultsFirstRecord.isDisplayed()) {
			webFunctions.clickOn(searchResultsFirstRecord);
			if(!takeOwnershipPopup) {
				webFunctions.clickOn(OwnershipPopupNoButton);
			}
			
		} else if (noSearchResults.isDisplayed()) {
		
		webFunctions.waitTillElementclickable(fileClaimButton);
		webFunctions.clickOn(fileClaimButton);
		}
	} ********************/
	
	
	
	public void clickOnSearchButton() {
		webFunctions.waitTillElementclickable(LoginScreen.searchBtn);
		webFunctions.clickOn(LoginScreen.searchBtn);
		
		if(webFunctions.verifyElementAvailableAndDisplayed(noSearchResults)) {
			webFunctions.waitTillElementclickable(fileClaimButton);
			webFunctions.clickOn(fileClaimButton);
			
		} else if (searchResultsFirstRecord.isDisplayed()) {
			webFunctions.clickOn(searchResultsFirstRecord);
			if(!takeOwnershipPopup) {
				webFunctions.clickOn(OwnershipPopupNoButton);
			}
		
		
		}
	}

	public void verifySSN() {
		webFunctions.getData("SSNID");
	}
	
	
	public void clickOnSaveContinueButton() {
		webFunctions.waitTillElementclickable(saveContinueButton);
		webFunctions.clickOn(saveContinueButton);
	}
	
	public static By getQuestionLocator(String questionName, String optionToSelect) {
		return  By.xpath("//label[contains(.,'"+questionName+"')]/ancestor::div[contains(@class,'fieldHeader')]//div/label[contains(text(),'"+optionToSelect+"')]/preceding-sibling::input[1]");
	}
	
	
	private WebElement getQuestionToSelect(String questionName, String optionToSelect) {
		return driver.findElement(getQuestionLocator(questionName, optionToSelect));
	}
	
	
	public void SelectPUSResident() {		
		webFunctions.waitTillElementclickable(getQuestionToSelect(Field.PUSResidentQ.getColumnName(),webFunctions.getData(Field.PUSResidentQ.getColumnName())));
		webFunctions.clickOn(getQuestionToSelect(Field.PUSResidentQ.getColumnName(),webFunctions.getData(Field.PUSResidentQ.getColumnName())));
		
	}
	
	
	public void SelectPEmpPast18Months() {		
		webFunctions.waitTillElementclickable(getQuestionToSelect(Field.PEmpPast18MonthsQ.getColumnName(),webFunctions.getData(Field.PEmpPast18MonthsQ.getColumnName())));
		webFunctions.clickOn(getQuestionToSelect(Field.PEmpPast18MonthsQ.getColumnName(),webFunctions.getData(Field.PEmpPast18MonthsQ.getColumnName())));
		
		if(webFunctions.getData(Field.PEmpPast18MonthsQ.getColumnName()).equalsIgnoreCase(ApplicationStaticData.YesText)){
			SelectPAllWorkInNJ();
		} 
		
	}
	
	public void SelectPAllWorkInNJ() {		
		webFunctions.waitTillElementclickable(getQuestionToSelect(Field.PAllWorkInNJQ.getColumnName(),webFunctions.getData(Field.PAllWorkInNJQ.getColumnName())));
		webFunctions.clickOn(getQuestionToSelect(Field.PAllWorkInNJQ.getColumnName(),webFunctions.getData(Field.PAllWorkInNJQ.getColumnName())));
		if(webFunctions.getData(Field.PAllWorkInNJQ.getColumnName()).equalsIgnoreCase(ApplicationStaticData.NoText)){
			SelectPAnyWorkInNJQ();
		}
	}
	
	private void SelectPAnyWorkInNJQ() {		
		webFunctions.waitTillElementclickable(getQuestionToSelect(Field.PAnyWorkInNJQ.getColumnName(),webFunctions.getData(Field.PAnyWorkInNJQ.getColumnName())));
		webFunctions.clickOn(getQuestionToSelect(Field.PAnyWorkInNJQ.getColumnName(),webFunctions.getData(Field.PAnyWorkInNJQ.getColumnName())));
		
	}
	
	
	public void SelectPMilitaryPast18MonthsQ() {		
		webFunctions.waitTillElementclickable(getQuestionToSelect(Field.PMilitaryPast18MonthsQ.getColumnName(),webFunctions.getData(Field.PMilitaryPast18MonthsQ.getColumnName())));
		webFunctions.clickOn(getQuestionToSelect(Field.PMilitaryPast18MonthsQ.getColumnName(),webFunctions.getData(Field.PMilitaryPast18MonthsQ.getColumnName())));
		
	}
	
	public void SelectPFedPast18MonthsQ() {		
		webFunctions.waitTillElementclickable(getQuestionToSelect(Field.PFedPast18MonthsQ.getColumnName(),webFunctions.getData(Field.PFedPast18MonthsQ.getColumnName())));
		webFunctions.clickOn(getQuestionToSelect(Field.PFedPast18MonthsQ.getColumnName(),webFunctions.getData(Field.PFedPast18MonthsQ.getColumnName())));
		
	}
	
	public void SelectPOutOfStateEmpQ() {		
		webFunctions.waitTillElementclickable(getQuestionToSelect(Field.POutOfStateEmpQ.getColumnName(),webFunctions.getData(Field.POutOfStateEmpQ.getColumnName())));
		webFunctions.clickOn(getQuestionToSelect(Field.POutOfStateEmpQ.getColumnName(),webFunctions.getData(Field.POutOfStateEmpQ.getColumnName())));
		
	}
	
	public void SelectPMaritimeEmpQ() {		
		webFunctions.waitTillElementclickable(getQuestionToSelect(Field.PMaritimeEmpQ.getColumnName(),webFunctions.getData(Field.PMaritimeEmpQ.getColumnName())));
		webFunctions.clickOn(getQuestionToSelect(Field.PMaritimeEmpQ.getColumnName(),webFunctions.getData(Field.PMaritimeEmpQ.getColumnName())));
		
	}
	
	
	
	public void SelectionPUnableToWorkQ() {		
		webFunctions.waitTillElementclickable(getQuestionToSelect(Field.PUnableToWorkQ.getColumnName(),webFunctions.getData(Field.PUnableToWorkQ.getColumnName())));
		webFunctions.clickOn(getQuestionToSelect(Field.PUnableToWorkQ.getColumnName(),webFunctions.getData(Field.PUnableToWorkQ.getColumnName())));
		
	}
	

}
