package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pagesObjects.nopCommerce.HomePageObject;
import pagesObjects.nopCommerce.LoginPageObject;
import pagesObjects.nopCommerce.MyProductReviewPageObject;
import pagesObjects.nopCommerce.AddressPageObject;
import pagesObjects.nopCommerce.CustomerInforPageObject;
import pagesObjects.nopCommerce.PageGeneratorManager;
import pagesObjects.nopCommerce.RegisterPageObject;
import pagesObjects.nopCommerce.RewardPointPageObject;

public class Level_07_Switch_Page extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		// driver khởi tạo xong map vào getHomePage(driver)
		homePage = PageGeneratorManager.getHomePage(driver);

		firstName = "Automation";
		lastName = "Testing";
		emailAddress = "auto" + generateFakeEmail() + "@hotmail.com";
		validPassword = "123456";
		System.out.println(emailAddress);

	}

	// Về nguyên tắc: khi 1 trang A qua trang B thì phải viết hàm mở trang B ra
	@Test
	public void User_01_Register() {

		registerPage = homePage.openRegisterPage();

		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		homePage = registerPage.clickToLogoutLink();

	}

	@Test
	public void User_02_Login() {
		loginPage = homePage.openLoginPage();

		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(validPassword);

		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

	}

	@Test
	public void User_03_My_Account() {
		customerInfoPage = homePage.openCustomerInforPage();
		Assert.assertTrue(customerInfoPage.isCustomerInfoPageDisplayed());

	}

	@Test
	public void User_04_Switch_Page() {
		// Knowledge của Page Object
		// 1 page A khi chuyển qua page B thì phải viết 1 hàm (action: open/click ...: link/ button/ image...) để mở page B đó lên

		// Customer Infor -> Address
		addressPage = customerInfoPage.openAddressPage(driver);

		// Address -> My Product Review
		myProductReviewPage = addressPage.openMyProductReviewPage(driver);

		// My Product Review -> Reward Point
		rewardPointPage = myProductReviewPage.openRewardPointPage(driver);

		// Reward Point -> Address
		addressPage = rewardPointPage.openAddressPage(driver);

		// Address -> Reward Point
		rewardPointPage = addressPage.openRewardPointPage(driver);

		// Reward Point -> My Product Review
		myProductReviewPage = rewardPointPage.openMyProductReviewPage(driver);
		customerInfoPage = rewardPointPage.openCustomerInforPage(driver);
		rewardPointPage = customerInfoPage.openRewardPointPage(driver);

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
	private CustomerInforPageObject customerInfoPage;
	private AddressPageObject addressPage;
	private MyProductReviewPageObject myProductReviewPage;
	private RewardPointPageObject rewardPointPage;

}