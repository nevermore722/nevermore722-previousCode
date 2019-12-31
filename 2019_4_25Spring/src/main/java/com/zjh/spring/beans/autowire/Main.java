package com.zjh.spring.beans.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: zjh
 * @Date: 2019/4/26 17:10
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/beans-autowire.xml");
        Person person = (Person) ctx.getBean("person");

        System.out.println(person);
    }
}
