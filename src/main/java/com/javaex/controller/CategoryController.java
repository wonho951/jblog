package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.CategoryService;
import com.javaex.vo.CategoryVo;

@Controller
//@RequestMapping(value = "/{id}/admin/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	

	//카테고리 리스트
	@ResponseBody
	@RequestMapping(value = "/{id}/admin/category/list", method = {RequestMethod.GET, RequestMethod.POST})
	public List<CategoryVo> List(@PathVariable("id") String id){
		System.out.println("[CategoryController.List()]");
		System.out.println("아이디 : " + id);
		
		List<CategoryVo> categoryList = categoryService.categoryList(id);
		
		System.out.println(categoryList);
		return categoryList;
	}
	
	
	//카테고리 추가
	@ResponseBody
	@RequestMapping(value = "/admin/category/add", method = {RequestMethod.GET, RequestMethod.POST})
	public CategoryVo add(@ModelAttribute CategoryVo categoryVo) {
		System.out.println("[CategoryController.add()]");
		System.out.println("vo :" + categoryVo);
		
		CategoryVo cateVo = categoryService.insert(categoryVo);
		System.out.println(cateVo);
		return cateVo;
	}
}
//너 저 유알엘 아뒤는 일부러빼고보내는거임?ㅇㅇㅇㅇㅋㅇㅋ? 뭐가어쨋다는거임?? 잘보셈 
