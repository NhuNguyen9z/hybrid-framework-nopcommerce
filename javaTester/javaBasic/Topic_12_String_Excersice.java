package javaBasic;

import org.testng.annotations.Test;

public class Topic_12_String_Excersice {

	public void TC_01() {
		String arr = "AutomaTion TestIng 19 20 AdvancEd!@#$ OnliNe";
		char[] charactor = arr.toCharArray();
		System.out.println(arr.toCharArray());
		int countUppCase = 0, countLowerCase = 0, countNumber = 0, countSpecial = 0;
		for (char c : charactor) {
			// Uppercase
			if (c >= 'A' && c <= 'Z') {
				countUppCase++;
			}
			// Lowercase
			else if (c >= 'a' && c <= 'z') {
				countLowerCase++;
			}
			// Number
			else if (c >= '0' && c <= '9') {
				countNumber++;
			}
			// Special
			else {
				countSpecial++;
			}
		}
		System.out.println(countUppCase);
		System.out.println(countLowerCase);
		System.out.println(countNumber);
		System.out.println(countSpecial);

	}

	public void TC_02() {
		String nameCourse = "Automation Testing 345 Tutorials Online 75";
		char[] name = nameCourse.toCharArray();
		int count = 0, countNumber = 0;
		for (char c : name) {
			if (c == 'a' || c == 'A') {
				count++;
			} else if (c >= '0' && c <= '9') {
				countNumber++;
			}
		}
		System.out.println("Count charactor 'a' = " + count);
		System.out.println("Contains word 'Testing' = " + nameCourse.contains("Testing"));
		System.out.println("Starts with word 'Automation' = " + nameCourse.startsWith("Automation"));
		System.out.println("End with word 'Online' = " + nameCourse.endsWith("Online"));
		System.out.println("Index of word 'Tutorials' = " + nameCourse.indexOf("Tutorials"));
		System.out.println("Replace = " + nameCourse.replace("Online", "Offline"));
		System.out.println("Count number = " + countNumber);
	}

	@Test
	public void TC_03() {
		String courseName = "12345", nstr = "";
		char[] courseNameArr = courseName.toCharArray();
		System.out.println(courseNameArr);
		for (int j = courseNameArr.length - 1; j >= 0; j--) {
			System.out.println(courseNameArr[j]);
			nstr = nstr + courseNameArr[j];
		}

		// char ch;
		// for (int i = 0; i < courseName.length(); i++) {
		// ch = courseName.charAt(i);
		// System.out.println(ch);
		// nstr = ch + nstr;
		// }
		System.out.println(nstr);
	}

}
