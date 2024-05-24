package com.test.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

	//접근 권한이 없을 때(403) > 안내 페이지
	@GetMapping("/accesserror.do")
	public String accesserror(Authentication auth, Model model) {
		
		System.out.println("Access Denide >>> " + auth);
		
		model.addAttribute("auth", auth);
		
		return "auth/accesserror";
	}
	
	//커스텀 로그인 페이지
	@GetMapping("/customlogin.do")
	public String customlogin(Model model) {
		
		return "auth/customlogin";
	}
	
	//커스텀 로그아웃 페이지(실제 로그아웃은 customlogout 에서 실행)
	@GetMapping("/customlogout.do")
	public String customlogpit(Model model) {
		
		return "auth/customlogout";
	}
	
}
