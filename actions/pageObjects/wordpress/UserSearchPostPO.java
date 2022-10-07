package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.UserSearchPageUI;

public class UserSearchPostPO extends BasePage {
	private WebDriver driver;

	public UserSearchPostPO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isMesssgeNothingFoundDisplayed(String message) {
		waitForElementVisible(driver, UserSearchPageUI.POST_NOTHING_FOUND_MESSAGE, message);
		return isElementDisplayed(driver, UserSearchPageUI.POST_NOTHING_FOUND_MESSAGE, message);
	}

}
