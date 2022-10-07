package com.nopcommerce.common;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Common_02_Register_Cookie extends BaseTest {

	@Parameters("browser")
	@BeforeTest(description = "Create new common User for all Classes Test")
	public void Register(String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "Testing";
		emailAddress = "auto" + generateFakeNumber() + "@hotmail.com";
		password = "123456";

		log.info("Pre-condition - Step 01: Navigate to 'Register' page");
		registerPage = homePage.openRegisterPage();

		log.info("Pre-condition - Step 02: Enter to Fistname textbox with value is '" + firstName + "'");
		registerPage.inputToFirstnameTextbox(firstName);

		log.info("Pre-condition - Step 03: Enter to Lastname textbox with value is '" + lastName + "'");
		registerPage.inputToLastnameTextbox(lastName);

		log.info("Pre-condition - Step 04: Enter to Email textbox with value is '" + emailAddress + "'");
		registerPage.inputToEmailTextbox(emailAddress);

		log.info("Pre-condition - Step 05: Enter to Password textbox with value is '" + password + "'");
		registerPage.inputToPasswordTextbox(password);

		log.info("Pre-condition - Step 06: Enter to Confirm Password textbox with value is '" + password + "'");
		registerPage.inputToConfirmPasswordTextbox(password);

		log.info("Pre-condition - Step 07: Click to 'Register' button");
		registerPage.clickToRegisterButton();

		log.info("Pre-condition - Step 08: Verify Register success message is displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		log.info("Pre-condition - Step 09: Click to Logout link");
		homePage = registerPage.clickToLogoutLink();

		log.info("Pre-condition - Step 10: Navigate to 'Login' page");
		loginPage = homePage.openLoginPage();

		log.info("Pre-condition - Step 11: Enter to Email textbox with value is '" + emailAddress + "'");
		loginPage.inputToEmailTextbox(emailAddress);

		log.info("Pre-condition - Step 12: Enter to Password textbox with value is '" + password + "'");
		loginPage.inputToPasswordTextbox(password);

		log.info("Pre-condition - Step 13: Click to Login button");
		homePage = loginPage.clickToLoginButton();

		loggedCookies = registerPage.getAllCookies(driver);
		for (Cookie cookie : loggedCookies) {
			System.out.println("Cookie at Common Class: " + cookie);
		}

	}

	@AfterTest
	public void AfterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private String firstName, lastName;
	public static String emailAddress, password;
	private UserLoginPageObject loginPage;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	public static Set<Cookie> loggedCookies;
	// Biến static thuộc Class quản lý ko thuộc instance quản lý - nên Class mà run xong thì các biến instance tự động hủy nhưng biến static vẫn còn tồn tại
	// Khi nào máy ảo java nó ko chạy nữa (all các class đều dc run xong) thì các biến static mới bị hủy đi

	// Các action chuyển trang thì lưu ý:
	// - Nên tạo page class mới khi 1 page có action/ element (viết hàm/ define các locator tương ứng): PO + UI
	// - Follow theo business của app chứ ko follow theo cái UI của app, UI có nhiều page html nhưng business vẫn là 1 page -> define thành 1 page class

}
