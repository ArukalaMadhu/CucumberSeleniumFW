package selenium;

import java.awt.Robot;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SeleniumActions{
	private static final Logger logger = LogManager.getLogger(SeleniumActions.class);
	public static WebDriver driver=null;
	//This method opens give URL
	public void openURL(String URL) {
		driver.get(URL);
	}	
	/* This method waits until (waitInSec) presence of given element
	 * @param locator - locator of the element e.x., By.id('id') or By.xpath('xpath')
	 * @param waitInSec
	 */
	public WebElement waitUntilPresenceOfElement(By locator, long waitInSec)throws Exception{		
		WebDriverWait wait = new WebDriverWait(driver, waitInSec);
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));	
		scrollToElement(element);
		highlightElement(element);
		return element;
	}
	public WebElement waitUntilVisibilityOfElement(By locator, long waitInSec)throws Exception{		
		WebDriverWait wait = new WebDriverWait(driver, waitInSec);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		scrollToElement(element);
		highlightElement(element);
		return element;
	}
	/* This method press the corresponding key from keyboard
	 * @param - key - type of key e.x., KeyEvent.VK_TAB	 * 
	 */
	public void pressKey(int key)throws Exception{
		Robot robot = new Robot();
		robot.keyPress(key);
		robot.keyRelease(key);
	}
	
	public void scrollToElement(WebElement element){
		try{
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
		}catch(Exception e){}
	}
	public void highlightElement(WebElement element){
		try{
			JavascriptExecutor js = (JavascriptExecutor)driver;		 
			js.executeScript("arguments[0].setAttribute('style', 'background: blue; border: 2px solid yellow;');",element);
		}catch(Exception e){}
	}
	public void click(By locator, long waitInSec){
		try {		
			this.waitUntilVisibilityOfElement(locator, waitInSec).click();		
			logger.info("clicked on "+locator.toString());
		}catch(Exception e) {
			System.out.println("Exception: "+e.getStackTrace());
			Assert.fail(e.getMessage());
		}
	}
	public void type(By locator, String text, long waitInSec){
		try {		
			this.waitUntilVisibilityOfElement(locator, waitInSec).sendKeys(text);	
		}catch(Exception e) {
			System.out.println("Exception: "+e.getStackTrace());
			Assert.fail(e.getMessage());
		}
	}
	public void clearAndType(By locator, String text, long waitInSec){
		try {		
			WebElement ele = this.waitUntilVisibilityOfElement(locator, waitInSec);
			ele.clear();
			ele.click();
		}catch(Exception e) {
			System.out.println("Exception: "+e.getStackTrace());
			Assert.fail(e.getMessage());
		}
	}
	public String runJavaScript(String jscript){
		String executeScriptResponse = null;
		try{		
			JavascriptExecutor jsDriver = (JavascriptExecutor)driver;
			executeScriptResponse = jsDriver.executeScript(jscript).toString();
		}catch(Exception e) {
			System.out.println("Exception: "+e.getStackTrace());
			Assert.fail(e.getMessage());
		}
		return executeScriptResponse;
	}
	public boolean isElementDisplayed(By locator, long waitInSec) {
		try {		
			return this.waitUntilVisibilityOfElement(locator, waitInSec).isDisplayed();
		}catch(Exception e) {
			System.out.println(locator+" is not displayed");
		}
		return false;
	}
	public boolean checkTitle(String expectedTitle, boolean exactmath) {			
		String actualTitle = driver.getTitle();
		logger.info("Title: "+actualTitle);
		if(exactmath)
			return actualTitle.equalsIgnoreCase(expectedTitle);
		else
			return actualTitle.contains(expectedTitle);		
	}
	
	
	public String captureScreenShot(String screenshotName){
		String screenshotFilePath = new File(".").getAbsolutePath()+"/screenshots/"+screenshotName;
		try{
			//Convert web driver object to TakeScreenshot
			TakesScreenshot scrShot =((TakesScreenshot)driver);
			//Call getScreenshotAs method to create image file
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			//Move image file to new destination		
			File DestFile=new File(screenshotFilePath);
			//Copy file at destination
			FileUtils.copyFile(SrcFile, DestFile);
		}catch(Exception e){
			Assert.fail("Exception occurred while taking screenshot: "+e.getMessage());
		}		
		return screenshotFilePath;
	}
		
	public void mouseHover(By locator, long waitInSec) throws Exception{		
		new Actions(driver).moveToElement(waitUntilVisibilityOfElement(locator, waitInSec)).build().perform();
	}
	public void mouseClick(By locator, long waitInSec) throws Exception{
		new Actions(driver).moveToElement(waitUntilVisibilityOfElement(locator, waitInSec)).click().perform();
	}
	public void doubleClick(By locator, long waitInSec) throws Exception{
		new Actions(driver).moveToElement(waitUntilVisibilityOfElement(locator, waitInSec)).doubleClick().perform();
	}	
	public void selectOptionFromDropDown(By locator, String option, long waitInSec) throws Exception{
		Select dropdown = new Select(waitUntilPresenceOfElement(locator, waitInSec));
		dropdown.selectByValue(option);
	}	
	public void selectOption(By dropDownLocator, By optionLocator, long waitInSec) throws Exception{
		waitUntilPresenceOfElement(dropDownLocator, waitInSec).click();
		waitUntilPresenceOfElement(optionLocator, waitInSec).click();
	}

}
