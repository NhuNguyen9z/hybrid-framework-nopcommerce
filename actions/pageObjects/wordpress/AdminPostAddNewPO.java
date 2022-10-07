package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminPostAddNewPageUI;

public class AdminPostAddNewPO extends BasePage {
	private WebDriver driver;

	public AdminPostAddNewPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToAddNewPostTitle(String textValue) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.TITLE_TEXTBOX);
		sendkeyToElement(driver, AdminPostAddNewPageUI.TITLE_TEXTBOX, textValue);

	}

	public void enterToAddNewPostBody(String textValue) {
		waitForElementClickable(driver, AdminPostAddNewPageUI.BODY_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.BODY_BUTTON);
		waitForElementVisible(driver, AdminPostAddNewPageUI.BODY_TEXTBOX);
		sendkeyToElement(driver, AdminPostAddNewPageUI.BODY_TEXTBOX, textValue);

	}

	public void clickToPublishButton(String textButton) {
		waitForElementClickable(driver, AdminPostAddNewPageUI.PUBLISH_BUTTON, textButton);
		clickToElement(driver, AdminPostAddNewPageUI.PUBLISH_BUTTON, textButton);
		waitForElementClickable(driver, AdminPostAddNewPageUI.PUBLISH_CONFIRM_BUTTON, textButton);
		clickToElement(driver, AdminPostAddNewPageUI.PUBLISH_CONFIRM_BUTTON, textButton);

	}

	public boolean isPostPublishMessageDisplayed(String dynamicValues) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.PUBLISHED_MESSAGE, dynamicValues);
		return isElementDisplayed(driver, AdminPostAddNewPageUI.PUBLISHED_MESSAGE, dynamicValues);
	}

	public AdminPostSearchPO openSearchPostPageUrl(String searchPostUrl) {
		openPageUrl(driver, searchPostUrl);
		return PageGenerator.getAdminPostSearchPage(driver);

	}

	public void enterToEditPostBody(String textValue) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.BODY_TEXTBOX);
		clearValueInElementByDeleteKey(driver, AdminPostAddNewPageUI.BODY_TEXTBOX);
		sendkeyToElement(driver, AdminPostAddNewPageUI.BODY_TEXTBOX, textValue);

	}

	public void clickToUpdateButton(String textButton) {
		waitForElementClickable(driver, AdminPostAddNewPageUI.PUBLISH_BUTTON, textButton);
		clickToElement(driver, AdminPostAddNewPageUI.PUBLISH_BUTTON, textButton);

	}

}
