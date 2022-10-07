package pageUIs.wordpress;

public class UserHomePageUI {
	public static final String POST_TITLE = "xpath=//article//a[text()='%s']";
	public static final String POST_CURRENT_DAY_BY_TITLE = "xpath=//article//a[text()='%s']/ancestor::header/div//a/time[text()='%s']";
	public static final String POST_BODY_BY_TITLE = "xpath=//article//a[text()='%s']/ancestor::header/following-sibling::div/p[text()='%s']";
	public static final String POST_AUTHOR_BY_TITLE = "xpath=//article//a[text()='%s']/ancestor::header/div//span/a[text()='%s']";
	public static final String POST_NOTHING_FOUND_MESSAGE = "xpath=//h1[@class='page-title' and text()='Nothing Found']";
	public static final String SEARCH_TEXTBOX = "xpath=//input[contains(@class,'wp-block-search__input')]";
	public static final String SEARCH_BUTTON = "xpath=//button[text()='Search']";

}
