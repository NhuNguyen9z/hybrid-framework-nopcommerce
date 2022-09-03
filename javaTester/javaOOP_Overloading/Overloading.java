package javaOOP_Overloading;

public class Overloading {

	private int firstNumber;
	private int secondNumber;

	public void sumNumber() {
		System.out.println(this.firstNumber + this.secondNumber);
	}

	public void sumNumber(int number) {
		System.out.println(number + (number * 10) / 100);
	}

	public void sumNumber(int firstNumber, int secondNumber) {
		System.out.println(firstNumber + secondNumber);
	}

	public void sumNumber(int firstNumber, float secondNumber) {
		System.out.println(firstNumber + secondNumber);
	}

	public void sumNumber(float firstNumber, float secondNumber) {
		System.out.println(firstNumber + secondNumber);
	}

	// Overloading: Đa hình trong quá trình compile
	// 1 - Nếu cùng số lượng tham số phải khác kiểu dữ liệu
	// 2 - Nếu khác số lượng tham số thì ko quan tâm kiểu dữ liệu
	// Luôn ưu tiên xét số lượng tham số trước rồi xét kiểu dữ liệu sau

	// Overloading: nạp chồng/ chồng hàm
	// Overriding: ghi đè/ đè hàm
	// Khi nói về trừu tượng thì: abstract Class và Interface đều thể hiện tính chất trừu tượng
	public static void main(String[] args) {

	}

}
