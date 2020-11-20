package com.stepdefinition;

import java.util.List;
import org.openqa.selenium.By;
import org.testng.Assert;

import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;
import selenium.SeleniumActions;

public class GoogleTestSearchFieldDef extends SeleniumActions {
//	@Before
//	public void initDriver() {
//		super.driver =  DriverInit.getDriver(); 
//	}
//	
//	@After
//	public void quitBrowser() {
//		quitDriver();
//	}
//		
	
	@Then("^the page displays Im Feeling Lucky button$")
	public void the_page_displays_Im_Feeling_Lucky_button(DataTable data) {
		List<List<String>> d = data.asLists();
//		Iterator<List<String>> rows = d.iterator();
//		while(rows.hasNext()) {
//			List <String> cols = rows.next();
//			Iterator<String> it = cols.iterator();
//			while(it.hasNext()) {
//				Assert.assertTrue("I'm Feeling Lucky is not displayed ", isElementDisplayed(By.id(it.next())));
//			}
//		}
		
		d.forEach(rws -> {
			List <String> rw = rws;
			Assert.assertTrue(isElementDisplayed(By.id(rw.get(0)),10),"I'm Feeling Lucky is not displayed ");			
		});
		 
		//Assert.assertTrue( isElementDisplayed(By.id(d.get(0).get(0))),"I'm Feeling Lucky is not displayed ");
	}
//	@Then("^close the browser$")
//	public void close_the_browser() {
//		driver.quit();
//		setDriverNull();
//	}

}
