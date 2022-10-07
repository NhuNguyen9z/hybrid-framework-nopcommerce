package com.patientpop.checkup;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.patientpop.checkup.CheckupPageObject;
import pageObjects.patientpop.checkup.HomePageObject;
import pageObjects.patientpop.checkup.PageGeneratorManager;

public class Level_18_Pattern_Object extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void BeforeClass(String browserName, String urlApp) {
		driver = getBrowserDriver(browserName, urlApp);
		checkupPage = PageGeneratorManager.getCheckupPage(driver);
		practiceName = "Nationals Park";
		streetAddress = "1500 South Capitol Street Southeast";
		city = "Washington";
		state = "Washington DC";
		zipcode = "20003";
		website = "https://www.mlb.com/nationals/ballpark";
		specialtyName = "Endocrinology and Metabolism Specialist";
	}

	@Test
	public void TC_01_CheckupPage() {
		checkupPage.inputAndSelectValueInDropdown(practiceName, practiceName);
		checkupPage.sleepInSecond(5);
		Assert.assertEquals(checkupPage.getTextboxValueByID("practicename"), practiceName);
		Assert.assertEquals(checkupPage.getTextboxValueByID("streetaddress"), streetAddress);
		Assert.assertEquals(checkupPage.getTextboxValueByID("city"), city);
		Assert.assertEquals(checkupPage.getStateValue(), state);
		Assert.assertEquals(checkupPage.getTextboxValueByID("zipcode"), zipcode);
		verifyEquals(checkupPage.getTextboxValueByID("website"), website);
		checkupPage.selectValueInSpecialtyDropdown(specialtyName, "specialty");
		checkupPage.sleepInSecond(2);
		Assert.assertEquals(checkupPage.getTextboxValueByID("specialty"), specialtyName);
		homePage = checkupPage.clickToCompareButton();

	}

	@Test
	public void TC_02_HomePage() {

		Assert.assertEquals(homePage.getHeaderPractice(), practiceName);
	}

	@AfterClass(alwaysRun = true)
	public void AfterClass() {
		closeBrowserAndDriver();
	}

	private WebDriver driver;
	private CheckupPageObject checkupPage;
	private HomePageObject homePage;
	private String practiceName, streetAddress, city, state, zipcode, website, specialtyName;
}
