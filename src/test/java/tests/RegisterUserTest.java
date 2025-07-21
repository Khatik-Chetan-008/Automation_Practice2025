package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import main.BaseClass;
import main.RegisterUserPage;

public class RegisterUserTest extends BaseClass{

	RegisterUserPage rs;
	@BeforeMethod
	public void setBeforeData()
	{
		rs=new RegisterUserPage(driver);
	}
	
	@Test(priority=1)
	public void signUpUser()
	{
		//Verify Signup with valid credentials and user should be navigated to registration page
		SoftAssert softAssert=new SoftAssert();
		rs.clickSignup();
		String actualSignUpLabelText=rs.getSignUpLabelText();
		String signUpLabelText="New User Signup!";
		softAssert.assertEquals(actualSignUpLabelText, signUpLabelText, "No such text is available");

		rs.enterName("Ganesh");
		rs.enterEmail("Ganesh9@mailinator.com");
		rs.clickAndVerifySignupBtn();
		String actualResult=rs.checkSignupSuccess();
		String expectedResult="ENTER ACCOUNT INFORMATION";
		softAssert.assertEquals(actualResult, expectedResult, "User is not navigated to signup/registration page");
		softAssert.assertAll();
	}
	
	
	@Test(dependsOnMethods="signUpUser")
	public void fillAndConfirmRegistrationDetails()
	{
		//Verify account creation with filling valid data
		SoftAssert softAssert=new SoftAssert();

		rs.selectTitle();
		rs.enterUsername("Ganesh");
		rs.enterUserPassword("Test@123");
		rs.SelectDays("13");
		rs.SelectMonths("12");
		rs.SelectYears("1996");
		rs.selectCheckboxes();
		rs.enterFirstName("Ganesh");
		rs.enterLastName("Sharma");
		rs.enterAddress1("Vastral,Ahmedabad");
		rs.enterState("Gujarat");
		rs.enterCity("Ahmedabad");
		rs.enterZipcode("382123");
		rs.enterMobileNo("8759523352");
	
		String actualResult=rs.clickAndVerifyCreateAccountBtn();
		String expectedResult="ACCOUNT CREATED!";
		softAssert.assertEquals(actualResult, expectedResult, "Account not created");
		softAssert.assertAll();
		rs.clickContinueButton();

	}
	
	@Test(dependsOnMethods="fillAndConfirmRegistrationDetails")
//	@Test(enabled=false) //enabled=false is used for skipping the test case
	public void verifyLoggedInUserName()
	{

		//Verify registered user account is deleted 
		SoftAssert softAssert=new SoftAssert();
		String text=rs.verifyLoggedInUser();
		softAssert.assertEquals(text, "Logged in as Ganesh", "No such user");
		String deleteAcctMsg=rs.deleteAccountOfUser();
		softAssert.assertEquals(deleteAcctMsg, "ACCOUNT DELETED!", "Account deleted msg is not displayed");
		rs.clickContinueButton();
		softAssert.assertAll();
	}
	
	@Test(priority=2)
	public void signupWithExistingEmail()
	{
		//Verify Signup with existing email id
		SoftAssert softAssert=new SoftAssert();
		rs.clickSignup();
		rs.enterName("Ganesh");
		rs.enterEmail("Ganesh7@mailinator.com");
		rs.clickAndVerifySignupBtn();
		String actualResult=rs.checkExistingMail();
		String expectedResult="Email Address already exist!";
		softAssert.assertEquals(actualResult, expectedResult, "Error message page");
		softAssert.assertAll();

	}
	
//	@Test(priority=3)
//	public void loginWithInvalidCredentials()
//	{
//		//Verify login functionality with invalid credentials
//		SoftAssert softAssert= new SoftAssert();	
//		rs.enterLoginEmail("Ganesh7@mailinator.com");
//		rs.enterLoginPassword("Test@12");
//		rs.clickAndVerifyLoginBtn();
//		String actualLoginErrorMsg=rs.checkLoginErrorMsg();
//		softAssert.assertEquals(actualLoginErrorMsg, "Your email or password is incorrect!","Wrong msg displayed");
//		softAssert.assertAll();
//		
//	}
//	@Test(priority=4)
//	public void loginWithValidCredentials()
//	{
//		//Verify login functionality with valid credentials
//		SoftAssert softAssert= new SoftAssert();			
//		rs.enterLoginEmail("Ganesh7@mailinator.com");
//		rs.enterLoginPassword("Test@123");
//		rs.clickAndVerifyLoginBtn();
//		String text=rs.verifyLoggedInUser();
//		softAssert.assertEquals(text, "Logged in as Ganesh", "User is not logged in");
//		softAssert.assertAll();
//		
//	}
//	
//	@Test(dependsOnMethods="loginWithValidCredentials")
//	public void logoutUser()
//	{
//		//Verify logout functionality 
//		SoftAssert softAssert= new SoftAssert();			
//		rs.clickLogoutBtn();
//		String actualLoginLabelText=rs.getLoginLabelText();
//		String loginLabelText="Login to your account";
//		softAssert.assertEquals(actualLoginLabelText, loginLabelText, "No such text is available for login");
//		softAssert.assertAll();
//	}
//	
}
