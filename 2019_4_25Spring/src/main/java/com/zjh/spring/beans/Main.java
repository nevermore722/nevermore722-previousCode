package com.zjh.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: zjh
 * @Date: 2019/4/25 14:01
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) {

/*        //创建HelloWorld的一个对象
        HelloWorld helloWorld = new HelloWorld();
        //为name属性赋值
        helloWorld.setName("zjh");
        */

        //1.创建Spring的IOC容器对象
        //ApplicationContext 代表IOC容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/applicationContext.xml");

        //2.从IOC容器中获取Bean实例
        //利用id定位到IOC容器中的bean
        HelloWorld helloWorld = (HelloWorld) ctx.getBean("helloWorld2");
        //利用类型返回IOC容器中的Bean，但要求IOC容器中只能有一个该类型的Bean
//        HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
        System.out.println(helloWorld);

        //调用hello方法
        //helloWorld.hello();

        Car car = (Car) ctx.getBean("car");
        System.out.println(car);

        car = (Car) ctx.getBean("car2");
        System.out.println(car);

        Person person = (Person) ctx.getBean("person");
        System.out.println(person);

        Person person2 = (Person) ctx.getBean("person2");
        System.out.println(person2);
    }
}
