package com.demo.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
    public static void main(String[] args) {
        ApplicationContext ctx=
                new ClassPathXmlApplicationContext("app.xml");

        System.out.println("hello");
//
//        Foo foo=ctx.getBean("foo",Foo.class);
//        System.out.println(foo.getMessage());
//        System.out.println(foo.hashCode());
//
//        Foo foo2=ctx.getBean("foo",Foo.class);
//        System.out.println(foo2.getMessage());
//        System.out.println(foo2.hashCode());

    }
}
