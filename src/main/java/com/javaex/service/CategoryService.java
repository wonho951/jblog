package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.CategoryDao;
import com.javaex.dao.PostDao;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.PostVo;

@Service
public class CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private PostDao postDao;
	
	
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
	
	
	
	//블로그 메인화면에 뿌려줄 데이터 
	public Map<String, Object> categoryMap(String id, int cateNo, int postNo){
		System.out.println("CategoryService.categoryMap()");
		
		Map<String, Object> listMap = new HashMap<String, Object>();
		
		List<CategoryVo> categoryList = categoryDao.getCategoryList(id);
		System.out.println("categoryList");
		
		
		if(cateNo == 0) {
			cateNo = categoryList.get(0).getCateNo();
			System.out.println("cateNo:" + cateNo);
		}
		
		
		
		List<PostVo> postList = postDao.postList(cateNo);
		
		
		if (postList.size() != 0) {
			
			if (postNo == 0) {
				postNo = postList.get(0).getPostNo();
				System.out.println("서비스1-postNo:" + postNo);
			}
		}
		
		System.out.println("서비스2-postNo" + postNo);
		
		PostVo postVo = postDao.postSelect(postNo);
		System.out.println(postVo);
		
		listMap.put("categoryList", categoryList);
		listMap.put("postList", postList);
		listMap.put("postVo", postVo);
		
		
		
		return listMap;
		
		
		
		
		
	}
	
	
	
	
}
