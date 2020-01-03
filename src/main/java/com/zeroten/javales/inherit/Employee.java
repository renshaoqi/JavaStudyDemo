package com.zeroten.javales.inherit;

import java.util.Date;

public  class Employee {
    private String name;    // 姓名
    private Date Day;   // 入职时间
    private Integer salary; // 薪水

    public Employee() {
        System.out.println("执行 Employee 的无参数构造方法");
    }

    public Employee(String name, Date Day, Integer salary) {
        this.name = name;
        this.Day = Day;
        this.salary = salary;
        System.out.println("执行 Employee 的有参数构造方法");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDay() {
        return Day;
    }

    public void setDay(Date day) {
        Day = day;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append("姓名：");
        sb.append(getName());
        sb.append(", 入职时间：");
        sb.append(getDay());
        sb.append(", 薪水标准：");
        sb.append(getSalary());

        System.out.println(sb.toString());
    }
}
