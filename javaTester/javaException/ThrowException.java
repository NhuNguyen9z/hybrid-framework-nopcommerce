package javaException;

import java.io.File;
import java.io.IOException;

public class ThrowException {

	public static void main(String[] args) throws IOException {

		findFile();
	}

	public static void findFile() throws IOException {
		String fileName = "automationfc.jpg";
		File newFile = new File(fileName);
		if (newFile.exists() && !newFile.isDirectory()) {
			// Action something
		} else {
			throw new IOException("This File not found" + fileName);
		}
	}
}
