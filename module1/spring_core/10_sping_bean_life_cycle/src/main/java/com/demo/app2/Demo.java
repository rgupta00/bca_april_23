package com.demo.app2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
    public static void main(String[] args) {
        AbstractApplicationContext ctx=
                new ClassPathXmlApplicationContext("app2.xml");

        ctx.registerShutdownHook();
        System.out.println("hello");
//
        Foo foo=ctx.getBean("foo",Foo.class);
        foo.doWork();
        foo.doWork();
//        System.out.println(foo.getMessage());
//        System.out.println(foo.hashCode());
//
//        Foo foo2=ctx.getBean("foo",Foo.class);
//        System.out.println(foo2.getMessage());
//        System.out.println(foo2.hashCode());

    }
}
