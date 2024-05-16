package com.test.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//예외 처리 > 주로 500번대 에러(서버측)
@Controller
public class Ex09Controller {

	@GetMapping(value="/ex09.do")
	public String ex09(Model model) {
		
		int num = 0; // Request processing failed; nested exception is java.lang.ArithmeticException: / by zero
		
		model.addAttribute("result", 100 / num);
		
		return "ex09";
	}
}
