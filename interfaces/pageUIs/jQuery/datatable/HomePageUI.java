package pageUIs.jQuery.datatable;

public class HomePageUI {
	public static final String PAGINATION_PAGE_BY_NUMBER = "xpath=//li[@class='qgrd-pagination-page']/a[text()='%s']";
	public static final String PAGINATION_PAGE_ACTIVE_BY_NUMBER = "xpath=//li/a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String HEADER_TEXTBOX_BY_LABEL = "xpath=//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
	public static final String HEADER_BY_LABEL_DISPLAYED = "xpath=//tr/td[text()='%s']";
	public static final String TOTAL_PAGINATION = "css=ul.qgrd-pagination-ul>li>a";
	public static final String PAGINATION_BY_INDEX = "xpath=//ul[@class='qgrd-pagination-ul']/li[%s]";
	public static final String ALL_ROW_EACH_PAGE = "xpath=//tr/td[@data-key='country']";

	// Index của cái cột mà mình cần enter/ click/ select vào
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//tr//td[text()='%s']/preceding-sibling::td";
	public static final String TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]/input";
	public static final String DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]/select";
	public static final String CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]/input[@type='checkbox']";
	public static final String UNCHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]/input[@type='checkbox']";
	public static final String ICON_NAME_BY_ROW_NUMBER = "xpath=//tbody/tr[%s]//button[@title='%s']";

	public static final String LOAD_DATA_BUTTON = "css=button#btnLoad";

}
