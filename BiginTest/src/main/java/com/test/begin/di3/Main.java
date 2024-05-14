package com.test.begin.di3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
//		Hong hong = new Hong();
//		
//		Service service = new Service(hong); //의존 주입 발생(DI)
//		service.work();
		
		//Hong 객체 생성하기
		//1. 개발자가 직접 생성
		//Hong hon = new Hong();
		
		//2. 스프링을 통해서 생성 > 빈 생성
		//- di3 .xml 환경 설정을 읽어오기
		
//		ApplicationContext context = new ClassPathXmlApplicationContext("file:/src/main/java/com/test/begin/di3/di3.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("com/test/begin/di3/di3.xml");
		
//		Hong hong = (Hong)context.getBean("hong");
//		hong.coding();
		
		Service service = (Service)context.getBean("service");
//		service.setHong(hong);
		service.work();
		
		
		//<bean id="hong2" name="h1, h2, h3" class="com.test.begin.di3.Hong"></bean>
		Hong hong2 = (Hong)context.getBean("hong");
		Hong hong3 = (Hong)context.getBean("h1");
		Hong hong4 = (Hong)context.getBean("h2");
		Hong hong5 = (Hong)context.getBean("h3");
		
		hong2.coding();
		hong3.coding();
		
		
		
	}
	
}








