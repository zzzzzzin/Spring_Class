package com.test.aop.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MemoDTO {
	
	private String seq;
	private String name;
	private String subject;
	private String content;
	private String regdate;
	
	//생성자 > 인자의 개수?
	public MemoDTO() {
		
	}

	public MemoDTO(String seq, String name, String subject, String content, String regdate) {
		this.seq = seq;
		this.name = name;
		this.subject = subject;
		this.content = content;
		this.regdate = regdate;
	}

	
	
	
	
}








