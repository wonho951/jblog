package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BlogVo;

@Repository
public class BlogDao {

	
	@Autowired
	private SqlSession sqlSession;
	
	
	
	//회원가입시 블로그 생성
	public int insert(BlogVo blogVo) {
		System.out.println("[BlogDao.insert()]");
		System.out.println(blogVo);
		
		
		return sqlSession.insert("blog.insertBlog", blogVo);
	}
}
