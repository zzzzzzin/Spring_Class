package com.test.web.connect;

public class Main {
	
	public static void main(String[] args) {
		
		//Main > Service > Hong

		//*** 계층과 계층간에 연결을 할 때 > 클래스 사용(X), 인터페이스 사용(O) > 권장사항(인데 필수)
		
		
		Service service = new Service();
		service.work();
		
		
	}

}
