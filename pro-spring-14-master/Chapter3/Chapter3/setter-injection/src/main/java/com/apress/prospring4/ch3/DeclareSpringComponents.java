package com.apress.prospring4.ch3;

import org.springframework.context.support.GenericXmlApplicationContext;

public class DeclareSpringComponents {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:META-INF/spring/app-context-annotation.xml");

        MessageRenderer messageRenderer = ctx.getBean("messageRenderer", MessageRenderer.class);

        messageRenderer.render();
    }
}
