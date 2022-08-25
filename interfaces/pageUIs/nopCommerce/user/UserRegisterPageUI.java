package pageUIs.nopCommerce.user;

public class UserRegisterPageUI {
	// dùng final khi muốn biến đó ko bị gán lại (tức là ko bị thay đổi)
	// -- tương tự như hằng số (constant) trong toán học: là giá trị cố định ko bao giờ thay đổi
	// static + final: hằng số
	// Biến static cho phép truy cập trực tiếp từ tên class -- và có thể chia sẻ dữ liệu giữa nhiều luồng (thread) khác nhau --> Parallel Testing
	// static: biến tĩnh - các class khác có thể truy cập vào biến này mà ko cần phải khởi tạo class chứa nó

	// Các Object chỉ dc define và gán dữ liệu duy nhất 1 lần
	public static final String FIRST_NAME_TEXTBOX = "xpath=//input[@id='FirstName']";
	public static final String LAST_NAME_TEXTBOX = "xpath=//input[@id='LastName']";
	public static final String EMAIL_TEXTBOX = "xpath=//input[@id='Email']";
	public static final String PASSWORD_TEXTBOX = "xpath=//input[@id='Password']";
	public static final String CONFIRM_PASSWORD_TEXTBOX = "xpath=//input[@id='ConfirmPassword']";
	public static final String FIRST_NAME_ERROR_MESSAGE = "xpath=//span[@id='FirstName-error']";
	public static final String LAST_NAME_ERROR_MESSAGE = "xpath=//span[@id='LastName-error']";
	public static final String EMAIL_ERROR_MESSAGE = "xpath=//span[@id='Email-error']";
	public static final String PASSWORD_ERROR_MESSAGE = "xpath=//span[@id='Password-error']";
	public static final String CONFIRM_PASSWORD_ERROR_MESSAGE = "xpath=//span[@id='ConfirmPassword-error']";
	public static final String REGISTER_BUTTON = "xpath=//button[@id='register-button']";
	public static final String LOGOUT_LINK = "xpath=//a[@class='ico-logout']";
	public static final String REGISTER_SUCCESS_MESSAGE = "xpath=//div[@class='result']";
	public static final String EXISTING_EMAIL_ERROR_MESSAGE = "xpath=//div[contains(@class,'message-error')]//li";
	public static final String WRONG_EMAIL_ERROR_MESSAGE = "xpath=//div[contains(@class,'message-error')]//li";
}
