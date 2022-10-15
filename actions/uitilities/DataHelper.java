package uitilities;

import java.util.Locale;

import com.github.javafaker.Faker;

public class DataHelper {
	private Locale local = new Locale("en"); // dùng ngôn ngữ là english
	private Faker faker = new Faker(local);

	public static DataHelper getDataHelper() {
		return new DataHelper();
	}

	public String getFirstName() {
		return faker.address().firstName();
	}

	public String getLastName() {
		return faker.address().lastName();
	}

	public String getEmailAddress() {
		return faker.internet().emailAddress();
	}

	public String getPassword() {
		return faker.internet().password(8, 12, true, true);
	}

	public String getPhoneNumber() {
		return faker.phoneNumber().cellPhone();
	}

	public String getCityName() {
		return faker.address().city();
	}

	public String getAddress() {
		return faker.address().streetAddress();
	}
}
