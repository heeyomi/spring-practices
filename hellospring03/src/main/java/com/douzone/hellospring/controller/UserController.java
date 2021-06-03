package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@ResponseBody
	@RequestMapping("/update")
	public String update(@RequestParam("n") String name) {
		// requestParama("name")인 경우 생략가능
		// 이거는 required가 true로 되어있음
		
		/*
		 * 만일 n이라는 이름의 파라미터가 없는 경우
		 * 400 Bad Request 에러가 발생 
		 */
		
		System.out.println(name);
		return "UserController.update()";
	}

	
	@ResponseBody
	@RequestMapping("/update2")
	public String update2(@RequestParam(value="n", required = true, defaultValue = "") String name, 
			@RequestParam(value="a", required = true, defaultValue = "0") int age) {
		System.out.println("---" + name + ":"+ age);
		return "UserController.update2()";
	}
}
