package com.AutomationFramework;

public enum Field {
	
	//config properties
	URL("URL"),
	SSIURL("SSI_URL"),
	
	SSNNumber("SSNNumber"),
	
	USERNAME("username"),
	PASSWORD("Password"),
	ClickOnSearchAFile("ClickOnSearchAFileLink"),
	
	SSI_USERNAME("SSI_username"),
	SSI_PASSWORD("SSI_Password"),
	
	PUSResidentQ("Do you currently reside in the United States, Puerto Rico, the US Virgin Islands or Canada?"),
	PEmpPast18MonthsQ("Have you been employed in the past 18 months?"),
	PAllWorkInNJQ("If \"Yes\", was all you work performed in New Jersey?"),
	PAnyWorkInNJQ("If \"No\", was any of your work performed in New Jersey?"),
	PMilitaryPast18MonthsQ("Have you served in the United States military in the past 18 months?"),
	PFedPast18MonthsQ("Have you worked for the Federal Government in the past 18 months?"),
	POutOfStateEmpQ("Not including federal or military employment, did you have any out-of-state employment?"),
	PMaritimeEmpQ("Have you worked for a Maritime Employer, or were you employed to work on a ship, in the past 18 months?"),
	PUnableToWorkQ("Are you currently disabled and unable to work?"),
	
	/****** ClaimantTab****************/
	FirstName("First Name:"),
	MiddleInit("Middle Initial:"),
	LastName("Last Name:"),
	SUFFIX("Suffix"),
	MainOccupation("MainOccupation"),
	JobDescription("JobDescription"),
	DateOfBirth("Date of Birth"),
	Gender("Gender:"),
	Race("Race:"),
	Ethnicity("Ethnicity:"),
	EducationalLevel("Educational Level:"),
	
	MainWageEarner("Main Wage Earner:"),
	Interpreter("If you are scheduled for an appointment, do you need an interpreter?"),
	SelectLanguage("If \"Yes\", please select the language you speak."),
	OtherLanguage("If \"Other\", please specify the language you speak."),
	BenefitsDeducted("Would you like to have 10% of your benefits deducted from"),
	DependentsClaimed("Do you wish to claim a dependency allowance for up to three dependents?"),
	LiveOutOfState("When you worked in New Jersey, did you live out of state?"),
	SeekingWorkInNJ("Will you continue seeking work in New Jersey?"),
	UnemploymentBenefitsOtherThanNJ("Have you filed for unemployment benefits in a state other than New Jersey in the past 12 months?"),
	UnemploymentBeneftsSelectState("Select other than NJ State:"),
	USCitizen("US Citizen:"),
	AlienRegType("Alien Registration Type:"),
	alienRegTypeDropDpwn("Alien Registration Type:"),
	AlienRegisterType_H1B("AlienRegisterType_H1B"),
	AlienRegisterType_A("AlienRegisterType_A"),
	AlienRegNum("Alien Registration Number:"),
	AlienAuthorizedToWork("Authorized to work in US:"),
	CountryOfOrigin("Country of Origin:"),
	workAuthDocDropDown("Work Authorization Document:"),
	WorkAuthorizationDropdownOption1("WorkAuthorizationDropdownOption1"),
	WorkAuthorizationDropdownOption2("WorkAuthorizationDropdownOption2"),
	workAuthorizationFromDate("workAuthorizationFromDate"),
		
	workAuthorizationToDate("workAuthorizationToDate"),
	perResCardExpDate("If Permanent Resident Card, Expiration Date:"),
	nameDiffThanClaimantName("Is the name on the document different than the 'Claimant Name' above?"),
	AlienFirstName("Alien First Name"),
	AlienLastName("Alien Last Name"),
	ResCountryTerritoryOfResidence("Res Country or Territory of Residence:"),
	ResStreet("Res Street:"),
	ResCity("Res City:"),
	ResState("Res Claimant Tab State:"),
	ResZipCode("Res Zip Code:"),
	MailingAddDiff("Mailing Address different from residence:"),
	MailCountryTerritoryOfResidence("Mailing Country or Territory of Residence:"),
	MailStreet("Mailing Street:"),
	MailCity("Mailing City:"),
	MailState("Mailing Claimant Tab State:"),
	MailZipCode("Mailing Zip Code:"),
	MainTel("Main Telephone:"),
	AltTel("Alternate Telephone:"),
	Email("Email:"),
	UnionHiringHall("Do you seek work through a Union hiring hall?"),
	UnionHiringHallNum("Union Hiring Hall Number:"),
	UnionHiringHallName("Union Hiring Hall Name:"),
	
	/******* Eligibility ************/
	WillingAbleToWorkFullTime("Are you ready, willing and able to work full-time?"),
	OfferedJobStartImmediately("If offered a job, could you start immediately?"),
	DisabilityWorkersCompBenefits("Since your last day of work, have you collected disability or workers compensation benefits?"),
	DisabledBeforeFilingClaim("Were you disabled immediately before filing this claim?"),
	DisabilityStartDate("If \"Yes\", what was the date your disability started?"),
	DisabilityRecoveryDate("What date did you recover from your disability?"),
	DisabilityPlan("What type of Disability Plan were you on?"),
	ContactLastEmpForMoreWrk("After recovering, did you contact your last employer for more work?"),
	ReleasedWithMedicalRestriction("After being medically cleared to work, were you released with any medical restrictions?"),
	AttendtingTrainingOrCollege("Are you currently attending school, job training or college?"),
	SelfEnrollInSchool("Did you self-enroll in school, through your Union hiring hall or were you enrolled by a counselor"),
	
	
	
	/****** NJ Employment *********/
	NoOfNJEmployers("NoOfNJEmployers"),
	//AddNJEmployerFlag()
	EmpName("EmployeeName:"),
	EmpFEIN("Employer FEIN:"),
	SYNNumber("SYN Number:"),
	AddLine1("Address Line 1:"),
	AddLine2("Address Line 2:"),
	AddLine3("Address Line 3:"),
	City("City:"),
	EmpTabState("Emp Tab State:"),
	ZipCode("Zip Code:"),
	TelNumber("Telephone Number:"),
	workTelPhone("What is your work location telephone number, if different than employer's telephone number?"),
	DiffPhysicalWorkLoc("Is your physical work location different than the employer"), //'s address above?
	WorkedUnderDiffName("In the past 18 months, have you worked under a name different from above?"),
	FirstDayOfWork("First Date of Work:"),
	LastDayOfWork("Last Date of Work:"),
	LagWage("Is this a lag employer?"),
	StillWorkForThisEmp("Do you still work for this employer?"),
	NoLongerWorkEmp("Why are you no longer working for this employer?"),
	
	NoLongerWorkEmpDropDown("NoLongerWorkEmpDropDown"),
	FiredDischargedOrTerminated("FiredDischargedOrTerminated"),
	StrikeOrLockoutByEmployer("StrikeOrLockoutByEmployer"),
	LayoffOrLackOfWork("LayoffOrLackOfWork"),
	QuitResignedOrRetired("QuitResignedOrRetired"),
	dischargeDate("What was your discharge date?"),
	Separation("Reason for Separation:"),
	TollOutVerified("Toll Out Verified:"),
	
	IndicateBestDesSituation("If yes, please indicate the best description of your situation"),
	RecalledByEmp("Do you expect to be recalled by this employer?"),
	BusCorpOrPartnership("Is this a business corporation or partnership?"),
	RelationshipToOwner("If this is not a business a corporation or partnership, what is your relationship to the owner?"),
	
	DefiniteCallBackDate("If \"Yes\", has your employer given you a definite call back date?"),
	EmpRecallDate("If \"Yes\", on what date do you expect to be recalled?"),
	SeasonalWork("Is your work seasonal?"),
	JobTitle("Job Title:"),
	SelfEmpOrBusiness("Are you self-employed or the owner of any business?"),
	OwnerOrAnyBusiness("Are you the owner, related to the owner, a corporate officer, or do you have 5% or more equitable"),
	RetirementPayment("Are you receiving, or have you received, any type of retirement payment, from any employers"),
	OtherPay("Have you received, or will you receive, any of the following since your last day of work:"),
	//PaymentType("PaymentType"),
	PaymentTypeDropDown("AdditionalPaymentType"),
	PaymentTypeHoliday("PaymentTypeHoliday"),
	PaymentTypeInLieuOfNotice("PaymentTypeInLieuOfNotice"),
	PaymentTypeVacation("PaymentTypeVacation"),
	PaymentTypeSeverance("PaymentTypeSeverance"),
	PaymentContinuation("PaymentContinuation"),
	PaymentOtherPay("PaymentOtherPay"),
	PaymentLastPayCheck("PaymentLastPayCheck"),
	AdditionalPaymentFromDate("AdditionalPaymentFromDate"),
	AdditionalPaymentToDate("AdditionalPaymentToDate"),
	AdditionalPaymentComments("AdditionalPaymentComments"),
	
	PaymentAdditionalAmount("AdditionalAmount"),
	WorkForThisEmp("Did you work for this employer?"),
	MaritimeEmp("Was this a maritime employer?"),
	
	
	/****** Military Employment *********/
	//Add new military Employer Page fields
	AddMilitaryEmployerFlag("AddMilitaryEmployerFlag"),
	UCXBranchOfService("Branch of Service(Block 2):"),
	UCXPayGrade("Pay Grade(Block 4b):"),
	UCXEntryDate("Entry Date(Block 12a):"),
	UCXSeparationDate("Separation Date(Block 12b):"),
	UCXDaysAccrued("Days Accrued(Block 16):"),
	UCXCharOfService("Character of Service(Block 24):"),
	UCXReasonDischarge("Narrative Reason for Discharge(Block 28):"),
	UCXDaysLost("Do you have any \"Days Lost\"(Block 29)?"),
	UCXDD214("DD214 member copy (Found on bottom right of form):"),
	UCXNationalGaurdOrReserve("Completed as a member of the National Guard or Reserve?"),
	UCXFirstTourOfEnlishment("Completed First Tour of Enlistment:"),
	UCXSeparationReason("Separation Reason:"),
	UCXRetireRegularOrDisability("Are you a military retiree: Regular or Disability?"),
	
	
	/****** Federal Employment *********/
	//Add new Federal Employer Page fields
	AddFederalEmployerFlag("AddFEDEmployerFlag"),
	
	/****** OutOfState Employment *********/
	//Add new OutOfState Employer Page fields
	AddOutOfStateEmpFlag("AddOutOfStateEmployerFlag"),
	CWCEmpName("OutOfState Employer Name:"),
	CWCAddLine1("OutOfState Address Line 1:"),
	CWCAddLine2("OutOfStateAddress Line 2:"),
	CWCAddLine3("OutOfState Address Line 3:"),
	CWCCity("OutOfState City:"),
	CWCState("OutOfState Emp Tab State:"),
	CWCZipCode("OutOfState Zip Code:"),
	CWCWageTransState("CWC Wage Transferring State:"),
	CWCEmploymentType("CWC Employment Type:"),
	CWCTelNumber("CWC Telephone Number:"),
	CWCDiffTelNumber("CWC Diff Telephone Number:"),
	CWCDiffPhysicalWorkLoc("Is your physical work location different than the employer"),
	CWCWorkedUnderDiffName("In the past 18 months, have you worked under a name different from above?"),
	CWCFirstDayOfWork("First Date of Work:"),
	CWCLastDayOfWork("Last Date of Work:"),
	CWCStillWorkForThisEmp("CWCStillWorkForThisEmp"),
	CWCNoLongerWorkEmp("Why are you no longer working for this employer?"),
	
	/****** Certify Submit ************************************/
	DateOfClaim("Date of Claim:");
	
	private String columnName;	
	
	private Field(String columnName) {
		this.columnName = columnName;
	}
	
	public String getColumnName() {
		return columnName;
	}

}
