package cn.edu.hit.weibo.component;

import cn.edu.hit.weibo.dao.BlogDao;
import cn.edu.hit.weibo.model.Blog;
import cn.edu.hit.weibo.subject.ReadOperation;

/**  
    * @ClassName: Counter  
    * @Description: 阅读计数组件
    * @author chenw  
    * @date 2017年11月25日  
    *    
    */  
    
public class Counter extends Component implements Observer{

	private ReadOperation readOperation;
	private BlogDao blogDao;
	
	  
	    /**  
	     * 创建一个新的实例 Counter.  
	     *  
	     * @param readOperation  
	     */  
	    
	public Counter(ReadOperation readOperation) {
		this.blogDao = new BlogDao();
		this.readOperation = readOperation;
	}

	  
	    /* (非 Javadoc)  
	    *   
	    *     
	    * @see cn.edu.hit.weibo.component.Component#update()  
	    */  
	    
	@Override
	public void update() {
		System.out.println("-------计数器-------");
		Blog blog = readOperation.getBlog();
		blog.setFequency(blog.getFequency()+1);
		blogDao.updateBlog(blog);
		System.out.println("*******阅读次数增加*******");
	}

}
