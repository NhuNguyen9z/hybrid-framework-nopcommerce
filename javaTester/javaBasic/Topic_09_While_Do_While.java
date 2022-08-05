package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_09_While_Do_While {

	// Hàm Scanner nhập ký tự từ bàn phím
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		TC_03_While();

	}

	public void TC_01() {

		for (int i = 0; i < 5; i++) {
			System.out.println("For: " + i);
			// vòng lặp for: kiểm tra điều kiện trước nếu thỏa mãn điều kiện sẽ chạy vào thân in ra i rồi sau đó tăng i lên 1 đơn vị
		}

		// Vòng lặp while
		int i = 0;
		while (i < 5) {
			System.out.println("While: " + i);
			i++;
		}

		System.out.println("Giá trị biến i sau khi chạy hết vòng while: " + i);
		// Vòng lặp do - while: chạy ít nhất 1 lần rồi mới kiểm tra điều kiện
		do {
			System.out.println("Do - while: " + i);
			i++;
		} while (i < 5);
	}

	@Test
	public static void TC_02_For() {
		// nhập số nguyên từ bàn phím
		int number = scanner.nextInt();
		for (; number < 100; number++) {
			if (number % 2 == 0) {
				System.out.println(number);
			}
		}
	}

	public static void TC_03_While() {
		int number = scanner.nextInt();

		while (number < 100) {
			if (number % 2 == 0) {
				System.out.println(number);

			}
			number++;

		}
	}

	public static void TC_04_Do_White() {
		int number = scanner.nextInt();

		do {
			if (number % 2 == 0) {
				System.out.println(number);

			}
			number++;

		} while (number < 100);
	}
}
