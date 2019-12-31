package com.zjh.spring.beans.collections;

import lombok.Data;

import java.util.Properties;

/**
 * @Author: zjh
 * @Date: 2019/4/26 15:07
 * @Version 1.0
 */
@Data
public class DataSource {

    private Properties properties;

    @Override
    public String toString() {
        return "DataSource{" +
                "properties=" + properties +
                '}';
    }
}
