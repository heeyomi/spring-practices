package com.douzone.guestbook.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douzone.guestbook.repository.GuestbookRepository;
import com.douzone.guestbook.vo.GuestbookVo;

@Controller
public class GuestbookController {
	@Autowired
	private GuestbookRepository guestbookRepository;
	
	@RequestMapping("")
	public String index(Model model) {
		List<GuestbookVo> list = guestbookRepository.find();
		for (GuestbookVo guestbookVo : list) {
			guestbookVo.setRegDate(guestbookVo.getRegDate().substring(0, 16));
		}
		model.addAttribute("list", list);
		return "/WEB-INF/views/index.jsp";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(GuestbookVo vo) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		vo.setRegDate(sdf.format(new Date()));
		guestbookRepository.insert(vo);
		return "redirect:/";
	}
	
	@RequestMapping(value="/delete/{no}", method = RequestMethod.GET)
	public String delete(@PathVariable("no") Long no, Model model) {
		model.addAttribute("no",no);
		return "/WEB-INF/views/deleteform.jsp";
	}
	
	@RequestMapping(value="/delete/{no}", method = RequestMethod.POST)
	public String delete(@PathVariable("no") Long no, String password) {
		GuestbookVo vo = guestbookRepository.findByNo(no);
		if (password.equals(vo.getPassword())) {
			guestbookRepository.delete(no, password);
		}
		return "redirect:/";
	}
	
}
