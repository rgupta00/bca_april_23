package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("aop.xml");

		Magician m=ctx.getBean("m", Magician.class);

		//System.out.println(m.getClass());
		m.doMagic(33,"foo");
		m.f2();
	}
}
