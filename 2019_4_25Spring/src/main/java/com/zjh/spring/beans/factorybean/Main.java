package com.zjh.spring.beans.factorybean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: zjh
 * @Date: 2019/4/30 10:55
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/beans-beanfactory.xml");
        Car car = (Car) ctx.getBean("car");

        System.out.println(car);
    }
}
