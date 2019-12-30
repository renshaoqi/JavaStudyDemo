package com.zeroten.javales.classObject;

import org.junit.Test;

public class VarTest {
    // 没有使用 static 修饰的是 实例变量，每个实例有单独的拷贝
    // index 用于存放当前是类的第几个实例
    public int index;

    // 使用 static 修饰的是类变量，所有实例共享
    // 用于记录创建的该类的实例个数
    public static int count = 0;

    public VarTest () {}

    public VarTest (int index) {
        this();
        this.index = index;
    }

    public VarTest (int index, int count) {
        this(index);
        this.count = count;
    }

    public void println() {
        String logStr = String.format("当前创建第%d实例，共%d个", index, count);
        System.out.println(logStr);
    }

    public static void main(String[] args) {
        VarTest v1 = new VarTest();
        v1.index = 1;
        VarTest.count++;
        // System.out.println("当前创建第" + v1.index + "个实例，共" + VarTest.count + "个");
        v1.println();
        VarTest v2 = new VarTest();
        v2.index = 2;
        VarTest.count++;
        // System.out.println("当前创建第" + v2.index + "个实例，共" + VarTest.count + "个");
        v2.println();
        System.out.println("v1看得的count=" + v1.count);
        System.out.println("v2看得的count=" + v2.count);

        System.out.println("v1看得的index=" + v1.index);
        System.out.println("v2看得的index=" + v2.index);
        VarTest v3 = new VarTest(3, 3);
        System.out.println("v3看得的index=" + v3.index);
        System.out.println("v3看得的count=" + v3.count);

    }
}
