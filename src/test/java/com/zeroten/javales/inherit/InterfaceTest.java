package com.zeroten.javales.inherit;

import org.testng.annotations.Test;

public class InterfaceTest {
    @Test
    public void testInterface() {
        // Interface i1 = new Interface(); 报错 接口不能使用 new 操作符进行实例化
        Interface i2 = new InterfaceImpl(); // 接口对象必须引用实现了接口的类对象
        i2.method();
        System.out.println(i2 instanceof Interface);    // 检查一个对象是否实现了某个特定的接口

        // 访问接口中的常量 建议使用 接口名来访问
        System.out.println(Interface.MAX_COUNT);    // 建议使用这种方法来访问
        System.out.println(i2.MAX_COUNT);
        System.out.println(InterfaceImpl.MAX_COUNT);
        i2.print();


    }
}
