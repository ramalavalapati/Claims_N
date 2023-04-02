package com.AutomationFramework;

import java.util.Map;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.AutomationFramework.SSI.pages.SSI_GeneralInformationPage;
import com.AutomationFramework.SSI.pages.SSI_LoginPage;
import com.AutomationFramework.SSI.pages.SSI_PreQualificationPage;
import com.AutomationFramework.SSI.pages.SSI_ResidenceAddressVerificationPage;
import com.AutomationFramework.pages.AddFederalEmployerPage;
import com.AutomationFramework.pages.AddMilitaryEmployerPage;
import com.AutomationFramework.pages.AddOutOfStateEmployerPage;
import com.AutomationFramework.pages.AdjudicationSummaryPage;
import com.AutomationFramework.pages.CertifySubmitPage;
import com.AutomationFramework.pages.ClaimantPage;
import com.AutomationFramework.pages.EligibilityPage;
import com.AutomationFramework.pages.EmploymentPage;
import com.AutomationFramework.pages.LoginPage;

public class SSITC extends BaseTest{
	public SSITC() {}
	
	@Factory(dataProvider = "testdata")
	public SSITC(Map<Object,Object> testdataSet) {
		setTestData(testdataSet);
	}	
	
	
	@Test
	public void createClaimsInitialApp() throws Exception {
		SSI_LoginPage loginPage = new SSI_LoginPage(getDriver(), getWebFunctions());
		loginPage.loginToApp();
		loginPage.clickOnFileANewClaimLink();
		loginPage.clikcOnFileAClaimBtn();
		loginPage.clickOnFileAClaimHomeContinueBtn();
		
		
		SSI_PreQualificationPage ssiPreQualificationPage = new SSI_PreQualificationPage(getDriver(), getWebFunctions());
		ssiPreQualificationPage.SelectLiveInUS();
		ssiPreQualificationPage.SelectRecentEmployment();
		ssiPreQualificationPage.SelectMilitaryService();
		ssiPreQualificationPage.SelectFedEmployment();
		ssiPreQualificationPage.SelectOutOfStateEmployment();
		ssiPreQualificationPage.SelMaritimeEmployment();
		ssiPreQualificationPage.SelectDisability();
		ssiPreQualificationPage.ClickOnContinueBtnPreQualification();
		ssiPreQualificationPage.ClickOnDoNotHavePin();
		
		
		//SSI_GeneralInformationPage
		SSI_GeneralInformationPage ssiGeneralInformationPage = new SSI_GeneralInformationPage(getDriver(), getWebFunctions());
		ssiGeneralInformationPage.SelectGender();
		ssiGeneralInformationPage.SelectIdentificationTypeNJDL();
		ssiGeneralInformationPage.SelectWrkUnderDifferentName();
		ssiGeneralInformationPage.SelectLivedInOutOfState();
		ssiGeneralInformationPage.SelectContinueSeekingWrkInNJ();
		ssiGeneralInformationPage.SelectClaimInOtherThanNJState();
		ssiGeneralInformationPage.ClickOnGeneralInfoPageContinuBtn();
		
		
		//SSI_ResidenceAddressVerificationPage
		SSI_ResidenceAddressVerificationPage ssiResidenceAddPage = new SSI_ResidenceAddressVerificationPage(getDriver(), getWebFunctions());
		ssiResidenceAddPage.FillResidenceAddressDetails();
		ssiResidenceAddPage.ClickOnResidenceAddressContinueBtn();
		ssiResidenceAddPage.ClickOnMailingAddYesOrNo();
		ssiResidenceAddPage.ClickOnAddVerificationConContinueBtn();
		
		
		
		
		
		
		
		
		
		
		/*loginPage.enterSSN();
		
		 * System.out.println("SSN Number is: "+getWebFunctions().getData("SSNNumber")
		 * ); //loginPage.enterSSN(true); loginPage.clickOnSearchButton();
		 * //loginPage.clickOnFileAClaimButton(); loginPage.SelectPUSResident();
		 * loginPage.SelectPEmpPast18Months(); //loginPage.SelectPAllWorkInNJ();
		 * //loginPage.SelectPAnyWorkInNJQ(); loginPage.SelectPMilitaryPast18MonthsQ();
		 * loginPage.SelectPFedPast18MonthsQ(); loginPage.SelectPOutOfStateEmpQ();
		 * loginPage.SelectPMaritimeEmpQ(); loginPage.SelectionPUnableToWorkQ();
		 * loginPage.clickOnSaveContinueButton();
		 */
		
		
		/*
		ClaimantPage claimantPage = new ClaimantPage(getDriver(), getWebFunctions());
		claimantPage.enterFirstName();
		claimantPage.enterMiddleInit();
		claimantPage.enterLastName();
		claimantPage.selectsuffix();
		
		claimantPage.enterDateOfBirth();
		claimantPage.selectGender();
		claimantPage.selectRace();
		claimantPage.selectEthinicity();
		claimantPage.selectEducationLevel();
		claimantPage.selectmainWageEarner();
		claimantPage.selectCDoYouNeedInterpreter();
		//claimantPage.selectCLanguageSpeak();
		
		claimantPage.selectBenefitsDeducted();
		
		claimantPage.selectLiveOutOfState();
		claimantPage.selectUnemploymentBenefitsOtherThanNJ();
		claimantPage.selectUSCitizen();
		claimantPage.enterResidenceAddress();
		claimantPage.selectCMialingAddDiff();
		claimantPage.enterContactInfo();
		claimantPage.selectUnionHiringHall();
		claimantPage.searchWithJobDetails();
		claimantPage.clickOnSearchButton();
		claimantPage.selectFirstResult();
		claimantPage.clickOnSaveContinueButton();		
		claimantPage.verifyClaimantFormStatus();
		
		EligibilityPage eligibilityPage = new EligibilityPage(getDriver(), getWebFunctions());
		
		eligibilityPage.selectWillingAbleToWorkFullTime();
		eligibilityPage.selectOfferedJobStartImmediately();
		eligibilityPage.selectDisabilityWorkersCompBenefits();
		eligibilityPage.selectDisabledBeforeFilingClaim();
		eligibilityPage.selectAttendtingTrainingOrCollege();
		eligibilityPage.clickOnSaveContinueButton();
		
		
		//Adding New Emp NJ
		EmploymentPage employmentPage = new EmploymentPage(getDriver(), getWebFunctions());
		employmentPage.updateLoopsIncompleteEmpDetailsIfAvailable(ApplicationStaticData.LoopsNJPrefixText);
		employmentPage.fillNJEmpDetails(ApplicationStaticData.NJPrefixText);	
		
		
		/************************
		//Adding Military Emp
		AddMilitaryEmployerPage addMilitaryEmpPage = new AddMilitaryEmployerPage(getDriver(), getWebFunctions());
		addMilitaryEmpPage.verifyAddNewMilitaryButtonDisplayed();
		addMilitaryEmpPage.fillAddNewMilitaryEmployerPage();
		
		
		//Adding Fed Emp
		AddFederalEmployerPage addFederalEmpPage = new AddFederalEmployerPage(getDriver(), getWebFunctions());
		addFederalEmpPage.verifyAddNewFederalButtonDisplayed();
		addFederalEmpPage.fillAddNewFederalEmployerPage();
		
		//Adding OutOfState Emp
		AddOutOfStateEmployerPage addOutOfStateEmpPage = new AddOutOfStateEmployerPage(getDriver(), getWebFunctions());
		addOutOfStateEmpPage.verifyAddNewOutOfStateEmpButtonDisplayed();
		addOutOfStateEmpPage.fillAddNewOutOfStateEmpPage();
		****************************************/
		
		/*
		
		  employmentPage.clickOnContinueBtnEmpTab();
		  
		  
		  AdjudicationSummaryPage AdjSummaryPage = new
		  AdjudicationSummaryPage(getDriver(), getWebFunctions());
		  AdjSummaryPage.clickOnContinueBtnAdjSummaryPage();
		  
		  
		  CertifySubmitPage certifySubmitPage = new CertifySubmitPage(getDriver(), getWebFunctions()); 
		  //certifySubmitPage.dateOfClaim();
		  certifySubmitPage.clickOnFinalCertifySubmit();
		  
		  
		  /****************Additonal claim flow ****************/
		  //Filed verified
		  // Click on File a Claim
		  //Address/update title verify
		  //Create separate method for address/update tab
		  //click on continue on Claimant tab
		  //Verify header for Reopener tab and create method to fill all reopener tab questions.
		//Employment - If Yes - {
		  						  //If {one method to add new employer}
								  //else{
									  //one more method to update existing employer
						
								  //}
						//}	else condition -   //Employement - If NO - If else - One method and click on contineue
		  
		 
		
		

		  System.out.println("dfddg");
	}
	
	
	
	/*
	 * public void verify() { LoginPage loginPage = new LoginPage(getDriver(),
	 * getWebFunctions());
	 * 
	 * }
	 */
	
	
}
