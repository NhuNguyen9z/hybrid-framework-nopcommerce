package pagesFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class HomePageObject extends BasePageFactory {

	private WebDriver driver;

	// Nhược điểm của Page Factory: gộp chung element vs action trong 1 class nếu class cỡ 1000 dòng code thì nó khó maintenance
	// chỉ phù hợp vs những dự án ít testcase và element
	public HomePageObject(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this); // this đại diện cho Page này
	}
	// Cách chạy
	// Khi khởi tạo 1 cái page nó sẽ nhảy vào constructor đầu tiên - gán driver và init các element tạo kết nối giữa element vs locator(FindBy)
	// Khi gọi hàm clickToRegisterLink thì nó gọi tới hàm waitForElementClickable nó sẽ tìm element registerLink
	// thì lúc này mới tìm element trong
	// @FindBy(how = How.XPATH, using = "//a[@class='ico-register']")
	// private WebElement registerLink;
	// Chứ ko phải khi khởi tạo page là đi tìm element - mặc dù đó là những biến global trong class này

	// // Khi khởi tạo 1 cái page nó sẽ nhảy vào constructor đầu tiên - gán driver và init các element
	// Tạo ra 1 kết nối giữa element vs FindBy ví dụ: element loginLink vs xpath = "//a[@class='ico-login']"
	// Dùng 1 hàm trong PageObject đó -> gọi nó ra -> gọi tới các hàm bên trong -> hàm bên trong truyền tham số element
	// -> lúc này element mới dc find --> chứ ko phải innit là đi tìm element luôn

	// Page UI - Ko cho phép define ở 1 class khác vì khi khởi tạo ở 1 page lên
	// thì bắt buộc phải init các element lên luôn để có 1 sự kết nối giữa các element - nếu đưa qua class khác thì bị fail
	@FindBy(how = How.XPATH, using = "//a[@class='ico-register']") // locator
	private WebElement registerLink; // registerLink: chỉ khai báo thôi lúc nào dùng thì nó sẽ tự đi tìm

	@FindBy(xpath = "//a[@class='ico-login']")
	private WebElement loginLink;

	@FindBy(xpath = "//a[@class='ico-logout']")
	private WebElement logoutLink;

	@FindBy(css = "a.ico-account")
	private WebElement myAccount;

	// Page Object/ Action - phải dùng tham số là WebElement
	public void clickToRegisterLink() {
		waitForElementClickable(driver, registerLink); // Khi nào dc gọi thì bắt đầu đi tìm element đã dc khai báo ở trên
		clickToElement(driver, registerLink);

	}

	public void clickToLoginLink() {
		waitForElementClickable(driver, loginLink);
		clickToElement(driver, loginLink);

	}

	public void clickToLogoutLink() {
		waitForElementClickable(driver, logoutLink);
		clickToElement(driver, logoutLink);

	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, myAccount);
		return isElementDisplay(driver, myAccount);
	}

}
