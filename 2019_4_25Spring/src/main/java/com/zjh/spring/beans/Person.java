package com.zjh.spring.beans;

import lombok.Data;

/**
 * @Author: zjh
 * @Date: 2019/4/25 16:03
 * @Version 1.0
 */
@Data
public class Person {

    private String name;
    private int age;
    private Car car;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", car=" + car +
                '}';
    }

    public Person() {
    }

    public Person(String name, int age, Car car) {
        this.name = name;
        this.age = age;
        this.car = car;
    }
}
