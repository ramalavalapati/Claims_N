package com.AutomationFramework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.AutomationFramework.ApplicationStaticData;
import com.AutomationFramework.Field;
import com.AutomationFramework.WebFunctions;

public class EligibilityPage extends BasePage {
	
	@FindBy(name="_eventId_save")
	private WebElement EligsaveContinueButton;
	
	@FindBy(name="disibilityDate")
	private WebElement DateDisabilityStarted;
	
	@FindBy(name="recoveryDate")
	private WebElement DisableRecoverDate;
	
	@FindBy(name="disabilityType")
	private WebElement DisablePlanType;
	
	@FindBy(name="schoolEnrollmentType")
	private WebElement schoolEnrollmentType;
	
    private WebFunctions web;
	
	public EligibilityPage(WebDriver driver, WebFunctions webFunctions) {
		super(driver, webFunctions);
		this.web = webFunctions;
	}
	
	
	/****** Method for identifying xpath for Yes/No questions **************/ 
	   private WebElement getQuestionToSelect(String questionName, String optionToSelect) {
		//return driver.findElement(By.xpath("//label[contains(.,'"+questionName+"')]/../following-sibling::div/label[text()='"+optionToSelect+"']/preceding-sibling::input[1]"));
		return driver.findElement(LoginPage.getQuestionLocator(questionName, optionToSelect));
				
	}
	   
	   
	   /*******   Are you ready, willing and able to immediately work full-time? *****/
		public void selectWillingAbleToWorkFullTime() {		
			web.waitTillElementclickable(getQuestionToSelect(Field.WillingAbleToWorkFullTime.getColumnName(),web.getData(Field.WillingAbleToWorkFullTime.getColumnName())));
			web.clickOn(getQuestionToSelect(Field.WillingAbleToWorkFullTime.getColumnName(),web.getData(Field.WillingAbleToWorkFullTime.getColumnName())));
		}
		
		
		/*******   If offered a job, could you start immediately? *****/
		public void selectOfferedJobStartImmediately() {		
			web.waitTillElementclickable(getQuestionToSelect(Field.OfferedJobStartImmediately.getColumnName(),web.getData(Field.OfferedJobStartImmediately.getColumnName())));
			web.clickOn(getQuestionToSelect(Field.OfferedJobStartImmediately.getColumnName(),web.getData(Field.OfferedJobStartImmediately.getColumnName())));
		}
		
		
		/*******   Since your last day of work, have you collected disability or workers compensation benefits? *****/
		public void selectDisabilityWorkersCompBenefits() {		
			web.waitTillElementclickable(getQuestionToSelect(Field.DisabilityWorkersCompBenefits.getColumnName(),web.getData(Field.DisabilityWorkersCompBenefits.getColumnName())));
			web.clickOn(getQuestionToSelect(Field.DisabilityWorkersCompBenefits.getColumnName(),web.getData(Field.DisabilityWorkersCompBenefits.getColumnName())));
		}
		
		
		/*******   Were you disabled immediately before filing this claim? *****/
		public void selectDisabledBeforeFilingClaim() {		
			web.waitTillElementclickable(getQuestionToSelect(Field.DisabledBeforeFilingClaim.getColumnName(),web.getData(Field.DisabledBeforeFilingClaim.getColumnName())));
			web.clickOn(getQuestionToSelect(Field.DisabledBeforeFilingClaim.getColumnName(),web.getData(Field.DisabledBeforeFilingClaim.getColumnName())));
			if(web.getData(Field.DisabledBeforeFilingClaim.getColumnName()).equalsIgnoreCase(ApplicationStaticData.YesText)) {
				disableBeforeClaimingYes();
				
			}
		}
		
		/*******************************************************************
		 * If "Yes", what was the date your disability started?            *
		 * Disability Recover Date                                         *
		 * Contact Last Employer for More work                             *
		 * Release with any medical restriction                            *
		 * *******************************************************************/
		public void disableBeforeClaimingYes() {
			web.waitTillElementclickable(DateDisabilityStarted);
			//web.waitTillElementclickable(getQuestionToSelect(Field.DisabilityStartDate.getColumnName(),web.getData(Field.DisabilityStartDate.getColumnName())));
			//web.clickOn(getQuestionToSelect(Field.DisabilityStartDate.getColumnName(),web.getData(Field.DisabilityStartDate.getColumnName())));
			web.enterText(DateDisabilityStarted, web.getData(Field.DisabilityStartDate.getColumnName()));
			web.enterText(DisableRecoverDate, web.getData(Field.DisabilityRecoveryDate.getColumnName()));
			web.selectOptionByText(DisablePlanType, web.getData(Field.DisabilityPlan.getColumnName()));
			
			web.clickOn(getQuestionToSelect(Field.ContactLastEmpForMoreWrk.getColumnName(),web.getData(Field.ContactLastEmpForMoreWrk.getColumnName())));
			web.clickOn(getQuestionToSelect(Field.ReleasedWithMedicalRestriction.getColumnName(),web.getData(Field.ReleasedWithMedicalRestriction.getColumnName())));
			
		}
		
		
		/*******   Are you currently attending school, job training or college? *****/
		public void selectAttendtingTrainingOrCollege() {		
			web.waitTillElementclickable(getQuestionToSelect(Field.AttendtingTrainingOrCollege.getColumnName(),web.getData(Field.AttendtingTrainingOrCollege.getColumnName())));
			web.clickOn(getQuestionToSelect(Field.AttendtingTrainingOrCollege.getColumnName(),web.getData(Field.AttendtingTrainingOrCollege.getColumnName())));
			if(web.getData(Field.AttendtingTrainingOrCollege.getColumnName()).equalsIgnoreCase(ApplicationStaticData.YesText)) {
				selectSelfEnroll();
			}
		}
		
		
		/*************self-enroll through Union *********************/
		public void selectSelfEnroll() {
			web.selectOptionByText(schoolEnrollmentType, web.getData(Field.SelfEnrollInSchool.getColumnName()));
		}
		
		
	
		public void clickOnSaveContinueButton() {
			web.waitTillElementclickable(EligsaveContinueButton);
			web.clickOn(EligsaveContinueButton);
		}
	

}
