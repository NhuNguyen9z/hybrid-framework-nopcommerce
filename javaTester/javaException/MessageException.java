package javaException;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MessageException {

	public static void main(String[] args) {
		FileOutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream("E://automationfc.txt");
			outputStream.write(65);

		} catch (FileNotFoundException e) {
			// e.printStackTrace();
			System.out.println(e.getMessage());
			// System.out.println(e.toString());

		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				if (outputStream != null) {
					outputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Result ----");
	}

}
