package uiAutomations;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import helper.WebElementActions;
public class HomePageUI {
	WebDriver driver;
	WebElementActions webActions;
	
	String personalTab = "//div[@id='menu-logo-container']//nav[@role='navigation']/ul/li[1]";
	String homeLoanMenu = "//a[@class='menu-trigger'][@href='/personal/home-loans']";
	String homeLoanSubMenu = "//div[@class='nav-container']//a[@href='/personal/home-loans']";
	
	public HomePageUI(WebDriver driver)
	{
			this.driver = driver;
			webActions = new WebElementActions(this.driver);
	}
	
	public void clickPersonalTab()
	{
		webActions.clickAction(personalTab);
	}
	
	public void clickHomeLoanOption()
	{
		webActions.clickAction(homeLoanMenu);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		webActions.clickAction(homeLoanSubMenu);
	}
	
	public String getPageTitle()
	{
		return webActions.getPageTitle();
	}
	
	

}
