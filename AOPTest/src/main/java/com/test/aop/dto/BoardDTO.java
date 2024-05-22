package com.test.aop.dto;

import lombok.ToString;

/*
	Builder 패턴
	객체 생성의 복잡성을 줄이고, 가독성을 높이며, 다양한 구성 옵션을 쉽게 관리
	특히, 객체의 생성자가 복잡하거나, 다양한 옵션을 지원해야 할 때 유용
	
	특징
	1. 순서가 자유로움
	2. 첨삭도 자유로움
*/
@ToString
public class BoardDTO {

	private String seq; 
	private String name;
	private String subject;
	private String content;
	private String regdate;
	
	private BoardDTO(BoardDTOBuilder builder) {
		this.seq = builder.seq;
		this.name = builder.name;
		this.subject = builder.subject;
		this.content = builder.content;
		this.regdate = builder.regdate;
	}
	
	//Nested Class > 역할 Builder 클래스
	public static class BoardDTOBuilder {
		
		private String seq; 
		private String name;
		private String subject;
		private String content;
		private String regdate;
		
		public BoardDTOBuilder setSeq(String seq) {
			this.seq = seq;
			return this;
		}
		public BoardDTOBuilder setName(String name) {
			this.name = name;
			return this;
		}
		public BoardDTOBuilder setSubject(String subject) {
			this.subject = subject;
			return this;
		}
		public BoardDTOBuilder setContent(String content) {
			this.content = content;
			return this;
		}
		public BoardDTOBuilder setRegdate(String regdate) {
			this.regdate = regdate;
			return this;
		}
		
		public BoardDTO build() {
			return new BoardDTO(this); 
		}
		
		
	}
}
