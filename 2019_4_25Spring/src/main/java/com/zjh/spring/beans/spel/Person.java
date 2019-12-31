package com.zjh.spring.beans.spel;

import lombok.Data;

/**
 * @Author: zjh
 * @Date: 2019/4/26 16:32
 * @Version 1.0
 */
@Data
public class Person {

    private String name;

    private Car car;

//    引用address bean的city属性
    private String city;

//    根据car的price确定info：car的price>=300000:金领
//    否则为白领
    private String info;
}
