package cn.edu.hit.weibo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import cn.edu.hit.weibo.model.Log;
import cn.edu.hit.weibo.util.JdbcUtils;

  
    /**  
    * @ClassName: LogDao  
    * @Description: 日志数据访问类
    * @author chenw  
    * @date 2017年11月25日  
    *    
    */  
    
public class LogDao {
	  
	    /**  
	    * @Title: addLog  
	    * @Description: 添加日志
	    * @param @param log    参数  
	    * @return void    返回类型  
	    * @throws  
	    */  
	    
	public void addLog(Log log) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JdbcUtils.getConnection();
			String sql = "insert into log (b_id,operation,time) value(?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, log.getBId());
			pstmt.setString(2, log.getOperation());
			pstmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
				if(con!=null){
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
