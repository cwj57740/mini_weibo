package cn.edu.hit.weibo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.hit.weibo.model.Blog;
import cn.edu.hit.weibo.util.JdbcUtils;

  
    /**  
    * @ClassName: BlogDao  
    * @Description: Blog数据访问类
    * @author chenw  
    * @date 2017年11月25日  
    *    
    */  
    
public class BlogDao {
	
	  
	    /**  
	    * @Title: addBlog  
	    * @Description: 添加博客
	    * @param @param blog    参数  
	    * @return int    返回类型  
	    * @throws  
	    */  
	    
	public int addBlog(Blog blog) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JdbcUtils.getConnection();
			String sql = "insert into blog (title,text) value(?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, blog.getTitle());
			pstmt.setString(2, blog.getText());
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
	        rs.next();
	        int key = rs.getInt(1);
	        return key;
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
		return -1;
	}
	  
	    /**  
	    * @Title: deleteBlog  
	    * @Description: 删除博客
	    * @param @param id    参数  
	    * @return void    返回类型  
	    * @throws  
	    */  
	    
	public void deleteBlog(int id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JdbcUtils.getConnection();
			String sql = "update blog set is_deleted = '1' where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
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
	  
	    /**  
	    * @Title: updateBlog  
	    * @Description: 修改博客（正文、标题、阅读次数）
	    * @param @param blog    参数  
	    * @return void    返回类型  
	    * @throws  
	    */  
	    
	public void updateBlog(Blog blog) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JdbcUtils.getConnection();
			String sql = "update blog set title = ?, text = ?, frequency = ? where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, blog.getTitle());
			pstmt.setString(2, blog.getText());
			pstmt.setInt(3, blog.getFequency());
			pstmt.setInt(4, blog.getId());
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
	  
	    /**  
	    * @Title: getAllBlogList  
	    * @Description: 获取所有博客(未被删除的)
	    * @param @return    参数  
	    * @return List<Blog>    返回类型  
	    * @throws  
	    */  
	    
	public List<Blog> getAllBlogList(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcUtils.getConnection();
			String sql = "select * from blog where is_deleted = '0'";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<Blog> blogList = new ArrayList<Blog>();
			while(rs.next()) {
				Blog blog = new Blog();
				blog.setId(rs.getInt(1));
				blog.setTitle(rs.getString(2));
				blog.setText(rs.getString(3));
				blog.setFequency(rs.getInt(4));
				blog.setIsDeleted(rs.getShort(5));
				blogList.add(blog);
			}
			return blogList;
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
		return null;
	}
	
	public Blog getBlogById(int id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcUtils.getConnection();
			String sql = "select * from blog where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			Blog blog = null;
			if(rs.next()) {
				blog = new Blog();
				blog.setId(rs.getInt(1));
				blog.setTitle(rs.getString(2));
				blog.setText(rs.getString(3));
				blog.setFequency(rs.getInt(4));
				blog.setIsDeleted(rs.getShort(5));
			}
			return blog;
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
		return null;
	}
}
