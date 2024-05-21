package com.test.tiles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/index.do")
	public String index() {
		
		return "index";
	}
	
	@GetMapping("/test.do")
	public String test() {
		
		//Tiles 적용 > return 값 > JSP(X)
		//                     > definition의 name값
		return "test";
	}
	
}






