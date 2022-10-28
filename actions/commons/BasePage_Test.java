package commons;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;
import pageObjects.wordpress.PageGenerator;
import pageObjects.wordpress.UserHomePO;
import pageUIs.jQuery.uploadFile.BasePageJQueryUI;
import pageUIs.nopCommerce.user.BasePageUI;

/**
 * @author Lenovo
 *
 */
public class BasePage_Test {
	private WebDriver driver;

	// Static method: áp dụng nguyên tắc đóng gói (Encapsulation) che dấu sự khởi tạo của đối tượng/ Class
	// public static BasePage_Test getBasePage_TestObject() {
	// return new BasePage_Test();
	// }

	// BÊN CÁC CLASS PAGE OBJECT THÌ DÙNG TỪ KHÓA SUPER ĐỂ GỌI RA CONSTRUCTOR CỦA LỚP CHA
	public BasePage_Test(WebDriver driver) {
		this.driver = driver;
	}

	public void openPageUrl(String url) {
		driver.get(url);
	}

	// tham số bắt buộc là WebDriver vì truyển vào thì mới gọi biến driver ra dc, nếu ko truyền vào thì gọi driver ko ra
	public String getPageTitle() {
		return driver.getTitle();

	}

	public String getPageUrl() {
		return driver.getCurrentUrl();
	}

	public String getPageSourceCode() {
		return driver.getPageSource();
	}

	public void backToPage() {
		driver.navigate().back();
	}

	public void forwardToPage() {
		driver.navigate().forward();
	}

	public void refreshCurrentoPage() {
		driver.navigate().refresh();
	}

	public Set<Cookie> getAllCookies() {
		return driver.manage().getCookies();
	}

	public void setCookie(Set<Cookie> cookies) {
		for (Cookie cookie : cookies) {
			driver.manage().addCookie(cookie);
		}
		sleepInSecond(2);
	}

	public Alert waitForAlertPresence() {
		WebDriverWait explicit = new WebDriverWait(driver, longTimeout);
		return explicit.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert() {
		waitForAlertPresence().accept();

	}

	public void cancelAlert() {
		waitForAlertPresence().dismiss();
	}

	public String getAlertText() {
		return waitForAlertPresence().getText();
	}

	public void senKeyToAlert(String textValue) {
		waitForAlertPresence().sendKeys(textValue);
	}

	public void switchToWindowById(String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String id : allWindows) {
			if (!id.equals(parentID)) {
				driver.switchTo().window(id);

			}
		}
	}

	public void switchToWindowByTitle(String expectTitle) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String id : allWindows) {
			driver.switchTo().window(id);
			String title = driver.getTitle();
			if (title.equals(expectTitle)) {
				break;
			}
		}
	}

	public void closeAllTabWindowWithoutParent(String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String id : allWindows) {
			if (!id.equals(parentID)) {
				driver.switchTo().window(id);
				driver.close();
			}

		}
		driver.switchTo().window(parentID);
	}

	// locatorType: id= /css=/ xpath=/ name=/ class=
	// locatorType: ID= /CSS=/ XPATH=/ NAME=/ CLASS=
	// locatorType: Id= /Css=/ Xpath=/ Name=/ Class=
	private By getByLocator(String locatorType) {
		By by = null;
		// System.out.println("Locator Type = " + locatorType);
		if (locatorType.startsWith("id=") || locatorType.startsWith("ID=") || locatorType.startsWith("Id=")) {
			by = By.id(locatorType.substring(3));
		} else if (locatorType.startsWith("css=") || locatorType.startsWith("CSS=") || locatorType.startsWith("Css=")) {
			by = By.cssSelector(locatorType.substring(4));
		} else if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=") || locatorType.startsWith("XPath=")) {
			by = By.xpath(locatorType.substring(6)); // substring(6): lấy ra 6 ký tự đầu tiên xóa đi
		} else if (locatorType.startsWith("name=") || locatorType.startsWith("NAME=") || locatorType.startsWith("Name=")) {
			by = By.name(locatorType.substring(5));
		} else if (locatorType.startsWith("class=") || locatorType.startsWith("CLASS=") || locatorType.startsWith("Class=")) {
			by = By.className(locatorType.substring(6));
		} else if (locatorType.startsWith("tagName")) {
			by = By.tagName(locatorType.substring(7));
		} else {
			throw new RuntimeException("Locator Type is not support");
		}

		return by;
	}

	private String getDynamicXpath(String locatorType, String... dynamicValues) {
		if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=") || locatorType.startsWith("XPath=")) {
			locatorType = String.format(locatorType, (Object[]) dynamicValues);
		}
		return locatorType;
	}

	public WebElement getWebElement(String locatorType) {
		return driver.findElement(getByLocator(locatorType));
	}

	public List<WebElement> getListWebElement(String locatorType) {
		return driver.findElements(getByLocator(locatorType));
	}

	public void clickToElement(String locatorType) {
		getWebElement(locatorType).click();
	}

	public void clickToElement(String locatorType, String... dynamicValues) {
		locatorType = getDynamicXpath(locatorType, dynamicValues);
		getWebElement(locatorType).click();
	}

	public void clearValueInElementByDeleteKey(String locatorType) {
		WebElement element = getWebElement(locatorType);
		element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
	}

	public void sendkeyToElement(String locatorType, String textValue) {
		// hàm dùng từ 2 lần trở lên thì nên define thành biến
		WebElement element = getWebElement(locatorType);
		element.clear();
		element.sendKeys(textValue);
	}

	public void sendkeyToElement(String locatorType, String textValue, String... dynamicValues) {
		locatorType = getDynamicXpath(locatorType, dynamicValues);
		WebElement element = getWebElement(locatorType);
		element.clear();
		element.sendKeys(textValue);
	}

	public void selectItemInDefaultDropdown(String locatorType, String textItem) {
		Select select = new Select(getWebElement(locatorType));
		select.selectByVisibleText(textItem);

	}

	public void selectItemInDefaultDropdown(String locatorType, String textItem, String... dynamicValues) {
		locatorType = getDynamicXpath(locatorType, dynamicValues);
		Select select = new Select(getWebElement(locatorType));
		select.selectByVisibleText(textItem);

	}

	public String getSelectItemDefaultDropdown(String locatorType) {
		Select select = new Select(getWebElement(locatorType));
		return select.getFirstSelectedOption().getText();
	}

	public String getSelectItemDefaultDropdown(String locatorType, String... dynamicValues) {
		locatorType = getDynamicXpath(locatorType, dynamicValues);
		Select select = new Select(getWebElement(locatorType));
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropdownMultiple(String locatorType) {
		Select select = new Select(getWebElement(locatorType));
		return select.isMultiple();

	}

	public void selectItemInCustomDropdown(String parentXpath, String childXpath, String expectTextItem) {
		getWebElement(parentXpath).click();
		sleepInSecond(1);
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((getByLocator(childXpath))));
		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectTextItem)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true)", item);
				sleepInSecond(1);
				item.click();
				break;
			}
		}
	}

	public void selectItemInCustomDropdown(String parentXpath, String childXpath, String expectTextItem, String... dynamicValues) {
		parentXpath = getDynamicXpath(parentXpath, dynamicValues);
		getWebElement(parentXpath).click();
		sleepInSecond(1);
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((getByLocator(childXpath))));
		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectTextItem)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true)", item);
				sleepInSecond(1);
				item.click();
				break;
			}
		}
	}

	public void inputSelectItemInCustomDropdown(String parentXpath, String childXpath, String textValue, String expectTextItem) {
		sendkeyToElement(parentXpath, textValue);
		sleepInSecond(1);
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((getByLocator(childXpath))));
		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectTextItem)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true)", item);
				sleepInSecond(1);
				item.click();
				break;
			}
		}
	}

	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getElementAttribute(String locatorType, String attributeName) {
		return getWebElement(locatorType).getAttribute(attributeName);
	}

	public String getElementAttribute(String locatorType, String attributeName, String... dynamicValues) {
		locatorType = getDynamicXpath(locatorType, dynamicValues);
		return getWebElement(locatorType).getAttribute(attributeName);
	}

	public String getElementText(String locatorType) {
		return getWebElement(locatorType).getText();
	}

	public String getElementText(String locatorType, String... dynamicValues) {
		locatorType = getDynamicXpath(locatorType, dynamicValues);
		return getWebElement(locatorType).getText();
	}

	public String getElementCssValue(String locatorType, String propertyName) {
		return getWebElement(locatorType).getCssValue(propertyName);
	}

	public String getHexaColorFromRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}

	public int getElementSize(String locatorType) {
		return getListWebElement(locatorType).size();
	}

	public int getElementSize(String locatorType, String... dynamicValues) {
		locatorType = getDynamicXpath(locatorType, dynamicValues);
		return getListWebElement(locatorType).size();
	}

	public void checkToDefaultCheckboxOrRadio(String locatorType) {
		WebElement element = getWebElement(locatorType);
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void checkToDefaultCheckboxOrRadio(String locatorType, String... dynamicValues) {
		locatorType = getDynamicXpath(locatorType, dynamicValues);
		WebElement element = getWebElement(locatorType);
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void uncheckToDefaultCheckbox(String locatorType) {
		WebElement element = getWebElement(locatorType);
		if (element.isSelected()) {
			element.click();
		}
	}

	public void uncheckToDefaultCheckbox(String locatorType, String... dynamicValues) {
		locatorType = getDynamicXpath(locatorType, dynamicValues);
		WebElement element = getWebElement(locatorType);
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementDisplayed(String locatorType) {
		return getWebElement(locatorType).isDisplayed();
	}

	public boolean isElementDisplayed(String locatorType, String... dynamicValues) {
		locatorType = getDynamicXpath(locatorType, dynamicValues);
		return getWebElement(locatorType).isDisplayed();
	}

	public boolean isElementUndisplayed(String locatorType) {
		// set timeout implicitWait = 5 giây vì nếu set 30 giây khi gặp 1 issue là nó quá mất time để verify 1 element ko hiển thị (ko có trong DOM)
		overrideImplicitWaitTimeout(shortTimeout);
		List<WebElement> elements = getListWebElement(locatorType);
		// phải set lại timeout implicitWait = 30 giây vì nếu để 5 giây có những page mới hiện icon loading chưa load xong nó sẽ ko đủ time find element
		// nếu như gán timeout implicitWait = 5 nó sẽ apply cho all các step về sau đó: findElement/ findElements

		overrideImplicitWaitTimeout(longTimeout);
		if (elements.size() == 0) { // element KO có trong DOM
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) { // element có trong DOM nhưng KO displayed
			return true;
		} else { // tức là element Displayed
			return false;
		}

	}

	public boolean isElementUndisplayed(String locatorType, String... dynamicValues) {
		// set timeout implicitWait = 5 giây vì nếu set 30 giây khi gặp 1 issue là nó quá mất time để verify 1 element ko hiển thị (ko có trong DOM)
		overrideImplicitWaitTimeout(shortTimeout);
		locatorType = getDynamicXpath(locatorType, dynamicValues);
		List<WebElement> elements = getListWebElement(locatorType);
		// phải set lại timeout implicitWait = 30 giây vì nếu để 5 giây có những page mới hiện icon loading chưa load xong nó sẽ ko đủ time find element
		// nếu như gán timeout implicitWait = 5 nó sẽ apply cho all các step về sau đó: findElement/ findElements

		overrideImplicitWaitTimeout(longTimeout);
		if (elements.size() == 0) { // element KO có trong DOM
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) { // element có trong DOM nhưng KO displayed
			return true;
		} else { // tức là element Displayed
			return false;
		}

	}

	public void overrideImplicitWaitTimeout(long timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	public boolean isElementEnable(String locatorType) {
		return getWebElement(locatorType).isEnabled();
	}

	public boolean isElementSelected(String locatorType) {
		return getWebElement(locatorType).isSelected();
	}

	public void switchToFrameIframe(String locatorType) {
		driver.switchTo().frame(getWebElement(locatorType));
	}

	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void hoverMouseToElement(String locatorType) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(locatorType)).perform();
	}

	public void pressKeyToElement(String locatorType, Keys key) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(locatorType), key).perform();
	}

	public void pressKeyToElement(String locatorType, Keys key, String... dynamicValues) {
		Actions action = new Actions(driver);
		locatorType = getDynamicXpath(locatorType, dynamicValues);
		action.sendKeys(getWebElement(locatorType), key).perform();
	}

	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void hightlightElement(String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(locatorType);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);

		// Highlight xong phải trả lại style element cũ
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}

	public void clickToElementByJS(String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(locatorType));
	}

	public String getElementValueByJSXpath(String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		xpathLocator = xpathLocator.replace("xpath=", ""); // loại bỏ đuôi xpath=
		return (String) jsExecutor.executeScript("return $(document.evaluate(\"" + xpathLocator + "\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue).val()");
	}

	public String getElementValueByJSXpath(String xpathLocator, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		xpathLocator = getDynamicXpath(xpathLocator, dynamicValues);
		xpathLocator = xpathLocator.replace("xpath=", ""); // loại bỏ đuôi xpath=
		return (String) jsExecutor.executeScript("return $(document.evaluate(\"" + xpathLocator + "\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue).val()");
	}

	public void scrollToElement(String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(locatorType));
	}

	// Get element ValidationMessage phải dùng Javascript Executor chứ ko dùng getText() trong Selenium được
	public String getElementValidationMessage(String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(locatorType));
	}

	public void removeAttributeInDOM(String locatorType, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(locatorType));
	}

	public boolean isImageLoaded(String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getWebElement(locatorType));
		if (status) {
			return true;
		}
		return false;
	}

	public boolean isImageLoaded(String locatorType, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		locatorType = getDynamicXpath(locatorType, dynamicValues);
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getWebElement(locatorType));

		return status;
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active")) == 0;
				} catch (Exception e) {
					return true;
				}

			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};
		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public void waitForElementVisible(String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
	}

	public void waitForElementVisible(String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		locatorType = getDynamicXpath(locatorType, dynamicValues);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
	}

	public void waitForAllElementVisible(String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locatorType)));
	}

	public void waitForAllElementVisible(String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		locatorType = getDynamicXpath(locatorType, dynamicValues);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locatorType)));
	}

	public void waitForElementInvisible(String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
	}

	public void waitForElementInvisible(String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		locatorType = getDynamicXpath(locatorType, dynamicValues);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
	}

	/**
	 * Wait for element undisplayed in DOM or not IN DOM and override implicit timeout
	 */
	public void waitForElementUndisplayed(String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, shortTimeout);
		overrideImplicitWaitTimeout(shortTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
		overrideImplicitWaitTimeout(longTimeout);
	}

	// Tại sao: Wait lại nên truyền tham số là By - ko nên truyển tham số là WebElement
	// Vì: trộn lẫn giữa 2 loại Wait thời gian chờ sẽ lâu hơn
	// nó phải find element trước rồi nó mới apply lại cho hàm Wait
	// ví dụ hàm này visibilityOfAllElementsLocatedBy(getByLocator(locatorType)) nó sẽ tìm Xpath vì xpath ko có find element nên hàm này chạy rất nhanh

	// ví dụ hàm này invisibilityOfAllElements(getListWebElement(driver, locatorType))
	// -- truyền vào cái List nếu như mà nó ko tìm thấy vì ko có element
	// nó phải chờ hàm này findElements(getByLocator(locatorType)) apply con số timout của implicit
	// -- thì phải hết timeout của implicit nó mới trả về List rỗng rồi lại apply ngược lại cho hàm invisibilityOfAllElements
	// Tại sao dùng List<WebElement> vì hàm này invisibilityOfAllElements chỉ có duy nhất tham số là List<WebElement> thôi ko có tham số cho By
	// Còn hàm visibilityOfAllElementsLocatedBy(getByLocator(locatorType)) có tham số By nêm mình dùng cái By

	public void waitForAllElementInvisible(String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(locatorType)));
	}

	public void waitForAllElementInvisible(String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		locatorType = getDynamicXpath(locatorType, dynamicValues);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(locatorType)));
	}

	public void waitForElementClickable(String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
	}

	public void waitForElementClickable(String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		locatorType = getDynamicXpath(locatorType, dynamicValues);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
	}

	public void uploadMultipleFiles(String... fileNames) {
		// Đường dẫn của thư mục uploadFiles: Window/ Mac/ Linux
		String filePath = GlobalConstants.UPLOAD_FILE;

		// Đường dẫn của all các file
		// 1 file: Java.png
		String fullFileName = "";
		for (String file : fileNames) {
			// filePath + Java.png + "\n"
			fullFileName = fullFileName + filePath + file + "\n";
		}
		fullFileName = fullFileName.trim();
		getWebElement(BasePageJQueryUI.UPLOAD_FILE).sendKeys(fullFileName);
		// CÁCH CHẠY
		// Khi gọi hàm getWebElement này locatorType xpath= gì đó thì sẽ vào getByLocator này trước vào đúng xpath truyền vào By.xpath xóa 6 ký tự đầu đi
		// lấy cái đuôi trả về đúng cái by thì thằng findElement nhận vào cái By - thì nó sẽ lấy dc cái element ra trả về 1 cái WebElement thì nó gọi
		// thằng sendKeys ra truyền đường dẫn của file vào là nó upload file lên dc
	}

	// ----------------------------------------------------------------------------------------
	// Tối ưu ở bài học Level_07_Switch_Page
	public UserMyProductReviewPageObject openMyProductReviewPage() {
		waitForElementVisible(BasePageUI.MY_PRODUCT_REVIEW_LINK);
		clickToElement(BasePageUI.MY_PRODUCT_REVIEW_LINK);
		return PageGeneratorManager.getMyProductReviewPage(driver);
	}

	public UserRewardPointPageObject openRewardPointPage() {
		waitForElementVisible(BasePageUI.REWARD_POINT_LINK);
		clickToElement(BasePageUI.REWARD_POINT_LINK);
		return PageGeneratorManager.getRewardPointPage(driver);
	}

	public UserAddressPageObject openAddressPage() {
		waitForElementVisible(BasePageUI.ADDRESS_LINK);
		clickToElement(BasePageUI.ADDRESS_LINK);
		return PageGeneratorManager.getAddressPage(driver);
	}

	public UserCustomerInforPageObject openCustomerInforPage() {
		waitForElementVisible(BasePageUI.CUSTOMER_INFOR_LINK);
		clickToElement(BasePageUI.CUSTOMER_INFOR_LINK);
		return PageGeneratorManager.getCustomerInforPage(driver);
	}

	// Tối ưu ở bài học Level_09_Dynamic_Locator
	// public BasePage_Test openPagesAtMyAccountByName(String pageName) {
	// waitForElementClickable(driver, BasePageUI.DYNAMIC_PAGES_NAME_AT_MY_ACCOUNT_AREA, pageName);
	// clickToElement(driver, BasePageUI.DYNAMIC_PAGES_NAME_AT_MY_ACCOUNT_AREA, pageName);
	// // click xong kiểm tra pageName để khởi tạo - nếu pageName = Addresses thì gọi qua PageGeneratorManager gọi qua getAddressPage khởi tạo ra
	// // khởi tạo thì new UserAddressPageObject lên - new thì gọi qua constructor map driver
	// // - khi khởi tạo xong nó sẽ trả về 1 object của class UserAddressPageObject
	// switch (pageName) {
	// case "Addresses":
	// return PageGeneratorManager.getAddressPage(driver);
	// case "My product reviews":
	// return PageGeneratorManager.getMyProductReviewPage(driver);
	// case "Reward points":
	// return PageGeneratorManager.getRewardPointPage(driver);
	// case "Customer info":
	// return PageGeneratorManager.getCustomerInforPage(driver);
	// default:
	// throw new RuntimeException("Invalid page name at My account area.");
	//
	// }
	// }

	// ----------
	// Pattern Object
	public void openPagesAtMyAccountByPageName(String pageName) {
		waitForElementClickable(BasePageUI.DYNAMIC_PAGES_NAME_AT_MY_ACCOUNT_AREA, pageName);
		clickToElement(BasePageUI.DYNAMIC_PAGES_NAME_AT_MY_ACCOUNT_AREA, pageName);
	}

	/**
	 * Enter to dynamic Textbox by Id
	 * 
	 * @param driver
	 * @param textboxId
	 * @param value
	 */
	public void inputToTextboxById(String textboxId, String value) {
		waitForElementVisible(BasePageUI.DYNAMIC_TEXTBOX_BY_ID, textboxId);
		sendkeyToElement(BasePageUI.DYNAMIC_TEXTBOX_BY_ID, value, textboxId);
	}

	/**
	 * Click to dynamic Button by Text
	 * 
	 * @param driver
	 * @param buttonText
	 */
	public void clickToButtonByText(String buttonText) {
		waitForElementClickable(BasePageUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);
		clickToElement(BasePageUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);
	}

	/**
	 * Select to dynamic Dropdown by Attribute Name
	 * 
	 * @param driver
	 * @param attributeName
	 * @param selectItem
	 */
	public void selectToDropdownByName(String attributeName, String selectItem) {
		waitForElementClickable(BasePageUI.DYNAMIC_DROPDOWN_BY_NAME, attributeName);
		selectItemInDefaultDropdown(BasePageUI.DYNAMIC_DROPDOWN_BY_NAME, selectItem, attributeName);
	}

	/**
	 * Click to dynamic Radio by Text
	 * 
	 * @param driver
	 * @param textLabel
	 */
	public void clickToRadioByText(String textLabel) {
		waitForElementClickable(BasePageUI.DYNAMIC_RADIO_BY_TEXT, textLabel);
		checkToDefaultCheckboxOrRadio(BasePageUI.DYNAMIC_RADIO_BY_TEXT, textLabel);
	}

	/**
	 * Click to dynamic Checkbox by Text
	 * 
	 * @param driver
	 * @param textLabel
	 */
	public void clickToCheckboxByText(String textLabel) {
		waitForElementClickable(BasePageUI.DYNAMIC_CHECKBOX_BY_TEXT, textLabel);
		checkToDefaultCheckboxOrRadio(BasePageUI.DYNAMIC_CHECKBOX_BY_TEXT, textLabel);
	}

	/**
	 * Get value in textbox by textboxID
	 * 
	 * @param driver
	 * @param attributeName
	 * @param textboxId
	 * @return
	 */
	public String getTextboxValueByID(String textboxId) {
		waitForElementVisible(BasePageUI.DYNAMIC_TEXTBOX_BY_ID, textboxId);
		return getElementAttribute(BasePageUI.DYNAMIC_TEXTBOX_BY_ID, "value", textboxId);
	}

	/**
	 * Get value in dropdown by ID
	 * 
	 * @param driver
	 * @param name
	 * @param textboxOption
	 * @return
	 */
	public String getDropdownValueByID(String name, String textboxOption) {
		waitForElementVisible(BasePageUI.DYNAMIC_DROPDOWN_VALUE, name, textboxOption);
		return getElementText(BasePageUI.DYNAMIC_DROPDOWN_VALUE, name, textboxOption);
		// return getElementAttribute(driver, BasePageUI.DYNAMIC_DROPDOWN_VALUE, "selected", name, textboxOption);
	}

	/**
	 * Verify radio is displayed by Text
	 * 
	 * @param driver
	 * @param textboxLable
	 * @return
	 */
	public boolean isRadioByTextDisplayedByText(String textboxLable) {
		waitForElementVisible(BasePageUI.DYNAMIC_RADIO_VALUE_BY_TEXT, textboxLable);
		return isElementDisplayed(BasePageUI.DYNAMIC_RADIO_VALUE_BY_TEXT, textboxLable);
	}

	/**
	 * Verify checkbox is displayed by Text
	 * 
	 * @param driver
	 * @param textLabel
	 * @return
	 */
	public boolean isCheckboxByTextDisplayedByText(String textLabel) {
		waitForElementVisible(BasePageUI.DYNAMIC_CHECKBOX_BY_TEXT, textLabel);
		return isElementDisplayed(BasePageUI.DYNAMIC_CHECKBOX_BY_TEXT, textLabel);
	}

	// Tối ưu ở bài học Level_08_Switch_Role
	public UserHomePageObject clickToLogoutLinkAtUserPage(WebDriver driver) {
		waitForElementClickable(BasePageUI.LOGOUT_LINK_AT_USER);
		clickToElement(BasePageUI.LOGOUT_LINK_AT_USER);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public AdminLoginPageObject clickToLogoutLinkAtAdminPage(WebDriver driver) {
		waitForElementClickable(BasePageUI.LOGOUT_LINK_AT_ADMIN);
		clickToElement(BasePageUI.LOGOUT_LINK_AT_ADMIN);
		return PageGeneratorManager.getAminLoginPage(driver);
	}

	public UserHomePO openEndUserSite(String urlUserSite) {
		openPageUrl(urlUserSite);
		return PageGenerator.getUserHomePage(driver);
	}

	private long longTimeout = GlobalConstants.LONG_TIMEOUT;
	private long shortTimeout = GlobalConstants.SHORT_TIMEOUT;
}
