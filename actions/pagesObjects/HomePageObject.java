package pagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import commons.BasePage;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {

	private WebDriver driver; // nguyên tắc ko phải khai báo driver đều phải khởi tạo
	// 1 class chỉ dc khởi tạo driver duy nhất 1 lần
	// driver đã khởi tạo ở class Level_03_Page_Object rồi thì ở trong class này ko dc khởi tạo nữa mà chỉ dc dùng lại

	// (Constructor) Hàm khởi tạo = cùng tên với class, ko có kiểu trả về
	// Khi khởi tạo 1 đối tượng của class đó thì hàm khởi tạo sẽ dc gọi đầu tiên
	// Nếu ko khai báo hàm khởi tạo thì mặc định sẽ tạo ra hàm khởi tạo ko có tham số như này
	// public HomePageObject(){
	// }

	// Hàm khởi tạo (Constructor)
	public HomePageObject(WebDriver driver) {
		// sẽ lấy driver bên class Level_03_Page_Object gán vào driver của HomePageObject thì lúc này this.driver có data
		this.driver = driver; // dùng this khi biến Global vào biến Local cùng tên
		// this.driver lấy driver Global ra gán bằng driver Local
	}

	public void clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);

	}

}
