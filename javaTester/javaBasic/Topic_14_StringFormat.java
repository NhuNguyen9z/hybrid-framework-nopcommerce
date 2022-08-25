package javaBasic;

public class Topic_14_StringFormat {
	public static String ADDRESS_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Addresses']";
	public static String MY_PRODUCT_REVIEW_LINK = "//div[contains(@class,'account-navigation')]//a[text()='My product reviews']";
	public static String REWARD_POINT_LINK = "/div[contains(@class,'account-navigation')]//a[text()='Reward points']";
	public static String CUSTOMER_INFOR_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Customer info']";

	// 1 tham số động
	public static String DYNAMIC_LINK_BY_SIDEBAR_PAGE_NAME = "//div[contains(@class,'account-navigation')]//a[text()='%s']";

	// 2 tham số động
	public static String DYMAMIC_LINK_BY_PAGE_NAME = "//div[contains(@class,'%s')]//a[text()='%s']";

	public static void main(String[] args) {

		clickToLink("//div[contains(@class,'account-navigation')]//a[text()='%s']", "Customer info");
		clickToLink("//div[contains(@class,'%s')]//a[text()='%s']", "account-navigation", "Customer info");

	}

	// 1 tham số động
	// public static String clickToLink(String dynamicLocator, String pageName) {
	// String locator = String.format(dynamicLocator, pageName);
	// System.out.println(locator);
	// return locator;
	//
	// }

	// 2 tham số động
	// public static void clickToLink(String dynamicLink, String areaName, String pageName) {
	// String locator = String.format(dynamicLink, areaName, pageName);
	// System.out.println(locator);
	// }

	// từ 1 -> n tham số động
	public static void clickToLink(String dynamicLocator, String... pageName) {
		String locator = String.format(dynamicLocator, (Object[]) pageName);
		System.out.println(locator);
	}

}
