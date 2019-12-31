package com.zjh.spring.beans.collections;

import com.zjh.spring.beans.Car;
import lombok.Data;

import java.util.List;

/**
 * @Author: zjh
 * @Date: 2019/4/25 16:03
 * @Version 1.0
 */
@Data
public class Person {

    private String name;
    private int age;
    private List<Car> cars;

    public Person(String name, int age, List<Car> cars) {
        this.name = name;
        this.age = age;
        this.cars = cars;
    }



    public Person() {
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cars=" + cars +
                '}';
    }
}
