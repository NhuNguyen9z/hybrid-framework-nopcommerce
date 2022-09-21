package pageObjects.patientpop.checkup;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

	public static CheckupPageObject getCheckupPage(WebDriver driver) {
		return new CheckupPageObject(driver);
	}

	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}

}
