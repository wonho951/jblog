package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;
import com.javaex.vo.BlogVo;

@Service
public class BlogService {

	@Autowired
	private BlogDao blogDao;
	
	//블로그 들어갈때 쓸 id 꺼내오기
	public BlogVo selectOne(String id) {
		System.out.println("[BlogService.selectOne(id)]" + id);
		
		return blogDao.selectOne(id);
	}
	
	
	
	
}
