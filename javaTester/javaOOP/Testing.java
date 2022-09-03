package javaOOP;

public class Testing {

	public static void main(String[] args) {

		// System.out.println(Topic_02_Variable_Property.studentAddress);
		//
		// Topic_01_Class_Object_Student student = new Topic_01_Class_Object_Student();
		// student.studentID = 1234; // Instance variable

		Topic_07_Getter_Setter topic = new Topic_07_Getter_Setter();
		topic.setPersonPhone(1089123456);
		System.out.println(topic.getPersonPhone());

	}

}
