@SubmitHomeLoanEnquire
Feature: Submit Enquire for HomeLoan at nab.com.au
	Scenario Outline: Submit Enquire Form with the details provided
	
	Given Browser is open
	And I am at the Home Page
	When I Click on the Personal tab
	Then I should view the menu for Personal tab and select Homeloan
	And Select Request a call back 
	Then Navigates to Call Back Form
	And Provide <ExistCust> <FirstName> <LastName> <State> <PhoneNo> and <Email> 
	Then Submit Form
	
	
	Examples:
	|ExistCust|FirstName|LastName|State|PhoneNo|Email|
	|false|Haiku|Sundar|NSW|0421000000|abc1$@gmail.com|
	|false|Aditi|Alok|VIC|0435000000|xyz9%@gmail.com|