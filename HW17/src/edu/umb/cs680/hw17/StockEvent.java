package edu.umb.cs680.hw17;

public class StockEvent {
	String ticker;
	double quote;
	
	public StockEvent(String s, double q) {
		this.ticker = s;
		this.quote = q;
	}
	
	public String getTicker() {
		return ticker;
	}
	
	public double getQuote() {
		return quote;
	}
}
