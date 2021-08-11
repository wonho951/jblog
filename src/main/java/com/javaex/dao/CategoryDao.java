package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.CategoryVo;

@Repository
public class CategoryDao {

	@Autowired
	private SqlSession sqlSession;
	
	//리스트 가져오기
	public List<CategoryVo> getCategoryList(String id){
		System.out.println("[CategoryDao.getCategoryList(id)] : " + id);
		
		return sqlSession.selectList("category.categoryList", id);
	}
	
}
