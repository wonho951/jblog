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
@RequestMapping(value = "/{id}/admin/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	/*@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public List<CategoryVo> List(@PathVariable("id") String id){
		System.out.println("[ApiCategoryController.List()]");
		
		List<CategoryVo> categoryList = categoryService.categoryList(id);
		
		System.out.println(categoryList);
		
		return categoryList;
	}*/
	
	@ResponseBody
	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public List<CategoryVo> List(@PathVariable("id") String id){
		System.out.println("[ApiCategoryController.List()] zzzzzzzzzzzzzzzz" + id);
		
		
		List<CategoryVo> categoryList = categoryService.categoryList(id);
		
		System.out.println(categoryList);
		return categoryList;
	}
	
}
