package commons;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driverBaseTest;
	protected final Log log; // biến log set final là ko dc phép gán lại

	protected BaseTest() {
		log = LogFactory.getLog(getClass()); // getClass là truyền chính class BaseTest vào
	}

	protected WebDriver getBrowserDriver(String browserName) {
		// browserList = Lấy ra giá trị của browserName rồi Uppercase lên convert qua BrowserList để compare - thì browserList lúc mang giá trị là String
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		if (browserList == BrowserList.FIREFOX) { // Firefox browser mới nhất thì cứ chọn FirefoxDriver(geckodriver) mới nhất -- tương tự cho Opera browser
			// WebDriverManager - chọn hết all trong file libWebDriverManager sau đó phải Add Build Path thì mới chạy được
			WebDriverManager.firefoxdriver().setup(); // tự tại driver tương ứng về
			driverBaseTest = new FirefoxDriver();
		} else if (browserList == BrowserList.SAFARI) {
			// WebDriverManager.safaridriver().setup(); // vì SafariDriver tích hợp sẵn vào OS rồi nên trong code ko cần setting nữa
			driverBaseTest = new SafariDriver();
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

			if (GlobalConstants.OS_NAME.startsWith("Windows")) {
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

		driverBaseTest.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS); // Setting timeout
		driverBaseTest.get(GlobalConstants.PORTAL_PAGE_URL);

		return driverBaseTest;

	}

	protected WebDriver getBrowserDriver(String browserName, String appUrl) {

		if (browserName.equals("firefox")) {

			WebDriverManager.firefoxdriver().setup(); // tự tại driver tương ứng về
			FirefoxOptions options = new FirefoxOptions();
			options.setAcceptInsecureCerts(false);
			// options.addArguments("--disable-geolocation");
			options.addPreference("dom.webnotifications.enabled", false);
			options.addPreference("geo.enabled", false);
			options.addPreference("geo.provider.use_corelocation", false);
			options.addPreference("geo.prompt.testing", false);
			options.addPreference("geo.prompt.testing.allow", false);
			driverBaseTest = new FirefoxDriver(options);
		} else if (browserName.equals("h_firefox")) { // headless firefox --- Auto for UI: ko nên dùng Headless
			// Browser option: 3.xx
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions(); // new lên
			options.addArguments("--headless"); // Add tham số -headless
			options.addArguments("window-size=1920x1080"); // Set size là bao nhiêu
			driverBaseTest = new FirefoxDriver(options);
		} else if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.setAcceptInsecureCerts(true);
			options.addArguments("--disable-geolocation");
			options.setExperimentalOption("useAutomationExtension", false);
			options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			options.setExperimentalOption("prefs", prefs);
			driverBaseTest = new ChromeDriver(options);
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

		driverBaseTest.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS); // Setting timeout
		driverBaseTest.manage().window().maximize();
		driverBaseTest.get(appUrl);

		return driverBaseTest;

	}

	protected String getEnviromentUrl(String enviromentName) {
		String envUrl = null;
		// Lấy value của environmentName rồi UpperCase lên convert qua EnvironmentList - sau đó get Value của nó ra rồi so sánh dùng if else hoặc switch-case
		// mục đích của dùng switch-case là ko bị trùng còn dùng if else thì có thể bị trùng (viết lại nó vẫn bị trùng vì nó ko check dc)
		EnviromentList enviromentList = EnviromentList.valueOf(enviromentName.toUpperCase());
		switch (enviromentList) {
		case DEV:
			envUrl = "https://demo.nopcommerce.com/";
			break;
		case STAGING:
			envUrl = "https://staging.nopcommerce.com/";
			break;
		case TESTING:
			envUrl = "https://test.nopcommerce.com/";
			break;
		case PRE_PROD:
			envUrl = "https://pre_prod.nopcommerce.com/";
			break;
		case PRODUCTION:
			envUrl = "https://prod.nopcommerce.com/";
			break;

		default:
			envUrl = "";
			break;
		}

		return envUrl;
	}

	protected int generateFakeNumber() {
		Random random = new Random();
		return random.nextInt(9999);
	}

	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try { // nếu dk đúng thì nhảy vào try
			Assert.assertTrue(condition);
			log.info("-------------------------PASSED--------------------------"); // cái log.info này là của Log4J

			// neu dk sai thi catch se bat lai
		} catch (Throwable e) {
			log.info("-------------------------FAILED--------------------------");
			pass = false;

			// Add loi vao reportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertFalse(condition);
			log.info("-------------------------PASSED--------------------------");

		} catch (Throwable e) {

			log.info("-------------------------FAILED--------------------------");
			pass = false;

			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e); // add ket qua
			Reporter.getCurrentTestResult().setThrowable(e); // add thong bao loi vao reportNG
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info("-------------------------PASSED--------------------------");

		} catch (Throwable e) {
			log.info("-------------------------FAILED--------------------------");
			pass = false;

			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	public WebDriver getDriverInstance() {

		return this.driverBaseTest;
	}

	protected void closeBrowserAndDriver() {
		String cmd = "";
		try {
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);

			String driverInstanceName = driverBaseTest.toString().toLowerCase();
			log.info("Driver instance name = " + driverInstanceName);

			if (driverInstanceName.contains("chrome")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
				} else {
					cmd = "pkill chromedriver";
				}
			} else if (driverInstanceName.contains("internetexplorer")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
				}
			} else if (driverInstanceName.contains("firefox")) {
				if (osName.contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
				} else {
					cmd = "pkill geckodriver";
				}
			} else if (driverInstanceName.contains("edge")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq msedgedriver*\"";
				} else {
					cmd = "pkill msedgedriver";
				}
			} else if (driverInstanceName.contains("opera")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq operadriver*\"";
				} else {
					cmd = "pkill operadriver";
				}
			} else if (driverInstanceName.contains("safari")) {
				if (osName.contains("mac")) {
					cmd = "pkill safaridriver";
				}
			}

			if (driverBaseTest != null) {
				// IE: Lưu lại các phiên đăng nhập trước đó (Khác Thread)
				driverBaseTest.manage().deleteAllCookies();
				driverBaseTest.quit();
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		} finally {
			try {
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	protected String getCurrentDay() {
		DateTime nowUTC = new DateTime(DateTimeZone.UTC);
		int day = nowUTC.getDayOfMonth();
		if (day < 10) {
			String dayValue = "0" + day;
			return dayValue;
		}
		return day + "";
	}

	protected String getCurrentMonth() {
		DateTime now = new DateTime(DateTimeZone.UTC);
		int month = now.getMonthOfYear();
		if (month < 10) {
			String monthValue = "0" + month;
			return monthValue;
		}
		return month + "";
	}

	protected String getCurrentYear() {
		DateTime now = new DateTime(DateTimeZone.UTC);
		return now.getYear() + "";
	}

	protected String getCurrentDate() {
		return getCurrentMonth() + "/" + getCurrentDay() + "/" + getCurrentYear();
	}

}
