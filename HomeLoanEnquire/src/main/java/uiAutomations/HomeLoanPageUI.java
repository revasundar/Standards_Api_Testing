package uiAutomations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import helper.WebElementActions;
public class HomeLoanPageUI {
	WebDriver driver;
	WebElementActions webActions;
	
	String homeLoanTab = "//nav[@aria-label='On this page']/ol/li/a[@data-target='home-loans']";
	String enquireNowButton = "//div[@data-sub-heading-id = 'home-loans']//div[@class='product-card']//a[contains(@aria-label,'Enquire now')]";
	String requestCallBack = "//ul[@class='link-list linklist']/li[2]/a";
	String callBackForm = "https://www.nab.com.au/common/forms/consumer-call-centre-request-a-callback?enquiryProduct1=Home%20loan%20enquiries&homeLoanTopic=New%20home%20loans";
	public HomeLoanPageUI(WebDriver driver)
	{
			this.driver = driver;
			webActions = new WebElementActions(this.driver);
	}
	
	public void clickHomeLoanTab()
	{
		webActions.clickAction(homeLoanTab);
	}
	
	public void clickEnquireNowButton()
	{
		webActions.clickAction(enquireNowButton);
	}
	
	public void clickRequestCallBack()
	{
		webActions.clickAction(requestCallBack);
	}
	
	public void NavigatesToCallBackForm()
	{
		webActions.navigatesTo(callBackForm);
	}
	
	
}
