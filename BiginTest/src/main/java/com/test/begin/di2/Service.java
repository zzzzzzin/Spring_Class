package com.test.begin.di2;

public class Service {
	
	private Hong hong;
	
	//내가 의존하는 객체를 직접 생성을 하지 않고, 외부로부터 받아와서 사용한다.
	//> 의존 주입(DI)
	
	//생성자 > 의존 주입 도구
//	public Service(Hong hong) {
//		this.hong = hong;
//	}
	
	//세터 > 의존 주입 도구
	public void setHong(Hong hong) {
		this.hong = hong;
	}
	
	public void work() {
		
		//*** 의존객체를 직접 생성한다.(X)
		
		hong.coding();
		
	}

}









