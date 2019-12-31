package com.zjh.spring.beans.factory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zjh
 * @Date: 2019/4/28 18:08
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private String brand;
    private double price;
}
