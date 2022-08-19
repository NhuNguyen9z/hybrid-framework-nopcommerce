package javaOOP;

public class CarOOP {
	private String carCompany;
	private String carName;
	private String fuelType;
	private float carSpeed;
	private double carPrice;

	protected CarOOP(String carCompany, String carName, String fuelType, float carSpeed, double carPrice) {
		this.carCompany = carCompany;
		this.carName = carName;
		this.fuelType = fuelType;
		this.carSpeed = carSpeed;
		this.carPrice = carPrice;
	}

	protected String getCarCompany() {
		return carCompany;
	}

	protected void setCarCompany(String carCompany) {
		this.carCompany = carCompany;
	}

	protected String getCarName() {
		return carName;
	}

	protected void setCarName(String carName) {
		this.carName = carName;
	}

	protected String getFuelType() {
		return fuelType;
	}

	protected void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	protected float getCarSpeed() {
		return carSpeed;
	}

	protected void setCarSpeed(float carSpeed) {
		this.carSpeed = carSpeed;
	}

	protected double getCarPrice() {
		return carPrice;
	}

	protected void setCarPrice(double carPrice) {
		this.carPrice = carPrice;
	}

	protected void showCarInfor() {
		System.out.println("Car Company = " + getCarCompany());
		System.out.println("Car Name = " + getCarName());
		System.out.println("Car Fuel Type = " + getFuelType());
		System.out.println("Car Speed = " + getCarSpeed());
		System.out.println("Car Price = " + getCarPrice());
	}

	public static void main(String[] args) {
		CarOOP honda = new CarOOP("Honda", "Camry", "Petro", 200f, 55000d);
		honda.showCarInfor();

		CarOOP mescedes = new CarOOP("Messcedes", "Ben", "Diesel", 300f, 70000d);
		// mescedes.carCompany = "Mescedes";
		// mescedes.carName = "Ben";
		// mescedes.fuelType = "Diesel";
		// mescedes.carSpeed = 350f;
		// mescedes.carPrice = 70000d;
		mescedes.showCarInfor();

	}
}
