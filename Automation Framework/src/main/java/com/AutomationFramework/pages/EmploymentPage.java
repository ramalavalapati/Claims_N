package com.AutomationFramework.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.AutomationFramework.ApplicationStaticData;
import com.AutomationFramework.Field;
import com.AutomationFramework.WebFunctions;

public class EmploymentPage extends BasePage {

	@FindBy(name = "_eventId_addNJEmployer")
	private WebElement addNJEMployerButton;	
	
	@FindBy(name = "_eventId_addCWCEmployer")
	private WebElement addOutOfStateEmployerButton;
	
	@FindBy(name = "_eventId_addUCFEEmployer")
	private WebElement addFEDEmployerButton;
	
	@FindBy(name = "empAddLine1")
	private WebElement EmpNameTxtBox;
	
	@FindBy(name = "regNum")
	private WebElement EmpFEINTxtBox;
	
	@FindBy(name = "statePayrollNr")
	private WebElement SYNNumTxtBox;
	
	@FindBy(name = "empAddLine2")
	private WebElement EmpAddLine1TxtBox;
	
	@FindBy(name = "empAddLine3")
	private WebElement EmpAddLine2TxtBox;
	
	@FindBy(name = "empAddLine4")
	private WebElement EmpAddLine3TxtBox;
	
	@FindBy(name = "empAddLine5")
	private WebElement EmpCityTxtBox;
	
	@FindBy(xpath="//select[@name='empAddLine6']")
	private WebElement EmpStateDropdown;
	
	@FindBy(name = "empZip")
	private WebElement EmpZipCodeTxtBox;
	
	@FindBy(name = "empTelephone")
	private WebElement EmpTelPhoneTxtBox;
	
	@FindBy(name = "workLocationPhoneNr")
	private WebElement EmpWorkLocPhoneTxtBox;
	
	@FindBy(id = "clearEmployer")
	private WebElement ClearEmp;
	
	@FindBy(id = "findEmployer")
	private WebElement findEmp;
	
	@FindBy(name = "beginDate")
	private WebElement EmpFirstDOWTxtBox;
	
	@FindBy(name = "lastDateWorked")
	private WebElement EmpLastDOWTxtBox;
	
	@FindBy(xpath="//select[@name='seperationCode']")
	private WebElement noLongerWorkEmpDropdown;
	
	@FindBy(xpath="//select[@name='stillEmployedReasonCd']")
	private WebElement stillEmpDropdown;
	
	@FindBy(name = "dischargeDate")
	private WebElement dischargeDate;
	
	@FindBy(id = "txtNJEmpQuitResignedRetiredTerReasonExp")
	private WebElement ReasonSeparation1;
	
	//xpath=("//div[@id='pageButtonsDiv']/div/a/input")
	@FindBy(xpath= "//textarea[@id = 'txtNJEmpQuitResignedRetiredTerReasonExp']")
	private WebElement ReasonSeparation;
	
	@FindBy(name="recallDate")
	private WebElement empRecallDate;
	
	@FindBy(name = "occupation")
	private WebElement JobTitleTxtBox;
	
	@FindBy(xpath ="//select[@name='businessFamilyRelationship']") 
	private WebElement relationshipToOwner;
	
	@FindBy(xpath="//select[@name='njEmpAdditionalPaymentType_payType']")
	private WebElement selectPaymentTypeDrpDown;
	
	@FindBy(name="njEmpAdditionalPaymentType_gross")
	private WebElement additionalAmountTxtField;
	
	@FindBy(name="njEmpAdditionalPaymentType_from")
	private WebElement additionalPaymentFromDate;
	
	@FindBy(name="njEmpAdditionalPaymentType_to")
	private WebElement additionalPaymentToDate;
	
	@FindBy(name="njEmpAdditionalPaymentType_comment")
	private WebElement additionalPaymentComment;
	
	@FindBy(name="monetaryReasonCode")                                   //JEFFB
	private WebElement monetaryRC;                                       //JEFFB
	
	@FindBy(xpath=("//div[@id='pageButtonsDiv']/div/a/input"))
	private WebElement empTabContinueBtn;	
	
	@FindBy(id="saveThisEmployerBtnValidation")
	private WebElement saveThisEmp;
	
	@FindBy(id="employmentData")
	private List<WebElement> employmentHis;
	
	@FindBy(xpath=("//table[@id='employmentData']/tbody/tr/td[9][normalize-space(text())='Incomplete']/ancestor::table[@id='employmentData']/tbody/tr/td/a"))
	private List<WebElement> inCompleteEmpNameLink;
	
	String ExistingCompletedEmpLink = "//tbody//tr/td/a[text()='ExistingEMPName']/../following-sibling::td[normalize-space(text())='Completed']";

	private WebFunctions web;
	

	public EmploymentPage(WebDriver driver, WebFunctions webFunctions) {
		super(driver, webFunctions);
		web = webFunctions;
	}
	
	
	private WebElement getQuestionToSelect(String questionName, String optionToSelect) {
		//return driver.findElement(By.xpath("//label[contains(.,'"+questionName+"')]/../following-sibling::div/label[text()='"+optionToSelect+"']/preceding-sibling::input[1]"));
		return driver.findElement(LoginPage.getQuestionLocator(questionName, optionToSelect));
				
	}
	
	/*
	 * public static By getLocatorForButtons(String buttonName) { return
	 * By.xpath("//input[@value='"+buttonName+"']"); }
	 */
	
	public void clickAddNJEmp() {
		web.waitTillElementclickable(addNJEMployerButton);
		web.clickOn(addNJEMployerButton);
	}

	
	
	/******* Add New NJ Emp 
	 * @param nJEMPIndex 
	 * @throws InterruptedException ****************/
	public void addNewEmpDetails(String prefix, int nJEMPIndex) throws InterruptedException {
		web.waitTillElementclickable(EmpNameTxtBox);
		web.enterText(EmpNameTxtBox, web.getData(prefix+nJEMPIndex+Field.EmpName.getColumnName()));
		web.enterText(EmpFEINTxtBox, web.getData(prefix+nJEMPIndex+Field.EmpFEIN.getColumnName()));
		web.enterText(SYNNumTxtBox, web.getData(prefix+nJEMPIndex+Field.SYNNumber.getColumnName()));
		web.enterText(EmpAddLine1TxtBox, web.getData(prefix+nJEMPIndex+Field.AddLine1.getColumnName()));
		web.enterText(EmpAddLine2TxtBox, web.getData(prefix+nJEMPIndex+Field.AddLine2.getColumnName()));
		web.enterText(EmpAddLine3TxtBox, web.getData(prefix+nJEMPIndex+Field.AddLine3.getColumnName()));
		web.enterText(EmpCityTxtBox, web.getData(prefix+nJEMPIndex+Field.City.getColumnName()));
		web.selectOptionByText(EmpStateDropdown, web.getData(prefix+nJEMPIndex+Field.EmpTabState.getColumnName()));
		web.enterText(EmpZipCodeTxtBox, web.getData(prefix+nJEMPIndex+Field.ZipCode.getColumnName()));
		//web.waitTillElementclickable(EmpTelPhoneTxtBox);
		web.clickOn(EmpTelPhoneTxtBox);
		web.enterText(EmpTelPhoneTxtBox, web.getData(prefix+nJEMPIndex+Field.TelNumber.getColumnName()));
		web.enterText(EmpWorkLocPhoneTxtBox, web.getData(prefix+nJEMPIndex+Field.workTelPhone.getColumnName()));
	}
	
	
	public void updateLoopsIncompleteEmpDetailsIfAvailable(String prefix) {
		
		if(web.verifyElementAvailableAndDisplayed(employmentHis) /*&& !(existingEmpLastDayOfWrk.size()>0 && (existingEmpLastDayOfWrk.get(0).isDisplayed()))*/) {
			List<WebElement> inCompleteEmpNameLink = web.getDriver().findElements(By.xpath("//table[@id='employmentData']/tbody/tr/td[9][normalize-space(text())='Incomplete']/ancestor::table[@id='employmentData']/tbody/tr/td/a"));
			int existingEmployeeCount=1;
			for(int i=1;i<=inCompleteEmpNameLink.size();i++) {
				if(web.verifyElementAvailableAndDisplayed(inCompleteEmpNameLink)) {
					String empName = web.getText(inCompleteEmpNameLink.get(0));
					web.clickOn(inCompleteEmpNameLink.get(0));
					//web.clickOn(inCompleteEmpNameLink.get(i));
					web.clickOn(getQuestionToSelect(Field.WorkForThisEmp.getColumnName(), web.getData(prefix+existingEmployeeCount+Field.WorkForThisEmp.getColumnName())));
										
					if(web.getData(Field.PMaritimeEmpQ.getColumnName()).equalsIgnoreCase(ApplicationStaticData.YesText)) {
					web.clickOn(getQuestionToSelect(Field.MaritimeEmp.getColumnName(), web.getData(prefix+existingEmployeeCount+Field.MaritimeEmp.getColumnName())));
					}
					
					storeExistingEmpDetails(prefix, existingEmployeeCount);								
					alternateWorkInfo(prefix,existingEmployeeCount);
					enterFirstLastDOW(web.getData(prefix+existingEmployeeCount+Field.FirstDayOfWork.getColumnName()),  web.getData(prefix+existingEmployeeCount+Field.LastDayOfWork.getColumnName()));
					//selectLagWageOnly(web.getData(prefix+nJEMPIndex+Field.LagWage.getColumnName()));
					selectStillWorkForThisEmp(prefix, existingEmployeeCount, web.getData(prefix+existingEmployeeCount+Field.StillWorkForThisEmp.getColumnName()), 
							web.getData(prefix+existingEmployeeCount+Field.NoLongerWorkEmp.getColumnName()),
							web.getData(prefix+existingEmployeeCount+Field.IndicateBestDesSituation.getColumnName()));
					selectRecalledByEmp(prefix, existingEmployeeCount);
					enterJobTitle(web.getData(prefix+existingEmployeeCount+Field.JobTitle.getColumnName()));
					selectSelfEmpOrBusiness(web.getData(prefix+existingEmployeeCount+Field.SelfEmpOrBusiness.getColumnName())); 
					selectOwnerOrAnyBusiness(prefix, existingEmployeeCount, web.getData(prefix+existingEmployeeCount+Field.OwnerOrAnyBusiness.getColumnName()));
					selectRetirementPayment(web.getData(prefix+existingEmployeeCount+Field.RetirementPayment.getColumnName())); 
					selectOtherPay(prefix, existingEmployeeCount, web.getData(prefix+existingEmployeeCount+Field.OtherPay.getColumnName()));
					selectRetirementPayment(web.getData(prefix+existingEmployeeCount+Field.RetirementPayment.getColumnName()));
					clickOnSavethisEmp();
					System.out.println("existing employee count is " +existingEmployeeCount);
					web.verifyElementPresent(getDriver().findElement(By.xpath(ExistingCompletedEmpLink.replaceFirst("ExistingEMPName", empName.trim()))), "Existing Emp status should be Completed.");
					
					inCompleteEmpNameLink = web.getDriver().findElements(By.xpath("//table[@id='employmentData']/tbody/tr/td[9][normalize-space(text())='Incomplete']/ancestor::table[@id='employmentData']/tbody/tr/td/a"));
					if(web.verifyElementAvailableAndDisplayed(inCompleteEmpNameLink)) {
						i =i-1;
						existingEmployeeCount++;
					}
				}
			}			
		} 
		
	}
	
	//**************  Store existing LOOPS emp details ******************//
	public void storeExistingEmpDetails(String prefix, int nJEMPIndex) {
		String existingEmpName = EmpNameTxtBox.getAttribute("value");
		String existingEmpFEINNumber = EmpFEINTxtBox.getAttribute("value");
		String existingSYNNumber = SYNNumTxtBox.getAttribute("value");
		String existingAddLineOne = EmpAddLine1TxtBox.getAttribute("value");
		String existingAddLineTwo = EmpAddLine2TxtBox.getAttribute("value");
		String existingCity = EmpCityTxtBox.getAttribute("value");
		Select selectExistingSate = new Select(EmpStateDropdown);
		WebElement existState = selectExistingSate.getFirstSelectedOption();
		
		String existingState = existState.getText();
		
		String existingZipCode = EmpZipCodeTxtBox.getAttribute("value");
		
		String existingTelephone = EmpTelPhoneTxtBox.getAttribute("value");
		
		web.clickOn(ClearEmp);
		web.getData(existingEmpFEINNumber);
		/*
		 * if(existingSYNNumber == null && existingSYNNumber.trim().isEmpty()) {
		 * web.enterText(SYNNumTxtBox, "00000000"); } else { web.enterText(SYNNumTxtBox,
		 * existingSYNNumber); }
		 */
		fillExistingDetails(existingEmpFEINNumber, EmpFEINTxtBox, existingEmpFEINNumber);
		fillExistingDetails(existingEmpName, EmpNameTxtBox, existingEmpName);
		fillExistingDetails(existingSYNNumber, SYNNumTxtBox, "00000000");
		fillExistingDetails(existingAddLineOne, EmpAddLine1TxtBox, "123 main street");
		fillExistingDetails(existingAddLineTwo, EmpAddLine2TxtBox, "123 main street");
		fillExistingDetails(existingCity, EmpCityTxtBox,"Trenton");
		fillExistingDetails(existingZipCode, EmpZipCodeTxtBox,"08625");
		fillExistingDetails(existingTelephone, EmpTelPhoneTxtBox,"1231231122");
		
		
		
		
		
		/*
		 * if(existingAddLineOne == null ) { web.enterText(EmpAddLine1TxtBox,
		 * "123 main street"); } else { web.enterText(EmpAddLine1TxtBox,
		 * existingAddLineOne); }
		 * 
		 * if(existingAddLineTwo == null ) { web.enterText(EmpAddLine2TxtBox,
		 * "123 main street"); } else { web.enterText(EmpAddLine2TxtBox,
		 * existingAddLineOne); }
		 * 
		 * 
		 * if(existingCity == null ) { web.enterText(EmpCityTxtBox, "Trenton"); } else {
		 * web.enterText(EmpCityTxtBox, existingCity); }
		 */
		
		if(existingState == null ) {
			web.selectOptionByText(EmpStateDropdown, web.getData(prefix+nJEMPIndex+Field.EmpTabState.getColumnName()));
		} else {
			web.selectOptionByText(EmpStateDropdown, existingState);
		}
		
		
	}
	
	private void fillExistingDetails(String existingData, WebElement element, String data) {
		if(existingData == null || existingData.trim().isEmpty()) {
			web.enterText(element, data);
		} else {
			web.enterText(element, existingData);
		}		
	}
	
	
	//Fill NJ Emp Details ************/
	public void fillNJEmpDetails(String prefix) throws InterruptedException {
		
		//web.waitTillElementclickable(existingEmp);
		for(int nJEMPIndex=1;nJEMPIndex<=web.getIntegerValue(web.getData(Field.NoOfNJEmployers.getColumnName()));nJEMPIndex++) {
			if(web.getData(prefix+nJEMPIndex+"AddNJEmployerFlag").equalsIgnoreCase(ApplicationStaticData.YesText)) {
				clickAddNJEmp(); 
				addNewEmpDetails(prefix, nJEMPIndex); 
				alternateWorkInfo(prefix, nJEMPIndex);
				enterFirstLastDOW(web.getData(prefix+nJEMPIndex+Field.FirstDayOfWork.getColumnName()),  web.getData(prefix+nJEMPIndex+Field.LastDayOfWork.getColumnName()));
				selectLagWageOnly(web.getData(prefix+nJEMPIndex+Field.LagWage.getColumnName()));
				selectStillWorkForThisEmp(prefix, nJEMPIndex, web.getData(prefix+nJEMPIndex+Field.StillWorkForThisEmp.getColumnName()), 
						web.getData(prefix+nJEMPIndex+Field.NoLongerWorkEmp.getColumnName()),
						web.getData(prefix+nJEMPIndex+Field.IndicateBestDesSituation.getColumnName()));
				selectRecalledByEmp(prefix, nJEMPIndex);
				enterJobTitle(web.getData(prefix+nJEMPIndex+Field.JobTitle.getColumnName()));
				selectSelfEmpOrBusiness(web.getData(prefix+nJEMPIndex+Field.SelfEmpOrBusiness.getColumnName())); 
				selectOwnerOrAnyBusiness(prefix, nJEMPIndex, web.getData(prefix+nJEMPIndex+Field.OwnerOrAnyBusiness.getColumnName()));
				selectRetirementPayment(web.getData(prefix+nJEMPIndex+Field.RetirementPayment.getColumnName())); 
				selectOtherPay(prefix, nJEMPIndex, web.getData(prefix+nJEMPIndex+Field.OtherPay.getColumnName()));
				selectRetirementPayment(web.getData(prefix+nJEMPIndex+Field.RetirementPayment.getColumnName()));
                web.selectOptionByText(monetaryRC, "MISSING EMPLOYER");                     //JEFFB
				clickOnSavethisEmp();


			} 		
		}
		
		
	}
	
	public void alternateWorkInfo(String prefix, int nJEMPIndex )  {
		
		selectDiffPhysicalWorkLoc(web.getData(prefix+nJEMPIndex+Field.DiffPhysicalWorkLoc.getColumnName()));
		 selectWorkedUnderDiffName(web.getData(prefix+nJEMPIndex+Field.WorkedUnderDiffName.getColumnName()));
		
	}
	
	
	
	
	
	/********** Is your physical work location different than the employer's address above? *****************/
	public void selectDiffPhysicalWorkLoc(String physicalWorkLoc) {
		web.waitTillElementclickable(getQuestionToSelect(Field.DiffPhysicalWorkLoc.getColumnName(),physicalWorkLoc));
		web.clickOn(getQuestionToSelect(Field.DiffPhysicalWorkLoc.getColumnName(),physicalWorkLoc));
	}
	
	
	/********** In the past 18 months, have you worked under a name different from above? *****************/
	public void selectWorkedUnderDiffName(String wrkDiffName) {
		web.waitTillElementclickable(getQuestionToSelect(Field.WorkedUnderDiffName.getColumnName(),wrkDiffName));
		web.clickOn(getQuestionToSelect(Field.WorkedUnderDiffName.getColumnName(), wrkDiffName)); //web.getData(Field.WorkedUnderDiffName.getColumnName()
	}
	
	/******* First and Last Date of Work  
	 * @param nJEMPIndex ****************/
	public void enterFirstLastDOW(String firstDow, String lastDOW)  {
		web.waitTillElementclickable(EmpFirstDOWTxtBox);
		web.clickOn(EmpFirstDOWTxtBox);
		web.enterText(EmpFirstDOWTxtBox, firstDow);
		web.waitTillElementclickable(EmpLastDOWTxtBox);
		web.clickOn(EmpLastDOWTxtBox);
		web.enterText(EmpLastDOWTxtBox,lastDOW);
	
	}
	
	
	/********** Lag Wages Only: 
	 * @param data *****************/
	public void selectLagWageOnly(String data) {
		web.clickOn(getQuestionToSelect(Field.LagWage.getColumnName(),data));
	}
	
	
	/********** Do you still work for this employer? *****************/
	public void selectStillWorkForThisEmp(String prefix, int nJEMPIndex, String YesORNoOption, String NoLongerWorkEmpOption, String BestDesSituation) {
		web.clickOn(getQuestionToSelect(Field.StillWorkForThisEmp.getColumnName(), YesORNoOption)); //web.getData(Field.StillWorkForThisEmp.getColumnName())));
		if(YesORNoOption.equalsIgnoreCase(ApplicationStaticData.NoText)){
			//selectNoLongerWorkEmp(NoLongerWorkEmpOption);
			selectNoLongerWorkEmp(prefix, nJEMPIndex, NoLongerWorkEmpOption);
		} else if(YesORNoOption.equalsIgnoreCase(ApplicationStaticData.YesText)) {
			selectBestDesSituation (prefix, nJEMPIndex, BestDesSituation);
		}
	}
	
	
	/********** Why are you no longer working for this employer? *****************/
	public void selectNoLongerWorkEmp(String prefix, int nJEMPIndex, String NoLongerWorkEmpOption) {
		//web.waitTillElementclickable(getQuestionToSelect(Field.NoLongerWorkEmp.getColumnName(),web.getData(Field.NoLongerWorkEmp.getColumnName())));
		web.selectOptionByText(noLongerWorkEmpDropdown, NoLongerWorkEmpOption);	

		//selectFiredOrQuitResignedOptions(prefix, nJEMPIndex);		
		if(web.getData(prefix+nJEMPIndex+Field.NoLongerWorkEmp.getColumnName()).equalsIgnoreCase(web.getData(Field.FiredDischargedOrTerminated.getColumnName()))) {
			web.enterText(dischargeDate, web.getData(prefix+nJEMPIndex+Field.dischargeDate.getColumnName()));
			web.enterText(ReasonSeparation, web.getData(prefix+nJEMPIndex+Field.Separation.getColumnName()));
		} else if(web.getData(prefix+nJEMPIndex+Field.NoLongerWorkEmp.getColumnName()).equalsIgnoreCase(web.getData(Field.QuitResignedOrRetired.getColumnName()))) {
			
			web.clickOn(getQuestionToSelect(Field.TollOutVerified.getColumnName(), web.getData(prefix+nJEMPIndex+Field.TollOutVerified.getColumnName())));
			
		}
		web.enterUsingJS("txtNJEmpQuitResignedRetiredSepReasonExp",  web.getData(prefix+nJEMPIndex+Field.Separation.getColumnName()));
		
	}


	
	/************* NoLongerWork options FIRED, DISCHARGED OR TERMINATED or 	QUIT, RESIGNED OR RETIRED *******************/
	/*
	
	public void selectFiredOrQuitResignedOptions(String prefix, int nJEMPIndex)  { 
		
		web.waitTillElementclickable(noLongerWorkEmpDropdown);
		
		web.selectOptionByText(noLongerWorkEmpDropdown, web.getData(prefix+nJEMPIndex+Field.PaymentTypeDropDown.getColumnName()));
		
		if(web.getData(prefix+nJEMPIndex+Field.IndicateBestDesSituation.getColumnName()).equalsIgnoreCase(web.getData(Field.FiredDischargedOrTerminated.getColumnName()))) {
		web.enterText(dischargeDate, web.getData(prefix+nJEMPIndex+Field.dischargeDate.getColumnName()));
		web.enterText(ReasonSeparation, web.getData(prefix+nJEMPIndex+Field.Separation.getColumnName()));
		} else if(web.getData(prefix+nJEMPIndex+Field.IndicateBestDesSituation.getColumnName()).equalsIgnoreCase(web.getData(Field.QuitResignedOrRetired.getColumnName()))) {
			web.enterText(ReasonSeparation, web.getData(prefix+nJEMPIndex+Field.Separation.getColumnName()));
			web.clickOn(getQuestionToSelect(Field.TollOutVerified.getColumnName(), web.getData(prefix+nJEMPIndex+Field.TollOutVerified.getColumnName())));
			
		}
	
	}
	*/
	
	
	/********** If yes, please indicate the best description of your situation *****************/
	public void selectBestDesSituation (String prefix, int nJEMPIndex, String BestDesSituation) {
		//web.waitTillElementclickable(getQuestionToSelect(Field.NoLongerWorkEmp.getColumnName(),web.getData(Field.NoLongerWorkEmp.getColumnName())));
		web.selectOptionByText(stillEmpDropdown, BestDesSituation);
		selectRecalledByEmp(prefix, nJEMPIndex);                
			
	}
	
	/******************************* Employer Recalled ******************************************/
	public void selectRecalledByEmp(String prefix, int nJEMPIndex) {
		web.clickOn(getQuestionToSelect(Field.RecalledByEmp.getColumnName(), web.getData(prefix+nJEMPIndex+Field.RecalledByEmp.getColumnName())));
		
		if(web.getData(prefix+nJEMPIndex+Field.RecalledByEmp.getColumnName()).equalsIgnoreCase(ApplicationStaticData.YesText)) {
			web.clickOn(getQuestionToSelect(Field.DefiniteCallBackDate.getColumnName(), web.getData(prefix+nJEMPIndex+Field.DefiniteCallBackDate.getColumnName())));
			if(web.getData(prefix+nJEMPIndex+Field.DefiniteCallBackDate.getColumnName()).equalsIgnoreCase(ApplicationStaticData.YesText)) {
				web.enterText(empRecallDate, web.getData(prefix+nJEMPIndex+Field.EmpRecallDate.getColumnName()));
				
			}
			web.clickOn(getQuestionToSelect(Field.SeasonalWork.getColumnName(), web.getData(prefix+nJEMPIndex+Field.SeasonalWork.getColumnName())));
			
		}
		
	}
	
	/********** Job Title: *****************/
	public void enterJobTitle(String title) {
		web.enterText(JobTitleTxtBox, title);
	}
	
	
	/********** Are you self-employed or the owner of any business? *****************/
	public void selectSelfEmpOrBusiness(String selfEmporBusinessValue) {
		web.clickOn(getQuestionToSelect(Field.SelfEmpOrBusiness.getColumnName(),selfEmporBusinessValue));
		
	}
	
	
	/********** Are you the owner, related to the owner, a corporate officer, or do you have 5% or more equitable *****************/
	/***************Is this business corporation & ********************************************************************************/
	/** If not business, what is your relationship to the owner?   ****************************************************************/
	/******************************************************************************************************************************/
	public void selectOwnerOrAnyBusiness(String prefix, int nJEMPIndex, String selectOwnerOrBusiness) {
		web.clickOn(getQuestionToSelect(Field.OwnerOrAnyBusiness.getColumnName(),selectOwnerOrBusiness));
		if(selectOwnerOrBusiness.equalsIgnoreCase(ApplicationStaticData.YesText)) {
			web.clickOn(getQuestionToSelect(Field.BusCorpOrPartnership.getColumnName(), web.getData(prefix+nJEMPIndex+Field.BusCorpOrPartnership.getColumnName())));
			if(web.getData(prefix+nJEMPIndex+Field.BusCorpOrPartnership.getColumnName()).equalsIgnoreCase(ApplicationStaticData.NoText)) {
			web.selectOptionByText(relationshipToOwner, web.getData(prefix+nJEMPIndex+Field.RelationshipToOwner.getColumnName()));
			}
			
		}
		
	}

	
	
	/********** Are you receiving, or have you received, any type of retirement payment, from any employers *****************/
	public void selectRetirementPayment(String retirementPaymentValue) {
		web.clickOn(getQuestionToSelect(Field.RetirementPayment.getColumnName(),retirementPaymentValue));
		
	}
	
	
	/********** Have you received, or will you receive, any of the following since your last day of work: *****************/
	public void selectOtherPay(String prefix, int nJEMPIndex, String YesORNoOption) {                               
		web.clickOn(getQuestionToSelect(Field.OtherPay.getColumnName(), YesORNoOption)); 
		if(YesORNoOption.equalsIgnoreCase(ApplicationStaticData.YesText)) {
			addPaymentTypes(prefix, nJEMPIndex);
		}
		
	}
	
	
	/*********** Add payment types 
	 * @param prefix ***********************************/
	public void addPaymentTypes(String prefix, int nJEMPIndex)  { 
		
		web.waitTillElementclickable(selectPaymentTypeDrpDown);
		
		web.selectOptionByText(selectPaymentTypeDrpDown, web.getData(prefix+nJEMPIndex+Field.PaymentTypeDropDown.getColumnName()));
		if(web.getData(prefix+nJEMPIndex+Field.PaymentTypeDropDown.getColumnName()).equalsIgnoreCase(web.getData(Field.PaymentTypeHoliday.getColumnName()))) {
		web.enterText(additionalAmountTxtField, web.getData(prefix+nJEMPIndex+Field.PaymentAdditionalAmount.getColumnName()));
		web.enterText(additionalPaymentFromDate, web.getData(prefix+nJEMPIndex+Field.AdditionalPaymentFromDate.getColumnName()));
		web.enterText(additionalPaymentToDate, web.getData(prefix+nJEMPIndex+Field.AdditionalPaymentToDate.getColumnName()));
		} else if(web.getData(prefix+nJEMPIndex+Field.PaymentTypeDropDown.getColumnName()).equalsIgnoreCase(web.getData(Field.PaymentTypeSeverance.getColumnName()))) {
			web.enterText(additionalAmountTxtField, web.getData(prefix+nJEMPIndex+Field.PaymentAdditionalAmount.getColumnName()));
			
		} else if(web.getData(prefix+nJEMPIndex+Field.PaymentTypeDropDown.getColumnName()).equalsIgnoreCase(web.getData(Field.PaymentTypeVacation.getColumnName()))) {
			web.enterText(additionalAmountTxtField, web.getData(prefix+nJEMPIndex+Field.PaymentAdditionalAmount.getColumnName()));
			
		} else if(web.getData(prefix+nJEMPIndex+Field.PaymentTypeDropDown.getColumnName()).equalsIgnoreCase(web.getData(Field.PaymentLastPayCheck.getColumnName()))) {
			web.enterText(additionalAmountTxtField, web.getData(prefix+nJEMPIndex+Field.PaymentAdditionalAmount.getColumnName()));
			
		} else if(web.getData(prefix+nJEMPIndex+Field.PaymentTypeDropDown.getColumnName()).equalsIgnoreCase(web.getData(Field.PaymentTypeInLieuOfNotice.getColumnName()))) {
			web.enterText(additionalAmountTxtField, web.getData(prefix+nJEMPIndex+Field.PaymentAdditionalAmount.getColumnName()));
			web.enterText(additionalPaymentFromDate, web.getData(prefix+nJEMPIndex+Field.AdditionalPaymentFromDate.getColumnName()));
			web.enterText(additionalPaymentToDate, web.getData(prefix+nJEMPIndex+Field.AdditionalPaymentToDate.getColumnName()));
			
		} else if(web.getData(prefix+nJEMPIndex+Field.PaymentTypeDropDown.getColumnName()).equalsIgnoreCase(web.getData(Field.PaymentContinuation.getColumnName()))) {
			web.enterText(additionalAmountTxtField, web.getData(prefix+nJEMPIndex+Field.PaymentAdditionalAmount.getColumnName()));
			web.enterText(additionalPaymentFromDate, web.getData(prefix+nJEMPIndex+Field.AdditionalPaymentFromDate.getColumnName()));
			web.enterText(additionalPaymentToDate, web.getData(prefix+nJEMPIndex+Field.AdditionalPaymentToDate.getColumnName()));
			
		} else if(web.getData(prefix+nJEMPIndex+Field.PaymentTypeDropDown.getColumnName()).equalsIgnoreCase(web.getData(Field.PaymentOtherPay.getColumnName()))) {
			web.enterText(additionalAmountTxtField, web.getData(prefix+nJEMPIndex+Field.PaymentAdditionalAmount.getColumnName()));
			web.enterText(additionalPaymentComment, web.getData(prefix+nJEMPIndex+Field.AdditionalPaymentComments.getColumnName()));
			
			System.out.println("asdadasd");
		} 
		
				
	}
	
	
	
	/******* Continue button Emp Tab*************/
	public void clickOnContinueBtnEmpTab() {
		web.clickOn(empTabContinueBtn);
	}


	
	//public void clickOnContinueBtnEmpTab() {
		//web.clickOn(saveThisEmp);
	//}
	
	
	
	
	
	
}
