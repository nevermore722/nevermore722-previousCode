package com.zjh.spring.beans.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: zjh
 * @Date: 2019/4/28 18:20
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/beans-factory.xml");
        Car car1 = (Car) ctx.getBean("car1");
        System.out.println(car1);

        Car car2 = (Car) ctx.getBean("car2");
        System.out.println(car2);
    }
}
