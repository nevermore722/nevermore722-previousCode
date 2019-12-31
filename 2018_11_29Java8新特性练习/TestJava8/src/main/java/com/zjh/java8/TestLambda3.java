package com.zjh.java8;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Java8 内置四大核心函数接口
 * Consumer<T>:消费型接口
 *      void accept(T t);
 *
 * Supplier<T>:供给型接口
 *      T get();
 *
 * Function<T,R>:函数型接口
 *      R apply(T t);
 *
 * Predicate<>:断言型接口
 *      boolean test(T t);
 *
 */
public class TestLambda3 {

    //Predicate<T> 断言型接口：
    @Test
    public void test4(){
        List<String> list = Arrays.asList("Hello","zjh","Lambda","www","ok");
        List<String> list1 = filterStr(list, (s) -> s.length() > 3);

        for (String str:list1) {
            System.out.println(str);
        }

    }

    //需求：将满足条件的字符串，放入集合中
    public List<String> filterStr(List<String> list, Predicate<String> predicate){
        List<String> strList = new ArrayList<>();

        for (String str:list){
            if (predicate.test(str)){
                strList.add(str);
            }
        }
        return strList;
    }
    //Function<T,R>函数型接口：
    @Test
    public void test3(){
        String s = strHandler("\t\t\t\t\t   测试处理字符串   ", (str) -> str.trim());
        System.out.println(s);

        String s2 = strHandler("测试处理字符串", (str) -> str.substring(2, 5));
        System.out.println(s2);
    }


    //需求：用于处理字符串
    public String strHandler(String str, Function<String,String> function){
        return function.apply(str);
    }


    //Supplier<T>供给型接口：
    @Test
    public void test2(){
        List<Integer> numList = getNumList(10,()->(int)(Math.random()*100));

        for (Integer num : numList){
            System.out.println(num);
        }
    }

    //需求：产生指定个数的整数，并放入集合中
    public List<Integer> getNumList(int num, Supplier<Integer> supplier){
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            Integer n = supplier.get();
            list.add(n);
        }
        return list;
    }

    //Consumer<T>消费型接口：
    @Test
    public void test1(){
        happy(10000,m-> System.out.println("消费型接口输出m:"+m));
    }

    public void happy(double money, Consumer<Double> con){
        con.accept(money);
    }



}
