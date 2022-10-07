package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.UserPostDetailPageUI;

public class UserPostDetailPO extends BasePage {
	private WebDriver driver;

	public UserPostDetailPO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isPostInforDisplayedWithPostTitle(String postTitle) {
		waitForElementVisible(driver, UserPostDetailPageUI.POST_TITLE, postTitle);
		return isElementDisplayed(driver, UserPostDetailPageUI.POST_TITLE, postTitle);
	}

	public boolean isPostInforDisplayedWithPostCurrentDay(String postTitle, String currentDate) {
		waitForElementVisible(driver, UserPostDetailPageUI.POST_CURRENT_DAY_BY_TITLE, postTitle, currentDate);
		return isElementDisplayed(driver, UserPostDetailPageUI.POST_CURRENT_DAY_BY_TITLE, postTitle, currentDate);
	}

	public boolean isPostInforDisplayedWithPostBody(String postTitle, String postBody) {
		waitForElementVisible(driver, UserPostDetailPageUI.POST_BODY_BY_TITLE, postTitle, postBody);
		return isElementDisplayed(driver, UserPostDetailPageUI.POST_BODY_BY_TITLE, postTitle, postBody);
	}

	public boolean PostInforDisplayedWithPostAuthor(String postTitle, String author) {
		waitForElementVisible(driver, UserPostDetailPageUI.POST_AUTHOR_BY_TITLE, postTitle, author);
		return isElementDisplayed(driver, UserPostDetailPageUI.POST_AUTHOR_BY_TITLE, postTitle, author);
	}

	public AdminDashboardPO openAdminSite(String urlAdminSite) {
		openPageUrl(driver, urlAdminSite);
		return PageGenerator.getAdminDashboardPage(driver);
	}

}
