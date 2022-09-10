package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
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
public class Level_12_Assert_Verify extends BaseTest {

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

	// Cấu trúc cơ bản của 1 class testcase
	// 1. Pre-condition: điều kiện/ bước để cho 1/ n testcase có thể chạy được - tương ướng với khai báo biến Global và khởi tạo trong @BeforeClass
	// 2. Testcase - tương ứng với @Test
	// 3. Post-condition: clean/ clear data - tương ướng với @AfterClass
	// Trong 1 testcase nếu action mà ko verify thì testcase đó sẽ luôn chạy đúng - nên cần verify để xem action đó chạy đúng hay sai
	// static method/ static variable có thể gọi ra sử dụng trực tiếp từ tên Class
	@Test
	public void User_01_Register_Login() {

		registerPage = homePage.openRegisterPage();

		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);

		registerPage.clickToRegisterButton();

		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed ...");

		homePage = registerPage.clickToLogoutLink();

		loginPage = homePage.openLoginPage();

		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(validPassword);

		homePage = loginPage.clickToLoginButton();
		verifyFalse(homePage.isMyAccountLinkDisplayed());
		customerInfoPage = homePage.openCustomerInforPage();
		verifyFalse(customerInfoPage.isCustomerInfoPageDisplayed());

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
	private UserCustomerInforPageObject customerInfoPage;

}
