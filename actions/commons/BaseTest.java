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
		// browserList = Lấy ra giá trị của browserName để compare - thì browserList lúc mang giá trị là String
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		if (browserList == BrowserList.FIREFOX) { // Firefox browser mới nhất thì cứ chọn FirefoxDriver(geckodriver) mới nhất -- tương tự cho Opera browser
			// WebDriverManager - chọn hết all trong file libWebDriverManager sau đó phải Add Build Path thì mới chạy được
			WebDriverManager.firefoxdriver().setup(); // tự tại driver tương ứng về
			driverBaseTest = new FirefoxDriver();
		} else if (browserList == BrowserList.H_FIREFOX) { // headless firefox --- Auto for UI: ko nên dùng Headless
			// Browser option: 3.xx
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions(); // new lên
			options.addArguments("--headless"); // Add tham số -headless
			options.addArguments("window-size=1920x1080"); // Set size là bao nhiêu
			driverBaseTest = new FirefoxDriver(options);
		} else if (browserList == BrowserList.CHROME) {
			WebDriverManager.chromedriver().setup();
			driverBaseTest = new ChromeDriver();
		} else if (browserList == BrowserList.H_CHROME) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driverBaseTest = new ChromeDriver(options);
		} else if (browserList == BrowserList.EDGE) {
			WebDriverManager.edgedriver().setup();
			driverBaseTest = new EdgeDriver();
		} else if (browserList == BrowserList.IE) {
			WebDriverManager.iedriver().arch32().setup();
			driverBaseTest = new InternetExplorerDriver();
		}

		else if (browserList == BrowserList.OPERA) {
			WebDriverManager.operadriver().setup();
			driverBaseTest = new OperaDriver();
		} else if (browserList == BrowserList.COCOC) {
			// Cốc cốc browser trừ đi 5-6 version ra chromedriver
			WebDriverManager.chromedriver().driverVersion("93.0.4577.63").setup();
			ChromeOptions options = new ChromeOptions();

			if (GlobalConstant.OS_NAME.startsWith("Windows")) {
				options.setBinary("C:\\Program Files (x86)\\CocCoc\\Browser\\Application\\browser.exe");
			} else {
				options.setBinary("...");
			}
			driverBaseTest = new ChromeDriver(options);
		} else if (browserList == BrowserList.BRAVE) {
			// Brave browser version nào dùng chromedriver version đó
			WebDriverManager.chromedriver().driverVersion("95.0.4638.17").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
			driverBaseTest = new ChromeDriver(options);
		} else {
			throw new RuntimeException("Browser name invalid");
		}

		driverBaseTest.manage().timeouts().implicitlyWait(GlobalConstant.LONG_TIMEOUT, TimeUnit.SECONDS); // Setting timeout
		driverBaseTest.get(GlobalConstant.PORTAL_PAGE_URL);

		return driverBaseTest;

	}

	protected WebDriver getBrowserDriver(String browserName, String urlApp) {

		if (browserName.equals("firefox")) {

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

		driverBaseTest.manage().timeouts().implicitlyWait(GlobalConstant.LONG_TIMEOUT, TimeUnit.SECONDS); // Setting timeout
		driverBaseTest.get(urlApp);

		return driverBaseTest;

	}

	protected String getEnviromentUrl(String serverName) {
		String envUrl = null;
		EnviromentList enviromentList = EnviromentList.valueOf(serverName.toUpperCase());
		if (enviromentList == EnviromentList.DEV) {
			envUrl = "https://demo.nopcommerce.com/";
		} else if (enviromentList == EnviromentList.TESTING) {
			envUrl = "https://admin-demo.nopcommerce.com";
		} else if (enviromentList == EnviromentList.STAGING) {
			envUrl = "";
		} else if (enviromentList == EnviromentList.PRODUCTION) {
			envUrl = "";
		}
		return envUrl;

	}

	protected int generateFakeEmail() {
		Random random = new Random();
		return random.nextInt(9999);
	}
}
