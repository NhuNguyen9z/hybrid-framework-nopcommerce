package javaOOP;

public class Student {
	// Property
	private int id;
	private String name;
	private float theory;
	private float practice;

	// Constructor
	protected Student(int id, String name, float theory, float practice) {
		this.id = id;
		this.name = name;
		this.theory = theory;
		this.practice = practice;
	}

	// Method
	protected int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected float getTheory() {
		return theory;
	}

	protected void setTheory(float theory) {
		this.theory = theory;
	}

	protected float getPractice() {
		return practice;
	}

	protected void setPractice(float practice) {
		this.practice = practice;
	}

	protected float getSumAvg() {
		return (theory + practice * 2) / 3;
	}

	protected void showInforStudent() {
		System.out.println("ID of Student = " + getId());
		System.out.println("Name of Student = " + getName());
		System.out.println("Score of Student = " + getSumAvg());
	}

	public static void main(String[] args) {
		Student sv1 = new Student(11, "Jonhny", 6.5f, 8f);
		sv1.showInforStudent();

		Student sv2 = new Student(12, "Henry", 8f, 8f);
		sv2.showInforStudent();

		Student sv3 = new Student(13, "Tony", 6f, 9f);
		sv3.showInforStudent();

	}
}
