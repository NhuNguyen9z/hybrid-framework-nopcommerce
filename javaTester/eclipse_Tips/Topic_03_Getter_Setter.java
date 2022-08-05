package eclipse_Tips;

public class Topic_03_Getter_Setter {

	private String carName;

	// Hàm get dữ liệu ra tương tự các hàm getURL trong selenium, những hàm Getter thường có return
	public String getCarName() {
		return carName;
	}

	// Hàm set dữ liệu vào (gán dữ liệu) tương tự các hàm click, sendKey trong selenium
	public void setCarName(String carName) {
		this.carName = carName;
	}

	// Page Object Pattern
	// Constructor -- hàm khởi tạo
	// public Topic_03_Getter_Setter(String carName) {
	//
	// this.carName = carName;
	// }

}
