package javaBasic;

import org.testng.annotations.Test;

public class Topic_10_Break_Continue {

	public void TC_01() {

		for (int i = 0; i < 10; i++) {

			// từ khóa continue loại trừ 1 điều kiện này ra
			if (i == 5) {
				continue;
			}
			System.out.println(i);
		}

	}

	@Test
	public void TC_02_Nested_For() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("Lần chạy của i (for thứ nhất) = " + i);

			// i = 1
			// Mỗi lần chạy của for trên sẽ apply cho all các lần chạy của for dưới này
			for (int j = 1; j <= 5; j++) {
				if (j == 4) {
					continue;
				}
				System.out.println("Lần chạy của j (for thứ hai) = " + j);

				for (int x = 1; x <= 5; x++) {
					if (x == 4) {
						continue;
					}
					System.out.println("x của for thứ ba = " + x);
				}
			}
		}
	}

}
