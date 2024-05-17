package com.test.web.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.web.service.DataService;

import lombok.RequiredArgsConstructor;

/*
	스프링 의존 주입
	1. 필드 주입, Field Injection
	2. Setter 주입
	3. 생성자 주입	> *** 가장 권장
*/

@Controller
//@Setter //클래스의 모든 필드에 대해 setter 메서드를 자동으로 생성
//@Getter //클래스의 모든 필드에 대해 getter 메서드를 자동으로 생성
//@NoArgsConstructor //파라미터가 없는 기본 생성자를 자동으로 생성
//@AllArgsConstructor //클래스의 모든 필드를 파라미터로 받는 생성자를 자동으로 생성, 모든 필드를 초기화하는 생성자를 생성
@RequiredArgsConstructor //final 필드나 @NonNull 어노테이션이 붙은 필드만을 파라미터로 받는 생성자를 자동으로 생성 > 의존성 주입을 위해
public class Ex10Controller {
	
	//private final BoardService service;
	@Qualifier("memo")
	private final DataService service;
	
	//필드 주입 > final 안 됨
//	@Autowired 
//	private final BoardService service;
	
	//세터 주입 > final 안 됨
//	@Autowired 
//	public void setService(BoardService service) {
//		this.service = service;
//	}
	
	//생성자 주입 > final 됨 > 가장 많이 사용
//	@Autowired 
//	public Ex10Controller(BoardService service) {
//		this.service = service;
//	}

	@GetMapping(value="/addBoard.do")
	public String add(String message) {
		
		//BoardService service = new BoardService();
		
		service.add(message);
		
		return "ex10";
	}

}













