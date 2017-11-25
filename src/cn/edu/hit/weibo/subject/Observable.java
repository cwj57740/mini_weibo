package cn.edu.hit.weibo.subject;

import cn.edu.hit.weibo.component.Observer;

public interface Observable {
	void registerObserver(Observer observer);
	void removeObserver(Observer observer);
	void notifyObservers();
}
