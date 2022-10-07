package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

public class Level_09_Dynamic_Locator extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "Testing";
		emailAddress = "auto" + generateFakeNumber() + "@hotmail.com";
		validPassword = "123456";
		System.out.println(emailAddress);

	}

	// Về nguyên tắc: khi 1 trang A qua trang B thì phải viết hàm mở trang B ra
	@Test
	public void User_01_Register_Login() {

		registerPage = homePage.openRegisterPage();

		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		homePage = registerPage.clickToLogoutLink();

		loginPage = homePage.openLoginPage();

		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(validPassword);

		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		customerInfoPage = homePage.openCustomerInforPage();
		Assert.assertTrue(customerInfoPage.isCustomerInforPageDisplayed());

	}

	@Test
	public void User_02_Switch_Page() {
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

		// My Product Review -> Customer Infor
		customerInfoPage = myProductReviewPage.openCustomerInforPage(driver);

		// Customer Infor -> Reward Point
		rewardPointPage = customerInfoPage.openRewardPointPage(driver);

	}

	@Test
	public void User_03_Dynamic_Pages_1() {

		// Customer Infor -> Address
		addressPage = (UserAddressPageObject) customerInfoPage.openPagesAtMyAccountByName(driver, "Addresses");
		// Address -> My Product Review
		myProductReviewPage = (UserMyProductReviewPageObject) addressPage.openPagesAtMyAccountByName(driver, "My product reviews");

		// My Product Review -> Reward Point
		rewardPointPage = (UserRewardPointPageObject) myProductReviewPage.openPagesAtMyAccountByName(driver, "Reward points");

		// Reward Point -> Address
		addressPage = (UserAddressPageObject) rewardPointPage.openPagesAtMyAccountByName(driver, "Addresses");

		// Address -> Reward Point
		rewardPointPage = (UserRewardPointPageObject) addressPage.openPagesAtMyAccountByName(driver, "Reward points");

		// Reward Point -> My Product Review
		myProductReviewPage = (UserMyProductReviewPageObject) rewardPointPage.openPagesAtMyAccountByName(driver, "My product reviews");

		// My Product Review -> Customer Infor
		customerInfoPage = (UserCustomerInforPageObject) myProductReviewPage.openPagesAtMyAccountByName(driver, "Customer info");

		// Customer Infor -> Reward Point
		rewardPointPage = (UserRewardPointPageObject) customerInfoPage.openPagesAtMyAccountByName(driver, "Reward points");

	}

	@Test
	public void User_03_Dynamic_Pages_2() {
		// Page A qua Page B: mở page B lên trước rồi khởi tạo page B lên sau

		// Customer Infor -> Address
		customerInfoPage.openPagesAtMyAccountByPageName(driver, "Addresses");
		addressPage = PageGeneratorManager.getAddressPage(driver); // khởi tạo ở tầng testcase
		// Address -> My Product Review
		addressPage.openPagesAtMyAccountByPageName(driver, "My product reviews");
		myProductReviewPage = PageGeneratorManager.getMyProductReviewPage(driver);

		// My Product Review -> Reward Point
		myProductReviewPage.openPagesAtMyAccountByPageName(driver, "Reward points");
		rewardPointPage = PageGeneratorManager.getRewardPointPage(driver);

		// Reward Point -> Address
		rewardPointPage.openPagesAtMyAccountByPageName(driver, "Addresses");
		addressPage = PageGeneratorManager.getAddressPage(driver);

		// Address -> Reward Point
		addressPage.openPagesAtMyAccountByPageName(driver, "Reward points");
		rewardPointPage = PageGeneratorManager.getRewardPointPage(driver);

		// Reward Point -> My Product Review
		rewardPointPage.openPagesAtMyAccountByPageName(driver, "My product reviews");
		myProductReviewPage = PageGeneratorManager.getMyProductReviewPage(driver);

		// My Product Review -> Customer Infor
		myProductReviewPage.openPagesAtMyAccountByPageName(driver, "Customer info");
		customerInfoPage = PageGeneratorManager.getCustomerInforPage(driver);

		// Customer Infor -> Reward Point
		customerInfoPage.openPagesAtMyAccountByPageName(driver, "Reward points");
		rewardPointPage = PageGeneratorManager.getRewardPointPage(driver);

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
	private UserAddressPageObject addressPage;
	private UserMyProductReviewPageObject myProductReviewPage;
	private UserRewardPointPageObject rewardPointPage;

}
