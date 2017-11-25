package cn.edu.hit.weibo.model;

  
    /**  
    * @ClassName: Log  
    * @Description: 日志实体类
    * @author chenw  
    * @date 2017年11月25日  
    *    
    */  
    
public class Log {
	
	//主键
	private int id;
	
	//博客外键
	private int bId;
	
	//执行数据操作
	private String operation;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBId() {
		return bId;
	}
	public void setBid(int bId) {
		this.bId = bId;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
}
