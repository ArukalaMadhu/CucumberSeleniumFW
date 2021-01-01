package com.stepdefinition;

import cucumber.api.java.en.Given;
import selenium.SeleniumActions;

public class GmailHomePage extends SeleniumActions {
	
	@Given("Open Gmail \"(.*)\"")
	public void openGmail(String URL) {
		openURL(URL);
	}

}
