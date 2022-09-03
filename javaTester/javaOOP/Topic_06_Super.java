package javaOOP;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class Topic_06_Super extends BaseOOP {

	// Super sẽ gọi qua Class cha --
	// 1 - Gọi trực tiếp thuộc tính (field) của lớp cha - nếu ko dùng super thì sẽ lấy biến của lớp hiện tại
	// 2 - Gọi trực tiếp phương thức (method) của lớp cha
	// 3 - Gọi trực tiếp hàm khởi tạo (constructor) của lớp cha --> dùng nhiều nhất
	// Dùng super khi: trong class con và class cha đều có 1 biến/ hàm cùng tên thì dùng super để gọi đến biến/ hàm của Class cha nếu ko dùng super sẽ gọi đến
	// biến/ hàm của Class con

	private WebDriver driver;
	public long longTimeout = 45;

	public Topic_06_Super() {
		// Luôn luôn gọi qua Constructor của class cha
		// super() phải đặt ở vị trí step đầu tiên
		// Nếu bên Class con ko dùng từ khóa super thì nó sẽ tự động gọi qua constructor mặc định Ko tham số của Class cha
		super(45);
		System.out.println("Constructor tại class con");

	}
	// Khi 1 class con kế thừa class cha mà class cha có constructor, thì thằng con cũng phải có hàm khởi tạo và gọi qua 1 constructor nào đó của class cha

	public static void main(String[] args) {

		Topic_06_Super topic = new Topic_06_Super();

	}

	public void setImplicitWait() {
		driver.manage().timeouts().implicitlyWait(super.longTimeout, TimeUnit.SECONDS);
	}

	public void clickToElement() {
		setImplicitWait();

		// Gọi qua hàm ở class cha
		super.setImplicitWait();

	}

}
