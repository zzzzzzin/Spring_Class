package com.test.mybatis.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddressDTO {

	private String seq;
	private String name;
	private String age;
	private String address;
	private String gender;
	
	//1:1 > xxxDTO
	private InfoDTO info; //자식테이블을 멤버변수로 작성
	
	//1:N > List<xxxDTO>
	private List<MemoDTO> memo;
	
}
