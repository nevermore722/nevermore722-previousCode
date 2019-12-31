package com.zjh.spring.beans.annotation.repository;

import com.zjh.spring.beans.annotation.TestObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Author: zjh
 * @Date: 2019/5/5 11:21
 * @Version 1.0
 */
@Repository
public class UserRepositoryImpl implements  UserRepository {

    @Autowired(required = false)
    private TestObject testObject;

    @Override
    public void save() {
        System.out.println("UserRepositoryImpl Save...");
        System.out.println(testObject);
    }
}
