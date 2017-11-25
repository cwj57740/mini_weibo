package cn.edu.hit.weibo.component;

  
    /**  
    * @ClassName: Component  
    * @Description: 观察者抽象类
    * @author chenw  
    * @date 2017年11月25日  
    *    
    */  
    
public abstract class Component implements Observer {

	@Override
	public abstract void update();

}
