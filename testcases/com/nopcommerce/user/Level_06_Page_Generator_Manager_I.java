package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_06_Page_Generator_Manager_I extends BaseTest {

	// Declare
	private WebDriver driver;
	private String firstName, lastName, existingEmail, notFoundEmail, invalidEmail, validPassword, incorrectPassword;

	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = new UserHomePageObject(driver);

		firstName = "Automation";
		lastName = "Testing";
		existingEmail = "akp" + generateFakeNumber() + "@hotmail.com";
		notFoundEmail = "akp" + generateFakeNumber() + "@yahoo.com";
		invalidEmail = "123@123@";
		validPassword = "123456";
		incorrectPassword = "123123";

		System.out.println("Pre-condition - Step 01: Click register link");
		homePage.openRegisterPage();

		// Click Register link -> nhảy qua trang Register
		registerPage = new UserRegisterPageObject(driver);

		System.out.println("Pre-condition - Step 02: Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(existingEmail);
		registerPage.inputToPasswordTextbox(validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);

		System.out.println("Pre-condition - Step 03: Click register button");
		registerPage.clickToRegisterButton();

		System.out.println("Pre-condition - Step 04: Verify success message displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		System.out.println("Pre-condition - Step 05: Click logout link");
		registerPage.clickToLogoutLink();

		// Click Logout thì bussiness nó sẽ quay về HomePage
		homePage = new UserHomePageObject(driver);

		// Cách 1:
		// - Cho việc khởi tạo Page Object trực tiếp ở trên testcase
		// - Kết nối giữa 2 Page Object với nhau
		// - KO bị lỗi NullPointer (1 class mang ra sử dụng nhưng chưa được khởi tạo)
		// Nhược điểm:
		// 1, Hiển thị việc khởi tạo page/ class ở trên testcase luôn (ko tuân theo tính chất đóng gói/ che dấu sự khởi tạo 1 đối tượng) - Encapsulation của OOP
		// 2, Bị lặp lại đoạn code khởi tạo page ở các step

	}

	@Test
	public void Login_01_Empty_Data() {
		homePage.openLoginPage();

		// Từ trang Home - click LoginLink -> nhảy qua trang Login
		loginPage = new UserLoginPageObject(driver);

		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");

	}

	@Test
	public void Login_02_Invalid_Email() {
		homePage.openLoginPage();

		// Từ trang Home - click LoginLink -> nhảy qua trang Login
		loginPage = new UserLoginPageObject(driver);

		loginPage.inputToEmailTextbox(invalidEmail);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");

	}

	@Test
	public void Login_03_Email_Not_Found() {
		homePage.openLoginPage();

		// Từ trang Home - click LoginLink -> nhảy qua trang Login
		loginPage = new UserLoginPageObject(driver);

		loginPage.inputToEmailTextbox(notFoundEmail);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageUnSuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

	}

	@Test
	public void Login_04_Existing_Email_Emty_Password() {
		homePage.openLoginPage();

		// Từ trang Home - click LoginLink -> nhảy qua trang Login
		loginPage = new UserLoginPageObject(driver);

		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox("");

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageUnSuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void Login_05_Existing_Email_Incorrect_Password() {

		homePage.openLoginPage();

		// Từ trang Home - click LoginLink -> nhảy qua trang Login
		loginPage = new UserLoginPageObject(driver);

		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(incorrectPassword);
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageUnSuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_06_Valid_Email_Password() {

		homePage.openLoginPage();

		// Từ trang Home - click LoginLink -> nhảy qua trang Login
		loginPage = new UserLoginPageObject(driver);

		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(validPassword);
		loginPage.clickToLoginButton();

		// Login thành công -> nhảy qua trang HomePage
		homePage = new UserHomePageObject(driver);

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

	}

	@AfterClass
	public void afterClass() {
		driver.quit();

	}

}
