package cn.edu.hit.weibo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import cn.edu.hit.weibo.model.Log;
import cn.edu.hit.weibo.util.JdbcUtils;

public class LogDao {
	public void addLog(Log log) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JdbcUtils.getConnection();
			String sql = "insert into log (id,b_id,operation,time) value(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, log.getId());
			pstmt.setInt(2, log.getBId());
			pstmt.setString(3, log.getOperation());
			pstmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
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
