package com.swagLabs.sort;

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

		loginPage.inputToUserNameTextbox("standard_user");
		loginPage.inputToPasswordTextbox("secret_sauce");
		productPage = loginPage.clickToLoginButton();
	}

	@Test
	public void Sort_01_Name() {
		productPage.selectItemInProductSortDropDown("Name (A to Z)");
		Assert.assertTrue(productPage.isProductNameSortByAscending());

		productPage.selectItemInProductSortDropDown("Name (Z to A)");
		Assert.assertTrue(productPage.isProductNameSortByDescending());
	}

	@Test
	public void Sort_02_Price_Asc() {
		productPage.selectItemInProductSortDropDown("Price (low to high)");
		Assert.assertTrue(productPage.isProductPriceSortByAscending());

		productPage.selectItemInProductSortDropDown("Price (high to low)");
		Assert.assertTrue(productPage.isProductPriceSortByDescending());
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();

	}

	private WebDriver driver;
	private LoginPageObject loginPage;
	private ProductPageObject productPage;

}
