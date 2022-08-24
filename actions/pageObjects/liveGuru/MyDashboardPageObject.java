package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.MyDashboardPageUI;

public class MyDashboardPageObject extends BasePage {
	private WebDriver driver;

	public MyDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getSuccessMessage() {
		waitForElementVisible(driver, MyDashboardPageUI.SUCCESSFUL_MESSAGE);
		return getElementText(driver, MyDashboardPageUI.SUCCESSFUL_MESSAGE);
	}

	public HomePageObject clickToLogoutLink() {
		waitForElementClickable(driver, MyDashboardPageUI.LOGOUT_LINK);
		clickToElement(driver, MyDashboardPageUI.LOGOUT_LINK);
		return new HomePageObject(driver);

	}

	public void clickToAccount() {
		waitForElementClickable(driver, MyDashboardPageUI.ICON_ACCOUNT);
		clickToElement(driver, MyDashboardPageUI.ICON_ACCOUNT);

	}

	public String getMyDashboardText() {
		waitForElementVisible(driver, MyDashboardPageUI.MYDASHBOARD_TEXT);
		return getElementText(driver, MyDashboardPageUI.MYDASHBOARD_TEXT);

	}

}
