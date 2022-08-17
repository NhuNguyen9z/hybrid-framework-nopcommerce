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

public class Level_02_Apply_BasePage_II {

	WebDriver driver;
	String emailAdress;

	// Declare (Khai báo)
	BasePage basePage;
	// BasePage: class
	// basePage: Object (là 1 đối tượng của class BasePage), 1 class có thể khởi tạo nhiều đối tượng

	String projectPath = System.getProperty("user.dir"); // Lấy ra thư mục của dự án

	// Khi muốn dùng class nào đó thì phải khai báo và khởi tạo nó lên

	// Khởi tạo trong beforeClass vì beforeClass chạy đầu tiên trong all các hàm của class Level_02_Apply_BasePage_I

	// Đầu tiên những biến gobal sẽ dc khai báo trước chạy trước rồi sẽ đến những hàm,
	// sẽ luôn ưu tiên hàm nào có beforeClass chạy trước rồi đến những testcase dc chạy tiếp theo
	// -- khi chạy hết all các testcase rồi thì sẽ gọi qua hàm afterClass
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe"); // nối chuỗi
		driver = new FirefoxDriver(); // sau khi chạy xong thì driver có 1 ID rồi

		// Initial (khởi tạo)
		// Áp dụng nguyên tắc đóng gói (Encapsulation) che dấu sự khởi tạo của đối tượng/ Class
		basePage = BasePage.getBasePageObject();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // Setting timeout
		emailAdress = "akp" + generateEmail() + "@hotmail.com";
		driver.get("https://demo.nopcommerce.com/");

	}

	@Test
	public void User_01_Register_Empty_Data() {
		// Trước khi click vào element nên Wait cho element đã sẵn sàng click hay chưa
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		// Nó sẽ dùng ID đó gán vào driver này
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");

	}

	@Test
	public void User_02_Register_Invalid_Email() {
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "Automation Testing");
		basePage.sendkeyToElement(driver, "//input[@id='LastName']", "Course");
		basePage.sendkeyToElement(driver, "//input[@id='Email']", "123g@123");
		basePage.sendkeyToElement(driver, "//input[@id='Password']", "123456");
		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");
		Assert.assertEquals(basePage.getElementText(driver, "//div[@class='message-error validation-summary-errors']//li"), "Wrong email");

	}

	@Test
	public void User_03_Register_Success() {
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "Automation Testing");
		basePage.sendkeyToElement(driver, "//input[@id='LastName']", "Course");
		basePage.sendkeyToElement(driver, "//input[@id='Email']", emailAdress);
		basePage.sendkeyToElement(driver, "//input[@id='Password']", "123456");
		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(basePage.getElementText(driver, "//div[@class='result']"), "Your registration completed");

		basePage.waitForElementClickable(driver, "//a[@class='ico-logout']");
		basePage.clickToElement(driver, "//a[@class='ico-logout']");
	}

	@Test
	public void User_04_Register_Existing_Email() {
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "Automation Testing");
		basePage.sendkeyToElement(driver, "//input[@id='LastName']", "Course");
		basePage.sendkeyToElement(driver, "//input[@id='Email']", emailAdress);
		basePage.sendkeyToElement(driver, "//input[@id='Password']", "123456");
		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(basePage.getElementText(driver, "//div[@class='message-error validation-summary-errors']//li"), "The specified email already exists");
	}

	@Test
	public void User_05_Register_Password_Less_Than_6_Chars() {
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "Automation Testing");
		basePage.sendkeyToElement(driver, "//input[@id='LastName']", "Course");
		basePage.sendkeyToElement(driver, "//input[@id='Email']", emailAdress);
		basePage.sendkeyToElement(driver, "//input[@id='Password']", "123");
		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123");

		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"), "Password must meet the following rules:\nmust have at least 6 characters");

	}

	@Test
	public void User_06_Register_Invalid_Confirm_Password() {
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "Automation Testing");
		basePage.sendkeyToElement(driver, "//input[@id='LastName']", "Course");
		basePage.sendkeyToElement(driver, "//input[@id='Email']", emailAdress);
		basePage.sendkeyToElement(driver, "//input[@id='Password']", "123456");
		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "654321");

		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");
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
