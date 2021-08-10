package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BlogVo;
import com.javaex.vo.UserVo;

@Repository
public class BlogDao {

	
	@Autowired
	private SqlSession sqlSession;
	
	
	
	//회원가입시 블로그 생성
	public void insert(UserVo userVo) {
		System.out.println("[BlogDao.insert()]");
		
		BlogVo blogVo = new BlogVo();
		
		
		System.out.println(blogVo);
		
		
		sqlSession.insert("blog.insertBlog", blogVo);
	}
}
