package com.carportal.test.model;

import com.carportal.model.CarDetails;

public class TestCarDetail {

	public static void main(String[] args) {
		CarDetails car1 = new CarDetails();
		car1.setActive(true);
		car1.setCarDetailId(1L);
		car1.setCarManufacturer("BMW");
		car1.setCarModel("Z4");
		car1.setDescription("A Carrr");
		car1.setKiloMeterDriven(1200L);
		car1.setModelYear(2020);
		car1.setOwner("Samm");
		car1.setPrice(123456);

		CarDetails car2 = new CarDetails();
		car2.setActive(true);
		car2.setCarDetailId(1L);
		car2.setCarManufacturer("BMW");
		car2.setCarModel("Z4");
		car2.setDescription("A Carrr");
		car2.setKiloMeterDriven(1200L);
		car2.setModelYear(2020);
		car2.setOwner("Samm");
		car2.setPrice(123456);

		System.out.println(car1 == car2);
		System.out.println("Car1 equal car2 " + car1.equals(car2));
		System.out.println("car1 hashcode " + car1.hashCode());
		System.out.println("car2 hashcode " + car2.hashCode());
		System.out.println(car1.toString());
	}

}
