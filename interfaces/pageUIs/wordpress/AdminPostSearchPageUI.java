package pageUIs.wordpress;

public class AdminPostSearchPageUI {
	public static final String ADD_NEW_BUTTON = "xpath=//a[@class='page-title-action' and text()='Add New']";
	public static final String SEARCH_POSTS_TEXTBOX = "css=input#post-search-input";
	public static final String SEARCH_POSTS_BUTTON = "css=input#search-submit";

	public static final String TABLE_HEADER_INDEX_BY_HEADER_NAME = "xpath=//table[contains(@class,'table-view-list posts')]/thead//th[@id='%s']/preceding-sibling::*";
	public static final String TABLE_ROW_VALUE_BY_HEADER_INDEX = "xpath=//table[contains(@class,'table-view-list posts')]/tbody/tr/*[%s]//a[text()='%s']";
	public static final String POST_TITLE = "xpath=//table[contains(@class,'table-view-list posts')]/tbody//td//a[@class='row-title' and text()='%s']";
	public static final String CHECKBOX_BY_POST = "xpath=//table[contains(@class,'table-view-list posts')]//tbody//tr/td//a[text()='%s']/ancestor::td/preceding-sibling::th//input";
	public static final String DROPDOWN_BY_POST = "css=select#bulk-action-selector-top";
	public static final String APPLY_BUTTON = "css=input#doaction";
	public static final String POST_MOVE_TO_TRASH_MESSAGE = "xpath=//div[@id='message']/p[contains(text(),'%s')]";
	public static final String POST_NO_FOUND_MESSAGE = "xpath=//table[contains(@class,'table-view-list posts')]/tbody//tr/td[text()='%s']";

}
