package com.zjh.spring.beans.cycle;


import lombok.Data;

/**
 * @Author: zjh
 * @Date: 2019/4/28 15:45
 * @Version 1.0
 */
@Data
public class Car {

    public Car() {
        System.out.println("Car's Constructor...");
    }

    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand){
        System.out.println("setBrand...");
        this.brand=brand;
    }

    private void init(){
        System.out.println("init....");
    }

    private void destroy(){
        System.out.println("destroy....");
    }
}
