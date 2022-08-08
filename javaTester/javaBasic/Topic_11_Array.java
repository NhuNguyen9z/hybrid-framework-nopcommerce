package javaBasic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Topic_11_Array {

	public static void main(String[] args) {

		// Array: cố định
		// Được define cố định bao nhiêu phần tử khi mình viết code (Compile)
		String[] studentName = { "An", "Long", "Nam" };
		// studentName[0] = "Hoa";

		String[] stdNewName = studentName.clone();

		System.out.println(stdNewName[0]);

		// Array có thể dùng vs điều kiện dc
		for (int i = 0; i < studentName.length; i++) {
			if (studentName[i].equals("Long")) {
				System.out.println(studentName[i]);
			}
		}

		// Nhược điểm của foreach: ít khi dùng kết hợp với điều kiện nếu kết hợp vs điều kiện thì ko biết nó ở index nào
		for (String std : studentName) {
			if (std.equals("Long")) {
				System.out.println("Click vào Long");
			}

		}

		// ArrayList - Động
		ArrayList<String> stdName = new ArrayList<>();
		// khi chạy mới add (Runtime)
		for (String std2 : studentName) {
			stdName.add(std2);
			System.out.println(std2);
		}

		List<String> names = Arrays.asList("Tom", "Jerry", "Donal");
		for (String name : names) {
			System.out.println("Name = " + name);
		}

		// Chuyển 1 mảng thành chuỗi dùng toString
		String std_Name = Arrays.toString(studentName);
		System.out.println(std_Name);

	}

}
