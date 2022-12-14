package edu.umb.cs680.hw17;

import java.util.LinkedList;
import java.util.List;

public abstract class Observable<StockEvent> {
	private LinkedList<Observer<StockEvent>> observers = new LinkedList<>();
	
	public Observable() {
		observers = new LinkedList<Observer<StockEvent>>();
	}
	
	public void addObserver(Observer<StockEvent> o) {
		observers.add(o);
	}
	
	public void removeObserver(Observer<StockEvent> o) {
		observers.remove(o);
	}
	
	public int countObservers() {
		return observers.size();	
	}

	public List<Observer<StockEvent>> getObservers(){
		return observers;
	}
	
	public void clearObservers() {
		observers.clear();
	}

	public void notifyObservers(StockEvent event) {
		observers.forEach( (observer)->{observer.update(this, event);} );
	}

}
