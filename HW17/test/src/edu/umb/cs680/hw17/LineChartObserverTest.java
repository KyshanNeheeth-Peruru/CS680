package src.edu.umb.cs680.hw17;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import edu.umb.cs680.hw17.LineChartObserver;
import edu.umb.cs680.hw17.StockQuoteObservable;

class LineChartObserverTest {
	StockQuoteObservable observable = new StockQuoteObservable();
	LineChartObserver lineChartObserver = new LineChartObserver();
	
	
	@Test
	void testLineChartObserverChangeQuoteOnce() {
		observable.addObserver(lineChartObserver);
		observable.changeQuote("1st change", 1.0);
	}
	
	@Test
	void testLineChartObserverChangeQuoteTwice() {
		observable.addObserver(lineChartObserver);
		observable.changeQuote("1st change", 1.0);
		observable.changeQuote("2nd change", 2.0);
	}
}
