package com.zeroten.javales.inherit;

public interface Interface {
    class InnerClass {}
    interface InnerInterface{}
    int MAX_COUNT = 100;
//    void method(){};  接口中定义的方法不能有方法体
    void method();
    default void print() {  // java 8 中新增的功能 这个默认方法不能覆盖 Object 中的方法，但可以重载 Object 中的方法；重载：方法名相同。参数类型或参数个数不同
        System.out.println("我是一个默认方法");
    }
    static void print2() {
        // Java 8 中新增的功能 静态方法：必须包含方法体
        // 接口中的静态方法是不能被继承的只能通过接口来访问
        System.out.println("我是一个Java8中新增的静态方法");
    }
}
