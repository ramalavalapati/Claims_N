package com.AutomationFramework.SSI.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.AutomationFramework.ApplicationStaticData;
import com.AutomationFramework.SSI_Field;
import com.AutomationFramework.WebFunctions;
import com.AutomationFramework.objectRepository.SSI_GeneralInformationScreen;
import com.AutomationFramework.pages.BasePage;

public class SSI_GeneralInformationPage extends BasePage{
	
	private WebFunctions webFunctions;
	
	public SSI_GeneralInformationPage (WebDriver driver, WebFunctions webFunctions) {
		super(driver, webFunctions);
		this.webFunctions = webFunctions;
	}
	
	
	public static By getQuestionGeneralInfoPage(String questionName, String optionToSelect) {
		return By.xpath("//label[contains(., '"+questionName+"')]/ancestor::table[@class='editView']/tbody/tr/td[2]/p/label[contains(text(),'"+optionToSelect+"')]");
	}
	
	private WebElement getQuestionToSelectGeneralInfoPage (String questionName, String optionToSelect) {
		return driver.findElement(getQuestionGeneralInfoPage(questionName, optionToSelect));
	}
	
	
	public void SelectGender() {
		webFunctions.waitTillElementclickable(getQuestionToSelectGeneralInfoPage(SSI_Field.SelectGender.getColumnName(), webFunctions.getData(SSI_Field.SelectGender.getColumnName())));
		webFunctions.clickOn(getQuestionToSelectGeneralInfoPage(SSI_Field.SelectGender.getColumnName(), webFunctions.getData(SSI_Field.SelectGender.getColumnName())));
	}
	
	public void SelectIdentificationTypeNJDL() {
		webFunctions.selectOptionByText(SSI_GeneralInformationScreen.NJDrivingLicense, webFunctions.getData(SSI_Field.SelectNJDL.getColumnName()));
	}
	
	
	public void SelectWrkUnderDifferentName() {
		webFunctions.waitTillElementclickable(getQuestionToSelectGeneralInfoPage(SSI_Field.SelectWrkUnderDiffName.getColumnName(), webFunctions.getData(SSI_Field.SelectWrkUnderDiffName.getColumnName())));
		webFunctions.clickOn(getQuestionToSelectGeneralInfoPage(SSI_Field.SelectWrkUnderDiffName.getColumnName(), webFunctions.getData(SSI_Field.SelectWrkUnderDiffName.getColumnName())));
		
	}
	
	
	public void SelectLivedInOutOfState() {
		webFunctions.waitTillElementclickable(getQuestionToSelectGeneralInfoPage(SSI_Field.SelectLivedOutOfState.getColumnName(), webFunctions.getData(SSI_Field.SelectLivedOutOfState.getColumnName())));
		webFunctions.clickOn(getQuestionToSelectGeneralInfoPage(SSI_Field.SelectLivedOutOfState.getColumnName(), webFunctions.getData(SSI_Field.SelectLivedOutOfState.getColumnName())));
		
		if(webFunctions.getData(SSI_Field.SelectLivedOutOfState.getColumnName()).equalsIgnoreCase(ApplicationStaticData.YesText)) {
			SelectContinueSeekingWrkInNJ();
		}
		
	}
	
	public void SelectContinueSeekingWrkInNJ() {
		webFunctions.selectOptionByText(SSI_GeneralInformationScreen.ContinueSeekingWrkInNJ, webFunctions.getData(SSI_Field.ContinueSeekWrkInNewJersey.getColumnName()));
	}
	
	
	public void SelectClaimInOtherThanNJState() {
		webFunctions.waitTillElementclickable(getQuestionToSelectGeneralInfoPage(SSI_Field.SelectClaimInOutOfState.getColumnName(), webFunctions.getData(SSI_Field.SelectClaimInOutOfState.getColumnName())));
		webFunctions.clickOn(getQuestionToSelectGeneralInfoPage(SSI_Field.SelectClaimInOutOfState.getColumnName(), webFunctions.getData(SSI_Field.SelectClaimInOutOfState.getColumnName())));
		
		if(webFunctions.getData(SSI_Field.SelectClaimInOutOfState.getColumnName()).equalsIgnoreCase(ApplicationStaticData.YesText)) {
			SelectOtherStateFiledClaim();
		}
	}
	
	public void SelectOtherStateFiledClaim() {
		webFunctions.selectOptionByText(SSI_GeneralInformationScreen.FiledAClaimInDifferentState, webFunctions.getData(SSI_Field.SelectOtherStateFiledAClaim.getColumnName()));
		
	}
	
	public void ClickOnGeneralInfoPageContinuBtn() {
		webFunctions.clickOn(SSI_GeneralInformationScreen.GeneralInfoPageContinueBtn);
	}
	
	
	
	
	

}
