package com.zjh.spring.beans.annotation;

import com.zjh.spring.beans.annotation.Controller.UserController;
import com.zjh.spring.beans.annotation.repository.UserRepository;
import com.zjh.spring.beans.annotation.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: zjh
 * @Date: 2019/5/5 11:34
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {



        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/beans-annotation.xml");

//        TestObject to = (TestObject) ctx.getBean("testObject");
//        System.out.println(to);
//
        UserController userController = (UserController) ctx.getBean("userController");
        System.out.println(userController);
        userController.excute();

//
//        UserService userService = (UserService) ctx.getBean("userService");
//        System.out.println(userService);

//        UserRepository userRepository = (UserRepository) ctx.getBean("userRepository");
//        System.out.println(userRepository);
    }
}
