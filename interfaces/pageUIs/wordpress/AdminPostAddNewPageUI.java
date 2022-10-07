package pageUIs.wordpress;

public class AdminPostAddNewPageUI {
	public static final String TITLE_TEXTBOX = "css=div>h1.wp-block-post-title";
	public static final String BODY_BUTTON = "xpath=//p[contains(@class,'block-editor-default') and @role='button']";
	public static final String BODY_TEXTBOX = "xpath=//p[contains(@class,'wp-block-paragraph') and @role='document']";
	public static final String PUBLISH_BUTTON = "xpath=//div[@class='edit-post-header__settings']//button[text()='%s']";
	public static final String PUBLISH_CONFIRM_BUTTON = "xpath=//div[@class='editor-post-publish-panel']//button[text()='%s']";
	public static final String PUBLISHED_MESSAGE = "xpath=//div[@class='components-snackbar__content' and text()='%s']";
}
