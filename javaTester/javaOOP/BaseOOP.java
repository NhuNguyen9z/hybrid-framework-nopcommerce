package javaOOP;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class BaseOOP {
	WebDriver driver;
	public long longTimeout = 45;

	private BaseOOP() { // private constructor sẽ ngăn chặn việc khởi tạo 1 đối tượng mới từ bên ngoài class
		System.out.println("Constructor tại class cha");
	}

	protected BaseOOP(String name) {
		System.out.println("Constructor tại class cha: " + name);
	}

	public BaseOOP(int number) {
		System.out.println("Constructor tại class cha: " + number);
	}

	public void setImplicitWait() {
		driver.manage().timeouts().implicitlyWait(longTimeout, TimeUnit.SECONDS);

	}
}
