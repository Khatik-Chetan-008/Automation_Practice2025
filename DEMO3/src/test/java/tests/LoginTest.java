package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import main.BaseClass;
import main.LoginPage;

@Listeners(utilities.ScreenshotListener.class)
public class LoginTest extends BaseClass{

	LoginPage login;
	@BeforeMethod
	public void setBefore()
	{
		login=new LoginPage(driver);
	}
	
	@Test(priority=1)
	public void loginWithInvalidCredentials()
	{
		//Verify login functionality with invalid credentials
		SoftAssert softAssert= new SoftAssert();	
		login.clickSignup();
		login.enterLoginEmail("Ganesh7@mailinator.com");
		login.enterLoginPassword("Test@12");
		login.clickAndVerifyLoginBtn();
		String actualLoginErrorMsg=login.checkLoginErrorMsg();
		softAssert.assertEquals(actualLoginErrorMsg, "Your email or password is incorrect!","Wrong msg displayed");
		softAssert.assertAll();
		
	}
	
	@Test(priority=2)
	public void loginWithValidCredentials()
	{
		//Verify login functionality with valid credentials
		SoftAssert softAssert= new SoftAssert();			
		login.enterLoginEmail("Ganesh7@mailinator.com");
		login.enterLoginPassword("Test@123");
		login.clickAndVerifyLoginBtn();
		String text=login.verifyLoggedInUser();
		softAssert.assertEquals(text, "Logged in as Ganesh", "User is not logged in");
		softAssert.assertAll();
		
	}
	
	@Test(dependsOnMethods="loginWithValidCredentials")
	public void logoutUser()
	{
		//Verify logout functionality 
		SoftAssert softAssert= new SoftAssert();			
		login.clickLogoutBtn();
		String actualLoginLabelText=login.getLoginLabelText();
		String loginLabelText="Login to your account";
		softAssert.assertEquals(actualLoginLabelText, loginLabelText, "No such text is available for login");
		softAssert.assertAll();
	}
	
}
