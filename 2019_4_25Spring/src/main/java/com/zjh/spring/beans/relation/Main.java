package com.zjh.spring.beans.relation;


import com.zjh.spring.beans.autowire.Address;
import com.zjh.spring.beans.autowire.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: zjh
 * @Date: 2019/4/26 17:30
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/beans-relation.xml");

//        Address address = (Address) ctx.getBean("address");
//        System.out.println(address);

        Address address = (Address) ctx.getBean("address3");
        System.out.println(address);

        Person person = (Person) ctx.getBean("person");
        System.out.println(person);
    }
}
