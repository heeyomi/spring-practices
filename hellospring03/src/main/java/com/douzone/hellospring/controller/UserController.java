package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @RequestMapping
 * 클래스 + 핸들러(메소드)
 * 
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String joinForm() {
		return "/WEB-INF/views/join.jsp";
	}

//	@ResponseBody
//	@RequestMapping(value="/join", method=RequestMethod.POST)
//	public String join(UserVo vo) {
//		System.out.println(vo);
//		return "UserController:join";
//	}

	//redirect
	@ResponseBody
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(UserVo vo) {
		System.out.println(vo);
		return "redirect:/";
	}
}
