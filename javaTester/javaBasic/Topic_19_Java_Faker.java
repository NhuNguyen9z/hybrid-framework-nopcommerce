package javaBasic;

import com.github.javafaker.Faker;

public class Topic_19_Java_Faker {

	public static void main(String[] args) {

		Faker faker = new Faker();

		System.out.println("Lastname = " + faker.address().firstName());
		System.out.println("Firstname = " + faker.address().lastName());
		System.out.println("Email = " + faker.internet().emailAddress());
		System.out.println("Password = " + faker.internet().password(8, 12, true, true));
		System.out.println("Country = " + faker.address().country());

	}

}
