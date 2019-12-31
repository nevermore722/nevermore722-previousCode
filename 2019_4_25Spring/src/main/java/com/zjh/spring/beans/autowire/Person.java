package com.zjh.spring.beans.autowire;

import lombok.Data;

/**
 * @Author: zjh
 * @Date: 2019/4/26 16:32
 * @Version 1.0
 */
@Data
public class Person {

    private String name;

    private Address address;

    private Car car;

}
