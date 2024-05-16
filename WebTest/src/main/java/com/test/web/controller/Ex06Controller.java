package com.test.web.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller //어노테이션 선언(컨트롤러)
public class Ex06Controller {
	
	@GetMapping(value="/add.do")
	public String add() {
		
		return "add"; 
	}

//	@PostMapping(value="/addok.do")
//	public String addok(HttpServletRequest req) {
//		
//		//req.setCharacterEncoding("UTF-8"); //따로 예외처리 x > 필터로 처리 O
//		String num = req.getParameter("num");
//		
//		//ModelAndView mv; //view의 역할을 addok.jsp에게 넘겼기 때문에 ModelAndView 작성 x
//		req.setAttribute("num", num);
//		
//		return "addok";
//	}
	
	
	//스프링에서는 요청 메서드에게 넘어오는 대부분의 데이터를 매개 변수 형태로 받는다.
//	@PostMapping("/addok.do")
//	public String addok(@RequestParam("num") String num) {	
//		//@RequestParam("num")은 req.getParameter("num")과 같은 역할 
//		//@RequestParam()는 자동 형변환을 해줌													
//		
//		
//		System.out.println(num);
//		
//		return "addok";
//	}
	
//	@PostMapping("/addok.do")
//	public String addok(String num, Model model) { 	
//		//@RequestParam("num") 생략 가능 > String num을 바꾸면 안 됨
//		//Model이라는 DTO
//		
//		System.out.println(num);
//		
//		//ModelAndView > Model만 남음
//		
//		model.addAttribute("num", num);
//		
//		return "addok";
//	}
//	
//	@PostMapping("/addok.do")
//	public String addok(Model model, 
//						@RequestParam("name")String name, 
//						@RequestParam("age")String age,
//						@RequestParam("address")String address) {
//		
//		model.addAttribute("name", name);					
//		model.addAttribute("age", age);					
//		model.addAttribute("address", address);					
//							
//		return "addok";
//	}
	
//	@PostMapping("/addok.do")
//	public String addok(Model model, 
//						String name, 
//						int age,
//						String address) {
//		
//		
//		//가장 많이 하는 행동 > DTO에 담기
//		AddressDTO dto = new AddressDTO();
//		dto.setName(name);
//		dto.setAge(age);
//		dto.setAddress(address);
//		
//		model.addAttribute("name", name);					
//		model.addAttribute("age", age);					
//		model.addAttribute("address", address);
//		
//		model.addAttribute("dto", dto);
//		
//		return "addok";
//	}
	
	
//	@PostMapping("/addok.do")
//	public String addok(Model model, AddressDTO dto,
//						@RequestParam(defaultValue = "100") int id) { //defaultValue 값은 파라미터로 값이 없을때 넣는 값
//		
//		//1. req.getParameter()
//		//2. DTO 생성
//		
//		System.out.println(id);
//		
//		model.addAttribute("dto", dto);
//		
//		return "addok";
//	}

	
	@PostMapping("/addok.do")
	public String addok(Model model
						//, String cb
						//, @RequestParam("cb") String[] cb
						//, @RequestParam("cb") List<String> cb
						//, @RequestParam("cb") ArrayList<String> cb
						, ArrayList<String> cb
						//, String[] cb
						//, List<String> cb
		) {
		
		//1,2,3,4,5
		//1,5
		//[1, 2, 3, 4, 5]
		System.out.println(cb);
		
		//[1, 2, 3, 4, 5]
		//System.out.println(Arrays.toString(cb));
		
		return "addok";
	}

//	@PostMapping("/addok.do")
//	public String addok(Model model, @ModelAttribute("num") String num) {
//		
//		//@ModelAttribute
//		//- 모델 객체에 데이터를 추가하지 않아도 자동으로 추가된다.
//		
//		return "addok";
//	}
	
}












