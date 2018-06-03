package com.google.Test;

import com.google.pojo.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @program: java8
 * @description:
 * @author: Shelton_Lee
 * @create: 2018-06-03 18:47
 *
 * 终止操作
 * 查找与匹配
 * allMatch -- 检查是否匹配所有元素
 * anyMatch -- 检查是否至少匹配一个元素
 * noneMatch -- 检查是否没有匹配所有元素
 * findFirst -- 返回第一个元素
 * count -- 返回流中元素的总个数
 * max -- 返回流中的最大值
 * min -- 返回流中的最小值
 *
 **/
public class TestStreamAPI3 {
    List<Employee> emps = Arrays.asList(
            new Employee(101,"张三",18,9999.99, Employee.Status.FREE),
            new Employee(102,"李四",59,6666.66, Employee.Status.BUSY),
            new Employee(103,"王五",28,3333.33, Employee.Status.VOCATION),
            new Employee(104,"赵六",8,7777.77, Employee.Status.FREE),
            new Employee(105,"田七",38,5555.55, Employee.Status.BUSY)
    );
    @Test
    public void test1(){
        boolean b1 = emps.stream()
                .allMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b1);

        boolean b2 = emps.stream()
                .anyMatch((e) -> e.getStatus().equals(Employee.Status.VOCATION));
        System.out.println(b2);

        boolean b3 = emps.stream()
                .noneMatch((e) -> e.getStatus().equals(Employee.Status.FREE));
        System.out.println(b3);

        Optional<Employee> op = emps.stream()
                .sorted((e1, e2) -> -Double.compare(e1.getSalary(), e2.getSalary()))
                .findFirst();
        System.out.println(op.get());
    }


    @Test
    public void test2(){
        Long count = emps.stream()
            .count();
        System.out.println(count);

        Optional<Employee> op1  = emps.stream()
                .max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(op1);

        Optional<Double> op2 = emps.stream()
                .map(Employee::getSalary)
                .min(Double::compare);
        System.out.println(op2.get());
    }
}
