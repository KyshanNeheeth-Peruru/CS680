package edu.umb.cs680.hw02;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PrimeGeneratorTest {

	@Test
	 public void primes1to20() {
	       PrimeGenerator pg = new PrimeGenerator(1, 20);
	       pg.generatePrimes();
	       Long[] expectedprimes = {2L, 3L, 5L, 7L,11L, 13L, 17L, 19L};
	       assertArrayEquals(expectedprimes, pg.getPrimes().toArray());
	 }

	 @Test
	 public void noPrimes62to66() {
	       PrimeGenerator pg = new PrimeGenerator(62, 66);
	       pg.generatePrimes();
	       assertEquals(pg.getPrimes().size(), 0);
	 }
	 
	 @Test
	 public void inputValues10to0() {
		 try {
			 PrimeGenerator pg = new PrimeGenerator(10, 0);
			 pg.generatePrimes();
			 }
		 catch (RuntimeException ex) {
			 assertEquals("Wrong input values: from=10 to=0", ex.getMessage());
			 }
		 }

	 @Test
	 public void equalFromAndToValues6to6() {
		 try {
	            PrimeGenerator pg = new PrimeGenerator(6, 6);
	            pg.generatePrimes();
	        }
		 catch (RuntimeException ex) {
	            assertEquals("Wrong input values: from=6 to=6", ex.getMessage());
	        }
	    }

	 @Test
	 public void inputNegativeValues() {
		 try {
	            PrimeGenerator pg = new PrimeGenerator(-10, -1);
	            pg.generatePrimes();
	        }
		 catch (RuntimeException ex) {
	            assertEquals("Wrong input values: from=-10 to=-1", ex.getMessage());
	        }
	 }

}
