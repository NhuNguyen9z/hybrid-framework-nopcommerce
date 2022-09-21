package pageObjects.patientpop.checkup;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.patientpop.checkup.CheckupPageUI;

public class CheckupPageObject extends BasePage {
	private WebDriver driver;

	public CheckupPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputAndSelectValueInDropdown(String textValue, String expectTextItem) {
		waitForElementVisible(driver, CheckupPageUI.PRACTICE_NAME_TEXTBOX_BY_ID);
		inputSelectItemInCustomDropdown(driver, CheckupPageUI.PRACTICE_NAME_TEXTBOX_BY_ID, CheckupPageUI.PRACTICE_NAME_DROPDOWN_CHILD_XPATH, textValue, expectTextItem);

	}

	public String getTextboxValueByID(String textboxID) {
		waitForElementVisible(driver, CheckupPageUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		return getElementValueByJSXpath(driver, CheckupPageUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
	}

	public String getStateValue() {
		waitForElementVisible(driver, CheckupPageUI.STATE_VALUE);
		return getElementText(driver, CheckupPageUI.STATE_VALUE);
	}

	public void selectValueInSpecialtyDropdown(String expectTextItem, String textboxID) {
		waitForElementClickable(driver, CheckupPageUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		selectItemInCustomDropdown(driver, CheckupPageUI.DYNAMIC_TEXTBOX_BY_ID, CheckupPageUI.SPECIALTY_NAME_DROPDOWN_CHILD_XPATH, expectTextItem, textboxID);
	}

	public HomePageObject clickToCompareButton() {
		waitForElementClickable(driver, CheckupPageUI.COMPARE_BUTTON);
		clickToElement(driver, CheckupPageUI.COMPARE_BUTTON);

		return PageGeneratorManager.getHomePage(driver);
	}

}
