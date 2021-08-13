package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {

	@Autowired
	private SqlSession sqlSession;
	
	
	//회원가입
	public int insert(UserVo userVo) {
		System.out.println("[UserDao.join()]");
		System.out.println("다오 : " + userVo);
		
		return sqlSession.insert("user.insertUser", userVo);
	}
	
	
	//아이디 중복 체크
	public UserVo selectUser(String id) {
		System.out.println("[UserDao.selectUser(String)]");
		System.out.println(id);
		
		
		return sqlSession.selectOne("user.selectUserById", id);
	}
	
	
	//로그인
	public UserVo selectUser(UserVo userVo) {
		System.out.println("[UserDao.selectUser()]");
		System.out.println(userVo);
		
		return sqlSession.selectOne("user.selectUser", userVo);
	}
}
