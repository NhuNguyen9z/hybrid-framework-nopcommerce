package javaBasic;

public class Topic_13_SubString {
	public static void main(String[] args) {
		String firstText = "id=Email";
		String secondText = "css=input[id='password']";
		String thirdText = "xpath=//button[text()='Login']";
		System.out.println(firstText.substring(3));
		System.out.println(secondText.substring(4));
		System.out.println(thirdText.substring(6));
	}

	// Selenium Locator (2x, 3x) có 8 loại:
	// - ID/ Classname/ Name/ Tagname/ LinkText/ PartialLinkText/ Css/ Xpath
	// - Tham số đầu vào đều là String

}
