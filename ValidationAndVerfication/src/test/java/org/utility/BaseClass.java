package org.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	
	public static WebDriver browserLaunch(String browserName) {

		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			System.err.println("invalid browser");
		}
		return driver;
	}
	
	
	
	public static void urlLaunch(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public static String currentUrl() {
        String url = driver.getCurrentUrl();
       
		return url;
	}
	
	public static void sendKeys(WebElement e,String value) {
      e.sendKeys(value);
	}
	
	public static void btnClick(WebElement e) {
		e.click();
	}
	
	
	public static String getAttribute(WebElement e) {
		String att = e.getAttribute("value");
		return att;
	}
	
	public static boolean btnDisplayed(WebElement e) {
       boolean displayed = e.isDisplayed();
	return displayed;
	}
	
	public static boolean btnEnabled(WebElement e) {
	       boolean enabled = e.isEnabled();
		return enabled;
		}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
