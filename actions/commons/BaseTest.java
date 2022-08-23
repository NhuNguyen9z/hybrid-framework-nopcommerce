package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driverBaseTest;

	protected WebDriver getBrowserDriver(String browserName) {
		if (browserName.equals("firefox")) { // Firefox browser mới nhất thì cứ chọn FirefoxDriver(geckodriver) mới nhất -- tương tự cho Opera browser
			// WebDriverManager - chọn hết all trong file libWebDriverManager sau đó phải Add Build Path thì mới chạy được
			WebDriverManager.firefoxdriver().setup(); // tự tại driver tương ứng về
			driverBaseTest = new FirefoxDriver();
		} else if (browserName.equals("h_firefox")) { // headless firefox --- Auto for UI: ko nên dùng Headless
			// Browser option: 3.xx
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions(); // new lên
			options.addArguments("--headless"); // Add tham số -headless
			options.addArguments("window-size=1920x1080"); // Set size là bao nhiêu
			driverBaseTest = new FirefoxDriver(options);
		} else if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driverBaseTest = new ChromeDriver();
		} else if (browserName.equals("h_chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driverBaseTest = new ChromeDriver(options);
		} else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driverBaseTest = new EdgeDriver();
		} else if (browserName.equals("ie")) {
			WebDriverManager.iedriver().arch32().setup();
			driverBaseTest = new InternetExplorerDriver();
		}

		else if (browserName.equals("opera")) {
			WebDriverManager.operadriver().setup();
			driverBaseTest = new OperaDriver();
		} else if (browserName.equals("cococ")) {
			// Cốc cốc browser trừ đi 5-6 version ra chromedriver
			WebDriverManager.chromedriver().driverVersion("93.0.4577.63").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files (x86)\\CocCoc\\Browser\\Application\\browser.exe");
			driverBaseTest = new ChromeDriver(options);
		} else if (browserName.equals("brave")) {
			// Brave browser version nào dùng chromedriver version đó
			WebDriverManager.chromedriver().driverVersion("95.0.4638.17").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
			driverBaseTest = new ChromeDriver(options);
		} else {
			throw new RuntimeException("Browser name invalid");
		}

		driverBaseTest.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // Setting timeout
		driverBaseTest.get("https://demo.nopcommerce.com/");

		return driverBaseTest;

	}

	protected int generateFakeEmail() {
		Random random = new Random();
		return random.nextInt(9999);
	}
}
