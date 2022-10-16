package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.UserData;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_20_Manage_Data_Faker_Part_III extends BaseTest {

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		emailAddress = UserData.Register.EMAILL_ADDRESS + generateFakeNumber() + "@live.com";

	}

	@Test
	public void User_01_Register() {
		log.info("Register - Step 01: Navigate to 'Register' page");
		registerPage = homePage.openRegisterPage();

		registerPage.clickToRadioByText(driver, "Female");

		log.info("Register - Step 02: Enter to Fistname textbox with value is '" + UserData.Register.FIRST_NAME + "'");
		registerPage.inputToTextboxById(driver, "FirstName", UserData.Register.FIRST_NAME);

		log.info("Register - Step 03: Enter to Lastname textbox with value is '" + UserData.Register.LAST_NAME + "'");
		registerPage.inputToTextboxById(driver, "LastName", UserData.Register.LAST_NAME);

		registerPage.selectToDropdownByName(driver, "DateOfBirthDay", UserData.Register.DAY);
		registerPage.selectToDropdownByName(driver, "DateOfBirthMonth", UserData.Register.MONTH);
		registerPage.selectToDropdownByName(driver, "DateOfBirthYear", UserData.Register.YEAR);

		log.info("Register - Step 04: Enter to Email textbox with value is '" + emailAddress + "'");
		registerPage.inputToTextboxById(driver, "Email", emailAddress);

		registerPage.clickToCheckboxByText(driver, "Newsletter");

		log.info("Register - Step 05: Enter to Password textbox with value is '" + UserData.Register.PASSWORD + "'");
		registerPage.inputToTextboxById(driver, "Password", UserData.Register.PASSWORD);

		log.info("Register - Step 06: Enter to Confirm Password textbox with value is '" + UserData.Register.PASSWORD + "'");
		registerPage.inputToTextboxById(driver, "ConfirmPassword", UserData.Register.PASSWORD);

		log.info("Register - Step 07: Click to 'Register' button");
		registerPage.clickToButtonByText(driver, "Register");

		log.info("Register - Step 08: Verify Register success message is displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		log.info("Register - Step 09: Click to Logout link");
		homePage = registerPage.clickToLogoutLink();

	}

	@Test
	public void User_02_Login() {
		log.info("Login - Step 01: Navigate to 'Login' page");
		loginPage = homePage.openLoginPage();

		log.info("Login - Step 02: Enter to Email textbox with value is '" + emailAddress + "'");
		loginPage.inputToTextboxById(driver, "Email", emailAddress);

		log.info("Login - Step 03: Enter to Password textbox with value is '" + UserData.Register.PASSWORD + "'");
		loginPage.inputToTextboxById(driver, "Password", UserData.Register.PASSWORD);

		log.info("Login - Step 04: Click to Login button");
		loginPage.clickToButtonByText(driver, "Log in");
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Login - Step 05: Verify 'My Account' link is displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());

	}

	@Test
	public void User_03_Customer_Infor() {
		log.info("Customer-Infor - Step 01: Navigate to 'Customer Info' page ");
		customerInfoPage = homePage.openCustomerInforPage();

		log.info("Customer-Infor - Step 02: Verify 'Customer Info' page is displayed");
		verifyTrue(customerInfoPage.isCustomerInforPageDisplayed());

		log.info("Customer-Infor - Step 03: Verify 'Radio' value is displayed");
		Assert.assertTrue(customerInfoPage.isRadioByTextDisplayedByText(driver, "Female"));

		log.info("Customer-Infor - Step 04: Verify 'First Name' value is correctly");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "FirstName"), UserData.Register.FIRST_NAME);

		log.info("Customer-Infor - Step 05: Verify 'Last Name' is correctly");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "LastName"), UserData.Register.LAST_NAME);

		log.info("Customer-Infor - Step 06: Verify 'Email' value is correctly");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "Email"), emailAddress);

		log.info("Customer-Infor - Step 07: Verify 'Day' value is correctly");
		Assert.assertEquals(customerInfoPage.getDropdownValueByID(driver, "DateOfBirthDay", UserData.Register.DAY), UserData.Register.DAY);

		log.info("Customer-Infor - Step 08: Verify 'Month' value is correctly");
		Assert.assertEquals(customerInfoPage.getDropdownValueByID(driver, "DateOfBirthMonth", UserData.Register.MONTH), UserData.Register.MONTH);

		log.info("Customer-Infor - Step 09: Verify 'Year' value is correctly");
		Assert.assertEquals(customerInfoPage.getDropdownValueByID(driver, "DateOfBirthYear", UserData.Register.YEAR), UserData.Register.YEAR);

		log.info("Customer-Infor - Step 10: Verify 'Checkbox' Newsletter is displayed");
		Assert.assertTrue(customerInfoPage.isCheckboxByTextDisplayedByText(driver, "Newsletter"));

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();

	}

	private WebDriver driver;
	private String emailAddress;

	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInfoPage;

}
