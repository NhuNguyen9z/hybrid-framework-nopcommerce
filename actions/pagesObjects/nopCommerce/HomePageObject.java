package pagesObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.HomePageUI;

public class HomePageObject extends BasePage {

	private WebDriver driver; // nguyên tắc: ko phải khai báo driver đều phải khởi tạo
	// 1 class chỉ dc khởi tạo driver duy nhất 1 lần
	// driver đã khởi tạo ở class Level_03_Page_Object rồi thì ở trong class này ko dc khởi tạo nữa mà chỉ dc dùng lại

	// (Constructor) Hàm khởi tạo = cùng tên với class, ko có kiểu trả về
	// Khi khởi tạo 1 đối tượng của class đó thì hàm khởi tạo sẽ dc gọi đầu tiên
	// Nếu ko khai báo hàm khởi tạo thì mặc định sẽ tạo ra hàm khởi tạo ko có tham số như này
	// public HomePageObject(){ }

	// Contructor: hàm khởi tạo/ hàm dựng - luôn chạy đầu tiên khi gọi đến Class đó - cùng tên vs class và ko có kiểu trả về
	// Khi new 1 đối tượng của class thì nó sẽ gọi contructor đầu tiên
	// - tức là khi class dc khởi tạo thì contructor sẽ dc gọi - giống như là 1 điều kiện đầu vào khi 1 class dc init lên
	// - tức là hàm contructor sẽ dc chạy đầu tiên sau đó đến biến global driver rồi đến các hàm bên dưới
	// - vì chạy đầu tiên nên sẽ map driver trước vậy khi chạy đến những hàm bên dưới thì driver đã có dữ liệu rồi
	public HomePageObject(WebDriver driver) {
		// sẽ lấy driver bên class "Level_03_Page_Object_01_Register" gán vào driver global của HomePageObject thì lúc này this.driver có data
		this.driver = driver; // dùng this khi biến Global vào biến Local cùng tên
		// this.driver lấy driver Global ra gán bằng driver Local
	}

	public RegisterPageObject openRegisterPage() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		// new RegisterPageObject(driver) nếu new kiểu này thì hàm sẽ ko trả về gì hết do chỉ new lên thôi chứ ko lấy ra gì hết
		// muốn lấy ra thì bắt buộc phải return
		// đây nó đang new ra 1 class thì mình sẽ cho nó return - thì cái data type của hàm này sẽ là chính cái class này luôn coi nó như 1 kiểu dữ liệu
		return PageGeneratorManager.getRegisterPage(driver);

	}

	public LoginPageObject openLoginPage() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getLoginPage(driver);

	}

	public void clickToLogoutLink() {
		waitForElementClickable(driver, HomePageUI.LOGOUT_LINK);
		clickToElement(driver, HomePageUI.LOGOUT_LINK);

	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplay(driver, HomePageUI.MY_ACCOUNT_LINK);
	}

	public CustomerInforPageObject openCustomerInforPage() {
		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getCustomerInforPage(driver);
	}

}