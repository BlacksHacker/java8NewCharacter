package com.google.Test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @program: java8
 * @description:
 * @author: Shelton_Lee
 * @create: 2018-06-02 21:40
 **/
public class TestLambda3 {


    //Consumer 消费型接口
    @Test
    public void test1(){
        happy(300, (m) -> System.out.println("消费"+m));
    }

    public void happy(double money, Consumer<Double> con){
        con.accept(money);
    }

    //供给型接口 Supplier
    @Test
    public void test2(){
        List list =  getList(5, () ->(int) Math.random() * 100);
        System.out.println(list.size());
    }

    public List<Integer> getList(int num, Supplier<Integer> sup){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++){
            int number = sup.get();
            list.add(number);
        }
        return list;
    }

    //Function<T,R> 函数型接口

    @Test
    public void test3(){
       String upper =  strHandler("adcccc", (str) -> str.toUpperCase());
        System.out.println(upper);
    }

    public String strHandler(String str, Function<String, String> fun){
        return fun.apply(str);
    }

    //断言型接口
    //将满足条件的字符串放入到集合中去

    public List<String> getList(List<String> list, Predicate<String> pre){
        List<String> strList = new ArrayList<>();
        for (String str:
             list) {
            if(pre.test(str)){
                strList.add(str);
            }
        }
        return  strList;
    }

    @Test
    public void test4(){
        List<String> list = Arrays.asList("Hello", "Sayy", "Web", "Java");
        List<String> strList = getList(list,(str) -> str.length() > 3);
        for (String str: strList
             ) {
            System.out.println(str);
        }
    }
}
