package com.test.nontiles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@GetMapping("/log.do")
	public String log() {
		
		return "admin/log";
	}
	
	@GetMapping("/setting.do")
	public String setting() {
		
		return "admin/setting";
	}
	
}













