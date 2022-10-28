package com.nopcommerce.user;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.UserDataMapper;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import uitilities.Environment;

public class Level_22_Multiple_Enviroment_Owner extends BaseTest {

	@Parameters({ "browser", "environment" })
	@BeforeClass
	public void beforeClass(String browserName, String environmentName) {

		// Set "env" == environmentName -- "env" chính là đại diện cho tên tiền tố của file .properties ví dụ dev.properties
		// khi chạy sẽ map env cho biến ${env} trong Environment interface để đổi cái tên
		ConfigFactory.setProperty("env", environmentName);

		// tạo ra 1 instance của Environment interface
		environment = ConfigFactory.create(Environment.class);

		// sẽ gọi đến hàm appUrl() hàm này sẽ gọi đến file dev.properties để lấy App.Url ra sau đó truyền vào cho hàm getBrowserDriver
		driver = getBrowserDriver(browserName, environment.appUrl());

		System.out.println(environment.appUrl());
		System.out.println(environment.appUser());
		System.out.println(environment.appPass());
		System.out.println(environment.dbUsername());
		System.out.println(environment.dbPassword());
		System.out.println(environment.dbHostname());

		homePage = PageGeneratorManager.getUserHomePage(driver);
		userData = UserDataMapper.getUserData();
		emailAddress = userData.getEmailAddress() + generateFakeNumber() + "@fakemail.com";

	}

	@Test
	public void User_01_Register() {
		log.info("Register - Step 01: Navigate to 'Register' page");
		registerPage = homePage.openRegisterPage();

		registerPage.clickToRadioByText(driver, "Female");

		log.info("Register - Step 02: Enter to Fistname textbox with value is '" + userData.getFirstName() + "'");
		registerPage.inputToTextboxById(driver, "FirstName", userData.getFirstName());

		log.info("Register - Step 03: Enter to Lastname textbox with value is '" + userData.getLastName() + "'");
		registerPage.inputToTextboxById(driver, "LastName", userData.getLastName());

		registerPage.selectToDropdownByName(driver, "DateOfBirthDay", userData.getDay());
		registerPage.selectToDropdownByName(driver, "DateOfBirthMonth", userData.getMonth());
		registerPage.selectToDropdownByName(driver, "DateOfBirthYear", userData.getYear());

		log.info("Register - Step 04: Enter to Email textbox with value is '" + emailAddress + "'");
		registerPage.inputToTextboxById(driver, "Email", emailAddress);

		registerPage.clickToCheckboxByText(driver, "Newsletter");

		log.info("Register - Step 05: Enter to Password textbox with value is '" + userData.getPassword() + "'");
		registerPage.inputToTextboxById(driver, "Password", userData.getPassword());

		log.info("Register - Step 06: Enter to Confirm Password textbox with value is '" + userData.getPassword() + "'");
		registerPage.inputToTextboxById(driver, "ConfirmPassword", userData.getPassword());

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

		log.info("Login - Step 03: Enter to Password textbox with value is '" + userData.getLoginPassword() + "'");
		loginPage.inputToTextboxById(driver, "Password", userData.getLoginPassword());

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
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "FirstName"), userData.getFirstName());

		log.info("Customer-Infor - Step 05: Verify 'Last Name' is correctly");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "LastName"), userData.getLastName());

		log.info("Customer-Infor - Step 06: Verify 'Email' value is correctly");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "Email"), emailAddress);

		log.info("Customer-Infor - Step 07: Verify 'Day' value is correctly");
		Assert.assertEquals(customerInfoPage.getDropdownValueByID(driver, "DateOfBirthDay", userData.getDay()), userData.getDay());

		log.info("Customer-Infor - Step 08: Verify 'Month' value is correctly");
		Assert.assertEquals(customerInfoPage.getDropdownValueByID(driver, "DateOfBirthMonth", userData.getMonth()), userData.getMonth());

		log.info("Customer-Infor - Step 09: Verify 'Year' value is correctly");
		Assert.assertEquals(customerInfoPage.getDropdownValueByID(driver, "DateOfBirthYear", userData.getYear()), userData.getYear());

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
	private UserDataMapper userData;
	Environment environment;

}
