package com.zjh.spring.beans.annotation.repository;

import org.springframework.stereotype.Repository;

/**
 * @Author: zjh
 * @Date: 2019/5/5 14:31
 * @Version 1.0
 */
@Repository
public class UserJdbcRepostitory implements UserRepository{
    @Override
    public void save() {
        System.out.println("UserJdbcRepostitory save...");
    }
}
