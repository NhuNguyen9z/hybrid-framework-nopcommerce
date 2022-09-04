package javaException;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TryCatchException {

	public static void main(String[] args) {

		int number = 10;
		try {
			number = 10 / 0; // happy thì nhảy vào try
		} catch (Exception e) {
			e.printStackTrace(); // unhappy thì nhảy vào catch
		}
		System.out.println(number);

		String[] browserName = { "Chrome", "Firefox", "Edge" };
		browserName[0] = "Safari";

		try {
			browserName[3] = "IE";
		} catch (Exception e) {
			// e.printStackTrace();
		}
		for (String browser : browserName) {
			System.out.println(browser);
		}

		int[] myList = new int[10]; // mảng số nguyên có 10 phần tử (số lượng phần tử)

		try {
			myList[9] = 30 / 0;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Vượt ngoài kích thước của Mảng");
		} catch (Exception e) {
			System.out.println("Ko thể chia cho 0");
		}

		FileOutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream("D://automationfc.txt");
			outputStream.write(55);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				outputStream.close(); // dùng finally để đảm bảo câu lệnh này luôn chạy qua
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Result ----");

		// Try - catch dc dùng để xử lý bắt exception còn finally dùng để clear dữ liệu hoặc muốn đoạn code nào đó bắt buộc chạy thì đưa vào finally
	}

}
