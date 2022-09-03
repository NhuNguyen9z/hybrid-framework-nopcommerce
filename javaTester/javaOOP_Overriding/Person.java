package javaOOP_Overriding;

public abstract class Person {

	// Option: có thể overriding hoặc KO
	public void eat() {
		System.out.println("Suất cơm 20.000 vnd");
	}

	// Must (Template) bắt buộc phải overriding
	public abstract void sleep();

	// Overriding: Class con có thể ghi đè 1 hàm của Class cha
	// thay đổi hành vi phù hợp cho Class con

	// Overriding: java quy ước overriding chính là tính Đa hình trong quá trình runtime (code chạy)

	// Rule:
	// Final method: KO dc override

	public final void walk() {
		System.out.println("Đi bộ");
	}

	public static void run() {
		System.out.println("Chạy bộ");
	}

	protected void dating() {
		System.out.println("Hẹn hò");
	}
}
