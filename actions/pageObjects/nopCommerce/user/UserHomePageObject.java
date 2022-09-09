package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.UserHomePageUI;

public class UserHomePageObject extends BasePage {

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
	public UserHomePageObject(WebDriver driver) {
		// sẽ lấy driver bên class "Level_03_Page_Object_01_Register" gán vào driver global của HomePageObject thì lúc này this.driver có data
		this.driver = driver; // dùng this khi biến Global vào biến Local cùng tên
		// this.driver lấy driver Global ra gán bằng driver Local
	}

	public UserRegisterPageObject openRegisterPage() {
		waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
		clickToElement(driver, UserHomePageUI.REGISTER_LINK);
		// new RegisterPageObject(driver) nếu new kiểu này thì hàm sẽ ko trả về gì hết do chỉ new lên thôi chứ ko lấy ra gì hết
		// muốn lấy ra thì bắt buộc phải return
		// đây nó đang new ra 1 class thì mình sẽ cho nó return - thì cái data type của hàm này sẽ là chính cái class này luôn coi nó như 1 kiểu dữ liệu
		return PageGeneratorManager.getUserRegisterPage(driver);

	}

	public UserLoginPageObject openLoginPage() {
		waitForElementClickable(driver, UserHomePageUI.LOGIN_LINK);
		clickToElement(driver, UserHomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);

	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, UserHomePageUI.MY_ACCOUNT_LINK);
	}

	public UserCustomerInforPageObject openCustomerInforPage() {
		waitForElementClickable(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getCustomerInforPage(driver);
	}

}
