package com.zjh.spring.aop.impl;

import org.springframework.stereotype.Component;

/**
 * @Author: zjh
 * @Date: 2019/5/10 10:34
 * @Version 1.0
 */
@Component
public class ArithmeticCalculatorImpl implements ArithmeticCalculator {
    @Override
    public int add(int i, int j) {
        int result = i+j;
        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result = i-j;
        return result;
    }

    @Override
    public int mul(int i, int j) {
        int result = i*j;
        return result;
    }

    @Override
    public int div(int i, int j) {
        int result = i/j;
        return result;
    }
}
