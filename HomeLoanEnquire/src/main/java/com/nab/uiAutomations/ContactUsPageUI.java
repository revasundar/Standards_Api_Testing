package com.nab.uiAutomations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.nab.helper.WebElementActions;

public class ContactUsPageUI {
	WebDriver driver;
	WebElementActions webActions;
	//myScreen = new Screen();
	//Pattern ebayHome = new Pattern("C:\\Users\\Sundar\\Desktop\\Snipping_Selenium\\ebay_Home.PNG");
	
	String callmeBack = "//a[@aria-label='Call me back']";
	String homeLoanRadioButton = "homeLoanRadio";
	String nextButton = "//button/div/span";
	
	public ContactUsPageUI(WebDriver driver)
	{
			this.driver = driver;
			webActions = new WebElementActions(this.driver);
	}
	
	public void clickCallMeBack()
	{
		webActions.scrollDown();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		webActions.clickActionPerform(callmeBack);
	}
	
	public void clickHomeLoanRadioButton()
	{
		webActions.clickByName(homeLoanRadioButton);
	}
	
	public void clickNext()
	{
		webActions.clickByText(nextButton,"Next");
	}

}
