package com.zeroten.javales.classObject;

import org.testng.annotations.Test;

public class ClassThisTest {
    private int index;
    // 构造器
    public ClassThisTest () {}
    // 实例方法
    public void println(String name) {
        System.out.println(this.index + ".hello" + name);
    }

    // 可变参数
    public void println(int... nums) {
        if (nums == null) {
            System.out.println("si null");
        }
        if (nums.length == 0) {
            System.out.println("param length is zero");
        }
        System.out.println("...............");
        for (int n = 0; n < nums.length; n++) {
            System.out.println(nums[n]);
        }
    }

    @Test
    public void testThis() {
        ClassThisTest obj = new ClassThisTest();
//        obj.println("work");
//        obj.println();
//        obj.println(1);
        obj.println(1, 3, 5, 7);
    }
}
