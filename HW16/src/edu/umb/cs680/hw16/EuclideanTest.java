package edu.umb.cs680.hw16;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class EuclideanTest {
	
	@Test
	public void testEuclideanTwo2DPoints() {
		List<Double> p1 = Arrays.asList(5.0, 8.0);
		List<Double> p2 = Arrays.asList(2.0, 4.0);
		double expected = 5;
		double actual = new Euclidean().distance(p1, p2);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testEuclideanTwo3DPoints() {
		List<Double> p1 = Arrays.asList(3.0, 8.0, 12.0);
		List<Double> p2 = Arrays.asList(4.0, 10.0, 6.0);
		double expected = Math.sqrt(41.0);
		double actual = new Euclidean().distance(p1, p2);
		assertEquals(expected, actual);
	}
}
