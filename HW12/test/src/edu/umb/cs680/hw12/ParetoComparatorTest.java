package edu.umb.cs680.hw12;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Collections;
import org.junit.jupiter.api.Test;
import edu.umb.cs680.hw12.Car;
import edu.umb.cs680.hw12.ParetoComparator;

class ParetoComparatorTest {
	ArrayList<Car> ListOfCars = new ArrayList<Car>();

	@Test
	public void verifyParetoCompare1() {
		Car a = new Car("A", "AA", 2015, 25, 100000);
		Car b = new Car("B", "BB", 2010, 40, 100000);
		Car c = new Car("C", "CC", 2012, 25, 100000);
		ListOfCars.add(a);
		ListOfCars.add(b);
		ListOfCars.add(c);
		for (Car car : ListOfCars) {
			car.setDominationCount(ListOfCars);
		}
		Collections.sort(ListOfCars, new ParetoComparator());
		assertEquals(a, ListOfCars.get(0));
		assertEquals(c, ListOfCars.get(1));
		assertEquals(b, ListOfCars.get(2));	
	}
}
