package edu.umb.cs680.hw16;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class ChebyshevTest {
	
	@Test
	public void testChebyshevTwo2DPoints() {
		List<Double> p1 = Arrays.asList(5.0, 10.0);
		List<Double> p2 = Arrays.asList(3.0, 6.0);
		double expected = 4;
		double actual = new Chebyshev().distance(p1, p2);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testChebyshevTwo3DPoints() {
		List<Double> p1 = Arrays.asList(5.0, 10.0, 15.0);
		List<Double> p2 = Arrays.asList(3.0, 6.0, 9.0);
		double expected = 6;
		double actual = new Chebyshev().distance(p1, p2);
		assertEquals(expected, actual);
	}
}
