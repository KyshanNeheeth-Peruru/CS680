package edu.umb.cs680.hw17;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import edu.umb.cs680.hw17.StockQuoteObservable;
import edu.umb.cs680.hw17.TableObserver;

class TableObserverTest {
	StockQuoteObservable observable = new StockQuoteObservable();
	TableObserver tableObserver = new TableObserver();
	
	
	@Test
	void testLineChartObserverChangeQuoteOnce() {
		observable.addObserver(tableObserver);
		observable.changeQuote("1st change", 1.0);
	}
	
	@Test
	void testLineChartObserverChangeQuoteTwice() {
		observable.addObserver(tableObserver);
		observable.changeQuote("1st change", 1.0);
		observable.changeQuote("2nd change", 2.0);
	}

}
