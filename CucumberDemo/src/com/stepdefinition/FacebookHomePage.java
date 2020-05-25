package com.stepdefinition;

import base.DriverInit;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import selenium.SeleniumActions;

public class FacebookHomePage extends SeleniumActions{
	@Given("Open Facebook \"(.*)\"")
	public void openFacebook(String URL) {
		openURL(URL);
	}
	@Before
	public void initDriver() {
		super.driver =  DriverInit.getDriver(); 
	}
	
	@After
	public void quitBrowser() {
		quitDriver();
	}
}
