package pageObjects.shopee;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import commons.BasePage;
import pageUIs.shopee.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void closePopup() {
		WebElement shadow_host1 = driver.findElement(By.cssSelector("shopee-banner-popup-stateful"));

		Object shadowRoot1 = ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot", shadow_host1);
		@SuppressWarnings("unchecked")
		String id = (String) ((Map<String, Object>) shadowRoot1).get("shadow-6066-11e4-a52e-4f735466cecf");
		RemoteWebElement shadowRootElement = new RemoteWebElement();
		shadowRootElement.setParent((RemoteWebDriver) driver);
		shadowRootElement.setId(id);

		shadowRootElement.findElement(By.cssSelector("div.shopee-popup__close-btn")).click();

	}

	public boolean isSearchButtonDisplayed() {
		waitForElementVisible(driver, HomePageUI.SEARCH_BUTTON);
		return isElementDisplayed(driver, HomePageUI.SEARCH_BUTTON);
	}

	public RegisterPageObject clickToRegisterLink(String name) {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK, name);
		clickToElement(driver, HomePageUI.REGISTER_LINK, name);
		return PageGeneratorManager.getRegisterPage(driver);

	}

}
