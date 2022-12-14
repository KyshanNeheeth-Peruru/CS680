package edu.umb.cs680.hw17;

public class TableObserver implements Observer {

	public void update(Observable sender, Object event) {
		StockEvent se = (StockEvent) event;
		System.out.println("Table Oberver:");
		System.out.println("Ticker:"+se.getTicker());
		System.out.println("Quote:"+se.getQuote());
	}

}
