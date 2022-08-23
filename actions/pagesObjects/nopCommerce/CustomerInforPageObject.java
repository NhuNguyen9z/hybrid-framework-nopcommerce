package pagesObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.CustomerInforPageUI;

public class CustomerInforPageObject extends BasePage {
	WebDriver driver;

	public CustomerInforPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isCustomerInfoPageDisplayed() {
		waitForElementVisible(driver, CustomerInforPageUI.CUSTOMER_INFOR_HEADERS);
		return isElementDisplay(driver, CustomerInforPageUI.CUSTOMER_INFOR_HEADERS);
	}

	public void clickToNewsletterCheckbox() {
		// TODO Auto-generated method stub

	}

}
