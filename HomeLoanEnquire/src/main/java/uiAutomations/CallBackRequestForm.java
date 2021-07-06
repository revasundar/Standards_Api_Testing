package uiAutomations;

import org.openqa.selenium.WebDriver;

import helper.WebElementActions;

public class CallBackRequestForm {
	WebDriver driver;
	WebElementActions webActions;
	String firstNameLoc = "//div/span//input[@label='First name']";
	String lastNameLoc = "//input[@label='Last name']";
	String phoneNoLoc = "//input[@label='Phone number']";
	String emailLoc = "//input[@label='Email']";
	String submitButton = "//button[@type='submit']";
	
	
	
	public CallBackRequestForm(WebDriver driver) {
		this.driver = driver;
		webActions = new WebElementActions(this.driver);
	}
	
	public void enterDetails(String existCust, String firstName, String lastName, String state, String phoneNo, String email) {
		selectExistingCustomer(existCust);
		System.out.println("ExistingCust: is Success "+existCust);
		//webActions.enterInput("//input[@id='field-page-Page1-nabID']","102333435");
		webActions.enterInput(firstNameLoc,firstName);
		System.out.println("After firstNameSuccess");
		webActions.enterInput(lastNameLoc, lastName);
		webActions.enterInput(phoneNoLoc, phoneNo);
		webActions.enterInput(emailLoc,email);
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
		webActions.clickAction(submitButton);
	}
	

}
