package com.nab.testRunner;


import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.junit.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
//import io.cucumber.testng.TestNGCucumberRunner;
import cucumber.api.testng.TestNGCucumberRunner;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",glue={"com.nab.StepDefintions"},
monochrome=true,
plugin={"pretty","html:target/HtmlReports"},
tags="@SubmitHomeLoanEnquire")

public class TestRunner {
	private TestNGCucumberRunner testNGCucumberRunner;
	
	@BeforeClass(alwaysRun=true)
	public void setUp()
	{
		testNGCucumberRunner= new TestNGCucumberRunner(this.getClass());
	}
	
	@Test(dataProvider="nabFeatures")
	public void scenarios(CucumberFeatureWrapper cucumberFeature)throws Throwable
	{
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	}
	
	@DataProvider(name="nabFeatures")
	public Object[][] features(){
		
		 if(testNGCucumberRunner == null){
		        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
		    }
		return testNGCucumberRunner.provideFeatures();
	}
	
	@AfterClass(alwaysRun=true)
	public void testExit()
	{
		testNGCucumberRunner.finish();
	}
	
	

}
