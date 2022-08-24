package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPageObject clickToMyAccountLink() {
		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		return new LoginPageObject(driver);

	}

	public boolean isDisplayMessageHomePage() {
		waitForElementVisible(driver, HomePageUI.HOMEPAGE_MESSAGE);
		return isElementDisplay(driver, HomePageUI.HOMEPAGE_MESSAGE);
	}

}
