package com.liveguru.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.liveGuru.HomePageObject;
import pageObjects.liveGuru.LoginPageObject;
import pageObjects.liveGuru.MyDashboardPageObject;
import pageObjects.liveGuru.PageGeneratorManager;
import pageObjects.liveGuru.RegisterPageObject;

public class Level_06_Page_Generator_Manager_III extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		// driver khởi tạo xong map vào getHomePage(driver)
		homePage = PageGeneratorManager.getHomePage(driver);
		emailAddress = "autofc" + generateFakeEmail() + "@mail.com";
		firstName = "Atuomation";
		lastName = "FC";
		validPassword = "123456";

	}

	@Test
	public void User_01_Register() {
		loginPage = homePage.clickToMyAccountLink();
		registerPage = loginPage.clickToCreateAnAccountButton();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);
		myDasboardPage = registerPage.clickRegisterButton();
		Assert.assertEquals(myDasboardPage.getSuccessMessage(), "Thank you for registering with Main Website Store.");
		myDasboardPage.clickToAccount();
		homePage = myDasboardPage.clickToLogoutLink();
		Assert.assertTrue(homePage.isDisplayMessageHomePage());

	}

	@Test
	public void User_02_Login() {
		loginPage = homePage.clickToMyAccountLink();
		loginPage.inputToEmailAddressTexbox(emailAddress);
		loginPage.inputToPasswordTextBox(validPassword);
		myDasboardPage = loginPage.clickToLoginButton();
		Assert.assertEquals(myDasboardPage.getMyDashboardText(), "MY DASHBOARD");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();

	}

	private WebDriver driver;
	private String firstName, lastName, emailAddress, validPassword;

	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private MyDashboardPageObject myDasboardPage;

}
