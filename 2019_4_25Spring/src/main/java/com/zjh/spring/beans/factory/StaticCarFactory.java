package com.zjh.spring.beans.factory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zjh
 * @Date: 2019/4/28 18:09
 * @Version 1.0
 * 静态工厂方法：直接调用某一个类的静态方法就可以返回Bean的实例
 */

public class StaticCarFactory {

    private static Map<String,Car> cars = new HashMap<String, Car>();

    static {
        cars.put("audi",new Car("audi",300000));
        cars.put("ford",new Car("ford",400000));
    }

    //静态工厂方法
    public static Car getCar(String name){
        return cars.get(name);
    }
}
