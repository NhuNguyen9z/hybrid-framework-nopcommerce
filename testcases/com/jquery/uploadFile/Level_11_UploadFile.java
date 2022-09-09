package com.jquery.uploadFile;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.uploadFile.HomePageObject;
import pageObjects.jQuery.uploadFile.PageGeneratorManager;

public class Level_11_UploadFile extends BaseTest {
	private HomePageObject homePage;
	String javaFileName = "Java.png";
	String csharpFileName = "CSharp.png";
	String pythonFileName = "Python.jpg";
	String[] multipleFileName = { "Java.png", "CSharp.png", "Python.jpg" };

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {
		driver = getBrowserDriver(browserName, appURL);
		homePage = PageGeneratorManager.getHomePage(driver);

	}
	// 1 cái upload element nó chỉ có thể upload dc nhiều file khi có thuộc tính multiple, nếu ko có thì chỉ upload dc 1 file
	// Upload file chỉ work với thẻ input type = "file"
	// Thẻ input có thể ẩn/ visible -> thì KO cần quan tâm -> mà chỉ cần sendkey
	// Hàm trim(): xóa kí tự khoảng trắng/ tab/ xuống dòng ở đầu hoặc cuối chuỗi (String)

	// var imageCsharp = $("//a[@title='Java.png']/img")[0]; [0] là lấy ra element đầu tiên

	@Test
	public void TC_01_Upload_One_File() {
		homePage.uploadMultipleFiles(driver, javaFileName);

		Assert.assertTrue(homePage.isFileLoadedByName(javaFileName));

		homePage.clickToStartButton();

		Assert.assertTrue(homePage.isFileLinkUploadedByName(javaFileName));

		Assert.assertTrue(homePage.isFileImageUploadedByName(javaFileName));

	}

	@Test
	public void TC_02_Upload_Multiple_File() {
		homePage.refreshCurrentoPage(driver);
		homePage.uploadMultipleFiles(driver, multipleFileName);

		Assert.assertTrue(homePage.isFileLoadedByName(javaFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(csharpFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(pythonFileName));

		homePage.clickToStartButton();

		Assert.assertTrue(homePage.isFileLinkUploadedByName(javaFileName));
		Assert.assertTrue(homePage.isFileLinkUploadedByName(csharpFileName));
		Assert.assertTrue(homePage.isFileLinkUploadedByName(pythonFileName));

		Assert.assertTrue(homePage.isFileImageUploadedByName(javaFileName));
		Assert.assertTrue(homePage.isFileImageUploadedByName(csharpFileName));
		Assert.assertTrue(homePage.isFileImageUploadedByName(pythonFileName));
		homePage.sleepInSecond(1);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();

	}

	private WebDriver driver;

}
