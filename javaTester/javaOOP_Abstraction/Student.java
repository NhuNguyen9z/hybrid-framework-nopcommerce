package javaOOP_Abstraction;

public abstract class Student implements IPerson, ICity {
	public void eat() {
		System.out.println("Struden Eat");
	}

	public abstract void age();

	public abstract void name();

	public static void main(String[] args) {

	}
}
