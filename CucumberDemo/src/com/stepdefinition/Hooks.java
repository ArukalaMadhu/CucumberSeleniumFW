package com.stepdefinition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.DriverInit;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import selenium.SeleniumActions;

public class Hooks {
	
	@Before()
	public void initDriver() {
		System.setProperty("log4j.configurationFile","config/log4j2.yaml");
		
		SeleniumActions.driver =  DriverInit.getDriver(); 
	}
	
	@After()
	public void quitBrowser(Scenario scenario) {
		try{
			if(scenario.isFailed()) {
				TakesScreenshot ts = (TakesScreenshot) SeleniumActions.driver;
				byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			}
		}catch(Exception e){			
		}
		DriverInit.quitDriver();
	}
	
}
