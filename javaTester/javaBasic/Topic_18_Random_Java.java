package javaBasic;

import java.util.Calendar;
import java.util.Random;

public class Topic_18_Random_Java {

	public static int getrandomNumber() {
		int uLimit = 999;
		int lLimit = 100;
		Random random = new Random();
		return lLimit + random.nextInt(uLimit - lLimit);
	}

	public static int getrandomNumber(int minimum, int maximum) {
		Random random = new Random();
		return minimum + random.nextInt(maximum - minimum);
	}

	public static int randomFakeNuber() {
		Random random = new Random();
		return random.nextInt(99999);
	}

	public static String getRandomEmail() {
		return "automation" + getRandomNumberByDateTime() + "@hotmail.com";
	}

	// Get random number by date time minute second (no duplicate)
	public static long getRandomNumberByDateTime() {
		return Calendar.getInstance().getTimeInMillis() % 100000;

	}

	public static void main(String[] args) {
		String email = "john" + getrandomNumber() + "@gmail.com";
		String email2 = "john" + getrandomNumber(10, 30) + "@gmail.com";

		System.out.println(email);
		System.out.println("Emai = " + email2);
		System.out.println("Emai = " + randomFakeNuber() + "@yahoo.com");
		System.out.println("Emai In Time 1 = " + getRandomEmail());
		System.out.println("Emai In Time 2 = " + getRandomEmail());
		System.out.println("Emai In Time 3 = " + getRandomEmail());
	}
}
