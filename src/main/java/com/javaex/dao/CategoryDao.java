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
		
		return sqlSession.selectList("category.categoryList", id);
	}
}
