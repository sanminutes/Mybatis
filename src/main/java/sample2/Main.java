package sample2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		// ������ �� ȯ�漳�� ������ ����.
		ApplicationContext ctx = new ClassPathXmlApplicationContext("sample2/beans.xml");
		MyMessage mm = (MyMessage) ctx.getBean("myMessageKr");
		mm.sayHello("ȫ�浿");
	}
}
