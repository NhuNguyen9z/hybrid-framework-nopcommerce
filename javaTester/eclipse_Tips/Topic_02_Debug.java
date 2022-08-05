package eclipse_Tips;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_02_Debug {
	WebDriver driver;

	// Mục đích của debug là để hiểu được luồng dữ liệu
	// Nếu làm đủ nhiều ko cần dùng debug quá nhiều --> đoán lỗi được
	@Test
	public void TC_01() {
		System.setProperty("webdriver.chrome.driver", ".\\browserDrivers\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("https://vi-vn.facebook.com/");
		String headerText = driver.findElement(By.cssSelector("h2._8eso")).getText();
		Assert.assertEquals(headerText, "Facebook giúp bạn kết nối và chia sẻ với mọi người trong cuộc sống của bạn.");

		boolean loginStatus = driver.findElement(By.name("login")).isDisplayed();
		Assert.assertTrue(loginStatus);

	}

}
