package javaBasic;

import org.testng.annotations.Test;

public class Topic_11_Array_Excersice {

	int[] number = { 5, 8, 4, 25, 60, 110 };

	public void TC_01_Find_Max_Number() {
		int x = 0;
		for (int i = 0; i < number.length; i++) {
			if (x < number[i]) {
				x = number[i];

			}
		}
		System.out.println("Max number = " + x);
	}

	public void TC_02_Sum_First_Last_Number() {
		int x;
		x = number[0] + number[number.length - 1];
		System.out.println("Sum = " + x);
	}

	public void TC_03_() {
		for (int i = 0; i < number.length; i++) {
			if (number[i] % 2 == 0) {
				System.out.println("Even number = " + number[i]);
			}
		}
	}

	public void TC_04_Excersice_4() {
		int[] arr = { 3, -7, 2, 5, 9, -6, 10, 12 };
		int i = 0, sum = 0;
		while (i < arr.length) {
			if (arr[i] % 2 != 0 && arr[i] > 0) {
				sum = sum + arr[i];
			}
			i++;
		}
		System.out.println(sum);

		// int sum = 0;
		// for (int i = 0; i < arr.length; i++) {
		// if (arr[i] > 0 && arr[i] % 2 != 0) {
		// sum = sum + arr[i];
		// }
		//
		// }
		// System.out.println(sum);
	}

	public void TC_05_Excersice_5() {
		int[] arr = { 3, -7, 2, 5, 9, -6, 10, 12, 0 };
		System.out.println("Length of array = " + arr.length);

		// for (int i = 0; i < arr.length; i++) {
		// if (arr[i] >= 0 && arr[i] <= 10) {
		// System.out.println(arr[i]);
		// }
		// }

		// Vòng lặp while
		int i = 0;
		while (i < arr.length) {
			if (arr[i] >= 0 & arr[i] <= 10) {
				System.out.println(arr[i]);
			}
			i++;

		}
	}

	@Test
	public void TC_06_Excersice_6() {
		int[] arr = { 3, 5, 7, 30, 10, 5, 8, 23, 0, -5 };
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}
		float avg = sum / arr.length;
		System.out.println("Sum all number = " + sum);
		System.out.println("Average all number = " + avg);
	}

}
