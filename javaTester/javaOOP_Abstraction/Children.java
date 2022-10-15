package javaOOP_Abstraction;

public class Children extends Student {

	public void eat() {
		System.out.println("Childen eat ...");
	}

	@Override
	public void name() {
		System.out.println("Childen name ...");

	}

	@Override
	public void age() {
		System.out.println("Childen age ...");

	}

	public static void main(String[] args) {
		Children children = new Children();
		children.eat();
		children.name();
		children.age();

	}

}
