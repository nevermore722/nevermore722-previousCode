package com.zjh.spring.beans.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: zjh
 * @Date: 2019/4/25 18:17
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        Person person = (Person) ctx.getBean("person3");

        System.out.println(person);

        NewPerson newPerson = (NewPerson) ctx.getBean("newPerson");
        System.out.println(newPerson);

        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println(dataSource.getProperties());

        Person person4 = (Person) ctx.getBean("person4");
        System.out.println(person4);

        Person person5 = (Person) ctx.getBean("person5");
        System.out.println(person5);
    }
}
