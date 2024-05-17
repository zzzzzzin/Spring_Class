package com.test.web.dao;

import org.springframework.stereotype.Repository;

@Repository //더이상 의존하는 객체가 없으면 Repository
public class BoardDAO {

	public String getData() {

		return "스프링";
	}

}
