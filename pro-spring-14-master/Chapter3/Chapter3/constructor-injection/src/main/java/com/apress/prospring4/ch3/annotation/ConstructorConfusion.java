package com.apress.prospring4.ch3.annotation;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;

@Service("constructorConfusion")
public class ConstructorConfusion {
    private String someValue;

//    @Autowired
    public ConstructorConfusion(String someValue) {
        System.out.println("ConstructorConfusion(String) called");
        this.someValue = someValue;
    }

    @Autowired
    public ConstructorConfusion(@Value("90") int someValue) {
        System.out.println("ConstructorConfusion(int) called");
        this.someValue = "Number: " + Integer.toString(someValue);
   }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:META-INF/spring/app-context-annotation.xml");

        ConstructorConfusion cc = ctx.getBean("constructorConfusion", ConstructorConfusion.class);
        System.out.println(cc); 
    }

    public String toString() {
        return someValue; 
    }
}
