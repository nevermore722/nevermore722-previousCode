package com.zjh.spring.beans.generic.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: zjh
 * @Date: 2019/5/5 17:31
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/beans-generic-di.xml");

        UserService userService = (UserService) ctx.getBean("userService");
        userService.add();

    }
}
