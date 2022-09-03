package javaOOP_Overriding;

public class Testing {

	public static void main(String[] args) {

		Student s = new Student();
		s.eat();
		s.sleep();
		s.workingTime();

		Employees e = new Employees();
		e.eat();
		e.sleep();
		e.workingTime();
	}

}
