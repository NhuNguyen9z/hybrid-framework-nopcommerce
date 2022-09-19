package com.nopcommerce.user;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_02_Register_Cookie;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;

@Listeners(commons.MethodListener.class)
public class Level_16_Share_Data_C extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Pre-condition - Step 01: Navigate to 'Login' page");
		loginPage = homePage.openLoginPage();

		log.info("Pre-condition - Step 02: Set all Coolies and reload page");
		loginPage.setCookie(driver, Common_02_Register_Cookie.loggedCookies);
		for (Cookie cookie : Common_02_Register_Cookie.loggedCookies) {
			System.out.println("Cookie at Class C: " + cookie);
		}
		loginPage.refreshCurrentoPage(driver);

		log.info("Pre-condition - Step 03: Verify 'My Account' link is displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());

	}

	@Test
	public void Search_01_Emty_Data() {

	}

	@Test
	public void Search_02_Related_Product_Name() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();

	}

	private WebDriver driver;

	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;

}
