package uiAutomations;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helper.WebElementActions;

public class CallBackRequestForm {
	WebDriver driver;
	WebElementActions webActions;
	String firstNameLoc = "field-page-Page1-aboutYou-firstName"; //"//div/span//input[@label='First name']";
	String lastNameLoc = "field-page-Page1-aboutYou-lastName";
	String stateLoc = "page-Page1-aboutYou-state";
	String phoneNoLoc = "field-page-Page1-aboutYou-phoneNumber";
	String emailLoc = "field-page-Page1-aboutYou-email";
	String submitButton = "page-Page1-btnGroup-submitBtn";
	String statexx = "//div[@id=page-Page1-aboutYou-state']/div[@class='body']";
	
	
	
	public CallBackRequestForm(WebDriver driver) {
		this.driver = driver;
		webActions = new WebElementActions(this.driver);
	}
	
	public void enterDetails(String existCust, String firstName, String lastName, String state, String phoneNo, String email) {
		selectExistingCustomer(existCust);
		System.out.println("ExistingCust: is Success "+existCust);
		//webActions.enterInput("//input[@id='field-page-Page1-nabID']","102333435");
		//driver.switchTo().alert().dismiss();
		webActions.enterInputElement(getElementFromList(firstNameLoc,"id"),firstName);
		webActions.enterInputElement(getElementFromList(lastNameLoc,"id"),lastName);
	
		WebElement stateEle = getElementFromList(stateLoc,"id");
		webActions.clickByElement(stateEle);
		String html1 = (String) ((JavascriptExecutor)driver).executeScript("return arguments[0].innerHTML;",stateEle);
		//System.out.println(html1);
		stateEle= getElementFromList(statexx,"xpath");
		webActions.clickByElement(getElementFromList(statexx,"xpath"));
		//stateEle.click();
		stateEle.sendKeys(Keys.ARROW_UP);
		stateEle.sendKeys(Keys.ENTER);
		webActions.enterInputElement(getElementFromList(phoneNoLoc,"id"),phoneNo);
		webActions.enterInputElement(getElementFromList(emailLoc,"id"),email);
		
		//new Actions(driver).moveToElement(elementName).click().perform();
		//System.out.println(driver.page_source);
	
	
	}
	
	public void selectExistingCustomer(String existCust)
	{
		String existingCust ;
		//String existingCust = "//label/input[@value='"+existCust+"']";
		if(existCust == "true") {
			existingCust = "//div[@type='radio'][@aria-invalid='false']/label[1]";
		}
		else
		{
			existingCust = "//div[@type='radio'][@aria-invalid='false']/label[2]";
		}
		
		
		webActions.clickAction(existingCust);
		
		
	}
	public void submitForm() {
		webActions.clickByElement(getElementFromList(submitButton,"id"));
		//webActions.clickAction(submitButton);
	}
	
	public WebElement getElementFromList(String locator, String locType)
	{	
		
		List<WebElement> weList = webActions.getList(locator,locType);
		System.out.println("Welist count: "+weList.size());
		return weList.get(0);
		
	}
	

}
