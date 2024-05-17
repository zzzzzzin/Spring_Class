package com.test.web.service;

import org.springframework.stereotype.Service;

import com.test.web.dao.BoardDAO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService implements DataService {
	
	//의존 주입으로 작성하기!
	private final BoardDAO dao;

	public void add(String message) {
		//System.out.println(message);
		
		//의존 객체 직접 작성 x
		//BoardDAO dao = new BoardDAO();
		
		
		
	}
	
}
