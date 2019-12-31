package com.zjh.spring.beans.cycle;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Author: zjh
 * @Date: 2019/4/28 16:11
 * @Version 1.0
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization:"+bean+","+beanName);

        if ("car".equals(beanName)){
            //...
        }

        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization:"+bean+","+beanName);
        Car car = new Car();
        car.setBrand("Ford");
        return car;
    }
}
