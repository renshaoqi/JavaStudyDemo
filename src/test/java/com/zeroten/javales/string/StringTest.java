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

        // 前缀判断
        System.out.println(str1.startsWith("H"));
        System.out.println(str1.startsWith("h"));

        // 后缀判断
        System.out.println(str1.endsWith("o"));

        // 包含判断
        System.out.println(str1.contains("ll"));
        System.out.println(str1.contains("hll"));
    }

    @Test
    public void test字符串查找() {
        String str = "hello, world";
        System.out.println(str.indexOf("l"));   // 返回索引值，找不到返回 -1
        System.out.println(str.indexOf('e'));
        System.out.println(str.indexOf(101));   // 根据 ASCII 值进行查找

        // 例 查找某个字符在字符串中出现的次数
        int index = -1;
        do {
            int at = str.indexOf("o", index + 1);
            if (at == -1) {
                break;
            }
            System.out.println(String.format("第 %d 位是小写字母o", at + 1));
            index = at;
        } while (true);
    }

    @Test
    public void test替换() {
        String str = "hello, world";
        System.out.println(str.replace("o", "O"));
    }

    @Test
    public void test除去空格() {
        String str = "   hello world    ";
        System.out.println(str.trim());
    }

    @Test
    public void test大小写转换() {
        String str = "Hello,world";
        System.out.println(str.toUpperCase());
        System.out.println(str.toLowerCase());
    }

    @Test
    public void testStringBuffer_StringBuilder() {
        StringBuffer sb = new StringBuffer();
        sb.append("hello");
        sb.append(",");
        sb.append("world");
        sb.append(".");
        System.out.println(sb.toString());
    }

    @Test
    public void testJVM优化() {
        // 1 字符串拼接
        String str = "hello" + "world"; // 这样会产生三个中间对象存放到常量池中，比较浪费内存
        // JVM 会自动进行上面的代码优化，如下
        String str1 = "hello world";

        // 2 字符串拼接 变量
        String str2 = "hello";
        String str3 = str2 + " world";
        // JVM 优化后
        StringBuilder str4 = new StringBuilder();
        str4.append(str2);
        str4.append(" world");

        // 3 循环示例
        long startTime = System.currentTimeMillis();    // 获取当前的时间，单位毫秒
        String str5 = "";
        for (int i = 0; i < 50000; i++) {
            str5 += i;
        }
        System.out.println(str5.length());
        long endTime = System.currentTimeMillis();
        System.out.println("耗时: " + (endTime - startTime) + "毫秒");
        // JVM 优化后
        long start = System.currentTimeMillis();
        String str6 = "";
        for (int n = 0; n < 50000; n++) {
            StringBuilder sb = new StringBuilder();
            sb.append(str6);
            sb.append(n);
            str6 = sb.toString();
        }
        long end = System.currentTimeMillis();
        System.out.println(str6.length());
        System.out.println("耗时: " + (end - start) + "毫秒");

        // 自己直接用 StringBuilder 来编写
        start = System.currentTimeMillis();
        String str7 = "";
        StringBuilder sb1 = new StringBuilder();
        for (int n = 0; n < 50000; n++) {
            sb1.append(n);
        }
        str7 = sb1.toString();
        System.out.println(str7.length());
        System.out.println("耗时: " + (end - start) + "毫秒");
    }
}
