package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pagesObjects.HomePageObject;
import pagesObjects.LoginPageObject;
import pagesObjects.RegisterPageObject;

public class Level_03_Page_Object_02_Login {

	// Declare
	private WebDriver driver;
	private String firstName, lastName, existingEmail, notFoundEmail, invalidEmail, validPassword, incorrectPassword;
	private String projectPath = System.getProperty("user.dir"); // Lấy ra thư mục của dự án
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe"); // nối chuỗi
		// 1 class chỉ được khởi tạo driver duy nhất 1 lần
		driver = new FirefoxDriver(); // sau khi chạy xong thì driver có 1 ID rồi
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // Setting timeout

		// Mở Url lên nó qua trang HomePage
		driver.get("https://demo.nopcommerce.com/");
		homePage = new HomePageObject(driver);

		firstName = "Automation";
		lastName = "Testing";
		existingEmail = "akp" + generateEmail() + "@hotmail.com";
		notFoundEmail = "akp" + generateEmail() + "@yahoo.com";
		invalidEmail = "123@123@";
		validPassword = "123456";
		incorrectPassword = "123123";

		System.out.println("Pre-condition - Step 01: Click register link");
		homePage.clickToRegisterLink();

		// Click Register link -> nhảy qua trang Register
		registerPage = new RegisterPageObject(driver);

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
		homePage = new HomePageObject(driver);

		// Beforeclass là pre-condition: để cho all các testcase có thể chạy dc
		// After class là pause condition
		// Bỏ đoạn code Register vào beforeClass mục đích: tái sử dụng lại 1 đoạn code ở bên Register - ko reference đến class Register
		// Phần precondition fail thì all các testcase đều bị skip bao gồm cả afterClass
		// Đang có tham số nếu bấm refesh sẽ gửi request lên server 1 lần nữa
		// Page Object: nguyên tắc là từ 1 trang A qua trang B thì phải khởi tạo trang B lên

		// Làm tập trung:
		// - Testcase - viết Step 1 lượt hết
		// - UI: định nghĩa các locator 1 lượt hết
		// - Action: gọi hàm và ráp locator 1 lượt hết
	}

	@Test
	public void Login_01_Empty_Data() {
		homePage.clickToLoginLink();

		// Từ trang Home - click LoginLink -> nhảy qua trang Login
		loginPage = new LoginPageObject(driver);

		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");

	}

	@Test
	public void Login_02_Invalid_Email() {
		homePage.clickToLoginLink();

		// Từ trang Home - click LoginLink -> nhảy qua trang Login
		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(invalidEmail);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");

	}

	@Test
	public void Login_03_Email_Not_Found() {
		homePage.clickToLoginLink();

		// Từ trang Home - click LoginLink -> nhảy qua trang Login
		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(notFoundEmail);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageUnSuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

	}

	@Test
	public void Login_04_Existing_Email_Emty_Password() {
		homePage.clickToLoginLink();

		// Từ trang Home - click LoginLink -> nhảy qua trang Login
		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox("");

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageUnSuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void Login_05_Existing_Email_Incorrect_Password() {

		homePage.clickToLoginLink();

		// Từ trang Home - click LoginLink -> nhảy qua trang Login
		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(incorrectPassword);
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageUnSuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_06_Valid_Email_Password() {

		homePage.clickToLoginLink();

		// Từ trang Home - click LoginLink -> nhảy qua trang Login
		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(validPassword);
		loginPage.clickToLoginButton();

		// Login thành công -> nhảy qua trang HomePage
		homePage = new HomePageObject(driver);

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		homePage.clickToLogoutLink();

	}

	@AfterClass
	public void afterClass() {
		driver.quit();

	}

	public int generateEmail() {
		Random random = new Random();
		return random.nextInt(9999);
	}

}
