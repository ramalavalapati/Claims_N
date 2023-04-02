package com.AutomationFramework.SSI.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.AutomationFramework.ApplicationStaticData;
import com.AutomationFramework.SSI_Field;
import com.AutomationFramework.WebFunctions;
import com.AutomationFramework.objectRepository.SSI_PreQualificationScreen;
import com.AutomationFramework.pages.BasePage;

public class SSI_PreQualificationPage extends BasePage {
	
	private WebFunctions webFunctions;
	
	
	public SSI_PreQualificationPage (WebDriver driver, WebFunctions webFunctions) {
		super(driver, webFunctions);
		this.webFunctions = webFunctions;
	}
	
	
	public static By getQuestionLocator(String questionName, String optionToSelect) {
		//return  By.xpath("//label[contains(., '"+questionName+"')]/ancestor::table[@class='editView']/tbody/tr/td[3]/p/label[contains(text(),'"+optionToSelect+"')]/preceding-sibling::input[1]");
		return  By.xpath("//label[contains(., '"+questionName+"')]/ancestor::table[@class='editView']/tbody/tr/td[3]/p/label[contains(text(),'"+optionToSelect+"')]");
	}
	
	private WebElement getQuestionToSelect(String questionName, String optionToSelect) {
		return driver.findElement(getQuestionLocator(questionName, optionToSelect));
	}
	
	
	public void SelectLiveInUS() { 
		webFunctions.waitTillElementclickable(getQuestionToSelect(SSI_Field.Residence.getColumnName(), webFunctions.getData(SSI_Field.Residence.getColumnName())));
		webFunctions.clickOn(getQuestionToSelect(SSI_Field.Residence.getColumnName(), webFunctions.getData(SSI_Field.Residence.getColumnName())));
		
		
	}
	
	public void SelectRecentEmployment() { 
		webFunctions.waitTillElementclickable(getQuestionToSelect(SSI_Field.RecentEmployment.getColumnName(), webFunctions.getData(SSI_Field.RecentEmployment.getColumnName())));
		webFunctions.clickOn(getQuestionToSelect(SSI_Field.RecentEmployment.getColumnName(), webFunctions.getData(SSI_Field.RecentEmployment.getColumnName())));
		
		if(webFunctions.getData(SSI_Field.RecentEmployment.getColumnName()).equalsIgnoreCase(ApplicationStaticData.YesText)) {
			SelectAllWrkPerformedInNJ();
		}
	}
	
	public void SelectAllWrkPerformedInNJ() {
		webFunctions.selectOptionByText(SSI_PreQualificationScreen.allWrkInNJ, webFunctions.getData(SSI_Field.AllWrkInNJ.getColumnName()));
		
		if(webFunctions.getData(SSI_Field.AllWrkInNJ.getColumnName()).equalsIgnoreCase(ApplicationStaticData.NoText)) {
			SelectAnyWrkPerformedInNJ();
		}
	}
	
	public void SelectAnyWrkPerformedInNJ() {
		webFunctions.selectOptionByText(SSI_PreQualificationScreen.anyWrkInNJ, webFunctions.getData(SSI_Field.AnyWrkInNJ.getColumnName()));
	}
	
	
	public void SelectMilitaryService() {
		webFunctions.waitTillElementclickable(getQuestionToSelect(SSI_Field.ServedMilitary.getColumnName(), webFunctions.getData(SSI_Field.ServedMilitary.getColumnName())));
		webFunctions.clickOn(getQuestionToSelect(SSI_Field.ServedMilitary.getColumnName(), webFunctions.getData(SSI_Field.ServedMilitary.getColumnName())));
	}
	
	
	
	public void SelectFedEmployment() {
		webFunctions.waitTillElementclickable(getQuestionToSelect(SSI_Field.WorkedFedEmp.getColumnName(), webFunctions.getData(SSI_Field.WorkedFedEmp.getColumnName())));
		webFunctions.clickOn(getQuestionToSelect(SSI_Field.WorkedFedEmp.getColumnName(), webFunctions.getData(SSI_Field.WorkedFedEmp.getColumnName())));
	}
	
	
	public void SelectOutOfStateEmployment() {
		webFunctions.waitTillElementclickable(getQuestionToSelect(SSI_Field.OutOfStateEmp.getColumnName(), webFunctions.getData(SSI_Field.OutOfStateEmp.getColumnName())));
		webFunctions.clickOn(getQuestionToSelect(SSI_Field.OutOfStateEmp.getColumnName(), webFunctions.getData(SSI_Field.OutOfStateEmp.getColumnName())));
	}
	
	public void SelMaritimeEmployment() {
		webFunctions.waitTillElementclickable(getQuestionToSelect(SSI_Field.MaritimeEmp.getColumnName(), webFunctions.getData(SSI_Field.MaritimeEmp.getColumnName())));
		webFunctions.clickOn(getQuestionToSelect(SSI_Field.MaritimeEmp.getColumnName(), webFunctions.getData(SSI_Field.MaritimeEmp.getColumnName())));
	}
	
	
	public void SelectDisability() {
		webFunctions.waitTillElementclickable(getQuestionToSelect(SSI_Field.DisabledUnableToWrk.getColumnName(), webFunctions.getData(SSI_Field.DisabledUnableToWrk.getColumnName())));
		webFunctions.clickOn(getQuestionToSelect(SSI_Field.DisabledUnableToWrk.getColumnName(), webFunctions.getData(SSI_Field.DisabledUnableToWrk.getColumnName())));
	}
	
	public void ClickOnContinueBtnPreQualification() {
		webFunctions.clickOn(SSI_PreQualificationScreen.preQualificationContinueBtn);
	}
	
	public void ClickOnDoNotHavePin() {
		webFunctions.clickOn(SSI_PreQualificationScreen.doNotHavePinAuthentication);
	}
	

}
