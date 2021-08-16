package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PostVo;

@Repository
public class PostDao {

	@Autowired
	private SqlSession sqlSession;
	
	//포스트하기(글쓰기)
	public void postInsert(PostVo postVo) {
		System.out.println("다오: " + postVo);
		
		//sqlSession.insert("post.insertPost", postVo);
		System.out.println("xml갔다온거 : " + postVo);
		
		sqlSession.insert("post.insertPost", postVo);
	}
	
	
	
	//포스트 리스트
	public List<PostVo> postList(int cateNo){
		System.out.println("[PostDao.postList()]");
		
		return sqlSession.selectList("post.postList", cateNo);
	}
	
	
	//포스트 한개만 가져오기
	public PostVo postSelect(int postNo) {
		System.out.println("[PostDao.postSelect()]");
		
		return sqlSession.selectOne("post.postSelect", postNo);
	}
	
	
}
