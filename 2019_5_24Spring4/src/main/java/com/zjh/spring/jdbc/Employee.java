package com.zjh.spring.jdbc;

import lombok.Data;

/**
 * @Author: zjh
 * @Date: 2019/5/26 16:11
 * @Version 1.0
 */
@Data
public class Employee {

    private Integer id;
    private String name;
    private String email;

    private Department department;
}
