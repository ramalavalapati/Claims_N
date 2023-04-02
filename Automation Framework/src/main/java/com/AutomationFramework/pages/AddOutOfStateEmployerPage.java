package com.AutomationFramework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.AutomationFramework.ApplicationStaticData;
import com.AutomationFramework.Field;
import com.AutomationFramework.WebFunctions;

public class AddOutOfStateEmployerPage extends BasePage{
	
	
	@FindBy(name = "_eventId_addCWCEmployer")
	private WebElement addCWCEmpButton;
	
	@FindBy(xpath="//span[text()='New Out Of State Employer']")
	public WebElement addNewCWCEmpPageHeader;
	
	@FindBy(name = "empAddLine1")
	private WebElement CWCEmpNameTxtBox;
	
	@FindBy(name = "empAddLine2")
	private WebElement CWCEmpAddLine1TxtBox;
	
	@FindBy(name = "empAddLine3")
	private WebElement CWCEmpAddLine2TxtBox;
	
	@FindBy(name = "empAddLine4")
	private WebElement CWCEmpAddLine3TxtBox;
	
	@FindBy(name = "empAddLine5")
	private WebElement CWCEmpCityTxtBox;
	
	@FindBy(xpath="//select[@name='empAddLine6']")
	private WebElement CWCEmpStateDropdown;
	
	@FindBy(name = "empZip")
	private WebElement CWCEmpZipCodeTxtBox;
	
	@FindBy(xpath="//select[@name='cwcStateFips']")
	private WebElement CWCWageTransState;
	
	@FindBy(xpath="//select[@name='cwcEmpType']")
	private WebElement CWCEmpType;
	
	@FindBy(name = "empTelephone")
	private WebElement CWCEmpTelPhoneTxtBox;
	
	@FindBy(name = "workLocationPhoneNr")
	private WebElement CWCEmpWorkLocPhoneTxtBox;
	
	@FindBy(name = "beginDate")
	private WebElement CWCEmpFirstDOWTxtBox;
	
	@FindBy(name = "lastDateWorked")
	private WebElement CWCEmpLastDOWTxtBox;
	
	private WebFunctions web;
	//out of state reuse methods
	private EmploymentPage employmentPage;
	
	@FindBy(xpath="//select[@name='seperationCode']")
	private WebElement CWCnoLongerWorkEmpDropdown;
	
	public AddOutOfStateEmployerPage(WebDriver driver, WebFunctions webFunctions) {
		super(driver, webFunctions);
		web = webFunctions;
		//out of state reuse methods
		employmentPage = new EmploymentPage(driver, webFunctions);
		
	}
	
	
	public void verifyNewOutOfStateEmployerPageDisplayed() {
		web.verifyElementPresent(addNewCWCEmpPageHeader,"");
	}
	
	
	/************ Click on Add Federal Employer button ******************/
	private void clickOnNewOutOfStateEmployerButton() {
		web.waitTillElementclickable(addCWCEmpButton);
		web.clickOn(addCWCEmpButton);
	}
	
	/************ Verify Add Military Employer button is displayed ******************/
	public void verifyAddNewOutOfStateEmpButtonDisplayed() {
		web.verifyElementPresent(addCWCEmpButton,"");
	}
	
	
	/************ Will execute if AddMilitaryEmployerFlag is Yes  
	 * @throws InterruptedException ******************/
	public void fillAddNewOutOfStateEmpPage() throws InterruptedException {
		if(web.getData(Field.AddOutOfStateEmpFlag.getColumnName()).equalsIgnoreCase(ApplicationStaticData.YesText)) {
			clickOnNewOutOfStateEmployerButton();
			verifyAddNewOutOfStateEmpButtonDisplayed();
			
			EnterOutOfStateEmpDetails();
			
			employmentPage.selectDiffPhysicalWorkLoc(web.getData(Field.CWCDiffPhysicalWorkLoc.getColumnName()));
			employmentPage.selectWorkedUnderDiffName(web.getData(Field.CWCWorkedUnderDiffName.getColumnName()));
			CWCenterFirstLastDOW();
			//employmentPage.selectStillWorkForThisEmp(web.getData(Field.CWCNoLongerWorkEmp.getColumnName()), 
					//web.getData(Field.NoLongerWorkEmp.getColumnName()), 
							//web.getData(Field.IndicateBestDesSituation.getColumnName()));
			
			clickOnSavethisEmp();
		}
	}
	
	
	/******* Enter New Out Of State Employer details section *********/
	public void EnterOutOfStateEmpDetails() {
		web.waitTillElementclickable(CWCEmpNameTxtBox);
		web.enterText(CWCEmpNameTxtBox, web.getData(Field.CWCEmpName.getColumnName()));
		web.enterText(CWCEmpAddLine1TxtBox, web.getData(Field.CWCAddLine1.getColumnName()));
		web.enterText(CWCEmpAddLine2TxtBox, web.getData(Field.CWCAddLine2.getColumnName()));
		web.enterText(CWCEmpAddLine3TxtBox, web.getData(Field.CWCAddLine3.getColumnName()));
		web.enterText(CWCEmpCityTxtBox, web.getData(Field.CWCCity.getColumnName()));
		web.enterText(CWCEmpStateDropdown, web.getData(Field.CWCState.getColumnName()));
		web.enterText(CWCEmpZipCodeTxtBox, web.getData(Field.CWCZipCode.getColumnName()));
		web.selectOptionByText(CWCWageTransState, web.getData(Field.CWCWageTransState.getColumnName()));
		web.selectOptionByText(CWCEmpType, web.getData(Field.CWCEmploymentType.getColumnName()));
		web.waitTillElementclickable(CWCEmpTelPhoneTxtBox);
		web.clickOn(CWCEmpTelPhoneTxtBox);
		web.enterText(CWCEmpTelPhoneTxtBox, web.getData(Field.CWCTelNumber.getColumnName()));
		web.enterText(CWCEmpWorkLocPhoneTxtBox, web.getData(Field.CWCDiffTelNumber.getColumnName()));
		
	}
	
	/******* CWC First and Last Date of Work  ****************/
	public void CWCenterFirstLastDOW()  {
		web.waitTillElementclickable(CWCEmpFirstDOWTxtBox);
		web.clickOn(CWCEmpFirstDOWTxtBox);
		web.enterText(CWCEmpFirstDOWTxtBox, web.getData(Field.CWCFirstDayOfWork.getColumnName()));
		web.waitTillElementclickable(CWCEmpLastDOWTxtBox);
		web.clickOn(CWCEmpLastDOWTxtBox);
		web.enterText(CWCEmpLastDOWTxtBox, web.getData(Field.CWCLastDayOfWork.getColumnName()));
	
	}
	
	/********** CWC Why are you no longer working for this employer? *****************/
	public void selectCWCNoLongerWorkEmp() {
		//web.waitTillElementclickable(getQuestionToSelect(Field.NoLongerWorkEmp.getColumnName(),web.getData(Field.NoLongerWorkEmp.getColumnName())));
		web.selectOptionByText(CWCnoLongerWorkEmpDropdown, web.getData(Field.CWCNoLongerWorkEmp.getColumnName()));
		
	}
	
	

}
