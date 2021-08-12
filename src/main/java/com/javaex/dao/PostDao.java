package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.CategoryVo;
import com.javaex.vo.PostVo;
import com.javaex.vo.UserVo;

@Repository
public class PostDao {

	@Autowired
	private SqlSession sqlSession;
	
	/* 회원가입시 포스트 기본생성 */
	public void insert(UserVo userVo) {
		System.out.println("[PostDao.insert()]");
		
		CategoryVo categoryVo = new CategoryVo();
		
		int cateNo = categoryVo.getCateNo();
		
		String postContent = "";
		
		
		PostVo postVo = new PostVo();
	}
	
	
}
