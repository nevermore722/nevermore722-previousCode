package com.zjh.spring.beans.properties;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @Author: zjh
 * @Date: 2019/4/26 17:30
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/beans-properties.xml");

        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
        try {
            System.out.println(dataSource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
