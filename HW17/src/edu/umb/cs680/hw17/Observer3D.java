package edu.umb.cs680.hw17;

public class Observer3D implements Observer<StockEvent> {
	public void update(Observable<StockEvent> sender, StockEvent event) {
		StockEvent se = (StockEvent) event;
		System.out.println("3D Observer:");
		System.out.println("Ticker:"+se.getTicker());
		System.out.println("Quote:"+se.getQuote());	
	}
}
