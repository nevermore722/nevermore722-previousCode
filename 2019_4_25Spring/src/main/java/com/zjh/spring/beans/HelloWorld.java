package com.zjh.spring.beans;

import lombok.Data;
import org.springframework.context.annotation.Bean;

/**
 * @Author: zjh
 * @Date: 2019/4/25 13:59
 * @Version 1.0
 */
@Data
public class HelloWorld {

    private String name;

    public void setName2(String name){
        System.out.println("setName:" + name);
        this.name = name;
    }

    public void hello(){
        System.out.println("hello:" + name);
    }

    public HelloWorld(){
        System.out.println("HelloWorld's Constructor...");
    }


}
