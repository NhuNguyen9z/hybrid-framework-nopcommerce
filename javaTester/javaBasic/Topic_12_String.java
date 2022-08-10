package javaBasic;

import org.openqa.selenium.Keys;

public class Topic_12_String {

	public static void main(String[] args) {
		// String là 1 tập hợp những ký tự --> thành chuỗi ký tự => String là chuỗi ký tự
		// == dùng cho kiểu nguyên thủy (== dùng để so sánh giá trị và vùng nhớ)
		// equal dùng cho kiểu tham chiếu ví dụ String (equal chỉ so sánh giá trị ko so sánh vùng nhớ)

		// System.setProperty("webdriver.gecko.driver", ".\\browserDrivers\\geckodriver.exe");
		// WebDriver driver = new FirefoxDriver();

		String schoolName = "Automation Testing";
		String courseName = "automation testing";
		String schoolAddress = "Ho Chi Minh City";

		System.out.println("Độ dài  = " + schoolName.length());
		System.out.println("Lấy ra một ký tự = " + schoolName.charAt(0));
		System.out.println("Nối 2 chuỗi = " + schoolName.concat(schoolAddress));
		System.out.println("Nối 2 chuỗi = " + schoolName + schoolAddress);

		// Kiểm tra 2 chuỗi bằng nhau tuyệt đối
		System.out.println("Kiểm tra 2 chuỗi bằng nhau tuyệt đối = " + schoolName.equals(courseName));
		System.out.println("Kiểm tra 2 chuỗi bằng nhau tuyệt đối = " + schoolName.equals("Automation Testing"));

		// Multi browser
		System.out.println("Kiểm tra 2 chuỗi bằng nhau tuyệt đối = " + schoolName.equalsIgnoreCase(courseName)); // Ko phân biệt hoa thường

		// startsWith/ endWith/ contains

		System.out.println("Có bắt đầu bằng 1 ký tự/ chuỗi ký tự = " + schoolName.startsWith("A"));
		System.out.println("Có bắt đầu bằng 1 ký tự/ chuỗi ký tự = " + schoolName.startsWith("Automation"));
		System.out.println("Có bắt đầu bằng 1 ký tự/ chuỗi ký tự = " + schoolName.startsWith("T"));

		System.out.println("Có chứa 1 ký tự/ chuỗi ký tự = " + schoolName.contains("Automation Testing"));
		System.out.println("Có chứa 1 ký tự/ chuỗi ký tự = " + schoolName.contains("T"));
		System.out.println("Có chứa 1 ký tự/ chuỗi ký tự = " + schoolName.contains("Testing"));
		System.out.println("Có chứa 1 ký tự/ chuỗi ký tự = " + schoolName.contains("Advanced"));

		System.out.println("Có kết thúc bằng 1 ký tự/ chuỗi ký tự = " + schoolName.endsWith("g"));
		System.out.println("Có kết thúc bằng 1 ký tự/ chuỗi ký tự = " + schoolName.endsWith("Testing"));
		System.out.println("Có kết thúc bằng 1 ký tự/ chuỗi ký tự = " + schoolName.endsWith("Automation"));

		System.out.println("Vị trí của 1 ký tự/ chuỗi ký tự trong chuỗi = " + schoolName.indexOf("Automation"));
		System.out.println("Vị trí của 1 ký tự/ chuỗi ký tự trong chuỗi = " + schoolName.indexOf("A"));
		System.out.println("Vị trí của 1 ký tự/ chuỗi ký tự trong chuỗi = " + schoolName.indexOf("utomation"));
		System.out.println("Vị trí của 1 ký tự/ chuỗi ký tự trong chuỗi = " + schoolName.indexOf("Testing"));

		System.out.println("Tách 1 ký tự/ chuỗi ký tự trong chuỗi = " + schoolName.substring(11));
		System.out.println("Tách 1 ký tự/ chuỗi ký tự trong chuỗi = " + schoolName.substring(11, 15));

		String result = "Viewing 48 of 132 results";
		// Split: Tách chuỗi thành 1 mảng dựa vào ký tự/ chuỗi ký tự
		String[] results = result.split(" "); // tách chuỗi dựa vào khoảng trắng
		for (String string : results) {
			System.out.println(string);
		}
		System.out.println("--------" + results[1]);

		// Replace
		String productPrice = "$100.00";
		productPrice = productPrice.replace("$", "");
		System.out.println(productPrice);

		// Convert String sang kiểu float -- dùng để sắp xếp nó: Sort Data (Asc/ Desc)
		float productPriceF = Float.parseFloat(productPrice);
		System.out.println(productPriceF);

		// Convert float sang kiểu String
		productPrice = String.valueOf(productPriceF);
		System.out.println("Convert float sang kiểu String = " + productPrice);

		String osName = System.getProperty("os.name");
		System.out.println(osName);
		// Windows 10 = windows
		// Handle multiple OS: MAC/ Windows(Actions - Keys - Ctrl/ Command)
		if (osName.toLowerCase().contains("windows")) {
			Keys key = Keys.CONTROL;
		} else {
			Keys key = Keys.COMMAND;
		}

		// Multiple browser: toUpperCase
		// firefox = FIREFOX (Enum)

		// String driverInstanceName = driver.toString();
		// System.out.println(driverInstanceName);
		// Close browser/ driver
		// if(driverInstanceName.contains("internetexplorer")) {
		// Sleep cứng thêm 5s sau mỗi sự kiện chuyển page
		// }

		// Hàm trim: Cắt khoảng trắng/ xuống dòng/ tab
		String helloWorld = "      \n      \t      Hello World!      ";
		System.out.println(helloWorld.trim());
		System.out.println(helloWorld);

		helloWorld = "";
		System.out.println("Empty = " + helloWorld.isEmpty());

		// Dynamic locator
		// Đại diện cho 1 chuỗi: %s
		// %b %t %d
		String dynamicButtonXpath = "//button[@id='%s']";
		System.out.println("Click to Login button = " + dynamicButtonXpath.format(dynamicButtonXpath, "login"));
		System.out.println("Click to Register button = " + dynamicButtonXpath.format(dynamicButtonXpath, "register"));
		System.out.println("Click to Search button = " + dynamicButtonXpath.format(dynamicButtonXpath, "search"));
	}

}
