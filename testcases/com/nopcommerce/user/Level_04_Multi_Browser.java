package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pagesObjects.HomePageObject;
import pagesObjects.RegisterPageObject;

// Các class trong phần testcase sẽ kế thừa BaseTest
// Các class trong package pagesObjects sẽ kế thừa BasePage
public class Level_04_Multi_Browser extends BaseTest {

	// Declare
	private WebDriver driver;
	private String firstName, lastName, emailAddess, password;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = new HomePageObject(driver);

		firstName = "Automation";
		lastName = "Testing";
		emailAddess = "akp" + generateEmail() + "@hotmail.com";
		password = "123456";

		// Cách chạy khi run từ file runNopcommerce.xml
		// khi start lên nó sẽ gọi firefox đầu tiên rồi gọi đến class "com.nopcommerce.user.Level_04_Multi_Browser"
		// thì class Level_04_Multi_Browser này dc kích hoạt - sẽ chạy những biến global trước
		// rồi sau đó chạy tới beforeClass
		// khi chạy tới beforeClass nó sẽ dùng @Parameters("browser") này lấy giá trị firefox của biến browser bên file runNopcommerce.xml qua
		// nó sẽ map vào cho cái tham số browserName của hàm beforeClass(String browserName)
		// rồi khởi tạo driver lên

		// Cách chạy
		// Đầu tiên sẽ chạy khai báo driver global trước
		// Sau đó chạy đến hàm getBrowserDriver(browserName) ở class BaseTest
		// lấy tham số browserName ở beforeClass truyền vào tham số browserName của hàm getBrowserDriver(browserName)
		// thì coi như tham số browserName của hàm getBrowserDriver(String browserName) trong class BaseTest và tham số này getBrowserDriver(browserName) bằng nhau
		// sau đó khởi tạo WebDriver lên thì tham số global driverBaseTest có dữ liệu
		// chạy xong hàm getBrowserDriver(browserName)
		// vậy driver bên này vs driverBaseTest khác nhau mà driver chỉ dc khởi tạo 1 lần
		// vậy cần phải lấy driverBaseTest truyền qua driver bên class Level_04_Multi_Browser này
		// cách đơn giản nhất là phải return driverBaseTest ở hàm getBrowserDriver(String browserName) của class BaseTest
		// vì hàm getBrowserDriver(browserName) trả về kiểu WebDriver
		// nên chạy xong hàm getBrowserDriver(browserName) gán lại dữ liệu cho driver --> thì driver có data nên chạy dc - driver = getBrowserDriver(browserName);
	}

	@Test
	public void Register_01_Empty_Data() {
		System.out.println("Register_01 - Step 01: Click register link");
		homePage.clickToRegisterLink();

		// Click Register link -> nhảy qua trang Register
		registerPage = new RegisterPageObject(driver);

		System.out.println("Register_01 - Step 02: Click register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_01 - Step 03: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtFirstNameTextbox(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastNameTextbox(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");

	}

	@Test
	public void Register_02_Invalid_Email() {
		System.out.println("Register_02 - Step 01: Click register link");
		homePage.clickToRegisterLink();

		// Click Register link -> nhảy qua trang Register
		registerPage = new RegisterPageObject(driver);

		System.out.println("Register_02 - Step 02: Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox("123g@123");
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Register_02 - Step 03: Click register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_02 - Step 04: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorWrongEmailMessage(), "Wrong email");

	}

	public void Register_03_Success() {
		System.out.println("Register_03 - Step 01: Click register link");
		homePage.clickToRegisterLink();

		// Click Register link -> nhảy qua trang Register
		registerPage = new RegisterPageObject(driver);

		System.out.println("Register_03 - Step 02: Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddess);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Register_03 - Step 03: Click register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_03 - Step 04: Verify success message displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		System.out.println("Register_03 - Step 05: Click logout link");
		registerPage.clickToLogoutLink();
	}

	public void Register_04_Existing_Email() {
		System.out.println("Register_04 - Step 01: Click register link");
		homePage.clickToRegisterLink();

		// Click Register link -> nhảy qua trang Register
		registerPage = new RegisterPageObject(driver);

		System.out.println("Register_04 - Step 02: Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddess);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Register_04 - Step 03: Click register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_04 - Step 04: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorExistingEmailMessage(), "The specified email already exists");
	}

	public void Register_05_Password_Less_Than_6_Chars() {
		System.out.println("Register_05 - Step 01: Click register link");
		homePage.clickToRegisterLink();

		// Click Register link -> nhảy qua trang Register
		registerPage = new RegisterPageObject(driver);

		System.out.println("Register_05 - Step 02: Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddess);
		registerPage.inputToPasswordTextbox("123");
		registerPage.inputToConfirmPasswordTextbox("123");

		System.out.println("Register_05 - Step 03: Click register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_05 - Step 04: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password must meet the following rules:\nmust have at least 6 characters");

	}

	public void Register_06_Invalid_Confirm_Password() {
		System.out.println("Register_06 - Step 01: Click register link");
		homePage.clickToRegisterLink();

		// Click Register link -> nhảy qua trang Register
		registerPage = new RegisterPageObject(driver);

		System.out.println("Register_06 - Step 02: Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddess);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(emailAddess);

		System.out.println("Register_06 - Step 03: Click register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_06 - Step 04: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "The password and confirmation password do not match.");
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
