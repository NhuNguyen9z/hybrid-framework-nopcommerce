package javaOOP_Abstraction;

public class Test {

	// - Abstract Class: thì mức độ abtraction từ 0 -> 100% - nghĩa là trong 1 Class abtract sẽ có hàm abstract và hàm KO abstract (hàm normal) -
	// hoặc trong 1 Class abtract có thể KO có hàm nào abtract cũng dc
	// Nếu là abstract Class thì KO có khởi tạo đối tượng

	// - Interface 100% là hàm abstract hết dù có từ khóa abstract hay ko
	// Hàm abstract: tên hàm có/ ko có tham số, ko có phần thân (hàm rỗng)
	// - Một Class A nếu kế thừa 1 Class B là abstract thì bắt buộc Class A phải implement lại all các hàm abtract của Class B đó
	// - Interface Ko có constructor vì ko thể new object từ Interface dc - tương tự Abstract Class
	// - Abstract method chỉ là phần giao diện ko có gì bên trong cả (1 method rỗng ko dc implement gì hết)
	// --> nó xây dựng ra 1 giao diện để cho những thằng khác phải implement lại
	// -- tại sao phải implement vì nó chỉ là method rỗng những thằng khác muốn làm gì tự nó phải lắp đầy vào (tự nó viết ra những cái mà nó muốn)
	// - Interface: All access modifier là public và abstract hết cho cả method/ property - Ko có các access modifier khác như: private, protected, default.
	// - Các biến trong Interface mặc định là hằng số dù có để static final hay ko
	// - 1 Class có thể implements nhiều Interface vì: ko mang ra để sử dụng được luôn mà phải viết lại mới dùng dc khác knowledge của kế thừa (extends) là lấy ra
	// dùng dc luôn
	// - Lưu ý: 1 Class thông thường KO dc phép chứa abstract method
	// - 1 Class extends 1 Class; 1 Class implements 1 or nhiều Interface; Interface extends Interface : tại sao extends mà ko phải implements vì cùng cấp;
	// Interface KO ĐƯỢC (ko hỗ trợ) implements/ extends Class - vì nếu Interface kế thừa Class thì nó ko dùng dc gì trong Class vì Interface thực chất là những hàm
	// rỗng bên trong

	// - Interface: define những giao diện để cho nhiều thằng có thể sử dụng dc
	// - Nếu vừa có cả Normal method vừa có cả Abstract method thì dùng Abstract Class
	// - nếu muốn xây dựng giao diện cho all thằng khác follow theo và ko có hàm nào dc implement bên trong thì dùng Interface
	// - Interface hỗ trợ đa kế thừa còn Abstract Class chỉ hỗ trợ đơn kế thừa

}
