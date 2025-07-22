package main;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	protected WebDriver driver;
	WebDriverWait wait; 
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//h2[contains(.,'Login to your account')]")
	WebElement loginLabel;
	
	@FindBy(xpath ="//input[@data-qa='login-email']")
	WebElement loginemail;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement loginPassword;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//p[normalize-space()='Your email or password is incorrect!']")
	WebElement loginErrorMsg;
	
	@FindBy(xpath="//li[10]//a[1]")
	WebElement loggedInUsername;
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	WebElement logoutBtn;
	
	@FindBy(linkText = "Signup / Login")
	WebElement Signuplink;
	
	public void clickSignup()
	{
		Signuplink.click();
	}
	
	public String getLoginLabelText()
	{
		waitForVisibilty(loginLabel);
		return loginLabel.getText();
	}
	
	public void enterLoginEmail(String lname) {
		waitForVisibilty(loginemail);
		loginemail.clear();
		loginemail.sendKeys(lname);
	}
	
	public void enterLoginPassword(String loginPwd) {
		loginPassword.clear();
		loginPassword.sendKeys(loginPwd);
	}
	
	public void clickAndVerifyLoginBtn()
	{
		loginBtn.click();
	}
	
	public String checkLoginErrorMsg()
	{
		waitForVisibilty(loginErrorMsg);
		return loginErrorMsg.getText();
	}
	public String verifyLoggedInUser()
	{
		waitForVisibilty(loggedInUsername);
		return loggedInUsername.getText();
	}
	public void clickLogoutBtn()
	{
		waitForVisibilty(logoutBtn);
		logoutBtn.click();
	}
	//utility method, using this you dont need to call wait method for each webelement
	private void waitForVisibilty(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
