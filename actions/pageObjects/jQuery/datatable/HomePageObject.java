package pageObjects.jQuery.datatable;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.datatable.HomePageUI;

public class HomePageObject extends BasePage {

	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPagingByPageNumber(String pageName) {
		waitForElementClickable(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageName);
		// CÁCH CODE CHẠY
		// Truyền số 10 thì sẽ gọi vào hàm openPagingByPageNumber, pageName chính là số 10
		// gọi vào hàm waitForElementClickable gọi elementToBeClickable gọi getByLocator gọi tiếp getDynamicXpath thì đi code từ trong ra ngoài
		// locatorType chính là "xpath=//li[@class='qgrd-pagination-page']/a[text()='%s']"
		// dynamicValues = "10"
		// gọi hàm getDynamicXpath trước: khi mà bằng xpath thì sẽ nhảy vào case locatorType = String.format(locatorType, (Object[]) dynamicValues);
		// locatorType lúc nãy - truyền dynamicValues vào chẳng khác nào bóc dynamicValues nhét vào locatorType - nghĩa là bóc số 10 bỏ vào %s
		// sau đó lấy dc locatorType ra rồi tiếp tục truyền vào hàm getByLocator thì lúc này nó đã map dc rồi nhảy vào case xpath= cắt đoạn xpath= đi rồi giữa lại
		// nguyên chuỗi
		// để nó findBy, findBy xong trả về cho thằng elementToBeClickable này
		//
		clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageName);

	}

	public boolean isPageNumberActived(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGINATION_PAGE_ACTIVE_BY_NUMBER, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGINATION_PAGE_ACTIVE_BY_NUMBER, pageNumber);
	}

	public void enterToHeaderTextboxByLabel(String headerLabel, String valueToSendkey) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, headerLabel);
		sendkeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, valueToSendkey, headerLabel);
		pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, Keys.ENTER, headerLabel);
	}

	public boolean isResultDisplay(String dynamicValues) {
		waitForElementVisible(driver, HomePageUI.HEADER_BY_LABEL_DISPLAYED, dynamicValues);
		return isElementDisplayed(driver, HomePageUI.HEADER_BY_LABEL_DISPLAYED, dynamicValues);
	}

	public List<String> getValueEachRowAllPage() {
		int totalPage = getElementSize(driver, HomePageUI.TOTAL_PAGINATION);

		// List<String>: cho phép lưu trùng
		// Set<String>: KO cho phép lưu trùng - chỉ lấy 1 giá trị duy nhất
		// Set<String> allRowValueUniqueAllPage = new HashSet<String>();
		List<String> allRowValueAllPage = new ArrayList<String>();

		// duyệt qua all các page number (paging)
		for (int index = 1; index <= totalPage; index++) { // vì có index nên ko dùng dc foreach
			clickToElement(driver, HomePageUI.PAGINATION_BY_INDEX, String.valueOf(index));

			// Get text của all các row mỗi page đưa vào ArrayList
			List<WebElement> allRowElementEachPage = getListWebElement(driver, HomePageUI.ALL_ROW_EACH_PAGE);
			for (WebElement eachRow : allRowElementEachPage) {
				String contryName = eachRow.getText();
				allRowValueAllPage.add(contryName); // getText ra sau đó lưu vào cái ArrayList
			}
		}
		return allRowValueAllPage;

	}

	public void enterToTextboxByColumnNameAtRowNumber(String columnName, String rowNumber, String valueToEnter) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementVisible(driver, HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		sendkeyToElement(driver, HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, valueToEnter, rowNumber, String.valueOf(columnIndex));

	}

	public void selectDropdownByColumnNameAtRowNumber(String columnName, String rowNumber, String valueToSelect) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementClickable(driver, HomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		selectItemInDefaultDropdown(driver, HomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, valueToSelect, rowNumber, String.valueOf(columnIndex));

	}

	public void clickToLoadButton() {
		waitForElementClickable(driver, HomePageUI.LOAD_DATA_BUTTON);
		clickToElement(driver, HomePageUI.LOAD_DATA_BUTTON);

	}

	public void checkToCheckboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementClickable(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		checkToDefaultCheckboxOrRadio(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));

	}

	public void uncheckToCheckboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementClickable(driver, HomePageUI.UNCHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		uncheckToDefaultCheckbox(driver, HomePageUI.UNCHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));

	}

	public void clickToIconByRowNumber(String iconName, String rowNumber) {
		waitForElementClickable(driver, HomePageUI.ICON_NAME_BY_ROW_NUMBER, rowNumber, iconName);
		clickToElement(driver, HomePageUI.ICON_NAME_BY_ROW_NUMBER, rowNumber, iconName);

	}

}
