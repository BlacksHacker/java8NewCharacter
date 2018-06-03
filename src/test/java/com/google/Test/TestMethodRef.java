package com.google.Test;

import com.google.pojo.Employee;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @program: java8
 * @description:
 * @author: Shelton_Lee
 * @create: 2018-06-03 11:13
 *
 * 方法引用
 **/
public class TestMethodRef  {


    //对象：：实例方法名
     @Test
    public void test1(){
        PrintStream ps1 = System.out;

        Consumer<String> con = (x) -> System.out.println(x);

        PrintStream ps2 = System.out;
        Consumer<String> con1 = ps2::println;
        Consumer<String> con2 = System.out::println;
        con2.accept("abcdef");
    }

    //类：：静态方法
    @Test
    public void test2(){
        Comparator<Integer> com1 = (x, y) -> Integer.compare(x, y);

        Comparator<Integer> com2 = Integer::compare;
    }

    //类 :: 实例方法
    @Test
    public void test3(){
        BiPredicate<String, String> bp = (x, y) -> x.equals(y);

        BiPredicate<String, String> bp1 = String::equals;
    }

    //构造器引用
     @Test
    public void test4(){
         Supplier<Employee> su1 = () -> new Employee();

         Supplier<Employee> su2 = Employee::new;
     }

     @Test
    public void test6(){
         Function<Integer, Employee> fun = (x) -> new Employee(x);
         Function<Integer, Employee> fun2 = Employee::new;
         Employee emp = fun2.apply(101);
         System.out.println(emp.getId());
     }

     //数组引用

    //格式；  ClassName::new
    @Test
    public void test7(){
         Function<Integer,String[]> fun1 = (x) -> new String[x];
         String[] strArray = fun1.apply(10);
        System.out.println(strArray.length);

        Function<Integer, String[]> fun2 = String[]::new;
        String[] str2Array = fun2.apply(20);
        System.out.println(str2Array.length);
    }

}
