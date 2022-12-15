package src.edu.umb.cs680.hw17;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import edu.umb.cs680.hw17.LineChartObserver;
import edu.umb.cs680.hw17.Observer3D;
import edu.umb.cs680.hw17.StockQuoteObservable;
import edu.umb.cs680.hw17.TableObserver;

class ObservableTest {

	@Test
	void testLineChartObserver() {
		StockQuoteObservable o = new StockQuoteObservable();
		LineChartObserver lco = new LineChartObserver();
		o.addObserver(lco);
		o.changeQuote("Line Chart", 1.0);
		o.changeQuote("Line Chart Observer", 2.0);
	}
	
	@Test
	void testTableObserver() {
		StockQuoteObservable o = new StockQuoteObservable();
		TableObserver t = new TableObserver();
		o.addObserver(t);
		o.changeQuote("Table", 1.0);
		o.changeQuote("Table Observer", 2.0);
	}
	
	@Test
	void test3DObserver() {
		StockQuoteObservable o = new StockQuoteObservable();
		Observer3D D3 = new Observer3D();
		o.addObserver(D3);
		o.changeQuote("3D", 1.0);
		o.changeQuote("3D Observer", 2.0);
	}
	
	@Test
	void testCountObservers () {
		StockQuoteObservable obs = new StockQuoteObservable();
		LineChartObserver lco = new LineChartObserver();
		obs.addObserver(lco);
		TableObserver t = new TableObserver();
		obs.addObserver(t);
		Observer3D D3 = new Observer3D();
		obs.addObserver(D3);
		assertEquals(3,obs.countObservers());
		obs.removeObserver(lco);
		assertEquals(2,obs.countObservers());
		obs.removeObserver(t);
		assertEquals(1,obs.countObservers());
		obs.removeObserver(D3);
		assertEquals(0,obs.countObservers());	
	}
	
	@Test
	void testCountObserversAndClearObservers () {
		StockQuoteObservable obs = new StockQuoteObservable();
		LineChartObserver lco = new LineChartObserver();
		obs.addObserver(lco);
		TableObserver t = new TableObserver();
		obs.addObserver(t);
		Observer3D D3 = new Observer3D();
		obs.addObserver(D3);
		assertEquals(3,obs.countObservers());
		obs.clearObservers();
		assertEquals(0,obs.countObservers());
	}
	
	@Test
	void testGetObservers () {
		StockQuoteObservable obs = new StockQuoteObservable();
		LineChartObserver lco = new LineChartObserver();
		obs.addObserver(lco);
		TableObserver t = new TableObserver();
		obs.addObserver(t);
		Observer3D D3 = new Observer3D();
		obs.addObserver(D3);
		assertEquals(3,obs.countObservers());
		assertSame(lco,obs.getObservers().get(0));
		assertSame(t,obs.getObservers().get(1));
		assertSame(D3,obs.getObservers().get(2));
	}
}
