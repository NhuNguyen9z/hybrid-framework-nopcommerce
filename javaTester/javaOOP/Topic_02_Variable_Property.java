package javaOOP;

public class Topic_02_Variable_Property {
	// Variable 1 biến sẽ mang 1 giá trị, thường khi tạo biến mình sẽ khởi tạo dữ liệu cho nó - vì nó ko có giá trị mặc định
	// 1 Property thì sẽ KO có khởi tạo dữ liệu cho nó mà phải gán dữ liệu thông qua các hàm Setter - lấy dữ liệu thông qua các hàm Getter
	// Thuộc tính (Property) phải đi với đối tượng (Object)

	int studentNumber;
	float studentPrice; // Global variable: ko cần khởi tạo cũng có giá trị mặc định
	// Access Modifier
	// Data Type
	// Variable name
	// Variable value
	private String studentName = "Automation FC"; // Biến toàn cuc (Global variable)

	// Static variable: có thể gán dữ liệu lại dc
	public static String studentAddress = "Saigon";
	// public static: dùng và gán lại dc
	// - Trong cùng 1 class: có thể dùng trong hàm static - có thể gọi trực tiếp trong hàm static mà KO cần thông qua đối tượng - có thể gán lại dữ liệu dc
	// - Khi ra ngoài class: truy cập trực tiếp từ tên class đến tên biến (mà KO cần thông qua đối tượng) - có thể gán lại dữ liệu dc - ko nên lạm dụng tạo các biến
	// là static.
	// private static: dùng trong phạm vi class này ( cho all instance/ Object dùng)
	private static String studentPhone = "0987654321";

	// final variable: KO cho phép gán lại/ Ko override lại - Cố định dữ liệu KO dc phép thay đổi trong quá trình chạy
	final String country = "Vietnam";

	// static final variable: hằng số (Constant): thường đại điện cho những gì cố định vd: các thứ trong tuần, tháng, mùa trong năm, số pi
	// KO dc ghi đè -
	// Có thể truy cập rộng rãi cho các instance/ thread
	// final variable KO dc gán lại giá trị mới sau khi đã khởi tạo - final method (hàm) KO cho phép override(ghi đè) - final class KO cho phép kế thừa
	// define static final vì ko muốn giá trị thay đổi trong quá trình chạy
	static final float PI_NUMBER = 3.1423455f;

	public static void main(String[] args) {

		Topic_01_Class_Object_Student student = new Topic_01_Class_Object_Student();

		student.studentID = 1234; // Instance variable

		String studentName = "Automation Course"; // Local variable - Biến cục bộ: hàm
		if (studentName.startsWith("Automation")) {
			int number = 100; // Local variable - Biến cục bô: block code
		}

		studentAddress = "Danang";
		studentPhone = "123";
		System.out.println(studentPhone);

		// Local variable: bắt buộc phải khởi tạo mới dc sử dụng (vì ko có giá trị mặc định) - ví dụ khởi tạo studentNumber = 0;
		int studentNumber;
		float studentPrice;

	}

	public Topic_02_Variable_Property() {

	}

}
