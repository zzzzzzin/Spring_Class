package com.test.web.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
//@Qualifier("memo")
@Primary //이게 붙으면 여러 구현체 중에 우선적으로 실행(하나만 주어야함)
public class MemoService implements DataService {
	
	public void add(String message) {
		System.out.println("메모: " + message);
	}

}
