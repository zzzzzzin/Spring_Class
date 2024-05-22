package com.test.aop.dto;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Component
public class AOPDTO {

	private String name;
	private String age; 
	private String color;
	
	//DTO에 bean으로 만들지 않는 이유
	//- 독립
	
	
}
