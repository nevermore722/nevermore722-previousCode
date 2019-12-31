package com.zjh.spring.beans.cycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: zjh
 * @Date: 2019/4/28 15:50
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/beans-cycle.xml");

        Car car = (Car) ctx.getBean("car");
        System.out.println(car);

        //关闭IOC容器
        ((ClassPathXmlApplicationContext) ctx).close();

        MyBeanPostProcessor myBeanPostProcessor = new MyBeanPostProcessor();
        myBeanPostProcessor.postProcessBeforeInitialization(null,null);
    }
}
