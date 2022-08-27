package javaBasic;

public class Topic_16_String_Format {

	public static void main(String[] args) {
		String locator = String.format("xpath=//div[contains(@class,'account-navigation')]//a[text()='%s']", "Addresses");
		locator = locator.substring(6); // substring: lấy ra 6 ký tự đầu tiên xóa đi
		System.out.println(locator);

	}

}
