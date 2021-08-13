package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.BlogService;
import com.javaex.service.CategoryService;
import com.javaex.service.PostService;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.PostVo;

@Controller
public class PostController {

	@Autowired
	private BlogService blogService;
	
	@Autowired
	private CategoryService categoryService;

	
	@Autowired
	private PostService postService;
	
	
	@RequestMapping(value = "/{id}/admin/writeForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String write(@PathVariable("id") String id, Model model) {
		System.out.println("PostController.write[]");
		
		//로그인한 사람 정보 뿌려주기
		BlogVo blogVo = blogService.selectOne(id);
		
		model.addAttribute("blogVo", blogVo);
		System.out.println("컨트롤러 아이디:" + id);
		System.out.println("컨트롤러 vo:" + blogVo);
		
		//카테고리 제목 뿌려줘야함
		List<CategoryVo> categoryList = categoryService.categoryList(id);
		
		model.addAttribute("categoryList", categoryList);
		System.out.println("컨트롤러 model:" + categoryList);
		return "blog/admin/blog-admin-write";
		
	}
	
	
	//포스트하기(글쓰기)
	@RequestMapping(value = "/{id}/admim/postWrite", method = {RequestMethod.GET, RequestMethod.POST})
	public String postWrite(@PathVariable("id") String id,@ModelAttribute PostVo postVo) {
		System.out.println("PostController.postWrite[]");
		System.out.println("컨트롤러: " + id);
		System.out.println("컨트롤러:" + postVo);
		
		postService.insertPost(postVo);
		System.out.println("되올아 오는중!:" + postVo);
		
		
		return "redirect:/" + id + "/admin/writeForm";
		
	}
	
	
}
