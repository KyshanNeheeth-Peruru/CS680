package edu.umb.cs680.hw12;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import edu.umb.cs680.hw12.Car;


class CarTest {

	private String[] carToStringArray(Car car) {
		String[] arr_car = {car.getMake(), car.getModel(), Integer.toString(car.getYear()),Integer.toString(car.getMileage()),Float.toString(car.getPrice())};
		return arr_car;
	}
	
	@Test
	void verifyCarEqualityWithMakeModelYear() {
		String[] exp = {"Toyoto", "RAV4", "2018", "250","125000.0"};
		Car act = new Car("Toyoto", "RAV4", 2018, 250, 125000);
		assertArrayEquals(exp, carToStringArray(act) );
	}

}
