package javaBasic;

import java.io.File;

public class Topic_17_System_Property {

	public static final String OS_NAME = System.getProperty("os.name");
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String UPLOAD_FILE_FOLDER = PROJECT_PATH + File.separator + "uploadFiles";

	// File.separator: nó sẽ tự detect ra là sẹc trái / cho MAC/ Linux hay sẹc phải \\ cho Windows
	// Khi download file về nó sẽ trỏ về 1 thư mục mặc định của User, ví dụ Window thì trỏ về thư mục Downloads/
	// dùng Static vì có thể truy cập tại bất kỳ vị trí nào trong toàn bộ framework
	// Constant: Hằng số (Ko thay đổi value khi run test)

	public static void main(String[] args) {
		System.out.println(PROJECT_PATH);
		System.out.println(UPLOAD_FILE_FOLDER);
		System.out.println(OS_NAME);

	}

}
