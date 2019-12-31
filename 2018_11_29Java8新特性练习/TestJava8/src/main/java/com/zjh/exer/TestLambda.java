package com.zjh.exer;


import com.zjh.java8.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestLambda {

    List<Employee> emps = Arrays.asList(
            new Employee(1, "张三", 18, 9999.99),
            new Employee(2, "李四", 38, 5555.55),
            new Employee(3, "王五", 50, 6666.66),
            new Employee(4, "赵六", 16, 3333.33),
            new Employee(5, "田七", 8, 7777.77)

    );

    @Test
    public void test1() {
        Collections.sort(emps, (e1, e2) -> {
            if (e1.getAge().equals(e2.getAge())) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return -Integer.compare(e1.getAge(), e2.getAge());
            }
        });

        for (Employee emp : emps) {
            System.out.println(emp);
        }
    }


    @Test
    public void test2() {
        String trimstr = strHandler("\t\t\t zzzjjjhhh    ", (str) -> str.trim());
        System.out.println(trimstr);

        String upper = strHandler("aabbccddefg", str -> str.toUpperCase());
        System.out.println(upper);

        String newStr = strHandler("zxcvbnm", str -> str.substring(2, 5));
        System.out.println(newStr);
    }

    //需求：用于处理字符串
    public String strHandler(String str, MyFunction mf) {
        return mf.getValue(str);
    }


    @Test
    public void test3() {
        op(100L, 200L, (x, y) -> x + y);

        op(100L, 200L, (x, y) -> x * y);
    }

    //需求：对两个Long型数据进行处理
    public void op(Long l1, Long l2, MyFunction2<Long, Long> mf) {
        System.out.println(mf.getValue(l1, l2));
    }
}
