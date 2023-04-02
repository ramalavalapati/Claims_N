package com.AutomationFramework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.AutomationFramework.ApplicationStaticData;
import com.AutomationFramework.Field;
import com.AutomationFramework.WebFunctions;

public class AddFederalEmployerPage extends BasePage{

	private WebFunctions web;
	//out of state reuse methods
	private EmploymentPage employmentPage;
	
	public AddFederalEmployerPage(WebDriver driver, WebFunctions webFunctions) {
		super(driver, webFunctions);
		web = webFunctions;
		//out of state reuse methods
		employmentPage= new EmploymentPage(driver, webFunctions);
	}
	
	
	private WebElement getQuestionToSelect(String questionName, String optionToSelect) {
		//return driver.findElement(By.xpath("//label[contains(.,'"+questionName+"')]/../following-sibling::div/label[text()='"+optionToSelect+"']/preceding-sibling::input[1]"));
		return driver.findElement(LoginPage.getQuestionLocator(questionName, optionToSelect));
				
	}
	
	
	@FindBy(xpath="//span[text()='New Federal Employer']")
	public WebElement addNewFederalEmployerPageHeader;
	
	@FindBy(name = "_eventId_addUCFEEmployer")
	private WebElement addFederalEmployerButton;
	
	
	public void verifyNewFederalEmployerPageDisplayed() {
		web.verifyElementPresent(addNewFederalEmployerPageHeader,"");
	}
	
	
	/************ Click on Add Federal Employer button ******************/
	private void clickOnAddNewFederalEmployerButton() {
		web.waitTillElementclickable(addFederalEmployerButton);
		web.clickOn(addFederalEmployerButton);
	}
	
	/************ Verify Add Military Employer button is displayed ******************/
	public void verifyAddNewFederalButtonDisplayed() {
		web.verifyElementPresent(addFederalEmployerButton,"");
	}
	
	
	/************ Will execute if AddMilitaryEmployerFlag is Yes  
	 * @throws InterruptedException ******************/
	public void fillAddNewFederalEmployerPage() throws InterruptedException {
		if(web.getData(Field.AddFederalEmployerFlag.getColumnName()).equalsIgnoreCase(ApplicationStaticData.YesText)) {
			clickOnAddNewFederalEmployerButton();
			verifyNewFederalEmployerPageDisplayed();
			
			//employmentPage.addNewEmpDetails();
			employmentPage.selectDiffPhysicalWorkLoc(web.getData(Field.DiffPhysicalWorkLoc.getColumnName()));
			employmentPage.selectWorkedUnderDiffName(web.getData(Field.WorkedUnderDiffName.getColumnName()));
			employmentPage.enterFirstLastDOW(web.getData(Field.FirstDayOfWork.getColumnName()),  web.getData(Field.LastDayOfWork.getColumnName()));
			//employmentPage.selectLagWageOnly();
			//employmentPage.selectStillWorkForThisEmp(web.getData(Field.StillWorkForThisEmp.getColumnName()), 
					//web.getData(Field.NoLongerWorkEmp.getColumnName()),
					//web.getData(Field.IndicateBestDesSituation.getColumnName()));
			//employmentPage.selectNoLongerWorkEmp();
			employmentPage.enterJobTitle(web.getData(Field.JobTitle.getColumnName()));
			//employmentPage.selectSelfEmpOrBusiness();
			//employmentPage.selectOwnerOrAnyBusiness();
			employmentPage.selectRetirementPayment(web.getData(Field.RetirementPayment.getColumnName()));
			//employmentPage.selectOtherPay(web.getData(Field.OtherPay.getColumnName()));
			clickOnSavethisEmp();
		}
	}
	
}
