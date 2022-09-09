package com.jquery.dataTable;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.datatable.HomePageObject;
import pageObjects.jQuery.datatable.PageGeneratorManager;

public class Level_10_DataTable_DataGrid extends BaseTest {
	public HomePageObject homePage;
	public List<String> actualAllCountryValue;
	public List<String> expectedAllCountryValue;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {
		driver = getBrowserDriver(browserName, appURL);
		homePage = PageGeneratorManager.getHomePage(driver);

	}

	public void Table_01_Paging() {

		homePage.openPagingByPageNumber("10");
		homePage.sleepInSecond(3);
		Assert.assertTrue(homePage.isPageNumberActived("10"));

		homePage.openPagingByPageNumber("20");
		homePage.sleepInSecond(3);
		Assert.assertTrue(homePage.isPageNumberActived("20"));

		homePage.openPagingByPageNumber("7");
		homePage.sleepInSecond(3);
		Assert.assertTrue(homePage.isPageNumberActived("7"));
		homePage.openPagingByPageNumber("18");
		homePage.sleepInSecond(3);
		Assert.assertTrue(homePage.isPageNumberActived("18"));

	}

	public void Table_02_Enter_To_Header() {
		homePage.refreshCurrentoPage(driver); // refresh tránh trường hợp bị cache
		homePage.enterToHeaderTextboxByLabel("Country", "Argentina");
		Assert.assertTrue(homePage.isResultDisplay("Argentina"));
		homePage.enterToHeaderTextboxByLabel("Females", "338282");
		Assert.assertTrue(homePage.isResultDisplay("338282"));
		homePage.enterToHeaderTextboxByLabel("Males", "349238");
		Assert.assertTrue(homePage.isResultDisplay("349238"));
		homePage.enterToHeaderTextboxByLabel("Total", "687522");
		Assert.assertTrue(homePage.isResultDisplay("687522"));
		homePage.sleepInSecond(3);

	}

	public void Table_03_Paging() {

		// đọc dữ liệu của file country.txt ra
		// lưu vào List<String> = Expected value = expectedAllCountryValue rồi so sánh với actualResult

		// actual result
		actualAllCountryValue = homePage.getValueEachRowAllPage();

	}

	@Test
	public void Table_04_Action_At_Any_Row() {
		homePage.clickToLoadButton();
		homePage.sleepInSecond(1);

		// homePage.enterToTextboxWithRowEachColumn("Artist", "2", "Bryan Adam");
		// homePage.sleepInSecond(1);
		// homePage.enterToTextboxWithRowEachColumn("Album", "1", "Please Forgive Me");
		// homePage.sleepInSecond(1);
		// homePage.enterToTextboxWithRowEachColumn("Year", "3", "1997");
		// homePage.sleepInSecond(1);
		// homePage.enterToTextboxWithRowEachColumn("Price", "4", "50");
		// homePage.sleepInSecond(1);
		// homePage.selectToDropdownWithRowEachColumn("Origin", "5", "Korea");
		// homePage.sleepInSecond(1);
		// homePage.selectToDropdownWithRowEachColumn("Origin", "5", "US");
		// homePage.sleepInSecond(1);
		// homePage.selectToDropdownWithRowEachColumn("Origin", "5", "Japan");
		// homePage.sleepInSecond(2);
		homePage.checkToCheckboxByColumnNameAtRowNumber("With Poster?", "3");
		homePage.sleepInSecond(1);
		homePage.checkToCheckboxByColumnNameAtRowNumber("With Poster?", "5");
		homePage.sleepInSecond(1);
		homePage.uncheckToCheckboxByColumnNameAtRowNumber("With Poster?", "1");
		homePage.sleepInSecond(1);
		homePage.uncheckToCheckboxByColumnNameAtRowNumber("With Poster?", "2");
		homePage.sleepInSecond(1);
		homePage.uncheckToCheckboxByColumnNameAtRowNumber("With Poster?", "4");

		homePage.clickToIconByRowNumber("Remove Current Row", "2");
		homePage.sleepInSecond(1);
		homePage.clickToIconByRowNumber("Insert Row Above", "2");
		homePage.sleepInSecond(1);
		homePage.clickToIconByRowNumber("Insert Row Above", "2");
		homePage.sleepInSecond(1);
		homePage.clickToIconByRowNumber("Move Up", "4");
		homePage.sleepInSecond(2);
		homePage.clickToIconByRowNumber("Move Down", "5");
		homePage.sleepInSecond(2);
		homePage.clickToIconByRowNumber("Remove Current Row", "6");
		homePage.clickToIconByRowNumber("Remove Current Row", "5");
		homePage.clickToIconByRowNumber("Remove Current Row", "4");
		homePage.clickToIconByRowNumber("Remove Current Row", "3");
		homePage.clickToIconByRowNumber("Remove Current Row", "2");
		homePage.clickToIconByRowNumber("Remove Current Row", "1");
		homePage.sleepInSecond(1);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();

	}

	private WebDriver driver;

}
