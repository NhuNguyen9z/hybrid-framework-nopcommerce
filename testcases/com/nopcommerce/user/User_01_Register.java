package com.nopcommerce.user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class User_01_Register {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir"); // Lấy ra thư mục của dự án

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe"); // nối chuỗi
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // Setting timeout

	}

	@Test
	public void User_01_Register_To_System() {
	}

	@Test
	public void User_02_Login_To_System() {
	}

	@Test
	public void User_03_Verify_My_Account() {
	}

	@AfterClass
	public void afterClass() {
		driver.quit();

	}

}
