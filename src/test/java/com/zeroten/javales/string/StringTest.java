package com.zeroten.javales.string;

import org.junit.Test;

public class StringTest {

    @Test
    public void testString() {
        String str1 = "hello";
        String str2 = "hello";
        String str3 = "hello" + "world";
        String str4 = str2 + "world";
        String str5 = new String("hello");
        String str6 = new String("hello");
        String str7 = str6.intern();
        String str8 = new String("hello").intern();
        System.out.println(str1 == str2);   // true
        System.out.println(str3 == str4);   // false
        System.out.println(str1 == str5);   // false
        System.out.println(str5 == str6);   // false
        System.out.println(str5 == str6);   // false
        System.out.println(str5.equals(str6));  // true
    }

    @Test
    public void testStringLength() {
        String str = "hello world";
        System.out.println(str.length());
        // 计算字符串的实际长度及代码点数
        System.out.println(str.codePointCount(0, str.length()));
    }

    @Test
    public void test字符串截取() {
        String str = "hello world";
        System.out.println(str.substring(1));
        System.out.println(str.substring(6));
    }

    @Test
    public void test字符串比较() {
        String str1 = "Hello";
        String str2 = "hello";
        System.out.println(str1.equals(str2));
        System.out.println(str1.equalsIgnoreCase(str2));    // 忽略大小写
    }
}
