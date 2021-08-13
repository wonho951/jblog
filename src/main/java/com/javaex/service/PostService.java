package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PostDao;
import com.javaex.vo.PostVo;

@Service
public class PostService {

	@Autowired
	private PostDao postDao;
	
	
	//포스트하기(글쓰기)
	public void insertPost(PostVo postVo) {
		System.out.println("서비스 : " + postVo);
		
		//postDao.postInsert(postVo);
		System.out.println("다오 갔다온거 : " + postVo);
		
		
		postDao.postInsert(postVo);
	}
}
