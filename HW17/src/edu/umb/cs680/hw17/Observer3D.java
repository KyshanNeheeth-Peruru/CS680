package edu.umb.cs680.hw17;

public class Observer3D implements Observer {
	public void update(Observable sender, Object event) {
		StockEvent se = (StockEvent) event;
		System.out.println("3D Observer:");
		System.out.println("Quote:"+se.getQuote());
		System.out.println("Ticker:"+se.getTicker());		
	}
}
