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

public class Level_06_Page_Generator_Manager_II extends BaseTest {

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
		// Lưu ý Với cách số 2 này thì case: homePage = new HomePageObject(driver); -- là ko xử lý đúng
		// nếu đưa "new HomePageObject(driver)" vào hàm getBrowserDriver(browserName) - như vậy nó ko hay vì nó chỉ giải
		// quyết dc 1 vấn đề thôi - nghĩa là nó chỉ chạy dc cho 1 server 1 màn hình 1 cái app là demo.nopcommerce thôi
		// vậy trong trường hợp mình có nhiều màn hình thì sao - ví dụ trang https://admin-demo.nopcommerce.com/ nếu mở lên thì ra màn hình Login
		// thì như vậy là cái hàm getBrowserDriver(browserName) chạy sai - nếu như mình cố tình đưa vào return HomePageObject thì nó ko hợp lý
		// như vậy mình cũng ko lấy driver ra dc - vì 1 cái hàm chỉ cho phép return 1 lần và lấy ra 1 cái dữ liệu thôi
		// nên Cách số 2 vẫn có nhược điểm chỗ này là chưa xử lý dc đoạn ngay đầu

		firstName = "Automation";
		lastName = "Testing";
		existingEmail = "akp" + generateFakeEmail() + "@hotmail.com";
		notFoundEmail = "akp" + generateFakeEmail() + "@yahoo.com";
		invalidEmail = "123@123@";
		validPassword = "123456";
		incorrectPassword = "123123";

		System.out.println("Pre-condition - Step 01: Click register link");

		// Cách 2:
		// - Đưa việc khởi tạo vào trong chính hàm (action của page cũ)
		// - Che dấu đi việc khởi tạo
		// - Có tính kết nối giữa 2 màn hình vs nhau
		// --> B = A.action --- page A action chuyển qua page B
		// Nhược điểm: chưa xử lý dc đoạn code khởi tạo class nhiều lần/ lặp lại
		registerPage = homePage.openRegisterPage();

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
		homePage = registerPage.clickToLogoutLink();

		// Click Logout thì bussiness nó sẽ quay về HomePage

	}

	@Test
	public void Login_01_Empty_Data() {
		loginPage = homePage.openLoginPage();

		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");

	}

	@Test
	public void Login_02_Invalid_Email() {
		loginPage = homePage.openLoginPage();

		loginPage.inputToEmailTextbox(invalidEmail);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");

	}

	@Test
	public void Login_03_Email_Not_Found() {
		loginPage = homePage.openLoginPage();

		loginPage.inputToEmailTextbox(notFoundEmail);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageUnSuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

	}

	@Test
	public void Login_04_Existing_Email_Emty_Password() {
		loginPage = homePage.openLoginPage();

		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox("");

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageUnSuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void Login_05_Existing_Email_Incorrect_Password() {

		loginPage = homePage.openLoginPage();

		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(incorrectPassword);
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageUnSuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_06_Valid_Email_Password() {

		loginPage = homePage.openLoginPage();

		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(validPassword);
		homePage = loginPage.clickToLoginButton();

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

	}

	@AfterClass
	public void afterClass() {
		driver.quit();

	}

}
