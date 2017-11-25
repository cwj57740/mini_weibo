package cn.edu.hit.weibo.subject;

import cn.edu.hit.weibo.dao.BlogDao;
import cn.edu.hit.weibo.model.Blog;

  
    /**  
    * @ClassName: ModifyOperation  
    * @Description: 修改操作类
    * @author chenw  
    * @date 2017年11月25日  
    *    
    */  
    
public class ModifyOperation extends Subject implements Observable{
	private BlogDao blogDao;
	  
	    /**  
	    * @Fields field:field:记录操作信息
	    */  
	    
	private String operation;
	  
	    /**  
	    * @Fields field:field:记录被操作的微博  
	    */  
	    
	private Blog blog;
	
	  
    public String getOperation() {
		return operation;
	}


	public void setOperation(String operation) {
		this.operation = operation;
	}


	public Blog getBlog() {
		return blog;
	}


	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	  
	    /**  
	    * @Title: add  
	    * @Description: 新增微博
	    * @param @param blog    参数  
	    * @return void    返回类型  
	    * @throws  
	    */  
	    
	public void add(Blog blog) {
		this.blog = blog;
		blogDao.addBlog(blog);
		operation = "新增微博";
		notifyObservers();
	}


		/**  
	    * @Title: modify  
	    * @Description: 修改微博
	    * @param @param blog    参数  
	    * @return void    返回类型  
	    * @throws  
	    */  
	    
	public void modify(Blog blog) {
		this.blog = blog;
		blogDao.updateBlog(blog);
		operation = "微博内容更改";
		notifyObservers();
	}

	  
	    /**  
	    * @Title: delete  
	    * @Description: 删除微博 
	    * @param @param blog    参数  
	    * @return void    返回类型  
	    * @throws  
	    */  
	    
	public void delete(Blog blog) {
		this.blog = blog;
		blogDao.deleteBlog(blog.getId());
		operation = "微博删除";
		notifyObservers();
	}
}
