package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.CategoryDao;
import com.javaex.vo.CategoryVo;

@Service
public class CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	//리스트 가져오기
	/*public List<CategoryVo> categoryList(String id){
		System.out.println("[CategoryService.categoryList(id)] : " + id);
		
		return categoryDao.getCategoryList(id);
	}*/
	
	
	
	
	public List<CategoryVo> categoryList(String id){
		System.out.println("[CategoryService.categoryList(id)] ");
		
		return categoryDao.getCategoryList(id);
	}
}
