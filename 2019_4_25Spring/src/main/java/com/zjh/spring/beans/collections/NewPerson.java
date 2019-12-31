package com.zjh.spring.beans.collections;

import com.zjh.spring.beans.Car;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @Author: zjh
 * @Date: 2019/4/25 16:03
 * @Version 1.0
 */
@Data
public class NewPerson {

    private String name;
    private int age;
    private Map<String,Car> cars;

    public NewPerson() {
    }

}
