package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminPostSearchPageUI;

public class AdminPostSearchPO extends BasePage {

	private WebDriver driver;

	public AdminPostSearchPO(WebDriver driver) {
		this.driver = driver;
	}

	public AdminPostAddNewPO clickToAddNewButton() {
		waitForElementClickable(driver, AdminPostSearchPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, AdminPostSearchPageUI.ADD_NEW_BUTTON);
		return PageGenerator.getAdminPostAddNewPage(driver);

	}

	public void inputToSearchTextboxWithTitle(String postTitle) {
		waitForElementVisible(driver, AdminPostSearchPageUI.SEARCH_POSTS_TEXTBOX);
		sendkeyToElement(driver, AdminPostSearchPageUI.SEARCH_POSTS_TEXTBOX, postTitle);

	}

	public void clickToSearchPostsButton() {
		waitForElementClickable(driver, AdminPostSearchPageUI.SEARCH_POSTS_BUTTON);
		clickToElement(driver, AdminPostSearchPageUI.SEARCH_POSTS_BUTTON);

	}

	public boolean isPostSearchTableDisplayed(String columnID, String postValue) {
		int columnIndex = getElementSize(driver, AdminPostSearchPageUI.TABLE_HEADER_INDEX_BY_HEADER_NAME, columnID) + 1;
		waitForElementVisible(driver, AdminPostSearchPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(columnIndex), postValue);
		return isElementDisplayed(driver, AdminPostSearchPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(columnIndex), postValue);
	}

	public AdminPostAddNewPO clickToPostTitleLink(String postTitle) {
		waitForElementVisible(driver, AdminPostSearchPageUI.POST_TITLE, postTitle);
		clickToElement(driver, AdminPostSearchPageUI.POST_TITLE, postTitle);
		return PageGenerator.getAdminPostAddNewPage(driver);

	}

	public void selectPostCheckboxByTitle(String postTitle) {
		waitForElementClickable(driver, AdminPostSearchPageUI.CHECKBOX_BY_POST, postTitle);
		checkToDefaultCheckboxOrRadio(driver, AdminPostSearchPageUI.CHECKBOX_BY_POST, postTitle);

	}

	public void selectMoveToTrashDropdown(String textItem) {
		waitForElementVisible(driver, AdminPostSearchPageUI.DROPDOWN_BY_POST);
		selectItemInDefaultDropdown(driver, AdminPostSearchPageUI.DROPDOWN_BY_POST, textItem);
	}

	public void clickToApplyButton() {
		waitForElementClickable(driver, AdminPostSearchPageUI.APPLY_BUTTON);
		clickToElement(driver, AdminPostSearchPageUI.APPLY_BUTTON);
	}

	public boolean isPostMoveToTrashDisplayed(String message) {
		waitForElementVisible(driver, AdminPostSearchPageUI.POST_MOVE_TO_TRASH_MESSAGE, message);
		return isElementDisplayed(driver, AdminPostSearchPageUI.POST_MOVE_TO_TRASH_MESSAGE, message);
	}

	public boolean isMesssgeNoPostFoundDisplayed(String message) {
		waitForElementVisible(driver, AdminPostSearchPageUI.POST_NO_FOUND_MESSAGE, message);
		return isElementDisplayed(driver, AdminPostSearchPageUI.POST_NO_FOUND_MESSAGE, message);
	}

	// public boolean isPostInfoUndisplayedWithPostTitle(String columnID, String postValue) {
	// int columnIndex = getElementSize(driver, AdminPostSearchPageUI.TABLE_HEADER_INDEX_BY_HEADER_NAME, columnID) + 1;
	// return isElementUndisplayed(driver, AdminPostSearchPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(columnIndex), postValue);
	// }

}
