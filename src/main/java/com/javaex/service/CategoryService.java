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
	
	
	
	//리스트 가져오기
	public List<CategoryVo> categoryList(String id){
		System.out.println("[CategoryService.categoryList(id)] ");
		System.out.println(id);
		
		return categoryDao.getCategoryList(id);
	}
	
	
	//카테고리 등록
	public CategoryVo insert(CategoryVo categoryVo) {
		System.out.println("[CategoryService.insert()]");
		
		System.out.println("가기전" + categoryVo);		
		categoryDao.insertCategory(categoryVo);
		System.out.println("갔다온 후" + categoryVo);
		
		int cateNo = categoryVo.getCateNo();
		
		//글 가져오기
		CategoryVo cateVo = categoryDao.selectCategory(cateNo);
		System.out.println("카테써 글하나가져올거냐::" + cateNo);
		
		return cateVo;
	}
	
	/*
	//삭제
	public boolean removeCategory(int cateNo) {
		System.out.println("[CategoryService.removeCategory()]");
		System.out.println("서비스 :" + cateNo);
		
		CategoryVo postCount = categoryDao.countSelect(cateNo);
		
		int Pcount = postCount.getPostCount();
		
		if(Pcount == 0 ) {
			categoryDao.categoryRemove(cateNo);
			
			return true;
		}else {
			return false;
		}
		
	}*/
	
	
	
	//삭제
	public int removeCategory(int cateNo) {
		System.out.println("[CategoryService.removeCategory()]");
		System.out.println("서비스 :" + cateNo);
		
		return categoryDao.categoryRemove(cateNo);
	}
	
	
	
	
	
	
	
	
}
