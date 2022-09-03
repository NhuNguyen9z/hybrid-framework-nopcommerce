package javaOOP;

public class Topic_01_Class_Object_Student {
	// Property
	public int studentID;
	private String name;
	private Float knowledgePoint;
	private Float practicePoint;

	// Constructor
	protected Topic_01_Class_Object_Student(int studentID, String name, Float knowledgePoint, Float practicePoint) {
		this.studentID = studentID;
		this.name = name;
		this.knowledgePoint = knowledgePoint;
		this.practicePoint = practicePoint;
	}

	public Topic_01_Class_Object_Student() {
		// TODO Auto-generated constructor stub
	}

	// Method
	protected int getId() {
		return studentID;
	}

	// Getter là hàm để lấy dữ liệu ra
	// Setter là hàm để gán dữ liệu vào
	// Nghĩa là muốn truy cập dữ liệu phải thông qua các hàm chứ ko dc phép lấy/ gán dữ liệu thông qua các thuộc tính -> để tăng độ bảo mật
	protected void setId(int studentID) {
		this.studentID = studentID;
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected float getKnowledgePoint() {
		return knowledgePoint;
	}

	protected void setKnowledgePoint(Float theory) {
		this.knowledgePoint = theory;
	}

	protected float getPracticePoint() {
		return practicePoint;
	}

	protected void setPracticePoint(Float practice) {
		this.practicePoint = practice;
	}

	protected Float getAveragePoint() {
		return (knowledgePoint + practicePoint * 2) / 3;
	}

	protected void showInforStudent() {
		System.out.println("-------------------------");
		System.out.println("ID of Student = " + getId());
		System.out.println("Name of Student = " + getName());
		System.out.println("Score of Student = " + getAveragePoint());
	}

	public static void main(String[] args) {
		Topic_01_Class_Object_Student firstStudent = new Topic_01_Class_Object_Student(11, "Jonhny", 6.5f, 8f);
		firstStudent.showInforStudent();

		Topic_01_Class_Object_Student secondStudent = new Topic_01_Class_Object_Student(12, "Henry", 8f, 8f);
		secondStudent.showInforStudent();

		Topic_01_Class_Object_Student thirdStudent = new Topic_01_Class_Object_Student(13, "Tony", 6f, 9f);
		thirdStudent.showInforStudent();

	}
}
