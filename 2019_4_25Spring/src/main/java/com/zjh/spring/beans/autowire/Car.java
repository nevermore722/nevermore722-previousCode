package com.zjh.spring.beans.autowire;

import lombok.Data;

/**
 * @Author: zjh
 * @Date: 2019/4/26 17:04
 * @Version 1.0
 */
@Data
public class Car {

    private String brand;
    private double price;

    public Car(){
        System.out.println("Car's Constructor...");
    }
}
