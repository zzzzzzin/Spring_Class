package com.test.begin.aop;

import java.util.Calendar;

import org.aspectj.lang.ProceedingJoinPoint;

//보조 업무 객체(클래스)
public class Logger {

	public void log(String message) {
		Calendar now = Calendar.getInstance();
		System.out.printf("[LOG]%tF %tT > %s\n", now, now, message);
	}
	
	//보조 업무 구현
	public void after() {
		System.out.println("보조 업무를 실행합니다.");
	}
	
	//보조 업무 구현
	public void around(ProceedingJoinPoint jp) {
		
		//주업무가 실행되는 소요시간 기록
		//1. 기록 시작
		//2. 주업무 실행
		//3. 기록 종료
		long begin = System.nanoTime();
		System.out.println("[LOG]기록을 시작합니다.");
		
		//주업무 실행
		//memo.add("메모");
		try {
			jp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}

		long end = System.nanoTime();
		System.out.println("[LOG]기록을 종료합니다.");
		
		System.out.printf("[LOG] 소요시간 %,dns\n", end - begin);
		
	}
	
	//After-running
	public void history(Object memo) {
		System.out.println("[LOG] 메모 읽기: " + memo);
	}
	
	
	//After-throwing
	public void check(Exception e) {
		System.out.println("[LOG] 예외 발생: " + e.getMessage());
		//DB Insert..
		//담당자 메일 발생 or 문자 메세지
	}
	
	
}
