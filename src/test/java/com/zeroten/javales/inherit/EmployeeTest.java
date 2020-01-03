package com.zeroten.javales.inherit;

import org.testng.annotations.Test;

import java.util.Date;

public class EmployeeTest {
    @Test
    public void testPrint() {
        Employee ep = new Employee("R先生", new Date(), 100);
//        ep.setName("R先生");
//        ep.setDay(new Date());
//        ep.setSalary(100);
        ep.print();
        System.out.println("================================");
        Manager jl = new Manager("沐沐", new Date(), 100, 50);
//        jl.setName("沐沐");
//        jl.setDay(new Date());
//        jl.setBonus(50);
//        jl.setSalary(100);
        jl.print();
    }
}
