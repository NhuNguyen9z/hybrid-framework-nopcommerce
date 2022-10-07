package com.nopcommerce.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import reportConfig.ExtentTestManagerV5;

@Listeners(commons.MethodListener.class)
public class Level_15_ExtentV5_ScreenShot extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "Testing";
		emailAddress = "auto" + generateFakeNumber() + "@hotmail.com";
		validPassword = "123456";
		System.out.println(emailAddress);

	}

	@Test
	public void User_01_Register(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "Register to system with valid Email and Password");
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 01: Navigate to 'Register' page");
		registerPage = homePage.openRegisterPage();

		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 02: Enter to Firstname textbox with value is '" + firstName + "'");
		registerPage.inputToFirstnameTextbox(firstName);

		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 03: Enter to Lastname textbox with value is '" + lastName + "'");
		registerPage.inputToLastnameTextbox(lastName);

		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 04: Enter to Email textbox with value is '" + emailAddress + "'");
		registerPage.inputToEmailTextbox(emailAddress);

		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 05: Enter to Password textbox with value is '" + validPassword + "'");
		registerPage.inputToPasswordTextbox(validPassword);

		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 06: Enter to Confirm Password textbox with value is '" + validPassword + "'");
		registerPage.inputToConfirmPasswordTextbox(validPassword);

		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 07: Click to 'Register' button");
		registerPage.clickToRegisterButton();

		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 08: Verify register success message is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	}

	@Test
	public void User_02_Login(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "Login to system successfully");
		ExtentTestManagerV5.getTest().log(Status.INFO, "Login - Step 01: Navigate to Login page");
		homePage = registerPage.clickToLogoutLink();
		loginPage = homePage.openLoginPage();

		ExtentTestManagerV5.getTest().log(Status.INFO, "Login - Step 02: Enter to Email textbox with value is '" + emailAddress + "'");
		loginPage.inputToEmailTextbox(emailAddress);

		ExtentTestManagerV5.getTest().log(Status.INFO, "Login - Step 03: Enter to Password textbox with value is '" + validPassword + "'");
		loginPage.inputToPasswordTextbox(validPassword);

		ExtentTestManagerV5.getTest().log(Status.INFO, "Login - Step 04: Click to Login button");
		homePage = loginPage.clickToLoginButton();

		ExtentTestManagerV5.getTest().log(Status.INFO, "Login - Step 05: Verify 'My Account' link is displayed");
		Assert.assertFalse(homePage.isMyAccountLinkDisplayed());

		ExtentTestManagerV5.getTest().log(Status.INFO, "Login - Step 06: Navigate to 'My Account' page");
		customerInforPage = homePage.openCustomerInforPage();

		ExtentTestManagerV5.getTest().log(Status.INFO, "Login - Step 06: Verify 'Customer Infor' page is displayed");
		Assert.assertFalse(customerInforPage.isCustomerInforPageDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();

	}

	private WebDriver driver;
	private String firstName, lastName, emailAddress, validPassword;

	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;

}
