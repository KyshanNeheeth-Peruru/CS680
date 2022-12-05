package edu.umb.cs680.hw12;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Collections;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class PriceComparatorTest {
	LinkedList<Car> carList = new LinkedList<Car>();

    @Test
	void testMileageComparator() {
    	Car a = new Car("A", "AA", 2010, 60, 167500);
		Car b = new Car("B", "BB", 2012, 40, 189000);
		Car c = new Car("C", "CC", 2014, 65, 119200);
		carList.add(a);
		carList.add(b);
		carList.add(c);
		Collections.sort(carList,new PriceComparator());
		assertEquals(b, carList.get(0));
		assertEquals(a, carList.get(1));
		assertEquals(c, carList.get(2));	
	}
}
