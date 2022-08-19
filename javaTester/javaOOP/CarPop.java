package javaOOP;

public class CarPop {
	static String carCompany;
	static String carName;
	static String fuelType;
	static float carSpeed;
	static double carPrice;

	public static void main(String[] args) {
		carCompany = "Honda";
		carName = "Camry";
		fuelType = "petro";
		carSpeed = 200f;
		carPrice = 50000d;

		System.out.println(" Car Company = " + carCompany);
		System.out.println(" Car Name = " + carName);
		System.out.println(" Car Fuel Type = " + fuelType);
		System.out.println(" Car Speed = " + carSpeed);
		System.out.println(" Car Price = " + carPrice);

		carCompany = "Mescedes";
		carName = "Ben";
		fuelType = "Diesel";
		carSpeed = 300f;
		carPrice = 10000d;

		System.out.println(" Car Company = " + carCompany);
		System.out.println(" Car Name = " + carName);
		System.out.println(" Car Fuel Type = " + fuelType);
		System.out.println(" Car Speed = " + carSpeed);
		System.out.println(" Car Price = " + carPrice);

	}

}
