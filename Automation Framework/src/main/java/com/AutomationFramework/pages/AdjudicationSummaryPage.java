package com.AutomationFramework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.AutomationFramework.WebFunctions;

public class AdjudicationSummaryPage extends BasePage{
	
	@FindBy(xpath=("//div[@id='pageButtonsDiv']/div/a/input"))
	private WebElement AdjSummaryTabContinueBtn;
	
	private WebFunctions web;

	public AdjudicationSummaryPage(WebDriver driver, WebFunctions webFunctions) {
		super(driver, webFunctions);
		this.web = webFunctions;
	}
	
	
	/******* Continue button Emp Tab*************/
	public void clickOnContinueBtnAdjSummaryPage() {
		web.clickOn(AdjSummaryTabContinueBtn);
	}

}
