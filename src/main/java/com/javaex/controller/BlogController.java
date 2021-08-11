package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.BlogService;
import com.javaex.service.CategoryService;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;

@Controller
public class BlogController {

	@Autowired
	private BlogService blogService;
	
	@Autowired
	private CategoryService categoryService;
	//블로그 메인
	@RequestMapping(value = "/{id}", method = {RequestMethod.GET, RequestMethod.POST})
	public String main(Model model, @PathVariable("id") String id ) {
		System.out.println("[BlogController.main()]" + id);
		
		
		//메인페이지에 뿌려줄 정보
		BlogVo blogVo = blogService.selectOne(id);
		System.out.println(blogVo);
		
		/*
		//카테고리 리스트 뿌려주기(제목)
		List<CategoryVo> categoryList = categoryService.categoryList(id);
		model.addAttribute("categoryList", categoryList);*/
		
		//블로그 생성 및 카테고리 
		if (blogVo != null) {
			model.addAttribute("blogVo", blogVo);
			//System.out.println("컨트롤러"+model);
			
			return "blog/blog-main";
		} else {
			return "error/403";
		}
		
	}
	
	//블로그 관리 페이지
	@RequestMapping(value = "/{id}/admin/basic", method = {RequestMethod.GET, RequestMethod.POST})
	public String admin(@PathVariable("id") String id, Model model) {
		System.out.println("[BlogController.admin()]" + id);
		
		BlogVo blogVo = blogService.selectOne(id);
		
		model.addAttribute("blogVo", blogVo);
		
		return "blog/admin/blog-admin-basic";
	}
	
	//블로그 기본설정(타이틀, 이미지 바꾸기)
	@RequestMapping(value = "/upload", method = {RequestMethod.GET, RequestMethod.POST})
	public String upload(@ModelAttribute BlogVo blogVo, @RequestParam("file") MultipartFile file,
						 @RequestParam("id") String id) {
		System.out.println("[BlogController.upload]");
		System.out.println("컨트롤러vo : " + blogVo);
		System.out.println("컨트롤러file : " + file);
		
		blogService.upload(blogVo, file);
		System.out.println("컨트롤러vo 갔다온거: " + blogVo);
		System.out.println("컨트롤러file 갔다온거: " + file);
		
		
		//return "redirect:/" + id + "/admin/basic";
		return "";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
