package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.DriverInit;

public class SeleniumActions {
	public WebDriver driver=null;
	
	public void openURL(String URL) {
		driver.get(URL);
	}
	
	public boolean isElementDisplayed(By locator) {
		try {		
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			return element.isDisplayed();
		}catch(NoSuchElementException e) {
			System.out.println(locator+" is not displayed");
		}
		return false;
	}
	public boolean checkTitle(String expectedTitle, boolean exactmath) {			
		String actualTitle = driver.getTitle();
		if(exactmath)
			return actualTitle.equalsIgnoreCase(expectedTitle);
		else
			return actualTitle.contains(expectedTitle);		
	}
	
	public void quitDriver() {
		if(driver!=null)
			driver.quit();
		DriverInit.setDriverNull();
	}
	
	

}
