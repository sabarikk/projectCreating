package org.login;

import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.pom.loginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.utility.BaseClass;

public class GC_Login_Page extends BaseClass {
	int no=1;
	SoftAssert s=new SoftAssert();
	
	@BeforeMethod
	private void beforeMethod() {
		System.out.println("TEST CASE "+no);
	
		browserLaunch("chrome");
	}
	
	@AfterMethod
	private void afterMethod() {
		s.assertAll();
		driver.quit();	
		no++;
	}

	
	@Test
	private void Test_Case_01() throws InterruptedException {

		System.out.println("Verify Login button functionality");
		urlLaunch("https://beta.greatcollections.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[.='Got it!']")).click();
		WebElement loginBtn = driver.findElement(By.xpath("//img[@alt='Login']"));
		boolean displayed = loginBtn.isDisplayed();
		boolean enabled = loginBtn.isEnabled();
		s.assertEquals(displayed, true);
		s.assertEquals(enabled, true);	
	}
	@Test
	private void Test_Case_02() throws InterruptedException {

		System.out.println("Verify after Login button is clicked, pages should be redirected to home page/Login area");
		urlLaunch("https://beta.greatcollections.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[.='Got it!']")).click();
		driver.findElement(By.xpath("//img[@alt='Login']")).click();
		String url = driver.getCurrentUrl();
		s.assertEquals(url, "https://beta.greatcollections.com//login.php?redirect=https%3A%2F%2Fbeta.greatcollections.com%2F");
	}
	
	@Test
	private void Test_Case_03() throws InterruptedException {

		System.out.println("Verify Login page URL-login.php");
		urlLaunch("https://beta.greatcollections.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[.='Got it!']")).click();
		driver.findElement(By.xpath("//img[@alt='Login']")).click();
		
		String url = driver.getCurrentUrl();
		if(url.contains("login.php")) {
			s.assertEquals(url, "https://beta.greatcollections.com//login.php?redirect=https%3A%2F%2Fbeta.greatcollections.com%2F");	
		}
		else {
			System.err.println("Invalid url");
		}
	}
	
	@Parameters({"username"})
	@Test
	private void Test_Case_04(String user) throws InterruptedException {

		System.out.println("Verify enter registered username or E-mail");
		urlLaunch("https://beta.greatcollections.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[.='Got it!']")).click();
		driver.findElement(By.xpath("//img[@alt='Login']")).click();
		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys(user);
		String username = userName.getAttribute("value");
		s.assertEquals(username, user);
	}

	@Parameters({"password"})
	@Test
	private void Test_Case_05(String pass) throws InterruptedException {

		System.out.println("Verify enter registered password");
		urlLaunch("https://beta.greatcollections.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[.='Got it!']")).click();
		driver.findElement(By.xpath("//img[@alt='Login']")).click();
		WebElement passWord = driver.findElement(By.id("password"));
		passWord.sendKeys(pass);
		String user = passWord.getAttribute("value");
		s.assertEquals(user, pass);
	}
	
	@Test
	private void Test_Case_06() throws InterruptedException {

		System.out.println("Verify Forgot password? hyperlink");
		urlLaunch("https://beta.greatcollections.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[.='Got it!']")).click();
		driver.findElement(By.xpath("//img[@alt='Login']")).click();
		WebElement forgetPassword = driver.findElement(By.xpath("//a[@class='smaller gray']"));
		forgetPassword.click();
		WebElement resetPassword = driver.findElement(By.xpath("//a[.='Reset Password']"));
		boolean displayed = resetPassword.isDisplayed();
		s.assertEquals(displayed, true);
	}
	
	@Test
	private void Test_Case_07() throws InterruptedException {

		System.out.println("Verify Log In button functionality");
		urlLaunch("https://beta.greatcollections.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[.='Got it!']")).click();
		driver.findElement(By.xpath("//img[@alt='Login']")).click();
		WebElement logIn = driver.findElement(By.xpath("//input[@value='Log In']"));
		boolean displayed = logIn.isDisplayed();
		boolean enabled = logIn.isEnabled();
		s.assertEquals(displayed, true);
		s.assertEquals(enabled, true);
	}
	
	@Parameters({"username","password"})
	@Test
	private void Test_Case_08(String user,String pass) throws InterruptedException {

		System.out.println("Verify after Log In button is clicked pages should be redirected to main.php page");
		urlLaunch("https://beta.greatcollections.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[.='Got it!']")).click();
		driver.findElement(By.xpath("//img[@alt='Login']")).click();
		driver.findElement(By.id("username")).sendKeys(user);
	    driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		Thread.sleep(5000);
		String url = driver.getCurrentUrl();
		//s.assertEquals(url, "https://beta.greatcollections.com//main.php");
		s.assertEquals(url, "https://beta.greatcollections.com/");
	}
	
	@Test
	private void Test_Case_09() throws InterruptedException {

		System.out.println("Verify checkbox in Remember me for future visits?");
		urlLaunch("https://beta.greatcollections.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[.='Got it!']")).click();
		driver.findElement(By.xpath("//img[@alt='Login']")).click();
		WebElement checkBox = driver.findElement(By.id("remember"));
		checkBox.click();
		boolean selected = checkBox.isSelected();
		s.assertEquals(selected, true);
	}
	
	@Test
	private void Test_Case_10() throws InterruptedException {

		System.out.println("Verify Reset password page URL-https://beta.greatcollections.com//login.php?cmd=_pw-renew");
		urlLaunch("https://beta.greatcollections.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[.='Got it!']")).click();
		driver.findElement(By.xpath("//img[@alt='Login']")).click();
		driver.findElement(By.xpath("//a[@class='smaller gray']")).click();
		Thread.sleep(3000);
		String url = driver.getCurrentUrl();
		s.assertEquals(url, "https://beta.greatcollections.com//login.php?cmd=_pw-renew");
	}

	@Parameters({"registeredEmail"})
	@Test
	private void Test_Case_11(String regEmail) throws InterruptedException {

		System.out.println("Verify enter registered Email address in reset password page");
		urlLaunch("https://beta.greatcollections.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[.='Got it!']")).click();
		driver.findElement(By.xpath("//img[@alt='Login']")).click();
		driver.findElement(By.xpath("//a[@class='smaller gray']")).click();
		Thread.sleep(3000);
		WebElement emailId = driver.findElement(By.name("email"));
		emailId.sendKeys(regEmail);
		String id = emailId.getAttribute("value");
		s.assertEquals(id, regEmail);
	}
	
	@Test
	private void Test_Case_12() throws InterruptedException {

		System.out.println("Verify contact information emai-id hyperlink and content in Reset password page");
		urlLaunch("https://beta.greatcollections.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[.='Got it!']")).click();
		driver.findElement(By.xpath("//img[@alt='Login']")).click();
		driver.findElement(By.xpath("//a[@class='smaller gray']")).click();
		Thread.sleep(3000);
		WebElement emailIdHyperLink = driver.findElement(By.xpath("//a[.='info@greatcollections.com']"));
		String text = emailIdHyperLink.getText();
		System.out.println(text);
		boolean displayed = emailIdHyperLink.isDisplayed();
		boolean enabled = emailIdHyperLink.isEnabled();
		s.assertEquals(text, "info@greatcollections.com");
		s.assertEquals(displayed, true);
		s.assertEquals(enabled, true);
	}
	
	@Parameters({"invalidUsername","password"})
	@Test
	private void Test_Case_13(String inUser,String pass) throws InterruptedException {

		System.out.println("Verify enter invalid login credentials");
		urlLaunch("https://beta.greatcollections.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[.='Got it!']")).click();
		driver.findElement(By.xpath("//img[@alt='Login']")).click();
		driver.findElement(By.id("username")).sendKeys(inUser);
	    driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		WebElement invalid = driver.findElement(By.xpath("//div[@style='padding:6px']"));
		boolean displayed = invalid.isDisplayed();
		s.assertEquals(displayed, true);
	}

	@Parameters({"invalidUsername","password"})
	@Test
	private void Test_Case_14(String inUser,String pass) throws InterruptedException {

		System.out.println("Verify error text /You have provided incorrect log-in credentials/ in login page");
		urlLaunch("https://beta.greatcollections.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[.='Got it!']")).click();
		driver.findElement(By.xpath("//img[@alt='Login']")).click();
		driver.findElement(By.id("username")).sendKeys(inUser);
	    driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		WebElement invalid = driver.findElement(By.xpath("//div[@style='padding:6px']"));
		boolean displayed = invalid.isDisplayed();
		s.assertEquals(displayed, true);
	}
	@Parameters({"emptyUsername","emptyPassword"})
	@Test
	private void Test_Case_15(String empUser,String empPass) throws InterruptedException {

	System.out.println("Validate login button with empty username and password");
		urlLaunch("https://beta.greatcollections.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[.='Got it!']")).click();
		driver.findElement(By.xpath("//img[@alt='Login']")).click();
		driver.findElement(By.id("username")).sendKeys(empUser);
	    driver.findElement(By.id("password")).sendKeys(empPass);
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		WebElement invalid = driver.findElement(By.xpath("//div[@style='padding:6px']"));
		String text = invalid.getText();
		s.assertEquals(text, "You have provided incorrect log-in credentials");
	}
	
	@Parameters({"invalidEmail"})
	@Test
	private void Test_Case_16(String inEmail) throws Exception {

		
		System.out.println("Verify enter invalid email address in reset password page");
		urlLaunch("https://beta.greatcollections.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[.='Got it!']")).click();
		driver.findElement(By.xpath("//img[@alt='Login']")).click();
		driver.findElement(By.xpath("//a[@class='smaller gray']")).click();
		Thread.sleep(3000);
		WebElement emailId = driver.findElement(By.name("email"));
		emailId.sendKeys(inEmail);
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        WebElement errorMassage = driver.findElement(By.id("error_email"));
        boolean displayed = errorMassage.isDisplayed();
		s.assertEquals(displayed, true);
	}
	
	@Parameters({"invalidEmail"})
	@Test
	private void Test_Case_17(String inEmail) throws Exception {

		
		System.out.println("Verify error text \"This is not a valid e-mail address\" in reset password page");
		urlLaunch("https://beta.greatcollections.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[.='Got it!']")).click();
		driver.findElement(By.xpath("//img[@alt='Login']")).click();
		driver.findElement(By.xpath("//a[@class='smaller gray']")).click();
		Thread.sleep(3000);
		WebElement emailId = driver.findElement(By.name("email"));
		emailId.sendKeys(inEmail);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
        WebElement errorMassage = driver.findElement(By.id("error_email"));
        String text = errorMassage.getText();
		s.assertEquals(text, "This is not a valid e-mail address");
	}
		
	@Test
	private void Test_Case_18() throws Exception {

		
		System.out.println("Verify reCAPTCHA-Privacy-Terms hyperlink");
		urlLaunch("https://beta.greatcollections.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[.='Got it!']")).click();
		driver.findElement(By.xpath("//img[@alt='Login']")).click();
		driver.findElement(By.xpath("//a[@class='smaller gray']")).click();
		Thread.sleep(3000);
        driver.switchTo().frame(0);
        WebElement captchaHyparlink = driver.findElement(By.xpath("//div[@class='rc-anchor-logo-portrait']"));
        boolean displayed = captchaHyparlink.isDisplayed();
        s.assertEquals(displayed, true);
	}
	
    @Parameters({"registeredEmail"})
	@Test
	private void Test_Case_19(String regEmail) throws Exception {

		
		System.out.println("Verify error \"Please complete the captcha above, to verify you're a human.\"");
		urlLaunch("https://beta.greatcollections.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[.='Got it!']")).click();
		driver.findElement(By.xpath("//img[@alt='Login']")).click();
		driver.findElement(By.xpath("//a[@class='smaller gray']")).click();
		Thread.sleep(3000);
        driver.findElement(By.name("email")).sendKeys(regEmail);
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        WebElement errorCaptcha = driver.findElement(By.id("error_captcha"));
        boolean displayed = errorCaptcha.isDisplayed();
        s.assertEquals(displayed, true);
		
	}
	
	@Test
	private void Test_Case_20() throws Exception {

		
		System.out.println("Validate moveover cursor to Login button and observe words\"Login to your existing GreatCollections account for access to all our features and bidding.");
		urlLaunch("https://beta.greatcollections.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[.='Got it!']")).click();
		WebElement loginBtn = driver.findElement(By.xpath("//img[@alt='Login']"));
		String value = loginBtn.getAttribute("title");
		s.assertEquals(value, "Login to your existing GreatCollections account for access to all our features and bidding.");
		
		
	}
	
	@Test
	private void Test_Case_21() throws Exception {

		
		System.out.println("Verify Login page with different browser");
		urlLaunch("https://beta.greatcollections.com");
		Thread.sleep(5000);
		driver.quit();
		browserLaunch("firefox");
		urlLaunch("https://beta.greatcollections.com");
		Thread.sleep(5000);
		driver.quit();
		browserLaunch("edge");
		urlLaunch("https://beta.greatcollections.com");
		Thread.sleep(5000);
	}
	

	
	
	
	
	
	

}
