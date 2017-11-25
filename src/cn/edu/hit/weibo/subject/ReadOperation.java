package cn.edu.hit.weibo.subject;

import cn.edu.hit.weibo.dao.BlogDao;
import cn.edu.hit.weibo.model.Blog;

  
    /**  
    * @ClassName: ReadOperation  
    * @Description: 阅读操作类
    * @author chenw  
    * @date 2017年11月25日  
    *    
    */  
    
public class ReadOperation extends Subject implements Observable{

	  
    

		/**  
	    * @Fields field:field:博客数据访问对象
	    */  
	    
	private BlogDao blogDao;
	  
	    /**  
	    * @Fields field:field:记录当前查询博客的id
	    */  
	    
	private Blog blog;
	
	  
	    /**  
	     * 创建一个新的实例 ReadOperation.  
	     *    
	     */  
	    
	public ReadOperation() {
		super();
		this.blogDao = new BlogDao();
	}
	
    

	public Blog getBlog() {
		return blog;
	}



	public void setBlog(Blog blog) {
		this.blog = blog;
	}



		/**  
	    * @Title: read  
	    * @Description: 阅读操作
	    * @param @param id
	    * @param @return    参数  
	    * @return Blog    返回类型  
	    * @throws  
	    */  
	    
	public Blog read(int id) {
		this.blog = blogDao.getBlogById(id);
		notifyObservers();
		return blog;
	}

}
