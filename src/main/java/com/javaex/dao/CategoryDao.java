package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.CategoryVo;
import com.javaex.vo.UserVo;

@Repository
public class CategoryDao {

	@Autowired
	private SqlSession sqlSession;
	
	
	//회원정보 받아서 카테고리 생성
	public void insert(UserVo userVo) {
		System.out.println("[CategoryDao.insert]");
		System.out.println(userVo);
		
		
		String id = userVo.getId();
		String cateName = "미분류";
		String description = "기본으로 만들어지는 카테고리 입니다.";
		
		CategoryVo categoryVo = new CategoryVo(id, cateName, description);
		
		sqlSession.insert("category.insert", categoryVo);
	}
	
	
	//리스트 가져오기
	public List<CategoryVo> getCategoryList(String id){
		System.out.println("[CategoryDao.getCategoryList(id)]");
		System.out.println(id);
		
		//return sqlSession.selectList("category.categoryList", id);
		return sqlSession.selectList("category.countList", id);
	}
	
	
	//카테고리 추가 
	public int insertCategory(CategoryVo categoryVo) {
		System.out.println("[CategoryDao.insert]");
		System.out.println("xml가기전 : " + categoryVo);
		
		int count = sqlSession.insert("category.categoryInsert", categoryVo);
		System.out.println("xml갔다온후 : " + categoryVo);
		return count;
	}
	
	
	//카테고리 1개 꺼내오기
	public CategoryVo selectCategory(int cateNo) {
		System.out.println("[CategoryDao.selectCategory]");
		
		return sqlSession.selectOne("category.selectCategory", cateNo);
	}
	
	/*
	//카테고리 삭제
	public int categoryRemove(int cateNo) {
		System.out.println("[CategoryDao.categoryRemove]");
		System.out.println("다오다오이리로 와다오 :" + cateNo);
		
		int count = sqlSession.delete("category.categoryRemove", cateNo);
		System.out.println("xml갔다옴? : " + cateNo);
		return count;
	}*/
	
	
	//포스트 카운트 가져오기
	public CategoryVo countSelect(int cateNo) {
		System.out.println("카운트 가져오기 :" + cateNo);
		
		CategoryVo postCount = sqlSession.selectOne("category.postCount", cateNo);
		System.out.println("정보좀 주쇼 : " + postCount.getPostCount());
		
		return postCount;
	}
	
	
	//카테고리 삭제
	public int categoryRemove(int cateNo) {
		System.out.println("[CategoryDao.categoryRemove]");
		System.out.println("다오다오이리로 와다오 :" + cateNo);
		
		int count = sqlSession.delete("category.categoryRemove", cateNo);
		System.out.println("xml갔다옴? : " + cateNo);
		return count;
	}
	
	
	
	
}
