package uiAutomations;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helper.WebElementActions;

public class ContactUsPageUI {
	WebDriver driver;
	WebElementActions webActions;
	//myScreen = new Screen();
	//Pattern ebayHome = new Pattern("C:\\Users\\Sundar\\Desktop\\Snipping_Selenium\\ebay_Home.PNG");
	
	String callmeBack = "//a[@aria-label='Call me back']";
	String homeLoanRadioButton = "myRadioButton-0";
	String nextButton = "//button[@data-component-id='Button']/div/span";
	
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
		//webActions.clickByName(homeLoanRadioButton);
		List<WebElement> radioButtons = webActions.getList(homeLoanRadioButton,"id");
		webActions.clickByElement(radioButtons.get(0));
	}
	
	public void clickNext()
	{
		List<WebElement> nextB = webActions.getList(nextButton,"xpath");
		webActions.clickByElement(nextB.get(0));
		//webActions.clickByText(next,"Next");
	}

}
