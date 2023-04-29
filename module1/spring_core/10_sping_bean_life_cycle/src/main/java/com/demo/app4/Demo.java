package com.demo.app4;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
    public static void main(String[] args) {
        AbstractApplicationContext ctx=
                new ClassPathXmlApplicationContext("app4.xml");

        Foo foo=ctx.getBean("foo",Foo.class);

        System.out.println(foo.getMessage());

        ctx.registerShutdownHook();
    }
}
