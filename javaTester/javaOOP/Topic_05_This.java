package javaOOP;

public class Topic_05_This {

	// This: chỉ dùng trong phạm vi là Class hiện tại (dùng để gọi qua biến thuộc phạm vi global)
	// 1 - Tham chiếu tới biến của lớp hiện tại --> dùng nhiều nhất
	// 2 - Gọi phương thức (method) của lớp hiện tại
	// 3 - Gọi hàm khởi tạo (constructor) của lớp hiện tại
	// 4 - Trả về instance của lớp hiện tại -- ít dùng
	// dùng this khi trong 1 Class có 2 biến local và global cùng tên nếu trong 1 hàm mà KO dùng this thì sẽ gọi qua biến local trước nếu dùng this thì sẽ gọi qua
	// biến global

	private int firstNumber;
	private int secondNumber;

	public Topic_05_This() {
		// this phải đặt ở vị trí step đầu tiên
		this(5, 10);
		System.out.print("");

	}

	public Topic_05_This(int firstNumber, int secondNumber) {
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
	}

	public void sumNumber() {
		System.out.println(this.firstNumber + this.secondNumber);
	}

	public void showNumber() {
		this.sumNumber();
	}

	public static void main(String[] args) {
		Topic_05_This topic = new Topic_05_This();
		topic.sumNumber();

	}

}
