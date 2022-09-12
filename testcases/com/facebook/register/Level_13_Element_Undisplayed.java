package com.facebook.register;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.LoginPageObject;
import pageObjects.facebook.PageGeneratorManager;

public class Level_13_Element_Undisplayed extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		loginPage = PageGeneratorManager.getLoginPage(driver);

	}

	// Element hiển thị: Displayed/ Visible
	// Element KO hiển thị: Undisplayed/ Invisible
	// Trường hợp 1: Element KO hiển thị nhưng vẫn còn tồn tại trong DOM/ cây HTML
	// Trưởng hơp 2: Element KO hiển thị nhưng KO còn tồn tại trong DOM/ cây HTML
	// Mở app là Login khởi tạo lên truyền driver để gán vào
	// Lưu ý: từ bài học Assert-Verify trở đi khi ứng dụng các hàm verifyTrue/ False/ Equals thì phải thêm cái Listeners vào trong các file xml để run testcase nó
	// mới chạy đúng
	// Nếu như làm demo cho 1 app khác thì cần tạo mới package/ file: testcase/ pageObjects/ pageUIs/ run testcase xml
	// Long timeout = 30s đủ để page dc load xong hoặc element dc render ra
	// implicitlyWait khi mà set Long_timeout nó sẽ apply cho những hàm findElement/ findElements chỉ cần set duy nhất 1 lần thôi nó sẽ dùng cho all các testcase
	// trong class của framework, nếu ko set thì timeout = 0
	// Tìm element thấy rồi tiếp tục gọi qua hàm isDisplayed -> nó thấy đang hiển thị thì trả về True (trước tiên nó sẽ ko quan tâm isDisplayed mà quan tâm có tìm
	// thấy element KO nếu find element tìm thấy thì mới gọi tới hàm isDisplayed)
	// có element có trong DOM nhưng ko hiển thị thì trả về False
	@Test
	public void TC_01_Verify_Element_Displayed() {
		loginPage.clickButtonCreateNewAccount();
		loginPage.inputToTextboxEmailAddress("automationfc@gmail.com");
		verifyTrue(loginPage.isConfirmEmailAddessDisplayed());
		loginPage.sleepInSecond(2);

	}

	@Test
	public void TC_02_Verify_Element_Undisplayed_In_DOM() {
		loginPage.inputToTextboxEmailAddress("");
		loginPage.sleepInSecond(2);
		verifyTrue(loginPage.isConfirmEmailAddessTextboxUndisplayed());

	}

	@Test
	public void TC_03_Verify_Element_Undisplayed_Not_In_DOM() {
		loginPage.clickToIconClose();
		verifyTrue(loginPage.isConfirmEmailAddessTextboxUndisplayed());

	}

	@AfterClass
	public void afterClass() {
		driver.quit();

	}

	private WebDriver driver;
	private LoginPageObject loginPage;

}
