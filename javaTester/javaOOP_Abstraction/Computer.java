package javaOOP_Abstraction;

public abstract class Computer {

	// Non-abstract (Normal)
	public void showCPU() {
		System.out.println("Intel CPU...");
	}

	// Abstract method
	public abstract void setRam();

}
