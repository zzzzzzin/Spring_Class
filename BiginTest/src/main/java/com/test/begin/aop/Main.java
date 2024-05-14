package com.test.begin.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//메인
public class Main {
	
	public static void main(String[] args) {
		
		//주 업무 객체 > Memo
		//MemoImpl memo = new MemoImpl(); //메모업무와 관련된 모든 일을 하는 객체
		
		//주업무 객체 > 빈으로 생성 > 스프링 컨테이너에 의해서 관리
		ApplicationContext context = new ClassPathXmlApplicationContext("com/test/begin/aop/memo.xml"); 
		MemoImpl memo = (MemoImpl)context.getBean("memo");
		
		//글쓰기
		memo.add("스프링 작업 중입니다.");
		memo.addSecret("스프링 작업 중입니다.");
		
		//글읽기
		try {
			String content = memo.read(10);
			System.out.println(content);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//글수정
		boolean result = memo.edit(15, "수정할 내용입니다.");
		
		//글삭제
		result = memo.del(15);
		
	}

}
