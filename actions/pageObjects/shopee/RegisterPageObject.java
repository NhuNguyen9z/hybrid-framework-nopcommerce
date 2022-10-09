package pageObjects.shopee;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.shopee.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToPhoneTextbox(String textValue) {
		waitForElementVisible(driver, RegisterPageUI.PHONE_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.PHONE_TEXTBOX, textValue);

	}

}
