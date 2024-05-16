package com.test.web.connect;

public class Service {
	
	public void work() {
		
		//클래스를 사용한 관계 > 강한 결합
		//인터페이스를 사용한 관계 > 느슨한 결합
		
		//Hong worker = new Hong();
		
		//Lee worker = new Lee();
		
		
		//Hong과 Lee를 Worker의 하나로 보기
		//Worker worker = new Hong();
		Worker worker = new Lee();
		
		String thing = worker.get("키보드");
		System.out.println(thing);
				
	}

}





