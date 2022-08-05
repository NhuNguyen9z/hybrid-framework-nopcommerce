package eclipse_Tips;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Topic_01_Template {
	static WebDriver driver;

	//file .class là file được biên dịch rồi và đóng gói thành 1 thư viện rồi ví dụ client-combined-3.141.59-sources.jar
	// mục đích của việc xem source là: tham khảo cách họ viết code/ code như thế nào/ hiểu rõ sâu bên dưới để sử dụng tốt hơn
	public static void main(String[] args) {

		WebElement nameTextbox = driver.findElement(By.cssSelector(""));
		
	}

}
