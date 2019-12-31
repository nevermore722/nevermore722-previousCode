package com.zjh.spring.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * @Author: zjh
 * @Date: 2019/5/26 16:35
 * @Version 1.0
 */
@Repository
public class EmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Employee get(Integer id){
        String sql = "SELECT id,name,email FROM employee WHERE id = ?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        Employee employee = jdbcTemplate.queryForObject(sql,rowMapper,id);

        return employee;
    }
}
