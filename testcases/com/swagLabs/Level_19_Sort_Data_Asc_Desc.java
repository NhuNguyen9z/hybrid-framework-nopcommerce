package com.swagLabs;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.swagLabs.LoginPageObject;
import pageObjects.swagLabs.PageGeneratorManager;
import pageObjects.swagLabs.ProductPageObject;

public class Level_19_Sort_Data_Asc_Desc extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String urlApp) {
		driver = getBrowserDriver(browserName, urlApp);
		loginPage = PageGeneratorManager.getLoginPage(driver);
	}

	@Test
	public void User_01_Login() {
		loginPage.inputToUserNameTextbox("standard_user");
		loginPage.inputToPasswordTextbox("secret_sauce");
		productPage = loginPage.clickToLoginButton();

	}

	@Test
	public void User_02_Sort_Product_Name_Asc() {
		productPage.selectToDropDown("Name (A to Z)");
		Assert.assertTrue(productPage.isProductNameSortAsc());
	}

	@Test
	public void User_03_Sort_Product_Name_Desc() {
		productPage.selectToDropDown("Name (Z to A)");
		Assert.assertTrue(productPage.isProductNameSortDesc());
	}

	@Test
	public void User_04_Sort_Product_Price_Asc() {
		productPage.selectToDropDown("Price (low to high)");
		Assert.assertTrue(productPage.isProductPriceSortAsc());
	}

	@Test
	public void User_05_Sort_Product_Price_Desc() {
		productPage.selectToDropDown("Price (high to low)");
		Assert.assertTrue(productPage.isProductPriceSortDesc());
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();

	}

	private WebDriver driver;
	private LoginPageObject loginPage;
	private ProductPageObject productPage;

}
