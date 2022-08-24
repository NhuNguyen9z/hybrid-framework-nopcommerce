package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstant;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;

public class Level_08_Switch_Role extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		userEmailAddress = "Joneydeep59@gmail.com";
		userValidPassword = "123456";
		adminEmailAdress = "admin@yourstore.com";
		adminValidPasswprd = "admin";

	}

	@Test
	public void Role_01_User_To_Admin() {
		userLoginPage = userHomePage.openLoginPage();

		userHomePage = userLoginPage.loginAsUser(userEmailAddress, userValidPassword);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
		userCustomerInforPage = userHomePage.openCustomerInforPage();
		userHomePage = userCustomerInforPage.clickToLogoutLinkAtUserPage();

		userHomePage.openPageUrl(driver, GlobalConstant.ADMIN_PAGE_URL);
		adminLoginPage = PageGeneratorManager.getAminLoginPage(driver);
		adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmailAdress, adminValidPasswprd);
		Assert.assertTrue(adminDashboardPage.isDasboardHeaderDisplayed());
		adminDashboardPage.sleepInSecond(1);
		adminLoginPage = adminDashboardPage.clickToLogoutLinkAtAdminPage();
	}

	@Test
	public void Role_02_Admin_To_User() {
		adminLoginPage.openPageUrl(driver, GlobalConstant.PORTAL_PAGE_URL);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		userLoginPage = userHomePage.openLoginPage();
		userHomePage = userLoginPage.loginAsUser(userEmailAddress, userValidPassword);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());

		// từ trang AdminLoginPage nhảy qua trang UserHomePage thì phải khởi tạo trang UserHomePage lên (từ A qua B thì phải khởi tạo B lên)
		// Ko return trong hàm openPageUrl vì thằng openPageUrl có thể điều hướng qua thẳng bất kỳ 1 page nào mà nó mở ra bằng Url
		// - thì mình return như vậy nó ko đúng mà mình phải return ở testcase (return tức là khởi tạo page lên)
		// - ví dụ những hàm như clickToLogoutLinkAtAdminPage là có return vì nó cố định cái luồng

		// Từ trang AdminhDashboard nếu như mà ko Logout mà tại AdminDashboard mở Url UserHomePage lên thì nó sẽ qua về trang UserHomePage
		// với trạng thái đã Login rồi

		// Mấu chốt của bài này là cần nắm dc:
		// - Behavior của flow cần làm/ define
		// - Chuyển page viết hàm cho đúng hành vi

	}

	@AfterClass
	public void afterClass() {
		driver.quit();

	}

	private WebDriver driver;
	private String userEmailAddress, userValidPassword, adminEmailAdress, adminValidPasswprd;

	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private UserCustomerInforPageObject userCustomerInforPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;

}
