package edu.umb.cs680.hw04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {
	private String[] carToStringArray(Car car) {
		String[] arr_car = {car.getMake(), car.getModel(), Integer.toString(car.getYear())};
		return arr_car;
	}
	
	@Test
	void verifyCarEqualityWithMakeModelYear() {
		String[] exp = {"Toyoto", "RAV4", "2018"};
		Car act = new Car("Toyoto", "RAV4", 2018, 250, 125000);
		assertArrayEquals(exp, carToStringArray(act) );
	}
}
