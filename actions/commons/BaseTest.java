package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	private WebDriver driverBaseTest;
	private String projectPath = System.getProperty("user.dir"); // Lấy ra thư mục của dự án

	protected WebDriver getBrowserDriver(String browserName) {
		if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");// nối chuỗi
			driverBaseTest = new FirefoxDriver();
		} else if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");// nối chuỗi
			driverBaseTest = new ChromeDriver();
		} else if (browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");// nối chuỗi
			driverBaseTest = new EdgeDriver();
		} else {
			throw new RuntimeException("Browser name invalid");
		}

		driverBaseTest.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // Setting timeout
		driverBaseTest.get("https://demo.nopcommerce.com/");

		return driverBaseTest;
	}
}
