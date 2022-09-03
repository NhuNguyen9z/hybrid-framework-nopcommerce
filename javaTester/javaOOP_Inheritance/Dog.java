package javaOOP_Inheritance;

public class Dog extends Animal {
	// Class đơn kế thừa 1 Class
	// Class đa kế thừa nhiều Interface

	public Dog() {
		super("Tom", 3);
		System.out.println("Child 's Constructor");
	}

	// Getter/ Setter và Access Modifier thể hiện cho tính Đóng Gói
	// extends thể hiện cho tính Kế Thừa
	// Overloading/ overriding thể hiện cho tính Đa Hình
	// extends abstract Class/ implements Interface thể hiện cho tính Trừu Tượng
}
