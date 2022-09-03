package javaOOP_Overriding;

public class Student extends Person implements IWork {

	@Override
	public void eat() {
		System.out.println("Suất cơm 15.000 vnd");
	}

	@Override
	public void sleep() {
		System.out.println("Ngủ 12h/ ngày");

	}

	@Override
	public void workingTime() {
		System.out.println("Học 6h/ ngày");

	}

	public void run(String name) {
		System.out.println("Hoc 6h/ ngày");

	}

	protected void dating() {
		System.out.println("Hẹn hò");
	}

	// Overriding: chỉ xuất hiện ở mối quan hệ kế thừa Class hoặc implements interface
}
