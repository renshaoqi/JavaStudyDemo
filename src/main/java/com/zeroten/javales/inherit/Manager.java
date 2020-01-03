package com.zeroten.javales.inherit;

import java.util.Date;

public class Manager extends Employee {
    private Integer bonus;  // 奖金

    public Manager() {
        System.out.println("执行 Manager 的无参数构造方法");
    }

    public Manager(String name, Date Day, Integer salary, Integer bonus) {
//        setName(name);
//        setDay(Day);
//        setSalary(salary);
        super(name, Day, salary);
        this.bonus = bonus;

        System.out.println("执行 Manager 的有参数构造方法");
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    @Override
    public Integer getSalary() {
        if (bonus == null) {
            return super.getSalary();
        }
        return super.getSalary() + bonus;
    }
}
