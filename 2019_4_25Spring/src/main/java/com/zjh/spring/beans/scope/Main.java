package com.zjh.spring.beans.scope;


import com.zjh.spring.beans.autowire.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: zjh
 * @Date: 2019/4/26 17:30
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/beans-scope.xml");


        Car car = (Car) ctx.getBean("car");
        Car car2 = (Car) ctx.getBean("car");

        System.out.println(car == car2);
    }
}
