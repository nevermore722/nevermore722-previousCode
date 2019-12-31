package com.zjh.spring.beans.annotation.service;

import com.zjh.spring.beans.annotation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @Author: zjh
 * @Date: 2019/5/5 11:22
 * @Version 1.0
 */
@Service
public class UserService {


    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(@Qualifier("userRepositoryImpl")UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void add(){
        System.out.println("UserService add...");
        userRepository.save();
    }
}
