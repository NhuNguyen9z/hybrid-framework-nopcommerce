package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.UserHomePageUI;

public class UserHomePO extends BasePage {
	private WebDriver driver;

	public UserHomePO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isPostInforDisplayedWithPostTitle(String postTitle) {
		waitForElementVisible(driver, UserHomePageUI.POST_TITLE, postTitle);
		return isElementDisplayed(driver, UserHomePageUI.POST_TITLE, postTitle);
	}

	public boolean isPostInforDisplayedWithPostCurrentDay(String postTitle, String currentDate) {
		waitForElementVisible(driver, UserHomePageUI.POST_CURRENT_DAY_BY_TITLE, postTitle, currentDate);
		return isElementDisplayed(driver, UserHomePageUI.POST_CURRENT_DAY_BY_TITLE, postTitle, currentDate);
	}

	public boolean isPostInforDisplayedWithPostBody(String postTitle, String postBody) {
		waitForElementVisible(driver, UserHomePageUI.POST_BODY_BY_TITLE, postTitle, postBody);
		return isElementDisplayed(driver, UserHomePageUI.POST_BODY_BY_TITLE, postTitle, postBody);
	}

	public boolean PostInforDisplayedWithPostAuthor(String postTitle, String author) {
		waitForElementVisible(driver, UserHomePageUI.POST_AUTHOR_BY_TITLE, postTitle, author);
		return isElementDisplayed(driver, UserHomePageUI.POST_AUTHOR_BY_TITLE, postTitle, author);
	}

	public UserPostDetailPO clickToPostTitleLink(String postTitle) {
		waitForElementClickable(driver, UserHomePageUI.POST_TITLE, postTitle);
		clickToElement(driver, UserHomePageUI.POST_TITLE, postTitle);
		return PageGenerator.getUserPostDetailPage(driver);
	}

	public void inputToSearchTextboxWithTitle(String textValue) {
		waitForElementVisible(driver, UserHomePageUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, UserHomePageUI.SEARCH_TEXTBOX, textValue);

	}

	public UserSearchPostPO clickToSearchButton() {
		waitForElementClickable(driver, UserHomePageUI.SEARCH_BUTTON);
		clickToElement(driver, UserHomePageUI.SEARCH_BUTTON);
		return PageGenerator.getUserSearchPostPage(driver);

	}

	public boolean isPostTitleUndisplayed(String postTitle) {
		return isElementUndisplayed(driver, UserHomePageUI.POST_TITLE, postTitle);
	}

}
