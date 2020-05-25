package com.stepdefinition;

import java.util.Map;
import org.openqa.selenium.By;
import org.testng.Assert;

import base.DriverInit;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import selenium.SeleniumActions;

public class GoogleSearchFieldDef extends SeleniumActions {
	
	@Before
	public void initDriver() {
		super.driver =  DriverInit.getDriver(); 
	}
	
	@After
	public void quitBrowser() {
		quitDriver();
	}
	
	//Global Hooks:
//	@Before() //@Before(order=0)
//	public void initDriver() {
//		super.driver =  DriverInit.getDriver(); 
//	}
//	
//	@After()
//	public void quitBrowser() {
//		quitDriver();
//	}
	//Local Hooks:
//	@Before(@smokeTest)
//	public void initDriver() {
//		super.driver =  DriverInit.getDriver(); 
//	}
//	
//	@After(@smokeTest)
//	public void quitBrowser() {
//		quitDriver();
//	}
		
	@Given("^Open google \"(.*)\"$") //\"([^\"]*)\"
	public void open_google_URL(String URL) {
	   openURL(URL);
	}

	@When("^I verify google home page \"([^\"]*)\"$")
	public void i_verify_google_home_page(String title) {
	 Assert.assertTrue(checkTitle(title,true),"Unexpected title: "+driver.getTitle());
	}

	@Then("^I verify that the page displays search text box$")
	public void i_verify_that_the_page_displays_search_text_box(DataTable data) {
		//Using map Object
		for(Map<String,String> mdata : data.asMaps(String.class,String.class)) {			
			Assert.assertTrue( isElementDisplayed(By.name(mdata.get("name"))),"Search input field is not displayed ");
		}
	}

	@And("^the page displays Google Search button$")
	public void the_page_displays_Google_Search_button() {
		//Assert.assertTrue(isElementDisplayed(By.xpath("//input[@name='btnK']")),"Search Button is not displayed ");
	}


}
