package src.edu.umb.cs680.hw16;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import edu.umb.cs680.hw16.Chebyshev;
import edu.umb.cs680.hw16.Distance;
import edu.umb.cs680.hw16.Euclidean;

class DistanceTest {
	private static List<Double> p1, p2, p3, p4, p5;
	private static List<List<Double>> pointsList = new LinkedList<>();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		p1 = Arrays.asList(2.0, 4.0, 6.0);
		p2 = Arrays.asList(3.0, 5.0, 7.0);
		p3 = Arrays.asList(1.0, 3.0, 5.0);
		p4 = Arrays.asList(3.0, 6.0, 9.0);
		p5 = Arrays.asList(4.0, 8.0, 5.0);
		pointsList.add(p1);
		pointsList.add(p2);
		pointsList.add(p3);
		pointsList.add(p4);
		pointsList.add(p5);
	}

	@Test
	public void testP1P2Distance() {
		double expected = Math.sqrt(3.0);
		double actual = Distance.get(p1, p2);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testP2p3Euclidean() {
		double expected = Math.sqrt(12.0);
		double actual = Distance.get(p2, p3, new Euclidean());
		assertEquals(expected, actual);
	}

	@Test
	public void testP3P4ManhattanWithLE() {
		double expected = 9.0;
		double actual = Distance.get(p3, p4, (List<Double> point1, List<Double> point2) -> IntStream.range(0, point1.size()).mapToDouble(i -> Math.abs(point1.get(i) - point2.get(i))).sum());
		assertEquals(expected, actual);
	}
	
	@Test
	public void testP4P5Chebyshev() {
		double expected = 4.0;
		double actual = Distance.get(p4, p5, new Chebyshev());
		assertEquals(expected, actual);
	}
	
	@Test
	public void testDistanceMatrix() {
		Double[][] expected = {{0.0,Math.sqrt(3.0),Math.sqrt(3.0),Math.sqrt(14.0),Math.sqrt(21.0)},
				{Math.sqrt(3.0),0.0, Math.sqrt(12.0), Math.sqrt(5.0), Math.sqrt(14.0)},
				{Math.sqrt(3.0),Math.sqrt(12.0),0.0,Math.sqrt(29.0),Math.sqrt(34.0)},
				{Math.sqrt(14.0),Math.sqrt(5.0),Math.sqrt(29.0),0.0,Math.sqrt(21.0)},
				{Math.sqrt(21.0),Math.sqrt(14.0),Math.sqrt(34.0),Math.sqrt(21.0),0.0}};
		List<List<Double>> actual = Distance.matrix(pointsList);
		for (int i = 0; i < expected.length; i++)
		{
			Double[] temp = new Double[5];
			assertArrayEquals(expected[i], actual.get(i).toArray(temp));
		}
	}
	
	@Test
	public void testDistanceMatrixMahattanUsingLE() {
		Double[][] expected = {{0.0,3.0,3.0,6.0,7.0},
				{3.0,0.0,6.0,3.0,6.0},
				{3.0,6.0,0.0,9.0,8.0},
				{6.0,3.0,9.0,0.0,7.0},
				{7.0,6.0,8.0,7.0,0.0}};
		List<List<Double>> actual = Distance.matrix(pointsList, (List<Double> point1, List<Double> point2) -> IntStream.range(0, point1.size()).mapToDouble(i -> Math.abs(point1.get(i) - point2.get(i))).sum());
		for (int i = 0; i < expected.length; i++)
		{
			Double[] temp = new Double[5];
			assertArrayEquals(expected[i], actual.get(i).toArray(temp));
		}
	}
}
