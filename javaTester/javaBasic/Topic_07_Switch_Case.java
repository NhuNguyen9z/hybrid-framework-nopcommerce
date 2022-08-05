package javaBasic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Topic_07_Switch_Case {
	Scanner scanner = new Scanner(System.in);
	String projectPath = System.getProperty("user.dir");
	WebDriver driver;

	// return hoặc break dùng để thoát ra khỏi vòng lặp
	// mặc dù break ko bắt buộc -- nếu ko dùng break thì sẽ chạy hết all các case để kiểm tra làm performance bị chậm 
	
	// Nhược điểm của switch case
	// Chỉ nhận int/ string/ enum
	// Ko dùng với các toán tử trong case: = < > != ==

	@Parameters("browser")

	public void TC_01(String browserName) {

		driver = getBowserDrivers(browserName);

		System.out.println(browserName);
		System.out.println(driver.toString());
		driver.quit();

	}

	
	public void TC_02() {
		int month = scanner.nextInt();
		
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("tháng có 31 ngày");
			break;

		case 2:
			System.out.println("Tháng có 28 ngày");
			break;
			
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("Tháng có 30 ngày");
			break;
		 
		default:
			System.out.println("Vui lòng nhập tháng trong khoảng 1 - 12");
			break;
		}
	}
	
	
	public void TC_03() {
		int number = scanner.nextInt();
		switch (number) {
		case 1:
			System.out.println("One");
			break;
		case 2:
			System.out.println("Two");
			break;
		case 3:
			System.out.println("Three");
			break;
		case 4:
			System.out.println("Four");
			break;
		case 5:
			System.out.println("Five");
			break;
		case 6:
			System.out.println("Six");
			break;
		case 7:
			System.out.println("Seven");
			break;
		case 8:
			System.out.println("Eight");
			break;
		case 9:
			System.out.println("Nine");
			break;
		case 10:
			System.out.println("Ten");
			break;
			

		default:
			System.out.println("Vui lòng nhập số từ 1 - 10");
			break;
		}
	}
	

	@Test
	public void TC_04() {
		int firstNumber = scanner.nextInt();
		int secondNumber = scanner.nextInt();
		String operator = scanner.next();
		
		switch (operator) {
		case "+":
			System.out.println("A + B = " +  (firstNumber + secondNumber));			
			break;
		case "-":
			System.out.println("A - B = " + (firstNumber - secondNumber));
			break;

		case "*":
			System.out.println("A * B = " + (firstNumber * secondNumber));
			break;
		case "/":
			System.out.println("A / B = " + (firstNumber / secondNumber));
			break;
		}
	}
	
	
	public WebDriver getBowserDrivers(String browserName) {

		switch (browserName) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();

			break;

		case "chrome":
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;

		case "edge":
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;

		default:
			new RuntimeException("Please input correct browse name");
			break;
		}

		return driver;
	}
}
