package src.edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import edu.umb.cs680.hw11.Manhattan;

class ManhattanTest {
	
	@Test
	public void testManhattanTwo2DPoints() 
	{
		List<Double> p1 = Arrays.asList(4.0, 8.0);
		List<Double> p2 = Arrays.asList(16.0, 25.0);
		double expected = 29;
		double actual = new Manhattan().distance(p1, p2);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testManhattanTwo3DPoints() 
	{
		List<Double> p1 = Arrays.asList(15.0, 8.0, 20.0);
		List<Double> p2 = Arrays.asList(10.0, 12.0, 18.0);
		double expected = 11;
		double actual = new Manhattan().distance(p1, p2);
		assertEquals(expected, actual);
	}
}
