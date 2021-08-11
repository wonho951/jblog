package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.BlogService;
import com.javaex.vo.BlogVo;

@Controller
public class BlogController {

	@Autowired
	private BlogService blogService;
	
	//블로그 메인
	@RequestMapping(value = "/{id}", method = {RequestMethod.GET, RequestMethod.POST})
	public String main(Model model, @PathVariable("id") String id ) {
		System.out.println("[BlogController.main()]" + id);
		

		//메인페이지에 뿌려줄 정보
		BlogVo blogVo = blogService.selectOne(id);
		
		//블로그 생성
		
		model.addAttribute("blogVo", blogVo);
		
		
		return "blog/blog-main";
	}
}
