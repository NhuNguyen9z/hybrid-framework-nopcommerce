package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;
import pagesObjects.HomePageObject;
import pagesObjects.RegisterPageObject;

public class Level_03_Page_Object {

	// Declare
	private WebDriver driver;
	private String firstName, lastName, emailAdress, password;
	private String projectPath = System.getProperty("user.dir"); // Lấy ra thư mục của dự án
	private HomePageObject homePage;
	private RegisterPageObject registerPage;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe"); // nối chuỗi
		// 1 class chỉ được khởi tạo driver duy nhất 1 lần
		driver = new FirefoxDriver(); // sau khi chạy xong thì driver có 1 ID rồi
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // Setting timeout
		driver.get("https://demo.nopcommerce.com/");

		firstName = "Automation";
		lastName = "Testing";
		emailAdress = "akp" + generateEmail() + "@hotmail.com";
		password = "123456";

		// biến driver sẽ dc dùng để gán vào HomePageObject(driver)
		// khi mà nó new lên xong gán vào HomePageObject(driver) thì driver có data -- sau đó gọi tới hàm khởi tạo HomePageObject
		homePage = new HomePageObject(driver);
		registerPage = new RegisterPageObject(driver);
		// Khởi tạo đúng thời điểm/ đúng chỗ
	}

	@Test
	public void User_01_Register_Empty_Data() {
		System.out.println("HomePage - Step 01: Click register link");
		homePage.clickToRegisterLink();

		System.out.println("RegisterPage - Step 02: Click register button");
		registerPage.clickToRegisterButton();

		System.out.println("RegisterPage - Step 03: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtFirstNameTextbox(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastNameTextbox(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");

	}

	@Test
	public void User_02_Register_Invalid_Email() {
		System.out.println("HomePage - Step 01: Click register link");
		homePage.clickToRegisterLink();

		System.out.println("RegisterPage - Step 02: Input value");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox("123g@123");
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("RegisterPage - Step 03: Click register button");
		registerPage.clickToRegisterButton();

		System.out.println("RegisterPage - Step 04: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorWrongEmailMessage(), "Wrong email");

	}

	@Test
	public void User_03_Register_Success() {
		System.out.println("HomePage - Step 01: Click register link");
		homePage.clickToRegisterLink();

		System.out.println("RegisterPage - Step 02: Input value");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAdress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("RegisterPage - Step 03: Click register button");
		registerPage.clickToRegisterButton();

		System.out.println("RegisterPage - Step 04: Verify error message displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		System.out.println("RegisterPage - Step 05: Click logout link");
		registerPage.clickToLogoutLink();
	}

	@Test
	public void User_04_Register_Existing_Email() {
		System.out.println("HomePage - Step 01: Click register link");
		homePage.clickToRegisterLink();

		System.out.println("RegisterPage - Step 02: Input value");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAdress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("RegisterPage - Step 03: Click register button");
		registerPage.clickToRegisterButton();

		System.out.println("RegisterPage - Step 04: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorExistingEmailMessage(), "The specified email already exists");
	}

	@Test
	public void User_05_Register_Password_Less_Than_6_Chars() {
		System.out.println("HomePage - Step 01: Click register link");
		homePage.clickToRegisterLink();

		System.out.println("RegisterPage - Step 02: Input value");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAdress);
		registerPage.inputToPasswordTextbox("123");
		registerPage.inputToConfirmPasswordTextbox("123");

		System.out.println("RegisterPage - Step 03: Click register button");
		registerPage.clickToRegisterButton();

		System.out.println("RegisterPage - Step 04: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password must meet the following rules:\nmust have at least 6 characters");

	}

	@Test
	public void User_06_Register_Invalid_Confirm_Password() {
		System.out.println("HomePage - Step 01: Click register link");
		homePage.clickToRegisterLink();

		System.out.println("RegisterPage - Step 02: Input value");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAdress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(emailAdress);

		System.out.println("RegisterPage - Step 03: Click register button");
		registerPage.clickToRegisterButton();

		System.out.println("RegisterPage - Step 04: Verify error message displayed");
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
