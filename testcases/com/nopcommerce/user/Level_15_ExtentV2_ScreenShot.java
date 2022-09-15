package com.nopcommerce.user;

//import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;

//import com.relevantcodes.extentreports.LogStatus;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
//import reportConfig.ExtentManagerV2;

@Listeners(commons.MethodListener.class)
public class Level_15_ExtentV2_ScreenShot extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "Testing";
		emailAddress = "auto" + generateFakeEmail() + "@hotmail.com";
		validPassword = "123456";
		System.out.println(emailAddress);

	}

	// @Test
	// public void User_01_Register(Method method) {
	// ExtentManagerV2.startTest(method.getName(), "User_01_Register");
	// ExtentManagerV2.getTest().log(LogStatus.INFO, "Register - Step 01: Navigate to 'Register' page");
	// registerPage = homePage.openRegisterPage();
	//
	// ExtentManagerV2.getTest().log(LogStatus.INFO, "Register - Step 02: Enter to Fistname textbox with value is '" + firstName + "'");
	// registerPage.inputToFirstnameTextbox(firstName);
	//
	// ExtentManagerV2.getTest().log(LogStatus.INFO, "Register - Step 03: Enter to Lastname textbox with value is '" + lastName + "'");
	// registerPage.inputToLastnameTextbox(lastName);
	//
	// ExtentManagerV2.getTest().log(LogStatus.INFO, "Register - Step 04: Enter to Email textbox with value is '" + emailAddress + "'");
	// registerPage.inputToEmailTextbox(emailAddress);
	//
	// ExtentManagerV2.getTest().log(LogStatus.INFO, "Register - Step 05: Enter to Password textbox with value is '" + validPassword + "'");
	// registerPage.inputToPasswordTextbox(validPassword);
	//
	// ExtentManagerV2.getTest().log(LogStatus.INFO, "Register - Step 06: Enter to Confirm Password textbox with value is '" + validPassword + "'");
	// registerPage.inputToConfirmPasswordTextbox(validPassword);
	//
	// ExtentManagerV2.getTest().log(LogStatus.INFO, "Register - Step 07: Click to 'Register' button");
	// registerPage.clickToRegisterButton();
	//
	// ExtentManagerV2.getTest().log(LogStatus.INFO, "Register - Step 08: Verify Register success message is displayed");
	// Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed ...");
	// ExtentManagerV2.endTest();
	// }
	//
	// @Test
	// public void User_02_Login(Method method) {
	// ExtentManagerV2.startTest(method.getName(), "User_02_Login");
	// ExtentManagerV2.getTest().log(LogStatus.INFO, "Login - Step 01: Navigate to 'Login' page");
	// homePage = registerPage.clickToLogoutLink();
	// loginPage = homePage.openLoginPage();
	//
	// ExtentManagerV2.getTest().log(LogStatus.INFO, "Login - Step 02: Enter to Email textbox with value is '" + emailAddress + "'");
	// loginPage.inputToEmailTextbox(emailAddress);
	//
	// ExtentManagerV2.getTest().log(LogStatus.INFO, "Login - Step 03: Enter to Password textbox with value is '" + validPassword + "'");
	// loginPage.inputToPasswordTextbox(validPassword);
	//
	// ExtentManagerV2.getTest().log(LogStatus.INFO, "Login - Step 04: Click to Login button");
	// homePage = loginPage.clickToLoginButton();
	//
	// ExtentManagerV2.getTest().log(LogStatus.INFO, "Login - Step 05: Verify 'My Account' link is displayed");
	// Assert.assertFalse(homePage.isMyAccountLinkDisplayed());
	//
	// ExtentManagerV2.getTest().log(LogStatus.INFO, "Login - Step 06: Navigate to 'Customer Info' page ");
	// customerInfoPage = homePage.openCustomerInforPage();
	//
	// ExtentManagerV2.getTest().log(LogStatus.INFO, "Login - Step 07: Verify 'Customer Info' page is displayed");
	// Assert.assertFalse(customerInfoPage.isCustomerInfoPageDisplayed());
	// ExtentManagerV2.endTest();
	// }

	@AfterClass
	public void afterClass() {
		driver.quit();

	}

	WebDriver driver;
	String firstName, lastName, emailAddress, validPassword;

	UserHomePageObject homePage;
	UserRegisterPageObject registerPage;
	UserLoginPageObject loginPage;
	UserCustomerInforPageObject customerInfoPage;

}
