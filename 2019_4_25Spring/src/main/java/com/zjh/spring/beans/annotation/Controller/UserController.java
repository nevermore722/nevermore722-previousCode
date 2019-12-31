package com.zjh.spring.beans.annotation.Controller;

import com.zjh.spring.beans.annotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Author: zjh
 * @Date: 2019/5/5 11:24
 * @Version 1.0
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public void excute(){
        System.out.println("UserController excute...");
        userService.add();
    }
}
