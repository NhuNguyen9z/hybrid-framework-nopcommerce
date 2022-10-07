package pageUIs.wordpress;

public class UserPostDetailPageUI {
	public static final String POST_TITLE = "xpath=//article//h1[text()='%s']";
	public static final String POST_CURRENT_DAY_BY_TITLE = "xpath=//article//h1[text()='%s']/parent::header/div/span//time[text()='%s']";
	public static final String POST_BODY_BY_TITLE = "xpath=//article//h1[text()='%s']/parent::header/following-sibling::div/p[text()='%s']";
	public static final String POST_AUTHOR_BY_TITLE = "xpath=//article//h1[text()='%s']/parent::header/div//span//a[text()='%s']";

}
