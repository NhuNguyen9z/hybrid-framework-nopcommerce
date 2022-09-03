package javaOOP_Inheritance;

public class Animal {

	public Animal() {
		System.out.println("Parent's Constructor");
	}

	public Animal(String name) {
		System.out.println("Parent's Constructor " + name);
	}

	public Animal(String name, int age) {
		System.out.println("Parent's Constructor = " + name);
		System.out.println("Parent's Constructor = " + age);
	}

}
