package com.test.mybatis.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.mybatis.dao.AddressDAO;
import com.test.mybatis.dto.AddressDTO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AddressController {

	private final AddressDAO dao;
	
	@GetMapping("/get")
	public AddressDTO get(String seq) {
		
		return dao.get(seq);
	}
	
	@GetMapping("/list")
	public List<AddressDTO> list() {
		
		return dao.list();
	}
	
	
}
