package StepDefintions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import uiAutomations.*;

import org.testng.Assert;

import browserConfig.TestBaseDriver;

public class HomeLoanEnquireSteps extends TestBaseDriver {
	//TestBaseDriver testbaseDriver = new TestBaseDriver();
	HomePageUI homePageUI;
	HomeLoanPageUI homeLoanPageUI;
	ContactUsPageUI contactUsPageUI;
	CallBackRequestForm callBackRequestForm;
	@Given("Browser is open")
	public void browser_is_open() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		init("chrome");
		System.out.println("HomePage");
		homePageUI = new HomePageUI(driver);
		homeLoanPageUI = new HomeLoanPageUI(driver);
		contactUsPageUI = new ContactUsPageUI(driver);
		callBackRequestForm = new CallBackRequestForm(driver);
	}
	
	@And("I am at the Home Page")
	public void i_am_at_the_home_page() {
		homePageUI = new HomePageUI(driver);
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		 String pageTitle = homePageUI.getPageTitle();
		 Assert.assertTrue(pageTitle.contains("NAB"));
		
		System.out.println("HomePage");
	}

	@When("I Click on the Personal tab")
	public void i_click_on_the_personal_tab() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		System.out.println("Personal");
		homePageUI.clickPersonalTab();
	}

	@Then("I should view the menu for Personal tab and select Homeloan")
	public void i_should_view_the_menu_for_personal_tab_and_select_homeloan() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.out.println("Menu");
		homePageUI.clickHomeLoanOption();
	}
	 
	@And("Select Request a call back")
	public void select_request_a_call_back() {
		System.out.println("Request Call Back");
		homeLoanPageUI.clickRequestCallBack();
	}
	
	@Then("Navigates to Call Back Form")
	public void navigates_to_call_back_form() {
		System.out.println("CallBackForm");
		homeLoanPageUI.NavigatesToCallBackForm();
	}
	
	@And("^Provide (.*) (.*) (.*) (.*) (.*) and (.*)$")
	public void provide_firstName_lastName_state_phoneNo_and_email(String existCust,  String firstName, String lastName, String state, String phoneNo, String email){
		System.out.println("existCust: "+existCust);
		System.out.println("firstName: "+firstName);
		System.out.println("lastName: "+lastName);
		System.out.println("state:"+state);
		System.out.println("phoneNo: "+phoneNo);
		System.out.println("email: "+email);
		callBackRequestForm.enterDetails(existCust, firstName, lastName, state, phoneNo, email);
		
	}
	
	@Then("Submit Form")
	public void submit_form() {
		callBackRequestForm.submitForm();
	}
	/*
	 * @And("I click on the Home Loans Tab") public void
	 * i_click_on_the_home_loans_tab() { System.out.println("Home Loans Tab");
	 * homeLoanPageUI.clickHomeLoanTab(); }
	 * 
	 * @Then("Scroll down to the enquire section and click on Enquire now button")
	 * public void
	 * scroll_down_to_the_enquire_section_and_click_on_enquire_now_button() {
	 * System.out.println("Scroll Down and select Enquire Now ");
	 * homeLoanPageUI.clickEnquireNowButton();
	 * 
	 * }
	 * 
	 * @And("Click Call me back") public void click_call_me_back() {
	 * System.out.println("Click Call me Back"); contactUsPageUI.clickCallMeBack();
	 * }
	 */
	 
	 @Then("Select New home loans radio button and click Next") 
	 public void select_new_home_loans_radio_button_and_click_next() { 
		 contactUsPageUI.clickHomeLoanRadioButton();
		 contactUsPageUI.clickNext();
	 }
	  
	 /* @And("I click on the Enquire now button") public void
	 * i_click_on_the_enquire_now_button() { // Write code here that turns the
	 * phrase above into concrete actions throw new
	 * io.cucumber.java.PendingException(); }
	 * 
	 * @Then("Navigates to contact us page") public void
	 * navigates_to_contact_us_page() { // Write code here that turns the phrase
	 * above into concrete actions throw new io.cucumber.java.PendingException(); }
	 * 
	 * @And("I click on Call me back option") public void
	 * i_click_on_call_me_back_option() { // Write code here that turns the phrase
	 * above into concrete actions throw new io.cucumber.java.PendingException(); }
	 * 
	 * @Then("I can view the options for Enquire") public void
	 * i_can_view_the_options_for_enquire() { // Write code here that turns the
	 * phrase above into concrete actions throw new
	 * io.cucumber.java.PendingException(); }
	 * 
	 * @And("I select the New home loans radio button and click Next") public void
	 * i_select_the_new_home_loans_radio_button_and_click_next() { // Write code
	 * here that turns the phrase above into concrete actions throw new
	 * io.cucumber.java.PendingException(); }
	 * 
	 * @Then("I Select existing customer as No") public void
	 * i_select_existing_customer_as_no() { // Write code here that turns the phrase
	 * above into concrete actions throw new io.cucumber.java.PendingException(); }
	 * 
	 * 
	 * @Then("I click Submit") public void i_click_submit() { // Write code here
	 * that turns the phrase above into concrete actions throw new
	 * io.cucumber.java.PendingException(); }
	 */

}
