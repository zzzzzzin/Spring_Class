package com.test.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//ModelAndView 사용
public class Ex02Controller implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//DB 작업 > 반환값
		int count = 123;
		String name = "홍길동";
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ex02");

		//JSP에게 전달할 데이터
		//request.setAttribute("count", count);
		//request.setAttribute("name", name);
		
		//스프링 > 되도록 request, response 노출(X) > .addObject() 을 사용 권장
		mv.addObject("count", count);
		mv.addObject("name", name);
		
		
		return mv; //잊지말고 반환할 값 수정하기
	}

	
	
}
