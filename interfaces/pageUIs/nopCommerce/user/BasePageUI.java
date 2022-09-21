package pageUIs.nopCommerce.user;

public class BasePageUI {
	public static final String ADDRESS_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Addresses']";
	public static final String MY_PRODUCT_REVIEW_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='My product reviews']";
	public static final String REWARD_POINT_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Reward points']";
	public static final String CUSTOMER_INFOR_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Customer info']";
	public static final String DYNAMIC_PAGES_NAME_AT_MY_ACCOUNT_AREA = "xpath=//div[contains(@class,'account-navigation')]//a[text()='%s']";
	public static final String LOGOUT_LINK_AT_USER = "xpath=//a[@class='ico-logout']";
	public static final String LOGOUT_LINK_AT_ADMIN = "xpath=//a[text()='Logout']";
	public static final String ICON_HEADER_DISPLAYED = "xpath=//div[@id='navbarText']//i[contains(@class,'fa-cogs')]";

	// Pattern Object
	public static final String DYNAMIC_TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
	public static final String DYNAMIC_BUTTON_BY_TEXT = "xpath=//button[text()='%s']";
	public static final String DYNAMIC_DROPDOWN_BY_NAME = "xpath=//select[@name='%s']";
	public static final String DYNAMIC_RADIO_BY_TEXT = "xpath=//label[text()='%s']/preceding-sibling::input";
	public static final String DYNAMIC_CHECKBOX_BY_TEXT = "xpath=//label[contains(text(),'%s')]/following-sibling::input";
	public static final String DYNAMIC_DROPDOWN_VALUE = "xpath=//select[@name='%s']/option[text()='%s']";
	public static final String DYNAMIC_RADIO_VALUE_BY_TEXT = "xpath=//label[text()='%s']/preceding-sibling::input[@checked='']";

}
