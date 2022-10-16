package com.nopcommerce.data;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import commons.GlobalConstants;

public class UserDataMapper {

	public static UserDataMapper getUserData() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(new File(GlobalConstants.PROJECT_PATH + "/resources/UserData.json"), UserDataMapper.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		// nguyên tắc của thằng này là tạo ra 1 object mapper
		// nếu như có 1 field nào chưa có hàm để lấy data ra thì nó sẽ báo lỗi
		// nghĩa là nếu đọc file .json có những biến chưa lấy ra thì nó sẽ KO báo lỗi - nếu dùng "mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
		// false)"
		// nếu KO dùng dòng này "mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)" sẽ có thuộc tính nào mình ko lấy ra nó sẽ báo lỗi ngay
		// readValue từ file .json
	}

	@JsonProperty("firstName") // từ 1 thuộc tính của json map qua 1 biến của java
	private String first_name;
	// biến firstName sẽ dùng từ khóa @JsonProperty("firstName") để lấy data trong file .json map vào trong biến firstName thì lúc này firstName có data
	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("emailAddress")
	private String emailAddress;

	@JsonProperty("password")
	private String password;

	@JsonProperty("day")
	private String day;

	@JsonProperty("month")
	private String month;

	@JsonProperty("year")
	private String year;

	@JsonProperty("login")
	private Login login;

	static class Login {
		@JsonProperty("username")
		private String username;

		@JsonProperty("password")
		private String password;

	}

	public String getLoginUserName() {
		return login.username;
	}

	public String getLoginPassword() {
		return login.password;
	}

	public String getFirstName() {
		return first_name;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public String getDay() {
		return day;
	}

	public String getMonth() {
		return month;
	}

	public String getYear() {
		return year;
	}
}
