package com.zeroten.javales.classObject;    // 1 包定义
import org.junit.Test;  // 2 包导入
public class ClassZucheng {
    // 3 实例变量或域变量
    private String name;
    // 3 类变量、静态变量
    private static String count;
    {
        // 7 初始化代码块 或 实例代码块
        System.out.println("类、方法之外用大括号扩起来的代码");
    }
    static {
        // 7 静态代码块 或 静态初始化代码块
        System.out.println("类、方法之外用大括号扩起来且前边有 static 修饰的代码");
    }
    // 4 实例方法
    public void print() {}
    // 4 静态方法
    public static void print1() {}
    // 5 构造器 或 构造方法
    public ClassZucheng() {}
    // 5 内部类
    class InnerClass {}
    @Test
    public void name() {
    }
}
