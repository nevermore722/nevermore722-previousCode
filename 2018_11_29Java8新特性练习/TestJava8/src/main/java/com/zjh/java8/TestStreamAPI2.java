package com.zjh.java8;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * 一、Stream 的三个操作步骤
 * <p>
 * 1.创建Stream
 * <p>
 * 2.中间操作
 * <p>
 * 3.终止操作（终端操作）
 */
public class TestStreamAPI2 {
    List<Employee> employees = Arrays.asList(
            new Employee(1, "张三", 18, 9999.99),
            new Employee(2, "李四", 38, 5555.55),
            new Employee(3, "王五", 50, 6666.66),
            new Employee(4, "赵六", 16, 3333.33),
            new Employee(5, "田七", 8, 7777.77),
            new Employee(7, "田七", 8, 7777.77),
            new Employee(7, "田七", 8, 7777.77),
            new Employee(7, "田七", 8, 7777.77)

    );

    //中间操作

    /**
     *         排序
     *         sorted()——自然排序 Comparable
     *         sorted(Comparator com)——定制排序 Comparator
     */
    @Test
    public void test7() {
        List<String> list = Arrays.asList("ccc", "aaa", "bbb", "ddd", "eee");

        list.stream()
                .sorted()
                .forEach(System.out::println);
        System.out.println("--------------------------------------------------------");

        employees.stream()
                .sorted((e1,e2)->{
                    if(e1.getAge().equals(e2.getAge())){
                        return e1.getName().compareTo(e2.getName());
                    }else {
                        return -e1.getAge().compareTo(e2.getAge());
                    }
                }).forEach(System.out::println);
    }


    /**
     *         映射
     *         map——接收Lambda，将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其
     *         映射成一个新的元素。
     *         flatMap——接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
     */
    @Test
    public void test5() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
        list.stream()
                .map((str) -> str.toUpperCase())
                .forEach(System.out::println);

        System.out.println("-------------------------------------");

        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
        System.out.println("-------------------------------------");

        Stream<Stream<Character>> stream = list.stream()
                .map(TestStreamAPI2::filterCharacter);

        stream.forEach((sm) -> {
            sm.forEach(System.out::println);
        });
        System.out.println("-------------------------------------");
        Stream<Character> sm = list.stream()
                .flatMap(TestStreamAPI2::filterCharacter);

        sm.forEach(System.out::println);
    }

    @Test
    public void test6() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");

        List list2 = new ArrayList();
        list2.add(11);
        list2.add(22);
        list2.addAll(list);

        System.out.println(list2);
    }

    public static Stream<Character> filterCharacter(String str) {
        List<Character> list = new ArrayList<>();

        for (Character ch : str.toCharArray()) {
            list.add(ch);
        }
        return list.stream();
    }

    /**
     *         筛选与切片
     *         filter——接收Lambda，从流中排除某些元素。
     *         limit——阶段流，使其元素不超过给定数量。
     *         skip(n)——跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回一个空流。与limit(n)互补
     *         distinct——筛选，通过流所生成元素的hashCode()和equals()去除重复元素
     */
    @Test
    public void test4() {
        employees.stream()
                .filter(e -> e.getSalary() > 5000)
                .skip(2)
                .distinct()
                .forEach(System.out::println);
    }

    @Test
    public void test3() {
        employees.stream()
                .filter((e) -> {
                    System.out.println("短路！");
                    return e.getSalary() > 5000;
                })
                .limit(2)
                .forEach(System.out::println);
    }

    //内部迭代：迭代操作由Stream API完成
    @Test
    public void test1() {
        //中间操作：不会执行任何操作
        Stream<Employee> stream = employees.stream()
                .filter(e -> {
                    System.out.println("Stream API 的中间操作，没有终止操作不执行");
                    return e.getAge() > 35;
                });
        //终止操作：一次性执行全部内容，即“惰性求值”
        stream.forEach(System.out::println);

    }

    //外部迭代
    @Test
    public void test2() {
        Iterator<Employee> it = employees.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
