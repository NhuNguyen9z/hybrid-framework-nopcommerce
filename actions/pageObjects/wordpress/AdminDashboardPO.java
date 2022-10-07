package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminDashboardPageUI;

public class AdminDashboardPO extends BasePage {
	private WebDriver driver;

	public AdminDashboardPO(WebDriver driver) {
		this.driver = driver;
	}

	public AdminPostSearchPO clickToPostslink() {
		waitForElementClickable(driver, AdminDashboardPageUI.POSTS_LINK);
		clickToElement(driver, AdminDashboardPageUI.POSTS_LINK);
		return PageGenerator.getAdminPostSearchPage(driver);
	}

}
