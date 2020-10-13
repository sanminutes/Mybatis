package sample3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		// 스프링 환경설정 파일을 연다.
		ApplicationContext ctx = new ClassPathXmlApplicationContext("sample3/beans.xml");
		Danaka danaka = (Danaka) ctx.getBean("danaka");
		danaka.has();
	}
}
