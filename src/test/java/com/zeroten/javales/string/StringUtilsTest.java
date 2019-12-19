package com.zeroten.javales.string;

import com.zeroten.javales.flow.StringUtils;
import org.junit.Assert;
import org.junit.Test;

public class StringUtilsTest {
    // 去掉字符串开头/结尾/中间的空格（不使用 trim 方法）
    @Test
    public void testTrimAll() {
        // 断言
        String hello = "hello";
        Assert.assertEquals(StringUtils.trimAll(" hello"), hello);
        Assert.assertEquals(StringUtils.trimAll("    hello"), hello);
        Assert.assertEquals(StringUtils.trimAll("hello "), hello);
        Assert.assertEquals(StringUtils.trimAll("hello    "), hello);
        Assert.assertEquals(StringUtils.trimAll("he llo"), hello);
        Assert.assertEquals(StringUtils.trimAll("  he llo  "), hello);
    }
    
    // 反转字符串  321 反转成 123

    @Test
    public void testReverse() {
        Assert.assertEquals(StringUtils.reverse("hello"), "olleh");
        Assert.assertEquals(StringUtils.reverse("123"), "321");

        String str1 = "hello" + " world";
        String str2 = "hello";
        str2 += " world";
        String str3 = "hello world";
        String str4 = str2.intern();
        System.out.println(str1 == str2); //false
        System.out.println(str1 == str3); // true
        System.out.println(str1 == str4); // true
        System.out.println(str2 == str3); // false
        System.out.println(str2 == str4); // false
    }
}
