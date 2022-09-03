package javaOOP;

public class Topic_07_Getter_Setter {
	private String personName;
	private int personAge;
	private int personPhone;
	private float personBankAccountAmount;

	// Setter: mục đích dùng để validate dữ liệu
	// Getter: mục đích ko cho phép lấy dữ liệu ra từ property
	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		if (personName == null || personName.isEmpty()) {
			throw new IllegalArgumentException("Tên nhập vào ko dc bỏ trống");
		} else {
			this.personName = personName;
		}

	}

	public int getPersonAge() {
		return personAge;
	}

	public void setPersonAge(int personAge) {
		if (personAge > 15 && personAge < 60) {
			this.personAge = personAge;

		} else {
			throw new IllegalArgumentException("Tuổi nhập vào ko hợp lệ");
		}

	}

	public int getPersonPhone() {
		return personPhone;
	}

	public void setPersonPhone(int personPhone) {
		if (!String.valueOf(personPhone).startsWith("0")) {
			throw new IllegalArgumentException("Số điện thoại bắt đầu bằng: 09 - 02 - 012 - 016 - 018 - 019");
		} else if (personPhone < 10 || personPhone > 11) {
			throw new IllegalArgumentException("Số điện thoại phải từ 10 -11 số.");
		} else {
			this.personPhone = personPhone;
		}

	}

	public float getPersonBankAccountAmount() {
		return personBankAccountAmount;
	}

	public void setPersonBankAccountAmount(float personBankAccountAmount) {
		if (personBankAccountAmount < 0) {
			throw new IllegalArgumentException("Số tiền ko hợp lệ.");

		} else {
			this.personBankAccountAmount = personBankAccountAmount;
		}

	}

}
