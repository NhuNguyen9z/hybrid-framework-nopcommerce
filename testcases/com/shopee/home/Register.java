package com.shopee.home;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.shopee.HomePageObject;
import pageObjects.shopee.PageGeneratorManager;
import pageObjects.shopee.RegisterPageObject;

public class Register extends BaseTest {

	private String phoneNumber = "0909123456";

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);

		homePage = PageGeneratorManager.getHomePage(driver);

	}

	@Test
	public void Register_01() {
		homePage.closePopup();
		Assert.assertTrue(homePage.isSearchButtonDisplayed());
		registerPage = homePage.clickToRegisterLink("Đăng Ký");
		registerPage.inputToPhoneTextbox(phoneNumber);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();

	}

	private WebDriver driver;

	private HomePageObject homePage;
	private RegisterPageObject registerPage;

}
