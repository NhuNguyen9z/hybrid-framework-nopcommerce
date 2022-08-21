package pageUIs.nopCommerce;

public class RegisterPageUI {
	// dùng final khi muốn biến đó ko bị gán lại (tức là ko bị thay đổi)
	// -- tương tự như hằng số (constant) trong toán học: là giá trị cố định ko bao giờ thay đổi
	// static + final: hằng số
	// Biến static cho phép truy cập trực tiếp từ tên class -- và có thể chia sẻ dữ liệu giữa nhiều luồng (thread) khác nhau --> Parallel Testing
	// static: biến tĩnh - các class khác có thể truy cập vào biến này mà ko cần phải khởi tạo class chứa nó

	// Các Object chỉ dc define và gán dữ liệu duy nhất 1 lần
	public static final String FIRST_NAME_TEXTBOX = "//input[@id='FirstName']";
	public static final String LAST_NAME_TEXTBOX = "//input[@id='LastName']";
	public static final String EMAIL_TEXTBOX = "//input[@id='Email']";
	public static final String PASSWORD_TEXTBOX = "//input[@id='Password']";
	public static final String CONFIRM_PASSWORD_TEXTBOX = "//input[@id='ConfirmPassword']";
	public static final String FIRST_NAME_ERROR_MESSAGE = "//span[@id='FirstName-error']";
	public static final String LAST_NAME_ERROR_MESSAGE = "//span[@id='LastName-error']";
	public static final String EMAIL_ERROR_MESSAGE = "//span[@id='Email-error']";
	public static final String PASSWORD_ERROR_MESSAGE = "//span[@id='Password-error']";
	public static final String CONFIRM_PASSWORD_ERROR_MESSAGE = "//span[@id='ConfirmPassword-error']";
	public static final String REGISTER_BUTTON = "//button[@id='register-button']";
	public static final String LOGOUT_LINK = "//a[@class='ico-logout']";
	public static final String REGISTER_SUCCESS_MESSAGE = "//div[@class='result']";
	public static final String EXISTING_EMAIL_ERROR_MESSAGE = "//div[contains(@class,'message-error')]//li";
	public static final String WRONG_EMAIL_ERROR_MESSAGE = "//div[contains(@class,'message-error')]//li";
}
