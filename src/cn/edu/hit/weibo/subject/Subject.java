package cn.edu.hit.weibo.subject;

import java.util.ArrayList;
import java.util.List;

import cn.edu.hit.weibo.component.Observer;

  
    /**  
    * @ClassName: Subject  
    * @Description: 事件类
    * @author chenw  
    * @date 2017年11月25日  
    *    
    */  
    
public abstract class Subject implements Observable {

	  
	    /**  
	    * @Fields field:field:观察者列表
	    */  
	    
	private List<Observer> observers;
	
	  
	    /**  
	     * 创建一个新的实例 Subject.  
	     *    
	     */  
	    
	public Subject(){
		observers = new ArrayList<Observer>();
	}
	
	  
	    /* (非 Javadoc)  
	    *   
	    *   
	    * @param observer  
	    * @see cn.edu.hit.weibo.subject.Observable#registerObserver(cn.edu.hit.weibo.component.Observer)  
	    */  
	    
	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	  
	    /* (非 Javadoc)  
	    *   
	    *   
	    * @param observer  
	    * @see cn.edu.hit.weibo.subject.Observable#removeObserver(cn.edu.hit.weibo.component.Observer)  
	    */  
	    
	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	  
	    /* (非 Javadoc)  
	    *   
	    *     
	    * @see cn.edu.hit.weibo.subject.Observable#notifyObservers()  
	    */  
	    
	@Override
	public void notifyObservers() {
		for(Observer observer: observers) {
			observer.update();
		}
	}

}
