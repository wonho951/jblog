package com.javaex.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.CategoryService;
import com.javaex.vo.CategoryVo;

@Controller
@RequestMapping(value = "/{id}/api/category")
public class ApiCategoryController {

	@Autowired
	private CategoryService categoryService;
	
	/*@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public List<CategoryVo> List(@PathVariable("id") String id){
		System.out.println("[ApiCategoryController.List()]");
		
		List<CategoryVo> categoryList = categoryService.categoryList(id);
		
		System.out.println(categoryList);
		
		return categoryList;
	}*/
	
	
	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public List<CategoryVo> List(@ModelAttribute CategoryVo categoryVo){
		System.out.println("[ApiCategoryController.List()]");
		
		List<CategoryVo> categoryList = categoryService.categoryList(categoryVo.getId());
		
		System.out.println(categoryList);
		
		return categoryList;
	}
	
}
