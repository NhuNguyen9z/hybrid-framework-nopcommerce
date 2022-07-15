package javaBasic;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Topic_06_Condition_Statement_Excersice {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	// Scanner sẽ nhận 1 số hay text từ bàn phím
	Scanner scanner = new Scanner(System.in);

	public void TC_01_Excercise() {
		int number = scanner.nextInt();

		if (number % 2 == 0) {
			System.out.println("Đây là số chẵn");
		} else {
			System.out.println("Đây là số lẻ");
		}
	}

	
	public void TC_02_Excercise() {

		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();

		if (numberA > numberB) {
			System.out.println(numberA + " lớn hơn " + numberB);
		} else if (numberA == numberB) {
			System.out.println(numberA + " bằng " + numberB);
		} else {
			System.out.println(numberA + " nhỏ hơn " + numberB);
		}

	}
	

	public void TC_03_Excercise() {

		String firstStudent = scanner.nextLine();
		String secondStudent = scanner.nextLine();

		if (firstStudent.equals(secondStudent)) {
			System.out.println("Hai sinh viên giống tên nhau");
		}
		 else {
			System.out.println("Hai sinh viên khác tên nhau");
		}

	}
	
	
	public void TC_04_Excercise() {

		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		int numberC = scanner.nextInt();

		if (numberA > numberB && numberA > numberC) {
			System.out.println(numberA + " Number A lớn nhất");
		}
		 else if(numberB > numberC){
			System.out.println(numberB + " Number B là số lớn nhất");
		} else {
			System.out.println(numberC + " Number C là số lớn nhất");
		}
	}
		
		
		public void TC_05_Excercise() {

			float studentPoint = scanner.nextFloat();
			

			if (studentPoint <= 10 && studentPoint >= 8.5) {
				System.out.println("Hệ số A");
			}
			 else if(studentPoint < 8.5 && studentPoint >= 7.5){
				System.out.println("Hệ số B");
			} else if(studentPoint < 7.5 && studentPoint >= 5){
				System.out.println(" Hệ số C");
			} else if(studentPoint < 5 && studentPoint >= 0) {
				System.out.println(" Hệ số D");
			} else {
				System.out.println(" Bạn vui lòng nhập lại");
			}

	}
		@Test
		public void TC_06_Excercise() {
			int month = scanner.nextInt();
			
			if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
				System.out.println("Tháng có 31 ngày");
			} else if(month == 2) {
				System.out.println("Tháng có 28 ngày");
			} else {
				System.out.println("Tháng có 30 ngày");
			}
			
		}

}
