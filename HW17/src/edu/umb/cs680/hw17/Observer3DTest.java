package edu.umb.cs680.hw17;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class Observer3DTest {
	StockQuoteObservable observable = new StockQuoteObservable();
	Observer3D D3Observer = new Observer3D();
	
	@Test
	void test3DObserverChangeQuoteOnce() {
		observable.addObserver(D3Observer);
		observable.changeQuote("1st change", 1.0);
	}
	
	@Test
	void test3DObserverChangeQuoteTwice() {
		observable.addObserver(D3Observer);
		observable.changeQuote("1st change", 1.0);
		observable.changeQuote("2nd change", 2.0);
	}

}
