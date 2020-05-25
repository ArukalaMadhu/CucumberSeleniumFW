package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverInit {
	private static  WebDriver driver=null;	
	
	private DriverInit(){
	}
	
	public static WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
		if(driver==null)
			driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		return DriverInit.driver;
	}
	
	public static void setDriverNull() {
		DriverInit.driver = null;
	}

}
