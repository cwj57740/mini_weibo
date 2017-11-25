package cn.edu.hit.weibo.model;

  
    /**  
    * @ClassName: Blog  
    * @Description: 博客实体类 
    * @author chenw  
    * @date 2017年11月25日  
    *    
    */  
    
public class Blog {

	//主键
	private int id;
	
	//标题
	private String title;
	
	//正文
	private String text;
	
	//阅读次数
	private int fequency;
	
	//是否删除
	private int isDeleted;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getFequency() {
		return fequency;
	}
	public void setFequency(int fequency) {
		this.fequency = fequency;
	}
	public int getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
}
