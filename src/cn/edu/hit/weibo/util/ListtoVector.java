package cn.edu.hit.weibo.util;

import java.util.List;
import java.util.Vector;

import cn.edu.hit.weibo.model.Blog;

public class ListtoVector {
	public Vector<Vector<String>> toVector(List<Blog> blogList){
		Vector<Vector<String>> vec = new Vector<Vector<String>>();
		for(int i=0;i<blogList.size();i++){
			Blog blog = blogList.get(i);
			String isDeleted = null;
			if(blog.getIsDeleted() == 0){
				isDeleted = "否";
			}else{
				isDeleted = "是";
			}
			String id = Integer.toString(blog.getId());
			String title = blog.getTitle();
			String text = blog.getText();
			String fequency = Integer.toString(blog.getFequency());
			Vector<String> combvec = new Vector<String>();
			combvec.add(id);
			combvec.add(title);
			combvec.add(text);
			combvec.add(fequency);
			combvec.add(isDeleted);
			vec.add(combvec);
		}
		return vec;
	}

}
