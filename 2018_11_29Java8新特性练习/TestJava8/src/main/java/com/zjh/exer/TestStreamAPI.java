package com.zjh.exer;

import com.zjh.java8.Employee;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TestStreamAPI {

    /*
        1.给定一个数字列表，如何返回一个由每个数平方构成的列表呢？
        ，给定【1，2，3，4，5】，应该返回【1，4，9，16，25】
     */
    @Test
    public void test1() {
        Integer[] nums = new Integer[]{1, 2, 3, 4, 5};
        Arrays.stream(nums)
                .map((x) -> x * x)
                .forEach(System.out::println);

        //计算平方和
        Optional<Integer> sum = Arrays.stream(nums)
                .map(x -> x * x )
                .reduce(Integer::sum);
        System.out.println(sum.get());

    }

    /*
        2.这么用map和reduce方法数一数流中有多少个Employee呢？
     */
    List<Employee> employees = Arrays.asList(
            new Employee(1, "张三", 18, 9999.99, Employee.Status.FREE),
            new Employee(2, "李四", 38, 5555.55, Employee.Status.BUZY),
            new Employee(3, "王五", 50, 6666.66, Employee.Status.VOCATION),
            new Employee(4, "赵六", 16, 3333.33, Employee.Status.FREE),
            new Employee(5, "田七", 8, 7777.77, Employee.Status.BUZY),
            new Employee(6, "田七", 8, 7777.77, Employee.Status.BUZY),
            new Employee(7, "田七", 8, 7777.77, Employee.Status.BUZY)

    );

    @Test
    public void test2() {
        Optional<Integer> count = employees.stream()
                .map((e) -> 1)
                .reduce(Integer::sum);

        System.out.println(count.get());
    }


}
