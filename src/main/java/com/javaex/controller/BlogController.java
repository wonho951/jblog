package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BlogController {

	
	//블로그 메인
	@RequestMapping(value = "{id}", method = {RequestMethod.GET, RequestMethod.POST})
	public String main() {
		System.out.println("[BlogController.main()]");
		
		
		return "blog/blog-main";
	}
}