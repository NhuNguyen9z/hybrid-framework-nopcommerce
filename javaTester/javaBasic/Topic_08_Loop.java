package javaBasic;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Topic_08_Loop {
	
	WebElement driver;

	
	public void TC_01_For_Iterate() {
//		for(int i = 0 ; i < 5; i++) {
//			System.out.println(i);
//		}
		
		// Vế 1: biến tạm dùng để tăng giá trị lên sau mỗi lần duyệt
		// Dùng để so sánh với tổng giá trị
		// Vế 2: So sánh với tổng
		// Vế 3: Tăng i lên 1 đơn vị sau khi chạy vào thân vòng for
		
		// Lần 1:
		//  i = 0
		// 0 < 5: đúng
		// System.out.println(0)
		//  i++ tăng i lên 1 đơn vị (i = 1)
		
		// Lần 2:
		// i = 1
		// 1 < 5: đúng
		// System.out.println(1)
		// i++ tăng i lên 1 đơn vị (i = 2)
		
		// Lần 3:
		// i = 2
		// 2 < 5: đúng
		// System.out.println(2)
		// i++ tăng i lên 1 đơn vị (i = 3)
		
		// Lần 4:
		// i = 3
		// 3 < 5: đúng
		// System.out.println(3)
		// i++ tăng i lên 1 đơn vị (i = 4)
		
		// Lần 5:
		// i = 4
		// 4 < 5 đúng
		// System.out.println(4)
		// i++ tăng i lên 1 đơn vị (i = 5)
		
		// Lần 6:
		// i = 5
		// 5 < 5: sai
		
		
		// Array
		String[] cityName = {"Ha noi", "Ho Chi Minh", "Da Nang", "Can Tho"};
		// Array/ List/ Set/ Queue (index) --- đều dùng index tức là tính từ vị trí số 0
		
		// For kết hợp if: thỏa mãn điều kiện mới action
		// Biến đếm - dùng điều kiện để filter
		for (int i = 0; i < cityName.length; i++) {
			if(cityName[i].equals("Da Nang")) {
				// Action
			System.out.println("Do action!");
			break;
			// dùng break khi nào nó tìm thấy điều kiện rồi thì thoát khỏi vòng lặp ko chạy cho những thằng còn lại
			}
			
		}
		
		// Dùng để chạy qua hết tất cả giá trị
		for (String city : cityName) {
			
		}
		
	}

	
	@Test
	public void TC_02_For_Each() {
		// for each dùng cho Collection và Array đều được
		// Array
		String[] cityName = {"Ha noi", "Ho Chi Minh", "Da Nang", "Can Tho"};
		
		// Java Collection
		// Class: ArrayList/ LinkedList/ Vector/..
		// Interface: List/ Set/ Queue		
		List<String> cityAddress = new ArrayList<String>();
		System.out.println(cityAddress.size());
		
		// Compile (Coding)
		cityAddress.add("Ha Giang");
		cityAddress.add("Lao Cai");
		cityAddress.add("Lang Son");
		System.out.println(cityAddress.size());
		
		// Runtime (Running)
		for (String city : cityName) {
			cityAddress.add(city);			
		}
		
		System.out.println(cityAddress.size());
		System.out.println(cityAddress);
		
		for (String cityAdd : cityAddress) {
			System.out.println(cityAdd);
			
		}
		
		// Java Generic
		List<WebElement> links = driver.findElements(By.xpath(""));	
		
		// Khi dùng element để xử lý dữ liệu/ get text/ value/ css/ attribute sau đó verify
		for (WebElement link : links) {
			// Nếu thao tác liên quan đến chuyển page/ refesh DOM/ HTML -- thì những element đã lưu ko còn tồn tại mà vẫn chạy tiếp For thì bị Fail --> StaleElementException
			// --> Nêm ko dùng để thao tác cho click chuyển page hoặc open link thì ko hợp lý
		}
	}
}

