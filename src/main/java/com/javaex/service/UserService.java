package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;
import com.javaex.dao.CategoryDao;
import com.javaex.dao.UserDao;
import com.javaex.vo.BlogVo;
import com.javaex.vo.UserVo;

@Service
public class UserService {

	@Autowired	//하나에 하나씩이다...
	private UserDao userDao;  //userdao
	
	@Autowired
	private BlogDao blogDao;  //blogdao
	
	@Autowired
	private CategoryDao categoryDao;
	
	//회원가입
	public int join(UserVo userVo) {
		System.out.println("[UserService.join()]");
		
		int count = userDao.insert(userVo);
		
		//블로그가 만들어져야 함
		String id = userVo.getId();
		String blogTitle = userVo.getUserName() + "의 블로그입니다.";
		//String logoFile = "/assets/images/spring-logo.jpg";
		String logoFile = "";
		//String logoFile = null;	-> 애초에 null값 주는데 왜 오류나는거지
		
		
		BlogVo blogVo = new BlogVo(id, blogTitle, logoFile);
		System.out.println(blogVo);
		blogDao.insert(blogVo);
		/*
		blogVo.setId(userVo.getId());
		blogVo.setBlogTitle(userVo.getUserName() + "의 블로그입니다.");  
		blogVo.setLogoFile("/assets/images/spring-logo.jpg");
		blogVo.setUserName(userVo.getUserName());
		*/
		
		//카테고리 생성하려면 정보 넘겨야함
		categoryDao.insert(userVo);
	
		
		System.out.println("서비스 userVo:"+userVo);
		//blogDao.insert(userVo);
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
