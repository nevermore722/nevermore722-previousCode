package com.zjh.spring.beans.generic.di;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: zjh
 * @Date: 2019/5/5 17:24
 * @Version 1.0
 */
public class BaseService<T> {

    @Autowired
    protected BaseRepository<T> repository;

    public void add(){
        System.out.println("add...");
        System.out.println(repository);
    }

}
