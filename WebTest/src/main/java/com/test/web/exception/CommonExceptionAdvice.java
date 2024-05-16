package com.test.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class CommonExceptionAdvice {
	
	//에러가 발생하면 자동으로 처리(500번대)
	@ExceptionHandler(Exception.class)
	public String except(Exception e, Model model) {
		
		
		return "error";
	}
	
	//404에러에 대한 페이지 호출
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handle404() {
		
		return "notfound";
	}

}
