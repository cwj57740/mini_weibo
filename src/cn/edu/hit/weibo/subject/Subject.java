package cn.edu.hit.weibo.subject;

import java.util.ArrayList;
import java.util.List;

import cn.edu.hit.weibo.component.Observer;

public abstract class Subject implements Observable {

	private List<Observer> observers;
	
	public Subject(){
		observers = new ArrayList<Observer>();
	}
	
	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for(Observer observer: observers) {
			observer.update();
		}
	}

}
