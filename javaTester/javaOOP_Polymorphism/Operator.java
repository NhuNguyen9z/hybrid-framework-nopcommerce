package javaOOP_Polymorphism;

public class Operator {

	public void sum(int a, int b) {
		System.out.println(a + b);
	}

	public void sum(float a, float b) {
		System.out.println(a + b);
	}

	public void sum(double a, double b) {
		System.out.println(a + b);
	}

	public void sum(long a, long b) {
		System.out.println(a + b);
	}

	public static void main(String[] args) {
		Operator opr = new Operator();
		// Đa hình trong lúc Compile vì: trình biên dịch nó sẽ chọn phương thức nào
		opr.sum(12, 20);
		opr.sum(1.234d, 3.456d);
		opr.sum(2.1f, 3.5f);
		opr.sum(40000l, 20000l);

	}

}
