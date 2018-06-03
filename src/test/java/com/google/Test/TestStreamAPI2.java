package com.google.Test;

import com.google.pojo.Employee;
import org.junit.Test;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;
import java.util.stream.Stream;

/**
 * @program: java8
 * @description:
 * @author: Shelton_Lee
 * @create: 2018-06-03 15:56
 *
 *
 **/
public class TestStreamAPI2 {

    List<Employee> emps = Arrays.asList(
            new Employee(101,"张三",18,9999.99),
            new Employee(102,"李四",59,6666.66),
            new Employee(103,"王五",28,3333.33),
            new Employee(104,"赵六",8,7777.77),
            new Employee(105,"田七",38,5555.55)

    );
    /*
    * 筛选与切片
    * filter
    * limit
    * skip
    * distinct
    *
    * */
    //内部迭代：迭代操作由StreamAPI完成
    //filter -- 接受Lambda，从流中排除某些元素
    @Test
    public void test1(){

        //中间操作：不会执行任何操作
        Stream<Employee> stream1 = emps.stream()
                .filter((e) -> e.getAge() > 35);

        //终止操作，一次性执行全部，即“”“”"惰性求值"
        stream1.forEach(System.out::println);
    }

    //limit 截断流
    //短路，前面条件不通过，后面的不用执行
    @Test
    public void test2(){
        emps.stream()
            .filter((e) -> {
                System.out.println("短路");
                return e.getSalary() > 5000;
            })
            .limit(2)
            .forEach(System.out::println);
    }

    //skip(n) 返回一个扔掉前n个元素的流，若不足n个，则返回一个空流，与limit互补
    //distinct 筛选，通过流所生成元素的HashCode（）和equals（）去掉重复元素。



    /*
    *映射
    * map
    * flatMap
    * */


    //map - 接受Lambda，将元素转换为其他形式或提取信息，接受一个函数作为参数，该函数会被应用到每个元素上，并将其映射为一个新的元素

    @Test
    public void test3(){
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");

        list.stream()
                .map((str) -> str.toUpperCase())
                .forEach(System.out::println);
        //提取信息
        emps.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }

    //将一个字符串转化为一个个字符，再转化为流的形式
    public static Stream<Character> filterCharacter(String str){
        List<Character> list = new ArrayList<>();

        for (Character ch : str.toCharArray()
             ) {
            list.add(ch);
        }
        return list.stream();
    }

    @Test
    public void test4(){
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        Stream<Stream<Character>> stream = list.stream()
                .map(TestStreamAPI2::filterCharacter);
        stream.forEach((sm) -> {
            sm.forEach(System.out::println);
        });
    }

    @Test
    public void test5(){
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        Stream<Character> sm = list.stream()
                .flatMap(TestStreamAPI2::filterCharacter);
        sm.forEach(System.out::println);
    }

    /*
    * 排序
    * sorted（）--自然排序（Comparable）
    * sorted(Comparator com)--定制排序（Comparator）
    * */

    @Test
    public void test6(){
       List <String> list = Arrays.asList("cc", "bb", "aa", "dd");
        list.stream()
                .sorted()
                .forEach(System.out::println);

        emps.stream()
                .sorted((e1, e2) -> {
                    if(e1.getAge().equals(e2.getAge()))
                        return e1.getName().compareTo(e2.getName());
                    else
                        return e1.getAge().compareTo(e2.getAge());
                })
                .forEach(System.out::println);
    }
}
