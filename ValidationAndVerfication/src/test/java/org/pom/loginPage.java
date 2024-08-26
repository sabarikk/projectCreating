package org.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utility.BaseClass;

public class loginPage extends BaseClass{

	
	public loginPage() {
     PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[.='Got it!']")
	private WebElement gotItBtn;
	
	@FindBy(xpath = "//img[@alt='Login']")
	private WebElement loginBtn;
	
	@FindBy(id = "username")
	private WebElement userName;
	
	@FindBy(id = "password")
	private WebElement passWord;
	
	@FindBy(id = "remember")
	private WebElement checkBox;
	
	@FindBy(xpath = "//a[@class='smaller gray']")
	private WebElement forgetPassword;
	
	@FindBy(xpath = "//input[@value='Log In']")
	private WebElement BtnlogIn;
	
	
	@FindBy(name = "email")
	private WebElement Email;
	
	
	@FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueBtn;


	public WebElement getGotItBtn() {
		return gotItBtn;
	}


	public WebElement getLoginBtn() {
		return loginBtn;
	}


	public WebElement getUserName() {
		return userName;
	}


	public WebElement getPassWord() {
		return passWord;
	}


	public WebElement getCheckBox() {
		return checkBox;
	}


	public WebElement getForgetPassword() {
		return forgetPassword;
	}


	public WebElement getBtnlogIn() {
		return BtnlogIn;
	}


	public WebElement getEmail() {
		return Email;
	}


	public WebElement getContinueBtn() {
		return continueBtn;
	}	
	
	
	
	
	
	
}
