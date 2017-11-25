package cn.edu.hit.weibo.component;

import cn.edu.hit.weibo.dao.LogDao;
import cn.edu.hit.weibo.model.Log;
import cn.edu.hit.weibo.subject.ModifyOperation;

/**  
    * @ClassName: Logger  
    * @Description: 日志记录组件
    * @author chenw  
    * @date 2017年11月25日  
    *    
    */  
    
public class Logger extends Component implements Observer{

	private ModifyOperation modifyOperation;
	private Log log;
	private LogDao logDao;
	
	  
      
        /**  
         * 创建一个新的实例 Logger.  
         *  
         * @param modifyOperation  
         */  
        
    public Logger(ModifyOperation modifyOperation) {
		super();
		this.modifyOperation = modifyOperation;
		this.logDao = new LogDao();
	}


		/* (非 Javadoc)  
	    *   
	    *     
	    * @see cn.edu.hit.weibo.component.Component#update()  
	    */  
	    
	@Override public void update() {
		System.out.println("-------记录器-------");
		this.log = new Log();
		log.setOperation(modifyOperation.getOperation());
		log.setBid(modifyOperation.getBlog().getId());
		logDao.addLog(log);
		System.out.println("******日志添加完毕*******");
	}

}
