package pageObjects.patientpop.checkup;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.patientpop.checkup.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getHeaderPractice() {
		waitForElementInvisible(driver, HomePageUI.PROGRESSBAR);
		waitForElementVisible(driver, HomePageUI.HEADER_PRACTICE);
		return getElementText(driver, HomePageUI.HEADER_PRACTICE);
	}

}
