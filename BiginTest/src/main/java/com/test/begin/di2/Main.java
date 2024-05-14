package com.test.begin.di2;

public class Main {

	public static void main(String[] args) {
		
		//목적] Hong에게 일을 시키자!!
		//Main > Hong (X)
		//Main > Service > Hong (O)
		
		
		//Hong hong = new Hong();
		
		//Main > (위임) > Service > (위임) > Hong
		//Main <-> (의존관계) <-> Service <-> (의존관계) <-> Hong
		//Main > Service(의존객체)
		//**** 필요할 때마다 직접(***) 의존 객체를 생성해서 사용하는 방식을 사용해왔다.
		
		
		//"프로그래밍에서 구성 요소간의 의존 관계가 소스 내부가 아닌 외부 환경에서 정의되게 하는 디자인 패턴"
		
		Hong hong = new Hong();
		
		Service service = new Service();
		service.setHong(hong); //의존 주입 발생(DI)
		service.work();
		
//		Service service = new Service(hong); //의존 주입 발생(DI)
//		service.work();
		
	}
	
}








