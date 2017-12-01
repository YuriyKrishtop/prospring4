package com.apress.prospring4.ch3.xml;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionInjection {
    private Map<String, Object> map;
    private Properties props;
    private Set set;
    private List list;

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:META-INF/spring/app-context-xml.xml");

        CollectionInjection instance = ctx.getBean("injectCollection", CollectionInjection.class);
        instance.displayInfo();
    }

    public void setList(List list) {
        this.list = list;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public void setMap(Map <String, Object> map) {
        this.map = map;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    public void displayInfo() {
        System.out.println("Map contents:\n");
        map.forEach(this::printValueKey);

        System.out.println("\nProperties contents:\n");
        props.forEach(this::printValueKey);

        System.out.println("\nSet contents:\n");
        set.forEach(this::printValue);

        System.out.println("\nList contents:\n");
        list.forEach(this::printValue);
    }

    private void printValue(Object value) {
        System.out.println("Value: " + value);
    }

    private void printValueKey(Object key, Object value) {
        System.out.println("Key: " + key + " - Value: " + value);
    }
}
