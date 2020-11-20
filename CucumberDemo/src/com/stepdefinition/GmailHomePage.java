package com.stepdefinition;

import base.DriverInit;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import selenium.SeleniumActions;

public class GmailHomePage extends SeleniumActions {
	
//	@Before
//	public void initDriver() {
//		super.driver =  DriverInit.getDriver(); 
//	}
//	
//	@After
//	public void quitBrowser() {
//		quitDriver();
//	}
	
	@Given("Open Gmail \"(.*)\"")
	public void openGmail(String URL) {
		openURL(URL);
	}

}
