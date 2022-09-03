package javaOOP_Polymorphism;

public class Test {

	public static void main(String[] args) {
		Animal ani = new Animal();

		ani.eat();

		ani = new Pig();
		ani.eat();

		ani = new Bird();
		ani.eat();
		// Đa hình trong lúc Runtime: Là lúc chạy mới quyết định được gọi method nào vì khi chạy nó mới new lên tạo object

	}

}
