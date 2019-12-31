package com.zjh.spring.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: zjh
 * @Date: 2019/5/10 16:25
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        //1.创建Spring的IOC容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("springConfig/applicationContext.xml");

        //2.从IOC容器中获取bean的实例
        ArithmeticCalculator arithmeticCalculator = ctx.getBean(ArithmeticCalculator.class);

        //3.使用bean
        int result = arithmeticCalculator.add(3,6);
        System.out.println("result:"+result);

        result = arithmeticCalculator.div(12,0);
        System.out.println("result:"+result);
    }
}
