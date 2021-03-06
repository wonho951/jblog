package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BlogVo;

@Repository
public class BlogDao {

	
	@Autowired
	private SqlSession sqlSession;
	
	
	/*
	//회원가입시 블로그 생성
	public void insert(UserVo userVo) {
		System.out.println("[BlogDao.insert()]");
		System.out.println(userVo);
		
		String id = userVo.getId();
		String blogTitle = userVo.getUserName() + "의 블로그 입니다.";
		String logoFile = "/assets/images/spring-logo.jpg";
		
		BlogVo blogVo = new BlogVo(id, blogTitle, logoFile);
		System.out.println("블로그다오: " + blogVo);
		
		sqlSession.insert("blog.insertBlog", blogVo);
	}*/
	
	
	//회원가입시 블로그 생성
	public void insert(BlogVo blogVo) {
		System.out.println("[BlogDao.insert()]");
		System.out.println(blogVo);
		
		
		System.out.println("블로그다오: " + blogVo);
		
		sqlSession.insert("blog.insertBlog", blogVo);
	}
	
	
	
	//블로그 들어갈때 쓸 id 꺼내오기
	public BlogVo selectOne(String id) {
		System.out.println("[BlogDao.selectOne(id)]" + id);
		
		return sqlSession.selectOne("blog.selectOne", id);
	}
	
	
	//블로그 기본설정(타이틀, 이미지 바꾸기) -> int에서 void로 수정 -> 사진 있어도 없어도 업데이트 되기만 하면 그만이니깐..하..
	public void upload(BlogVo blogVo) {
		System.out.println("[BlogDao.upload(BlogVo blogVo)]");
		System.out.println(blogVo);
		
		sqlSession.update("blog.update", blogVo);
	}
	
	//블로그 기본설정(타이틀만 바꾸기)
	public void uploadTitle(BlogVo blogVo) {
		System.out.println("[BlogDao.uploadTitle(BlogVo blogVo)]");
		
		sqlSession.update("blog.updateTitle", blogVo);
		
	}
	
	
	
}
