package cn.edu.hit.weibo.subject;

import cn.edu.hit.weibo.component.Observer;

  
    /**  
    * @ClassName: Observable  
    * @Description: 被观察者接口
    * @author chenw  
    * @date 2017年11月25日  
    *    
    */  
    
public interface Observable {
	  
	    /**  
	    * @Title: registerObserver  
	    * @Description: 注册观察者
	    * @param @param observer    参数  
	    * @return void    返回类型  
	    * @throws  
	    */  
	    
	void registerObserver(Observer observer);
	  
	    /**  
	    * @Title: removeObserver  
	    * @Description: 移除观察者
	    * @param @param observer    参数  
	    * @return void    返回类型  
	    * @throws  
	    */  
	    
	void removeObserver(Observer observer);
	  
	    /**  
	    * @Title: notifyObservers  
	    * @Description: 通知观察者列表 
	    * @param     参数  
	    * @return void    返回类型  
	    * @throws  
	    */  
	    
	void notifyObservers();
}
