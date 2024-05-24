package com.test.security.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

//접근 권한 페이지 처리 방법 > AccessDeniedHandler를 직접 구현
public class CustomAccessDeniedHanlder implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {

		//403 발생 > handle() > 상대적으로 URI 지정 방식보다 구체적인 조작
		System.out.println("Access Denied Handler");
		
		response.sendRedirect("/security/accesserror.do");
		
	}
	
}
