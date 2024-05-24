package com.test.security.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDTO {
	
	private String memberid; 
	private String memberpw;
	private String membername;
	private String enabled;
	private String email;
	private String gender;
	private String regdate;
	
	//회원은 여러개의 auth를 가질 수 있어서 list로 설정
	private List<AuthDTO> authlist; 
	
	//회원 가입용 권한
	private String auth;

}
