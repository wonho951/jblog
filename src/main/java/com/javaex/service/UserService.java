package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;
import com.javaex.dao.UserDao;
import com.javaex.vo.BlogVo;
import com.javaex.vo.UserVo;

@Service
public class UserService {

	@Autowired
	//userdao
	private UserDao userDao;
	//blogdao
	private BlogDao blogDao;
	
	
	//회원가입
	public int join(UserVo userVo) {
		System.out.println("[UserService.join()]");
		
		int count = userDao.insert(userVo);
		
		
		//블로그가 만들어져야 함
		String id = userVo.getId();
		String blogTitle = userVo.getUserName() + "의 블로그입니다.";  
		String logoFile = "spring-logo.jps";
		
		BlogVo blogVo = new BlogVo(id, blogTitle, logoFile);
		blogDao.insert(blogVo);
		
				
		return count;
	}
	
	
	//아이디 중복체크
	public boolean getUser(String id) {
		System.out.println("[UserService.getUser(String)]");
		
		UserVo userVo = userDao.selectUser(id);
		System.out.println(userVo);
		
		if(userVo == null) {
			return true;
		}else {
			return false;
		}
		
	}
	
	
	//로그인
	public UserVo getUser(UserVo userVo) {
		System.out.println("[UserService.getUser()]");
		
		UserVo authUser = userDao.selectUser(userVo);
		
		return authUser;
	}
	
}
