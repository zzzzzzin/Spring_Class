package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//스프링이 빈으로 관리하는 대상이 있는 곳 > component-scan base-package="com.test.web"

//빈이 되기 위한 자격
//- @Component  > 아래 3가지가 아닐때 사용
//- @Controller > 컨트롤러 역할 
//- @Service > 서비스 역할
//- @Repository > DAO 역할

@Controller
public class Ex07Controller {

	@GetMapping("/ex07.do")
	public String ex07() {
		
		return "ex07";
	}
	
}
