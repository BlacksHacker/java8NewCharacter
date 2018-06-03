package com.google.pojo;

/**
 * @program: java8
 * @description:
 * @author: Shelton_Lee
 * @create: 2018-06-02 18:45
 **/
public class Employee {
    private Integer id;
    private String name;
    private Integer age;
    private Double salary;
    private Status Status;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Employee(Integer id, String name, Integer age, Double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Employee(Integer id, String name, Integer age, Double salary, Employee.Status status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        Status = status;
    }

    public Employee() {
    }

    public Employee(int id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", Status=" + Status +
                '}';
    }

    public Employee.Status getStatus() {
        return Status;
    }

    public void setStatus(Employee.Status status) {
        Status = status;
    }

    public enum Status{
        FREE,
        BUSY,
        VOCATION;
    }
}
