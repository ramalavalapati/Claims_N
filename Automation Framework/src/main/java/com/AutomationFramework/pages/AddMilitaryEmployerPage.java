package com.AutomationFramework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.AutomationFramework.ApplicationStaticData;
import com.AutomationFramework.Field;
import com.AutomationFramework.WebFunctions;

public class AddMilitaryEmployerPage extends BasePage{
	private WebFunctions web;
	//out of state reuse methods
	private EmploymentPage employmentPage;
	
	public AddMilitaryEmployerPage(WebDriver driver, WebFunctions webFunctions) {
		super(driver, webFunctions);
		web = webFunctions;
		//out of state reuse methods
		employmentPage = new EmploymentPage(driver, webFunctions);
		
	}
	
	
	private WebElement getQuestionToSelect(String questionName, String optionToSelect) {
		//return driver.findElement(By.xpath("//label[contains(.,'"+questionName+"')]/../following-sibling::div/label[text()='"+optionToSelect+"']/preceding-sibling::input[1]"));
		return driver.findElement(LoginPage.getQuestionLocator(questionName, optionToSelect));
				
	}
	
	
	@FindBy(xpath="//span[text()='New Military Employer']")
	public WebElement addNewMilitaryEmployerPageHeader;
	
	@FindBy(name = "_eventId_addUCXEmployer")
	private WebElement addMilitaryEmployerButton;
	
	
	@FindBy(xpath="//select[@name='ucxMilitaryBranch']")
	private WebElement UCXBranchOfSerivceDropdown;
	
	@FindBy(xpath="//select[@name='ucxPayGrade']")
	private WebElement UCXPayGradeDropdown;
	
	@FindBy(name="ucxEntryDate")
	private WebElement UCXEntryDateTxtBox;
	
	@FindBy(name="ucxSeperationDate")
	private WebElement UCXSeperationDateTxtBox;
	
	@FindBy(name="ucxAccrDays")
	private WebElement UCXDaysAccruedTxtBox;
	
	@FindBy(xpath="//select[@name='ucxCharOfService']")
	private WebElement UCXCharOfServiceDropdown;
	
	@FindBy(xpath="//select[@name='ucxNarrative']")
	private WebElement UCXReasonDischargeDropdown;
	
	
	@FindBy(xpath="//select[@name='ucxDd214Copy']")
	private WebElement UCXDD214Dropdown;
	
	@FindBy(xpath="//select[@name='ucxSepCode']")
	private WebElement UCXSeparationReasonDropdown;
	
	
	private void verifyNewMilitaryEmployerPageDisplayed() {
		web.verifyElementPresent(addNewMilitaryEmployerPageHeader,"");
	}
	
	
	/************ Click on Add Military Employer button ******************/
	private void clickOnAddNewMilitaryEmployerButton() {
		web.waitTillElementclickable(addMilitaryEmployerButton);
		web.clickOn(addMilitaryEmployerButton);
	}
	
	/************ Verify Add Military Employer button is displayed ******************/
	public void verifyAddNewMilitaryButtonDisplayed() {
		web.verifyElementPresent(addMilitaryEmployerButton,"");
	}
	
	
	/************ Will execute if AddMilitaryEmployerFlag is Yes  ******************/
	public void fillAddNewMilitaryEmployerPage() {
		if(web.getData(Field.AddMilitaryEmployerFlag.getColumnName()).equalsIgnoreCase(ApplicationStaticData.YesText)) {
			clickOnAddNewMilitaryEmployerButton();
			verifyNewMilitaryEmployerPageDisplayed();
	
			selectUCXBranchOfService();
			selectUCXBranchOfService();
			selectUCXPayGrade();
			selectUCXEntryDate();
			selectUCXSeparationDate();
			selectUCXDaysAccrued();
			selectUCXCharOfService();
			selectUCXReasonDischarge();
			selectUCXDaysLost();
			selectUCXDD214();
			selectUCXNationalGaurdOrReserve();
			selectUCXFirstTourOfEnlishment();
			selectUCXSeparationReason();
			selectUCXRetireRegularOrDisability();
			clickOnSavethisEmp();
			
	
		}
	}
	
	
	/********** Branch of Service(Block 2): *****************/
	public void selectUCXBranchOfService() {
		//web.waitTillElementclickable(getQuestionToSelect(Field.NoLongerWorkEmp.getColumnName(),web.getData(Field.NoLongerWorkEmp.getColumnName())));
		web.selectOptionByText(UCXBranchOfSerivceDropdown, web.getData(Field.UCXBranchOfService.getColumnName()));
		
	}
	
	/********** Pay Grade(Block 4b): *****************/
	public void selectUCXPayGrade() {
		//web.waitTillElementclickable(getQuestionToSelect(Field.NoLongerWorkEmp.getColumnName(),web.getData(Field.NoLongerWorkEmp.getColumnName())));
		web.selectOptionByText(UCXPayGradeDropdown, web.getData(Field.UCXPayGrade.getColumnName()));
		
	}
	
	/********** Entry Date(Block 12a): *****************/
	public void selectUCXEntryDate() {
		web.waitTillElementclickable(UCXEntryDateTxtBox);
		web.enterText(UCXEntryDateTxtBox, web.getData(Field.UCXEntryDate.getColumnName()));
	}
	
	
	/********** Separation Date(Block 12b): *****************/
	public void selectUCXSeparationDate() {
		web.waitTillElementclickable(UCXSeperationDateTxtBox);
		web.enterText(UCXSeperationDateTxtBox, web.getData(Field.UCXSeparationDate.getColumnName()));
	}
	
	
	/********** Days Accrued(Block 16): *****************/
	public void selectUCXDaysAccrued() {
		web.waitTillElementclickable(UCXDaysAccruedTxtBox);
		web.enterText(UCXDaysAccruedTxtBox, web.getData(Field.UCXDaysAccrued.getColumnName()));
	}
	
	
	/********** Character of Service(Block 24): *****************/
	public void selectUCXCharOfService() {
		web.waitTillElementclickable(UCXCharOfServiceDropdown);
		web.enterText(UCXCharOfServiceDropdown, web.getData(Field.UCXCharOfService.getColumnName()));
	}
	
	
	/********** Narrative Reason for Discharge(Block 28): *****************/
	public void selectUCXReasonDischarge() {
		web.waitTillElementclickable(UCXReasonDischargeDropdown);
		web.enterText(UCXReasonDischargeDropdown, web.getData(Field.UCXReasonDischarge.getColumnName()));
	}
	
	
	/********** Do you have any "Days Lost"(Block 29)? *****************/
	public void selectUCXDaysLost() {
		web.clickOn(getQuestionToSelect(Field.UCXDaysLost.getColumnName(),web.getData(Field.UCXDaysLost.getColumnName())));
		
	}
	
	
	/********** DD214 member copy (Found on bottom right of form): *****************/
	public void selectUCXDD214() {
		web.waitTillElementclickable(UCXDD214Dropdown);
		web.enterText(UCXDD214Dropdown, web.getData(Field.UCXDD214.getColumnName()));
	}
	
	
	/********** Completed as a member of the National Guard or Reserve? *****************/
	public void selectUCXNationalGaurdOrReserve() {
		web.clickOn(getQuestionToSelect(Field.UCXNationalGaurdOrReserve.getColumnName(),web.getData(Field.UCXNationalGaurdOrReserve.getColumnName())));
		
	}
	
	
	/********** Completed First Tour of Enlistment: *****************/
	public void selectUCXFirstTourOfEnlishment() {
		web.clickOn(getQuestionToSelect(Field.UCXFirstTourOfEnlishment.getColumnName(),web.getData(Field.UCXFirstTourOfEnlishment.getColumnName())));
		
	}
	
	/********** Separation Reason: *****************/
	public void selectUCXSeparationReason() {
		web.waitTillElementclickable(UCXSeparationReasonDropdown);
		web.enterText(UCXSeparationReasonDropdown, web.getData(Field.UCXSeparationReason.getColumnName()));
	}
	
	
	/********** Are you a military retiree: Regular or Disability? *****************/
	public void selectUCXRetireRegularOrDisability() {
		web.clickOn(getQuestionToSelect(Field.UCXRetireRegularOrDisability.getColumnName(),web.getData(Field.UCXRetireRegularOrDisability.getColumnName())));
		
	}
	
	
	
	//out of state reuse methods from employment page
	public void fillOutOfStateEmployerDetails() throws InterruptedException {
		//employmentPage.addNewEmpDetails();
	}
}
