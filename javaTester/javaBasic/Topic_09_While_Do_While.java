package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

// break; câu lệnh dùng để thoát khỏi vòng lặp: for, while, do-while, switch-case
// Nếu như mình cần apply 1 điều kiện cho all các element trong vòng lặp thì ko dùng break
// Nếu như mình chỉ lọc ra 1 điều kiện mà ko chạy những cái còn lại thì nên dùng break

public class Topic_09_While_Do_While {

	// Hàm Scanner nhập ký tự từ bàn phím
	Scanner scanner = new Scanner(System.in);

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

	public void TC_02_For() {
		// nhập số nguyên từ bàn phím
		int number = scanner.nextInt();
		for (; number < 100; number++) {
			if (number % 2 == 0) {
				System.out.println(number);
			}
		}
	}

	public void TC_03_While() {
		int number = scanner.nextInt();

		while (number < 100) {
			if (number % 2 == 0) {
				System.out.println(number);

			}
			number++;

		}
	}

	public void TC_04_Do_White() {
		int number = scanner.nextInt();

		do {
			if (number % 2 == 0) {
				System.out.println(number);
			}
			number++;

		} while (number < 100);
	}

	public void TC_05() {
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();

		// Các số từ a - b
		while (numberA < numberB) {
			if (numberA % 3 == 0 && numberA % 5 == 0) {
				System.out.println(numberA);
			}
			numberA++;

		}
	}

	@Test
	public void TC_06() {
		int number = scanner.nextInt();
		int i = 0;
		do {
			if (number % 2 != 0) {

				System.out.println(number);
				i += number; // i = i + number
			}
			number--;
		} while (number > 0);

		System.out.println(i);
	}

}
