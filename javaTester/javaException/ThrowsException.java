package javaException;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ThrowsException {

	public static void main(String[] args) throws IOException, InterruptedException {
		FileOutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream("D://automationfc.txt");
			outputStream.write(55);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			outputStream.close(); // dùng finally để đảm bảo câu lệnh này luôn chạy qua
		}
		System.out.println("Result ----");

		sleepInSecond(3);
	}

	public static void sleepInSecond(long timeout) throws InterruptedException {
		Thread.sleep(timeout * 1000);

	}

}
