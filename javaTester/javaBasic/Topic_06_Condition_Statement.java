package javaBasic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Topic_06_Condition_Statement {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	public void TC_01_If() {
		boolean status = 5 > 3;
		System.out.println(status);

		// Hàm if sẽ nhận vào 1 điều kiện đúng
		// Kiểm tra duy nhất 1 điều kiện
		// Nếu điều kiện này đúng thì sẽ action (xxx) trong phần thân
		if (status) {
			// Đúng thì vào phần thân của if
			// Sai thì bỏ qua
			System.out.println("Go to if");
		}

		// Gán (assign)
		int studentNumber = 10; // gán biến studentNumber này bằng 10 (gán trực tiếp)

		// So sánh
		status = (studentNumber != 10);
		System.out.println(status);

		WebDriver driver = new FirefoxDriver();

		// 1. trường hợp popup luôn có trong DOM
		// Element luôn luôn có trong DOM dù popup có hiển thị hay ko
		WebElement salePopup = driver.findElement(By.id(""));
		if (salePopup.isDisplayed()) {

		}

		// 2. Trường hợp popup ko có trong DOM
		// Element ko có trong DOM khi popup ko hiển thị
		List<WebElement> salePopups = driver.findElements(By.id(""));
		if (salePopups.size() > 0 && salePopups.get(0).isDisplayed()) { // nếu 2 cái đúng hết thì mới nhảy vào phần thân
																		// của if (nếu 1 trong 2 bị sai thì sẽ ko vào)
			// salePopups.size() > 0 -- vì findElements ko hề bị fail nếu như ko có element
			// nào, nếu element ko có trong DOM thì trả về 1 list rỗng --> thì nó có thể
			// kiểm tra trường hợp popup ko hiển thị hoặc popup hiển thị
			// salePopups.get(0).isDisplayed() -- nếu salePopups lấy ra element đầu tiên mà
			// nó isDisplayed thì nó sẽ chạy vào trong phần thân của if

		}

		// Uncheck to checkbox
		WebElement languagesCheckbox = driver.findElement(By.id(""));
		if (languagesCheckbox.isSelected()) {
			languagesCheckbox.click();
		}

		// Check to checkbox
		if (!languagesCheckbox.isSelected()) {
			languagesCheckbox.click();
		}
	}

	public void TC_02_If_Else() {
		// lưu ý ko add file .exe vào Build path vì nó là file thực thi nên add vào nó
		// ko compare ko đọc dc nên khi add vào nó sẽ sai

		// Có tới 2 điều kiện: nếu như đúng thì vào if - sai thì vào else
		// Nếu driver Start vs browser như Chrome/ Firefox/ Edge/ Safari thì dùng hàm
		// click thông thường (builtin) của Selenium WebDriver

		// Nếu driver là IE thì dùng hàm click của JavascriptExecutor

		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();

//		System.setProperty("webdriver.ie.driver", projectPath + "\\browserDrivers\\IEDriverServer.exe");
//		driver = new InternetExplorerDriver();

		System.out.println(driver.toString());
		if (driver.toString().contains("internet explorer")) {
			System.out.println("Click by JavaScript Executor");

		} else {
			System.out.println("Click By Selenium");

		}
	}

	@Parameters("browser")
	@Test // Để chạy testcase này phải qua file .xml vì chạy trực tiếp nó ko tìm thấy
			// parameter đâu hết
	public void TC_03_If_Else_If_Else(String browserName) {
		// Có nhiều điều kiện
		// Best Practice: Ko nên if-else quá nhiều

		if (browserName.equalsIgnoreCase("chrome")) {// hàm equalsIgnoreCase ko phân biệt hoa thường

			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else { // Safari/ Opera
			throw new RuntimeException("Please input correct the browser name");

		}
		System.out.println(browserName);
		System.out.println(driver.toString());
		driver.quit();

	}

	public void TC_04_If_Else_If_Else() {
		String pageName = "Login";
		if (pageName.equals("Login")) {
			// LoginPage loginPage = new LoginPage();
			// return loginPage;
		} else if (pageName.equals("Register")) {
			// RegisterPage registerPage = new RegisterPage();
			// return registerPage;
		} else if (pageName.equals("Customer")) {
			// CustomerPage customerPage = new CustomerPage();
			// return customerPage;
		} else {
			// HomePage homePage = new HomePage();
			// return homePage;
		}

		// if-else
		int age = 20;
		String access = (age < 18) ? "You can not access to System" : "Wellcome to System";

		if (age < 18) {
			access = "You can not access to System";
		} else {
			access = "Wellcome to System";
		}
		System.out.println(access);
	}

}
