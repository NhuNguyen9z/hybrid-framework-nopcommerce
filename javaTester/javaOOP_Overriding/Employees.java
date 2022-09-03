package javaOOP_Overriding;

public class Employees extends Person implements IWork {

	@Override
	public void eat() {
		System.out.println("Suất cơm 25.000 vnd");
	}

	@Override
	public void sleep() {
		System.out.println("Ngủ 8h/ ngày");

	}

	@Override
	public void workingTime() {
		System.out.println("Làm 8h/ ngày");

	}

}
