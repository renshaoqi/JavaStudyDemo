package com.zeroten.javales.classObject;

public class ClassStaticTest {
    private static int count;
    public ClassStaticTest() {
        count++;
    }
    public static void printCount() {
        System.out.println("共实例了" + count + "次");
    }
    public static void main(String[] args) {
        new ClassStaticTest();
        new ClassStaticTest();
        new ClassStaticTest();
        new ClassStaticTest();
        new ClassStaticTest();
        ClassStaticTest.printCount();
    }
}
