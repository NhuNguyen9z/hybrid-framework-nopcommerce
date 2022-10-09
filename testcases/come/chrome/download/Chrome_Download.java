package come.chrome.download;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;

public class Chrome_Download extends BaseTest {
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);

	}

	@Test
	public void Download() {

		WebElement shadow_host1 = driver.findElement(By.tagName("downloads-manager"));

		Object shadowRoot1 = ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot", shadow_host1);
		@SuppressWarnings("unchecked")
		String id = (String) ((Map<String, Object>) shadowRoot1).get("shadow-6066-11e4-a52e-4f735466cecf");
		RemoteWebElement shadowRootElement = new RemoteWebElement();
		shadowRootElement.setParent((RemoteWebDriver) driver);
		shadowRootElement.setId(id);

		WebElement shadow_host2 = shadowRootElement.findElement(By.cssSelector("downloads-toolbar"));

		Object shadowRoot2 = ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot", shadow_host2);
		@SuppressWarnings("unchecked")
		String id2 = (String) ((Map<String, Object>) shadowRoot2).get("shadow-6066-11e4-a52e-4f735466cecf");
		RemoteWebElement shadowRootElement2 = new RemoteWebElement();
		shadowRootElement2.setParent((RemoteWebDriver) driver);
		shadowRootElement2.setId(id2);

		WebElement shadow_host3 = shadowRootElement2.findElement(By.cssSelector("cr-toolbar"));

		Object shadowRoot3 = ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot", shadow_host3);
		@SuppressWarnings("unchecked")
		String id3 = (String) ((Map<String, Object>) shadowRoot3).get("shadow-6066-11e4-a52e-4f735466cecf");
		RemoteWebElement shadowRootElement3 = new RemoteWebElement();
		shadowRootElement3.setParent((RemoteWebDriver) driver);
		shadowRootElement3.setId(id3);

		String actualHeading = shadowRootElement3.findElement(By.cssSelector("div[id=leftContent] h1")).getText();
		Assert.assertEquals("Downloads", actualHeading);

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();

	}

	private WebDriver driver;
}
