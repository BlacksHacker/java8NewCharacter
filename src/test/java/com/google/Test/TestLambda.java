package com.google.Test;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import com.google.pojo.Employee;

/**
 * @program: java8
 * @description:
 * @author: Shelton_Lee
 * @create: 2018-06-02 18:42
 **/
public class TestLambda {
    List<Employee> emps = Arrays.asList(
            new Employee(101,"张三",18,9999.99),
            new Employee(102,"李四",59,6666.66),
            new Employee(103,"王五",28,3333.33),
            new Employee(104,"赵六",8,7777.77),
            new Employee(105,"田七",38,5555.55)
    );
    @Test
    public void test1(){
        Collections.sort(emps,(e1,e2) -> {
            if(e1.getAge() == e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            }else{
                return Integer.compare(e1.getAge(),e2.getAge());
            }

        });

        for (Employee emp : emps){
            System.out.println(emp);
        }
    }

    /*
     *
     * @author Shelton_Lee
     * @date 2018/6/2 21:13
     * @param   传入一个参数，一个处理方法的对象
     * @return   处理后的字符串
     */
    public String strHandler(String str,MyFunction mf){
        return mf.getValue(str);
    }

    @Test
    public void test2(){
        String upperStr = strHandler("abfds",(str) -> {
            return str.toUpperCase().toLowerCase();
        });
        System.out.println(upperStr);
    }


    public void op(Long l1, Long l2, MyFunction2<Long, Long> mf){
        System.out.println(mf.getValue(l1, l2));
    }

    @Test
    public void test3(){
        op(200L, 300L, (l1, l2)->l1*l2);
    }
}
