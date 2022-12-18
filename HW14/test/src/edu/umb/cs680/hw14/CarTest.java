package edu.umb.cs680.hw14;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.junit.jupiter.api.Test;
import edu.umb.cs680.hw14.Car;

class CarTest {
ArrayList<Car> CarList = new ArrayList<Car>();
	
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
	
	@Test
    public void testParetoComparator() {
		CarList.add(new Car("A", "aa", 2010, 60, 125000));
        CarList.add(new Car("B", "bb", 2020, 50, 225000));
        for (Car car : CarList)
        {
            car.setDominationCount(CarList);
        }
        Collections.sort(CarList, (Car car1, Car car2) -> car1.getDominationCount()-car2.getDominationCount());
        assertEquals("A", CarList.get(0).getMake());
        assertEquals("B", CarList.get(1).getMake());

    }
	
	@Test
    public void testMileageComparator() {
        CarList.add(new Car("A", "aa", 2010, 60, 125000));
        CarList.add(new Car("B", "bb", 2020, 50, 225000));
        Collections.sort(CarList,(Car car1, Car car2) -> car1.getMileage()-car2.getMileage());
        assertEquals(50,CarList.get(0).getMileage());
        assertEquals(60, CarList.get(1).getMileage());
    }
	
	@Test
    public void testMileageComparatorComparing() {
        CarList.add(new Car("A", "aa", 2010, 60, 125000));
        CarList.add(new Car("B", "bb", 2020, 50, 225000));
        Collections.sort(CarList,Comparator.comparing((Car car) -> car.getMileage()));
        assertEquals(50,CarList.get(0).getMileage());
        assertEquals(60, CarList.get(1).getMileage());
    }
	
	@Test
    public void testMileageComparatorNaturalOrder() {
        CarList.add(new Car("A", "aa", 2010, 60, 125000));
        CarList.add(new Car("B", "bb", 2020, 50, 225000));
        Collections.sort(CarList,Comparator.comparing(Car::getMileage,Comparator.naturalOrder()));
        assertEquals(50,CarList.get(0).getMileage());
        assertEquals(60, CarList.get(1).getMileage());
    }

    @Test
    public void testPriceComparator() {
    	CarList.add(new Car("A", "aa", 2010, 60, 125000));
        CarList.add(new Car("B", "bb", 2020, 50, 225000));
        Collections.sort(CarList,(Car car1, Car car2) -> (int) (car1.getPrice()-car2.getPrice()));
        assertEquals(125000,CarList.get(0).getPrice());
        assertEquals(225000, CarList.get(1).getPrice());
    }
    
    public void testPriceComparatorReverseOrder() {
    	CarList.add(new Car("A", "aa", 2010, 60, 125000));
        CarList.add(new Car("B", "bb", 2020, 50, 225000));
        Collections.sort(CarList,Comparator.comparing(Car::getPrice,Comparator.reverseOrder()));
        assertEquals(225000,CarList.get(0).getPrice());
        assertEquals(125000, CarList.get(1).getPrice());
    }


    @Test
    public void testYearComparator() {
    	CarList.add(new Car("A", "aa", 2010, 60, 125000));
        CarList.add(new Car("B", "bb", 2020, 50, 225000));
        Collections.sort(CarList, Comparator.comparing(Car::getYear));
        assertEquals(2010, CarList.get(0).getYear());
        assertEquals(2020, CarList.get(1).getYear());
    }
    
    @Test
    public void testYearComparatorReversed() {
    	CarList.add(new Car("A", "aa", 2010, 60, 125000));
        CarList.add(new Car("B", "bb", 2020, 50, 225000));
        //Collections.sort(CarList,Comparator.comparing(Car::getYear,Comparator.reverseOrder()));
        Collections.sort(CarList, Comparator.comparing((Car::getYear)).reversed());
        assertEquals(2020, CarList.get(0).getYear());
        assertEquals(2010, CarList.get(1).getYear());
    }

}
