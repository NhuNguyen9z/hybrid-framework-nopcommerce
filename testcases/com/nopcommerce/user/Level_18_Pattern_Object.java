package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

@Listeners(commons.MethodListener.class)
public class Level_18_Pattern_Object extends BaseTest {

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
		day = "10";
		month = "May";
		year = "1999";
	}

	@Test
	public void User_01_Register() {
		log.info("Register - Step 01: Navigate to 'Register' page");
		registerPage = homePage.openRegisterPage();

		registerPage.clickToRadioByText(driver, "Female");

		log.info("Register - Step 02: Enter to Fistname textbox with value is '" + firstName + "'");
		registerPage.inputToTextboxById(driver, "FirstName", firstName);

		log.info("Register - Step 03: Enter to Lastname textbox with value is '" + lastName + "'");
		registerPage.inputToTextboxById(driver, "LastName", lastName);

		registerPage.selectToDropdownByName(driver, "DateOfBirthDay", day);
		registerPage.selectToDropdownByName(driver, "DateOfBirthMonth", month);
		registerPage.selectToDropdownByName(driver, "DateOfBirthYear", year);

		log.info("Register - Step 04: Enter to Email textbox with value is '" + emailAddress + "'");
		registerPage.inputToTextboxById(driver, "Email", emailAddress);

		registerPage.clickToCheckboxByText(driver, "Newsletter");

		log.info("Register - Step 05: Enter to Password textbox with value is '" + validPassword + "'");
		registerPage.inputToTextboxById(driver, "Password", validPassword);

		log.info("Register - Step 06: Enter to Confirm Password textbox with value is '" + validPassword + "'");
		registerPage.inputToTextboxById(driver, "ConfirmPassword", validPassword);

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

		log.info("Login - Step 03: Enter to Password textbox with value is '" + validPassword + "'");
		loginPage.inputToTextboxById(driver, "Password", validPassword);

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
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "FirstName"), firstName);

		log.info("Customer-Infor - Step 05: Verify 'Last Name' is correctly");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "LastName"), lastName);

		log.info("Customer-Infor - Step 06: Verify 'Email' value is correctly");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "Email"), emailAddress);

		log.info("Customer-Infor - Step 07: Verify 'Day' value is correctly");
		Assert.assertEquals(customerInfoPage.getDropdownValueByID(driver, "DateOfBirthDay", day), day);

		log.info("Customer-Infor - Step 08: Verify 'Month' value is correctly");
		Assert.assertEquals(customerInfoPage.getDropdownValueByID(driver, "DateOfBirthMonth", month), month);

		log.info("Customer-Infor - Step 09: Verify 'Year' value is correctly");
		Assert.assertEquals(customerInfoPage.getDropdownValueByID(driver, "DateOfBirthYear", year), year);

		log.info("Customer-Infor - Step 10: Verify 'Checkbox' Newsletter is displayed");
		Assert.assertTrue(customerInfoPage.isCheckboxByTextDisplayedByText(driver, "Newsletter"));

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();

	}

	private WebDriver driver;
	private String firstName, lastName, emailAddress, validPassword, day, month, year;

	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInfoPage;

}
// KO dùng Pattern Object khi: specific element chỉ có ở màn hình đó - KO có sử dụng ở nhiều màn hình
// Pattern Object KO phù hợp cho tất cả các loại dự án
// Có thể kết hợp vừa Page Object với Pattern Object
