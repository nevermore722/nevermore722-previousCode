package com.zjh.spring.beans.spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: zjh
 * @Date: 2019/4/26 17:10
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/beans-spel.xml");
        Address address = (Address) ctx.getBean("address");
        System.out.println(address);

        Car car = (Car) ctx.getBean("car");
        System.out.println(car);

        Person person = (Person) ctx.getBean("person");
        System.out.println(person);
    }
}
