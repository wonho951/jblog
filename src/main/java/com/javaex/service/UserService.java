package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	
	//회원가입
	public int join(UserVo userVo) {
		System.out.println("[UserService.join()]");
		
		return userDao.insert(userVo);
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
	
}
