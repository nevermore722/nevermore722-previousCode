package com.zjh.spring.aop.helloworld;

/**
 * @Author: zjh
 * @Date: 2019/5/10 10:40
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) {
//        ArithmeticCalculator arithmeticCalculator = null;
//        arithmeticCalculator = new ArithmeticCalculatorLoggingImpl();

        ArithmeticCalculator target = new ArithmeticCalculatorImpl();
        ArithmeticCalculator proxy = new AruthmeticCalculatorLoggingProxy(target).getLoggingProxy();

        System.out.println(proxy.getClass().getName());

        int result = proxy.add(1,2);
        System.out.println("-->"+result);
        result=proxy.div(4,2);
        System.out.println("-->"+result);
    }
}
