package com.test.aop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.aop.dao.AOPDAO;
import com.test.aop.dto.AOPDTO;
import com.test.aop.dto.BoardDTO;
import com.test.aop.dto.CommentDTO;
import com.test.aop.singleton.TestDAO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AOPController {
	
	private final AOPDAO dao; //수업용

	private final AOPDAO dao2;
	private final TestDAO dao3;
	
	@GetMapping(value="/test.do")
	public String test() {
		
		//MemoDTO m1 = new MemoDTO(null, null, null, null, null)
		//BoardDTO b1 = new BoardDTO();
		BoardDTO b1 = new BoardDTO.BoardDTOBuilder()
									.setSeq("1")
									.setSubject("제목입니다.")
									.setContent("내용입니다.")
									.setName("홍길동")
									.setRegdate("2024")
									.build();
		
		System.out.println(b1);
		
		CommentDTO c1 = CommentDTO.builder()
									.name("홍길동")
									.subject("댓글입니다.")
									.content("내용입니다.")
									.build();
							
		System.out.println(c1);
		
		
		//스프링이 관리하는 모든 빈은 싱글톤이다.
		//싱글톤 패턴: 특정 클래스의 인스턴스가 하나만 생성되도록 보장하고, 이에 대한 전역 접근점을 제공
//		System.out.println(dao == dao2);		//true
//		System.out.println(dao.equals(dao2));	//true
//		
//		System.out.println(dao3.service()); 	//data
		
//		AOPDTO dto1 = new AOPDTO();
//		dto1.setName("홍길동");
//
//		AOPDTO dto2 = new AOPDTO();
//		dto2.setName("아무개");
//		
//		System.out.println(dto1 == dto2);		//false
//		System.out.println(dto1.equals(dto2));	//false
//		
//		//DAO dao1 = new DAO();
//		
//		DAO dao2 = DAO.getInstance(); //100번지
//
//		DAO dao3 = DAO.getInstance(); //100번지
//		
//		System.out.println(dao2 == dao3);		//true
//		System.out.println(dao2.equals(dao3));	//true
		
		return "list";
	}
	
	//주요 업무 > 메모장
	//보조 업무 > 로그
	@GetMapping("/list.do")
	public String list() {
		
		System.out.println("Controller.list");
		dao.list();
		
		return "list";
	}

	@GetMapping("/add.do")
	public String add() {
		
		AOPDTO dto = new AOPDTO();
		dto.setName("병아리");
		dto.setAge("1");
		dto.setColor("노랑");
		
		System.out.println("Controller.add");
		dao.add(dto);
		
		return "add";
	}
	
	@GetMapping("/view.do")
	public String view() {
				
		System.out.println("Controller.view");
		dao.view();
		
		return "view";
	}
	
	
}
