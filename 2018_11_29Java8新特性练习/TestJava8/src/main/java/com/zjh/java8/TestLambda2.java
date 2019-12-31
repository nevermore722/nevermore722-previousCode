package com.zjh.java8;

import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;
import java.util.function.Consumer;

/**
 * 一、Lambda表达式的基础语法：Java8中引入了一个新的操作符"->"该操作符称为箭头操作符或Lambda操作符
 * 箭头操作符将Lambda表达式拆分成两部分：
 * <p>
 * 左侧：Lambda表达式的参数列表
 * 右侧：Lambda表达式中所需执行的功能，即Lambda体
 * <p>
 * 语法格式一：无参数，五返回值
 * () -> System.out.println("Hello Lambda!")
 * <p>
 * 语法格式二：有一个参数，并且无返回值
 * (x) -> System.out.println(x)
 * <p>
 * 语法格式三：若只有一个参数，小括号可以省略不写
 * (x) -> System.out.println(x)
 * <p>
 * 语法格式四：有两个以上参数，并且Lambda体中有多条语句
 * Comparator<Integer> com = (x,y) ->{
 * System.out.println("函数式接口");
 * return Integer.compare(x,y);
 * };
 * <p>
 * 语法格式五：若Lambda体中只有一条语句，return和大括号都可以省略不写
 * (x, y) -> Integer.compare(x, y);
 * <p>
 * 语法格式六：Lambda表达式的参数列表的数据类型可以省略不写，因为JVM编译器通过上下文推断出，数据类型，即“类型推断”
 * （Integer x,Integer y) -> Integer.compare(x,y);
 * <p>
 * 上联：左右遇一括号省
 * 下联：左侧推断类型省
 * 横批：能省则省
 * <p>
 * 二、Lambda表达式需要“函数式接口”的支持
 * 函数式接口：接口中只有一个抽象方法的接口，称为函数式接口。可以使用注解@FunctionalInterface修饰
 * 可以检查是否是函数式接口
 */
public class TestLambda2 {

    @Test
    public void test1() {
        int num = 0;//jdk 1.7前，必须是final

        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!" + num);
            }
        };

        r.run();

        System.out.println("------------------------------------------------------------");

        Runnable r1 = () -> System.out.println("Hello Lambda!");
        r1.run();
    }

    @Test
    public void test2() {
        Consumer<String> con = (x) -> System.out.println(x);
        con.accept("我是zjh");
    }

    @Test
    public void test3() {
        Comparator<Integer> com = (x, y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x, y);
        };
    }

    @Test
    public void test4() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
    }

    @Test
    public void test5() {
//        String[] strs;
//        strs = {"aaa","bbb","ccc"};

        List<String> list = new ArrayList<>();

        show(new HashMap<>());
    }

    public void show(Map<String, Integer> map) {

    }

    //需求：对一个数进行运算
    @Test
    public void test6() {
        Integer num = operation(100, x -> x * x);
        System.out.println(num);

        System.out.println(operation(200, (y) -> y + 200));
    }

    public Integer operation(Integer num, MyFun mf) {
        return mf.getValue(num);
    }


}
