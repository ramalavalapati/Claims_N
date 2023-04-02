package com.AutomationFramework.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.AutomationFramework.ApplicationStaticData;
import com.AutomationFramework.Field;
import com.AutomationFramework.WebFunctions;

public class ClaimantPage extends BasePage {
	
	@FindBy(name="firstName")
	private WebElement FirstNameTxtBox;
	
	
	@FindBy(name="middleInit")
	private WebElement MiddleInitialTxtBox;
	
	@FindBy(name="lastName")
	private WebElement LastNameTxtBox;
	
	@FindBy(xpath="//select[@name='suffix']")
	private WebElement suffixDropdown;	
	
	@FindBy(xpath="//label[contains(text(),'What is your main occupation?')]/following::input[@name='usrEnteredJobTitle']")
	private WebElement mainOccupationQuestion;
	
	@FindBy(xpath="//label[contains(text(),'What is your job description?')]/following::textarea[@name='usrEnteredJobDescription']")
	private WebElement jobDescriptionQuestion;
	
	@FindBy(xpath="//input[@value='Search for Occupation']")
	private WebElement searchButton;
	
	
	@FindBy(xpath="//table[@id='resultsTable']//td/input")
	private WebElement resultTableFirstButton;
	
	@FindBy(name="dateOfBirth")
	private WebElement DateOfBirthTxtBox;
	
	@FindBy(xpath="//select[@name='sex']")
	private WebElement genderDropdown;
	
	@FindBy(xpath="//select[@name='raceCode']")
	private WebElement raceDropdown;
	
	@FindBy(xpath="//select[@name='ethnicCodes']")
	private WebElement ethnicityDropdown;
	
	@FindBy(xpath="//select[@name='education']")
	private WebElement educationLevelDropdown;
	
	@FindBy(xpath="//select[@name='mainWageEarner']")
	private WebElement mainWageEarner;
	
	@FindBy(xpath="//select[@name='languageInterpreter']")
	private WebElement languageInterpreterDropdown;
	
	@FindBy(xpath="//select[@id='selectFiledInOtherState']")
	private WebElement UnemploymentBenefitsOtherThanNJDropdown;
	
	@FindBy(xpath="//select[@name='resCountryOfResidence']")
	private WebElement resCountryTerritoryDropdown;
	
	//selectAlienType
	@FindBy(xpath= "//select[@name='alienType']")
	private WebElement alienRegTypeDropDpwn;
	
	//AlienRegNum
	@FindBy(id="txtAlienRegNumber")
	private WebElement AlienRegNumTxtBox;
	
	//CountryOfOriginDropDown
	@FindBy(xpath="//select[@name='countryOfOrigin']")
	private WebElement CountryOfOriginDropDown;
	
	//workAuthDocDropDpwn
	@FindBy(xpath=("//select[@id='selectAlienDocumentType']"))
	private WebElement workAuthDocDropDown;
	
	//EAD From date
	@FindBy(id="workAuthorizationFromDate")
	private WebElement workAuthorizationFromDate;
	
	//EAD To date
	@FindBy(id="workAuthorizationToDate")
	private WebElement workAuthorizationToDate;
	
	//Permanent Resident Card, Expiration Date:
	@FindBy(id="permResCardExpiryDate")
	private WebElement permResCardExpDate;
	
	//AlienNameDiff First Name
	@FindBy(id = "txtAlienNameDifferentFirst")
	private WebElement AlienDiffFirstName;
	
	//AlienNameDiff First Name
		@FindBy(id = "txtAlienNameDifferentLast")
		private WebElement AlienDiffLastName;
	
	@FindBy(name="resStreet")
	private WebElement ResStreetTxtBox;
	
	@FindBy(name="resCity")
	private WebElement ResCityTxtBox;
	
	@FindBy(xpath="//select[@name='resState']")
	private WebElement resStateDropdown;
	
	@FindBy(name="resZip")
	private WebElement ResZipTxtBox;
	
	@FindBy(xpath="//select[@name='mailCountryOfResidence']")
	private WebElement mailCountryTerritoryDropdown;
	
	@FindBy(name="mailStreet")
	private WebElement mailStreetTxtBox;
	
	@FindBy(name="mailCity")
	private WebElement mailCityTxtBox;
	
	@FindBy(xpath="//select[@name='mailState']")
	private WebElement mailStateDropdown;
	
	@FindBy(name="mailZip")
	private WebElement mailZipTxtBox;
	
	@FindBy(name="claimantPhone")
	private WebElement MainTelPhoneTxtBox;
	
	@FindBy(name="altPhone")
	private WebElement AltTelPhoneTxtBox;
	
	@FindBy(name="email")
	private WebElement emailTxtBox;
	
	@FindBy(name="hireHallNum")
	private WebElement UnionHiringNumTxtBox;
	
	@FindBy(name="localName")
	private WebElement UnionHiringNameTxtBox;
	
	@FindBy(name="MunicipalityCodeVerifyButton")
	private WebElement MunicipalityCodeVerifyButton;
	
	@FindBy(name= "MailingAddressVerifyButton")
	private WebElement MailingAddressVerifyBtn;
	
	@FindBy(id="eventId_checkError")
	private WebElement ClaimantsaveContinueButton;
	
	@FindBy(xpath="//li[@id='claimant']//i[contains(@class,'check')]")
	private WebElement claimantTabStatus;
	
	@FindBy(xpath ="//table[@class='consumerAddressEditView']")
	private List<WebElement> ResUnitedStatesPostalService;
	
	@FindBy(xpath="//input[@name='consumerAddressRadio' and @value='2']")
	private WebElement KeepResAddRadioBtn;
	
	
	@FindBy(xpath ="(//table[@class='consumerAddressEditView'])[2]")
	private List<WebElement> MailUnitedStatesPostalService;
	
	@FindBy(xpath="(//table[@class='consumerAddressEditView']/tbody/tr[2]/td/p[@class='consumerRadioCls'])[2]")
	private WebElement KeepMailAddRadioBtn;
	
	
	
	private WebFunctions web;
	
	public ClaimantPage(WebDriver driver, WebFunctions webFunctions) {
		super(driver, webFunctions);
		this.web = webFunctions;
	}
	
	
	private WebElement getQuestionToSelect(String questionName, String optionToSelect) {
		//return driver.findElement(By.xpath("//label[contains(.,'"+questionName+"')]/../following-sibling::div/label[text()='"+optionToSelect+"']/preceding-sibling::input[1]"));
		return driver.findElement(LoginPage.getQuestionLocator(questionName, optionToSelect));
				
	}
	

	public  WebElement getQuestionLocatorcontainssinglequote(String questionName, String optionToSelect) {
		return  driver.findElement(By.xpath("//label[normalize-space(text())= \""+questionName+"\"]/ancestor::div[contains(@class,'fieldHeader')]//div/label[contains(text(),'"+optionToSelect+"')]/preceding-sibling::input[1]"));
	}
	
	
	public void enterFirstName() {
		web.enterText(FirstNameTxtBox, web.getData(Field.FirstName.getColumnName()));
	}
	
	
	
	public void enterMiddleInit() {
		web.enterText(MiddleInitialTxtBox, web.getData(Field.MiddleInit.getColumnName()));
	}
	
	
	public void enterLastName() {
		web.enterText(LastNameTxtBox, web.getData(Field.LastName.getColumnName()));
	}
	
	public void selectsuffix() {
		web.selectOptionByValue(suffixDropdown, web.getData(Field.SUFFIX.getColumnName()));
	}
	
	public void enterDateOfBirth() {
		web.waitTillElementclickable(DateOfBirthTxtBox);
		web.clickOn(DateOfBirthTxtBox);
		web.enterText(DateOfBirthTxtBox, web.getData(Field.DateOfBirth.getColumnName()));
	}
	
	public void selectGender() {
		web.waitTillElementclickable(genderDropdown);
		web.selectOptionByText(genderDropdown, web.getData(Field.Gender.getColumnName()));
	}
	
	public void selectRace() {
		web.waitTillElementclickable(raceDropdown);
		web.selectOptionByText(raceDropdown, web.getData(Field.Race.getColumnName()));
		System.out.println("race values: "+web.getData(Field.Race.getColumnName()));
	}
	
	public void selectEthinicity() {
		web.waitTillElementclickable(ethnicityDropdown);
		web.selectOptionByText(ethnicityDropdown, web.getData(Field.Ethnicity.getColumnName()));
		System.out.println("Ethnicity values: "+web.getData(Field.Ethnicity.getColumnName()));
	}
	
	public void selectEducationLevel() {
		web.waitTillElementclickable(educationLevelDropdown);
		web.selectOptionByValue(educationLevelDropdown, web.getData(Field.EducationalLevel.getColumnName()));
	}
	
	/********** Main Wage Earner *****************/
	public void selectmainWageEarner() {
		//web.selectOptionByValue(mainWageEarner, web.getData(Field.MainWageEarner.getColumnName()));
		web.waitTillElementclickable(getQuestionToSelect(Field.MainWageEarner.getColumnName(),web.getData(Field.MainWageEarner.getColumnName())));
		web.clickOn(getQuestionToSelect(Field.MainWageEarner.getColumnName(),web.getData(Field.MainWageEarner.getColumnName())));
	}
	
	
	
	/*******   Do you need an interpreter? *****/
	
	public void selectCDoYouNeedInterpreter() {		
		web.waitTillElementclickable(getQuestionToSelect(Field.Interpreter.getColumnName(),web.getData(Field.Interpreter.getColumnName())));
		web.clickOn(getQuestionToSelect(Field.Interpreter.getColumnName(),web.getData(Field.Interpreter.getColumnName())));
		if(web.getData(Field.Interpreter.getColumnName()).equalsIgnoreCase(ApplicationStaticData.YesText)){
			selectCLanguageSpeak();
		} 
	}
	
	
	/*******   Interpreter Language from dropdown list *****/
	public void selectCLanguageSpeak() {		
		web.waitTillElementclickable(languageInterpreterDropdown);
		web.selectOptionByText(languageInterpreterDropdown, web.getData(Field.SelectLanguage.getColumnName()));
	}
	
	
	/********** 10% benefits deducted *****************/
	public void selectBenefitsDeducted() {
		//web.selectOptionByValue(mainWageEarner, web.getData(Field.MainWageEarner.getColumnName()));
		web.waitTillElementclickable(getQuestionToSelect(Field.BenefitsDeducted.getColumnName(),web.getData(Field.BenefitsDeducted.getColumnName())));
		web.clickOn(getQuestionToSelect(Field.BenefitsDeducted.getColumnName(),web.getData(Field.BenefitsDeducted.getColumnName())));
	}
	
	/********** Dependents Claimed *****************/                                                                                                      //JJB
	public void selectDependentsClaimed() {                                                                                                                //JJB
		web.waitTillElementclickable(getQuestionToSelect(Field.DependentsClaimed.getColumnName(),web.getData(Field.DependentsClaimed.getColumnName())));   //JJB
		web.clickOn(getQuestionToSelect(Field.DependentsClaimed.getColumnName(),web.getData(Field.DependentsClaimed.getColumnName())));                    //JJB
	}
	
	
	/********** worked in NJ, live out of state *****************/
	public void selectLiveOutOfState() {
		//web.selectOptionByValue(mainWageEarner, web.getData(Field.MainWageEarner.getColumnName()));
		web.waitTillElementclickable(getQuestionToSelect(Field.LiveOutOfState.getColumnName(),web.getData(Field.LiveOutOfState.getColumnName())));
		web.clickOn(getQuestionToSelect(Field.LiveOutOfState.getColumnName(),web.getData(Field.LiveOutOfState.getColumnName())));
		if(web.getData(Field.LiveOutOfState.getColumnName()).equalsIgnoreCase(ApplicationStaticData.YesText)){
			selectSeekingWorkInNJ();
		}
	}
	
	/*******   Will you continue seeking work in New Jersey? *****/
	public void selectSeekingWorkInNJ() {		
		web.waitTillElementclickable(getQuestionToSelect(Field.SeekingWorkInNJ.getColumnName(),web.getData(Field.SeekingWorkInNJ.getColumnName())));
		web.clickOn(getQuestionToSelect(Field.SeekingWorkInNJ.getColumnName(),web.getData(Field.SeekingWorkInNJ.getColumnName())));
	}
	
	
	/********** unemployment benefits other than NJ in past 12 months *****************/
	public void selectUnemploymentBenefitsOtherThanNJ() {
		//web.selectOptionByValue(mainWageEarner, web.getData(Field.MainWageEarner.getColumnName()));
		web.waitTillElementclickable(getQuestionToSelect(Field.UnemploymentBenefitsOtherThanNJ.getColumnName(),web.getData(Field.UnemploymentBenefitsOtherThanNJ.getColumnName())));
		web.clickOn(getQuestionToSelect(Field.UnemploymentBenefitsOtherThanNJ.getColumnName(),web.getData(Field.UnemploymentBenefitsOtherThanNJ.getColumnName())));
		if(web.getData(Field.UnemploymentBenefitsOtherThanNJ.getColumnName()).equalsIgnoreCase(ApplicationStaticData.YesText)){
			selectUnemploymentBenfitsOtherThanNJState();
		}
	}
	
	
	/*******   Unemployment benefits other than NJ, Select other state *****/
	public void selectUnemploymentBenfitsOtherThanNJState() {		
		web.waitTillElementclickable(UnemploymentBenefitsOtherThanNJDropdown);
		web.selectOptionByText(UnemploymentBenefitsOtherThanNJDropdown, web.getData(Field.UnemploymentBeneftsSelectState.getColumnName()));
	}
	
	/********** US Citizen or Not US Citizen *****************/
	public void selectUSCitizen() {
		//web.selectOptionByValue(mainWageEarner, web.getData(Field.MainWageEarner.getColumnName()));
		web.waitTillElementclickable(getQuestionToSelect(Field.USCitizen.getColumnName(),web.getData(Field.USCitizen.getColumnName())));
		web.clickOn(getQuestionToSelect(Field.USCitizen.getColumnName(),web.getData(Field.USCitizen.getColumnName())));
		if(web.getData(Field.USCitizen.getColumnName()).equalsIgnoreCase(ApplicationStaticData.NoText)){
			//selectH1B();
			selectAienAType();
			nameDiffThanClaimantName();
			
		}
	}
	
	/******** Selecting H1B   ************/
	public void selectH1B() {
		//web.selectOptionByValue(mainWageEarner, web.getData(Field.MainWageEarner.getColumnName()));
		web.waitTillElementclickable(getQuestionToSelect(Field.USCitizen.getColumnName(),web.getData(Field.USCitizen.getColumnName())));
		web.waitTillElementclickable(alienRegTypeDropDpwn);
		web.selectOptionByText(alienRegTypeDropDpwn, web.getData(Field.AlienRegType.getColumnName()));
	}
	
	
	
	/*****  Selecting Alien Type   ***********/
	public void selectAienAType() {
		//web.selectOptionByValue(mainWageEarner, web.getData(Field.MainWageEarner.getColumnName()));
		//web.waitTillElementclickable(getQuestionToSelect(Field.USCitizen.getColumnName(),web.getData(Field.USCitizen.getColumnName())));
		web.waitTillElementclickable(alienRegTypeDropDpwn);
		web.selectOptionByText(alienRegTypeDropDpwn, web.getData(Field.AlienRegType.getColumnName()));
		//if(web.getData(Field.AlienRegType.getColumnName()).equalsIgnoreCase(web.getData(Field.AlienRegisterType_H1B.getColumnName()))) {
		if(web.getData(Field.alienRegTypeDropDpwn.getColumnName()).equalsIgnoreCase(web.getData(Field.AlienRegisterType_H1B.getColumnName()))) {
			//web.selectOptionByText(alienRegTypeDropDpwn, web.getData(Field.AlienRegType.getColumnName()));
		//} else if((web.getData(Field.AlienRegType.getColumnName()).equalsIgnoreCase(web.getData(Field.AlienRegisterType_A.getColumnName())))) {
		} else 
		{ 
			web.getData(Field.alienRegTypeDropDpwn.getColumnName()).equalsIgnoreCase(web.getData(Field.AlienRegisterType_A.getColumnName()));
			//web.selectOptionByText(alienRegTypeDropDpwn, web.getData(Field.AlienRegType.getColumnName()));
			web.enterText(AlienRegNumTxtBox, web.getData(Field.AlienRegNum.getColumnName()));
			web.selectOptionByText(CountryOfOriginDropDown, web.getData(Field.CountryOfOrigin.getColumnName()));
			web.waitTillElementclickable(getQuestionToSelect(Field.AlienAuthorizedToWork.getColumnName(),web.getData(Field.AlienAuthorizedToWork.getColumnName())));
		web.clickOn(getQuestionToSelect(Field.AlienAuthorizedToWork.getColumnName(),web.getData(Field.AlienAuthorizedToWork.getColumnName())));
		
		if(web.getData(Field.AlienAuthorizedToWork.getColumnName()).equalsIgnoreCase(ApplicationStaticData.YesText)){
			EADOrPermanentRes();
		}
		
		}
	}
	
	
	//Selecting Work Authorization document and dates
	public void EADOrPermanentRes() {
		web.waitTillElementclickable(workAuthDocDropDown);
		web.selectOptionByText(workAuthDocDropDown, web.getData(Field.workAuthDocDropDown.getColumnName()));
		if (web.getData(Field.workAuthDocDropDown.getColumnName()).equalsIgnoreCase(web.getData(Field.WorkAuthorizationDropdownOption1.getColumnName()))) {
			web.enterText(workAuthorizationFromDate, web.getData(Field.workAuthorizationFromDate.getColumnName()));
			web.enterText(workAuthorizationToDate, web.getData(Field.workAuthorizationToDate.getColumnName()));
		}
		
		else { web.getData(Field.workAuthDocDropDown.getColumnName()).equalsIgnoreCase(web.getData(Field.WorkAuthorizationDropdownOption2.getColumnName()));
			   web.enterText(permResCardExpDate, web.getData(Field.perResCardExpDate.getColumnName()));
		}
		
	}
	
	
	//Alien name different	
	public void nameDiffThanClaimantName() {
		web.clickOn(getQuestionLocatorcontainssinglequote(Field.nameDiffThanClaimantName.getColumnName(), web.getData(Field.nameDiffThanClaimantName.getColumnName())));
		if(web.getData(Field.nameDiffThanClaimantName.getColumnName()).equalsIgnoreCase(ApplicationStaticData.YesText)) {
			web.enterText(AlienDiffFirstName, web.getData(Field.AlienFirstName.getColumnName()));
			web.enterText(AlienDiffLastName, web.getData(Field.AlienLastName.getColumnName()));
		}
	}
	
	
	
	/********** Residence Address *****************/
	public void enterResidenceAddress() {
		//web.selectOptionByValue(mainWageEarner, web.getData(Field.MainWageEarner.getColumnName()));    CountryTerritoryDropdown
		web.waitTillElementclickable(resCountryTerritoryDropdown);
		web.selectOptionByText(resCountryTerritoryDropdown, web.getData(Field.ResCountryTerritoryOfResidence.getColumnName()));
		
		web.waitTillElementclickable(ResStreetTxtBox);
		web.enterText(ResStreetTxtBox, web.getData(Field.ResStreet.getColumnName()));
		
		web.waitTillElementclickable(ResCityTxtBox);
		web.enterText(ResCityTxtBox, web.getData(Field.ResCity.getColumnName()));
		
		web.waitTillElementclickable(resStateDropdown);
		web.selectOptionByText(resStateDropdown, web.getData(Field.ResState.getColumnName()));
		
		web.waitTillElementclickable(ResZipTxtBox);
		web.enterText(ResZipTxtBox, web.getData(Field.ResZipCode.getColumnName()));
		
		
		web.waitTillElementclickable(MunicipalityCodeVerifyButton);
		web.clickOn(MunicipalityCodeVerifyButton);
		
		chooseResAddEntered();
		
	}
	
	
	
	
	
	/*******   Mailling Address Different from residence *****/
	
	public void selectCMialingAddDiff() {		
		web.waitTillElementclickable(getQuestionToSelect(Field.MailingAddDiff.getColumnName(),web.getData(Field.MailingAddDiff.getColumnName())));
		web.clickOn(getQuestionToSelect(Field.MailingAddDiff.getColumnName(),web.getData(Field.MailingAddDiff.getColumnName())));
		if(web.getData(Field.MailingAddDiff.getColumnName()).equalsIgnoreCase(ApplicationStaticData.YesText)){
			
			enterMailingAddress();
			
		}
	}
	
	

	
	/********** Mailing Address *****************/
	public void enterMailingAddress() {
		//web.selectOptionByValue(mainWageEarner, web.getData(Field.MainWageEarner.getColumnName()));    CountryTerritoryDropdown
		web.waitTillElementclickable(mailCountryTerritoryDropdown);
		web.selectOptionByText(mailCountryTerritoryDropdown, web.getData(Field.MailCountryTerritoryOfResidence.getColumnName()));
		
		web.waitTillElementclickable(mailStreetTxtBox);
		web.enterText(mailStreetTxtBox, web.getData(Field.MailStreet.getColumnName()));
		
		web.waitTillElementclickable(mailCityTxtBox);
		web.enterText(mailCityTxtBox, web.getData(Field.MailCity.getColumnName()));
		
		web.waitTillElementclickable(mailStateDropdown);
		web.selectOptionByText(mailStateDropdown, web.getData(Field.MailState.getColumnName()));
		
		web.waitTillElementclickable(mailZipTxtBox);
		web.enterText(mailZipTxtBox, web.getData(Field.MailZipCode.getColumnName()));
		
		web.waitTillElementclickable(MailingAddressVerifyBtn);
		web.clickOn(MailingAddressVerifyBtn);
		
		chooseMailAddEntered();
		
	}
	
	
	
	/**********Residential Address The United States Postal Service recommends ********************/
	public void chooseResAddEntered() {
		
		if(ResUnitedStatesPostalService.size()>0 && ResUnitedStatesPostalService.get(0).isDisplayed()) {
			web.waitTillElementclickable(KeepResAddRadioBtn);
			web.clickOn(KeepResAddRadioBtn);
			
	}
		
	}
	
	
	/**********Residential Address The United States Postal Service recommends ********************/
	public void chooseMailAddEntered() {
		
		if(MailUnitedStatesPostalService.size()>0 && MailUnitedStatesPostalService.get(0).isDisplayed()) {
			web.waitTillElementclickable(KeepMailAddRadioBtn);
			web.clickOn(KeepMailAddRadioBtn);
			
	}
		
	}
	
	
	
	
	
	
	/********** Contact Information 
	 * @throws InterruptedException *****************/
	public void enterContactInfo() throws InterruptedException {
		//web.selectOptionByValue(mainWageEarner, web.getData(Field.MainWageEarner.getColumnName()));    CountryTerritoryDropdown
		//web.waitTillElementclickable(MainTelPhoneTxtBox);
		Thread.sleep(1000);
		web.enterText(MainTelPhoneTxtBox, web.getData(Field.MainTel.getColumnName()));
		
		//web.waitTillElementclickable(ResStreetTxtBox);
		web.enterText(AltTelPhoneTxtBox, web.getData(Field.AltTel.getColumnName()));
		
		web.enterText(emailTxtBox, web.getData(Field.Email.getColumnName()));
		
	}
	
	/*******   Union Hiring hall *****/
	
	public void selectUnionHiringHall() {		
		web.waitTillElementclickable(getQuestionToSelect(Field.UnionHiringHall.getColumnName(),web.getData(Field.UnionHiringHall.getColumnName())));
		web.clickOn(getQuestionToSelect(Field.UnionHiringHall.getColumnName(),web.getData(Field.UnionHiringHall.getColumnName())));
		if(web.getData(Field.UnionHiringHall.getColumnName()).equalsIgnoreCase(ApplicationStaticData.YesText)){
			enterUnionHiringNumAndName();
		}
	}
	
	
	/*******   Union Hiring hall *****/
	
	public void enterUnionHiringNumAndName() {
		
		web.waitTillElementclickable(UnionHiringNumTxtBox);
		web.enterText(UnionHiringNumTxtBox, web.getData(Field.UnionHiringHallNum.getColumnName()));
		
		web.waitTillElementclickable(UnionHiringNameTxtBox);
		web.enterText(UnionHiringNameTxtBox, web.getData(Field.UnionHiringHallName.getColumnName()));
		
	}
	
	
	
	
	public void searchWithJobDetails() {
		web.enterText(jobDescriptionQuestion, web.getData(Field.JobDescription.getColumnName()));
		web.enterText(mainOccupationQuestion, web.getData(Field.MainOccupation.getColumnName()));
	}
	
	public void clickOnSearchButton() {
		web.waitTillElementclickable(searchButton);
		web.clickOn(searchButton);
	}
	
	public void selectFirstResult() {
		web.waitTillElementclickable(resultTableFirstButton);
		web.clickOn(resultTableFirstButton);
	}
	
	
	public void clickOnSaveContinueButton() {
		web.waitTillElementclickable(ClaimantsaveContinueButton);
		web.clickOn(ClaimantsaveContinueButton);
	}
	
	public void verifyClaimantFormStatus() {
		web.verifyElementPresent(claimantTabStatus,"Claimant Tab status should be Complete");
	}
	

}
