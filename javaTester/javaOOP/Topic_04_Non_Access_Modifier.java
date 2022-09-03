package javaOOP;

public abstract class Topic_04_Non_Access_Modifier {

	// Static: Variable/ Method
	// Dùng cho all các instance/ object
	// Phạm vi cho toàn bộ System (project) sử dụng nó
	// Có thể override lại được (gán lại dc)
	// Trong cùng 1 class: có thể gọi trực tiếp trong hàm static mà KO cần thông qua đối tượng
	// Ngoài class:
	// -- Truy cập trực tiếp từ tên class đến tên biến/ hàm static - mà KO cần thông qua đối tượng
	// -- Ko cần tạo instance/ object
	// -- Ko nên lạm dụng các biến/ hàm là static
	// 1 hàm static có thể gọi trực tiếp đến 1 hàm static khác trong cùng 1 class
	// KO CÓ STATIC CLASS
	static String browserName = "Chrome";

	// Non-static: phải truy cập thông qua object
	String serverName = "Testing";

	public static void main(String[] args) {
		System.out.println(browserName);
		browserName = "Firefox";
		System.out.println(browserName);
		// Topic_04_Non_Access_Modifier topic = new Topic_04_Non_Access_Modifier();
		// System.out.println(topic.serverName);

		// Hàm non-static
		// topic.clickToElement("Button");

		// Hàm static
		senkeyToElement("Link");

	}
	// Final class: Cho khởi tạo đối tượng nhưng KO cho kế thừa
	// Abstract class: Cho kế thừa nhưng ko cho khởi tạo đối tượng
	// Lưu ý: 1 abstract class mới cho phép define 1 hàm abstract

	// 2 loại lỗi:
	// Lỗi compiler: Trong quá trình viết code sai sẽ báo lỗi
	// Lỗi Rumtime: Trong quá trình mình run system/ testcase

	public void clickToElement(String elementName) {
		System.out.println(elementName);
	}

	public static void senkeyToElement(String elementName) {
		System.out.println(elementName);
	}

	// Abstract method: ko có phần thân (body) -
	// dùng với: public, protected
	// Bắt buộc các class con phải override các hàm này lại
	protected abstract void setAnnimalName();

	// define Enum để tránh trường hợp thay đổi dữ liệu - enum là giá trị cố định

}
