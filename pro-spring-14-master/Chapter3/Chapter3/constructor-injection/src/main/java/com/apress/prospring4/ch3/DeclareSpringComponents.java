package com.apress.prospring4.ch3;

import org.springframework.context.support.GenericXmlApplicationContext;

public class DeclareSpringComponents {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:META-INF/spring/app-context-xml.xml");

        MessageProvider messageProvider = ctx.getBean("messageProvider", MessageProvider.class);

        System.out.println(messageProvider.getMessage());
    }
}
