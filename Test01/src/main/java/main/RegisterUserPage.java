package main;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterUserPage {

	protected WebDriver driver;
	WebDriverWait wait; 
	
	public RegisterUserPage(WebDriver driver) {
		this.driver=driver;
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText = "Signup / Login")
	WebElement Signuplink;
	
	@FindBy(xpath = "//h2[contains(.,'New User Signup!')]")
	WebElement signupLabel;
	
	@FindBy(xpath = "//input[@type='text' and @placeholder='Name']")
	WebElement name;
	
	@FindBy(xpath = "//input[@data-qa='signup-email']")
	WebElement email;
	
	@FindBy(xpath="//button[normalize-space()='Signup']")
	WebElement signupBtn;
	
	@FindBy(xpath="//b[normalize-space()='Enter Account Information']")
	WebElement registerInfoLabel;
	
	@FindBy(xpath="//div[@data-qa='title' and @id='uniform-id_gender1']")
	WebElement title;
	
	@FindBy(id="name")
	WebElement fullName;
	
	@FindBy(id="password")
	WebElement userPassword;
	
	@FindBy(id="days")
	WebElement clickDaysDropdown;
	
	@FindBy(id="months")
	WebElement clickMonthsDropdown;
	
	@FindBy(id="years")
	WebElement clickYearsDropdown;
	
	@FindBy(id="newsletter")
	WebElement selectCBForNewsletter;
	
	@FindBy(id="optin")
	WebElement selectCBForOffers;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="last_name")
	WebElement lastName;
	
	@FindBy(id="address1")
	WebElement address1;
	
	@FindBy(id="state")
	WebElement state;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="zipcode")
	WebElement zipcode;
	
	@FindBy(id="mobile_number")
	WebElement mobileNumber;
	
	@FindBy(css="button[data-qa='create-account']")
	WebElement createAccountBtn;
	
	@FindBy(xpath="//h2[@data-qa='account-created']")
	WebElement getAccountCreationText;
	
	@FindBy(xpath="//a[normalize-space()='Continue']")
	WebElement continueBtn;
	
	@FindBy(xpath="//li[10]//a[1]")
	WebElement loggedInUsername;
	
	@FindBy(xpath="//a[normalize-space()='Delete Account']")
	WebElement deleteAccBtn;
	
	@FindBy(xpath="//b[normalize-space()='Account Deleted!']")
	WebElement deleteMsg;
	
	@FindBy(xpath="//p[normalize-space()='Email Address already exist!']")
	WebElement emailExistMsg;
	
	
	
	
	
//	@FindBy(xpath = "//h2[contains(.,'Login to your account')]")
//	WebElement loginLabel;
//	
//	@FindBy(xpath ="//input[@data-qa='login-email']")
//	WebElement loginemail;
//	
//	@FindBy(xpath="//input[@placeholder='Password']")
//	WebElement loginPassword;
//	
//	@FindBy(xpath="//button[normalize-space()='Login']")
//	WebElement loginBtn;
//	
//	@FindBy(xpath="//p[normalize-space()='Your email or password is incorrect!']")
//	WebElement loginErrorMsg;
//	
//	@FindBy(xpath="//a[normalize-space()='Logout']")
//	WebElement logoutBtn;
	
	public void clickSignup()
	{
		Signuplink.click();
	}
	
	public String getSignUpLabelText()
	{
		waitForVisibilty(signupLabel);
		return signupLabel.getText();
	}
//	public String getLoginLabelText()
//	{
//		waitForVisibilty(loginLabel);
//		return loginLabel.getText();
//	}
//	
//	public void enterLoginEmail(String lname) {
//		waitForVisibilty(loginemail);
//		loginemail.clear();
//		loginemail.sendKeys(lname);
//	}
//	
//	public void enterLoginPassword(String loginPwd) {
//		loginPassword.clear();
//		loginPassword.sendKeys(loginPwd);
//	}
//	
//	public void clickAndVerifyLoginBtn()
//	{
//		loginBtn.click();
//	}
//	
//	public String checkLoginErrorMsg()
//	{
//		waitForVisibilty(loginErrorMsg);
//		return loginErrorMsg.getText();
//	}
	
	public void enterName(String uname) {
		waitForVisibilty(name);
		name.clear();
		name.sendKeys(uname);
	}
	
	public void enterEmail(String userEmail) {
		email.clear();
		email.sendKeys(userEmail);
	}
	
	public void clickAndVerifySignupBtn()
	{
		signupBtn.click();
	}
	
	public String checkSignupSuccess()
	{
		waitForVisibilty(registerInfoLabel);
		return registerInfoLabel.getText();
	}
	public String checkExistingMail()
	{
		waitForVisibilty(emailExistMsg);
		return emailExistMsg.getText();
	}
	public void selectTitle()
	{
		title.click();
	}
	
	public void enterUsername(String uname)
	{
		fullName.clear();
		fullName.sendKeys(uname);
	}
	
	
	public void enterUserPassword(String upwd)
	{
		userPassword.clear();
		userPassword.sendKeys(upwd);
	}
	
	public void SelectDays(String day)
	{
		clickDaysDropdown.click();
		Select days=new Select(clickDaysDropdown);
		days.selectByValue(day);
	}
	
	public void SelectMonths(String month)
	{
		clickDaysDropdown.click();
		Select months=new Select(clickMonthsDropdown);
		months.selectByValue(month);
	}
	
	public void SelectYears(String year)
	{
		clickDaysDropdown.click();
		Select years=new Select(clickYearsDropdown);
		years.selectByValue(year);
	}
	
	public void selectCheckboxes()
	{
		selectCBForNewsletter.click();
		selectCBForOffers.click();
	}
	
	public void enterFirstName(String fname)
	{
		firstName.clear();
		firstName.sendKeys(fname);
	}
	
	public void enterLastName(String lname)
	{
		lastName.clear();
		lastName.sendKeys(lname);
	}
	
	public void enterAddress1(String add1)
	{
		address1.clear();
		address1.sendKeys(add1);
	}
	
	public void enterState(String stateName)
	{
		state.clear();
		state.sendKeys(stateName);
	}
	
	public void enterCity(String cityName)
	{
		city.clear();
		city.sendKeys(cityName);
	}
	
	public void enterZipcode(String Zp)
	{
		zipcode.clear();
		zipcode.sendKeys(Zp);
	}
	
	public void enterMobileNo(String mno)
	{
		mobileNumber.clear();
		mobileNumber.sendKeys(mno);
	}
	
	public String clickAndVerifyCreateAccountBtn()
	{
		createAccountBtn.click();
		waitForVisibilty(getAccountCreationText);
		return getAccountCreationText.getText();
	}
	
	public void clickContinueButton()
	{
		waitForVisibilty(continueBtn);
		continueBtn.click();
	}
	
	public String verifyLoggedInUser()
	{
		waitForVisibilty(loggedInUsername);
		return loggedInUsername.getText();
	}
	
	public String deleteAccountOfUser() {
		waitForVisibilty(deleteAccBtn);
		deleteAccBtn.click();
		waitForVisibilty(deleteMsg);
		return deleteMsg.getText();
	}
	
//	public void clickLogoutBtn()
//	{
//		waitForVisibilty(logoutBtn);
//		logoutBtn.click();
//	}
	//utility method, using this you dont need to call wait method for each webelement
	private void waitForVisibilty(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
