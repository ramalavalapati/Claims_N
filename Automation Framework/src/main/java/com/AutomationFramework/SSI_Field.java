package com.AutomationFramework;

public enum SSI_Field {
	
	Residence("*  1.1 Do you currently live in the United States?"),
	RecentEmployment("*  1.2 Have you had a job in the last 18 months?"),
	AllWrkInNJ("1.2.1 If \"Yes,\" was all your work performed in New Jersey?"),
	AnyWrkInNJ("1.2.2 If \"No,\" was any of your work performed in New Jersey?"),
	ServedMilitary("*  1.3 Have you served in the United States military in the last 18 months?"),
	WorkedFedEmp("*  1.4 Have you worked for the Federal Government in the last 18 months?"),
	OutOfStateEmp("1.5 Not including federal or military employment, did you have any out-of-state employment?"),
	MaritimeEmp("*  1.6 Have you worked for a Maritime Employer in the last 18 months (for example, did you work on a ship or in a harbor)?"),
	DisabledUnableToWrk("1.7 Are you currently disabled and unable to work?"),
	
	//General Information
	SelectGender("1.2 Please select your sex:"),
	SelectNJDL("1.3 Please select the option that describes your NJ Motor Vehicle Commission-issued identification:"),
	SelectWrkUnderDiffName("1.4 In the past 18 months, have you worked under a name different from above?"),
	SelectLivedOutOfState("1.5 When you worked in New Jersey, did you live out of state?"),
	ContinueSeekWrkInNewJersey("If \"Yes,\" will you continue seeking work in New Jersey?"),
	SelectClaimInOutOfState("*  1.6 Have you filed an Unemployment Insurance claim in a State other than New Jersey in the past 12 months?"),
	SelectOtherStateFiledAClaim("If \"Yes,\" please select the state in which you filed a claim in the past 12 months:"),
	
	
	//Residence Address Page
	EnterAddressLine1("Address"),
	EnterCity("City"),
	EnterState("State"),
	EnterZipCode("Zip Code"),
	
	//Residence Address Verification Conitnued
	MailingAddDifferentYesOrNo("Is your mailing address different from your residence address selected above?"),
	
	//Mailing Address Verification
	EnterMailingAddLine1("Mailing Address line1"),
	EnterMailingCity("Mailing City"),
	SelectMailingState("Mailing State"),
	EnterMailingZipCode("Mailing ZipCode");
	
	
	
	
	
	
	
	
	private String columnName;

	private SSI_Field (String columnName) {
		this.columnName = columnName;
	}
	
	public String getColumnName() {
		return columnName;
	}
	
	

}
