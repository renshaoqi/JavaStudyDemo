**字符串**
- 字符串的定义、创建
- 字符串常用操作： 长度、子串、拼接等
- String/ StringBuffer / StringBuilder
- JVM 对字符串的优化
- 应用练习： 使用 TDD 编写
- 常见面试问题

**数组**
- 数组定义及声明
- 数组的初始化
- 数组遍历
- 数组拷贝
- 数组填充
- 数组排序
- 多维数组和不规则数组
- 应用练习
- 常见面试问题

# 字符串
&emsp;&emsp;Java 字符串就是 Unicode 字符序列。Java 没有内置的字符类型，而是在标准 
Java 类库中提供了一个预定义类 String 。每个用双引号括起来的字符串都是 String 类的一
个实例。可以通过直接赋值或者 new 操作符来创建字符串。
```
String str1 = "";
String str2 = "hello world";
String str3 = new String("create String with new"); 
```
&emsp;&emsp;String 类没有提供用于修改字符串的方法，所以我们将 String 类对象称为不可
变字符串，它被声明为 final class，所有的属性也被定义为 final 。但是我们可以修改字符
串变量，让它的值指向另外一个字符串。

&emsp;&emsp;为了提高内存利用率，JVM 有一个字符常量池，每次使用双引号定义字符串，JVM 会先
到常量池中来检测是否已经存在，存在则直接对该对象的引用；否则在常量池中创建一个新增并返回该值
的引用。

&emsp;&emsp;使用 new 创建字符串（new String("字符串")）时，会直接在堆中创建该字符串并返回
其引用。从 java6 开始，String 类提供了 intern() 方法，调用该方法时，JVM 去字符串常量检测是
否已存在该字符串，如果已存在则返回引用；如果不存在则在常量池中添加并返回其引用。

&emsp;&emsp;Java 6中，字符串常量池存在 PermGen 里，也就是("永久代")，而这个空间是有限的，基
本不会被 FullGC 之外的垃圾收集机制扫描。如果使用不当，经常会发生 OOM。在后续的版本中，将字符串
常量池放在堆中，而且默认的缓存大小也在不断的扩大。在 java 8 中永久代 PermGen 也被元数据区
MetaSpace 替代。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20191218103723291.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3JlbnNoYW9xaQ==,size_16,color_FFFFFF,t_70)

# 字符串操作
**长度**
- `int length()` 返回采用 UTF-16 编码表示的给定字符串所需要的代码单元数量。也就是 String 内部
 char 数组的长度。（char 数据类型是一个采用 UTF-16 编码表示 Unicode 代码点的代码单元）
- `int codePointCount(int begIndex, int endIndex)` 表示字符串的实际长度，及代码点数。

**子串**
- `String substring(int beginIndex)`
- `Stirng substring(int beginIndex, int endIndex)`
```
String str = "hello world"
System.out.println(str.substring(1));
System.out.println(str.substring(0, 1));
System.out.println(str.substring(0, str.length()- 1 ));
System.out.println(str.substring(0, str.length() + 1));
```

**拼接**

可以直接使用 + 和 += 运算符来进行字符串的拼接，例如：
- String str = "hello" + "world";
- String str = "hello"; str += "world";
- String str = "hello"; str = str + "world";

**格式化**

为了让字符串拼接更简洁直观，我们可以使用字符串格式化方法 String.format
- %s 字符串
- %c 字符类型
- %b 布尔类型
- %d 整数类型（十进制数）
- %x 整数类型（十六进制数）
- %o 整数类型（八进制数）
- %f 浮点类型
- %a 浮点类型（十六进制数）
- %% 百分比类型
- %n 换行

**判断**
- 相等判断
```java
equals 判断值是否相等
equalsIgnoreCase 不区分大小写，判断值是否相等。
```
- 前缀判断
```java
"hello".startsWith("h"); // true
```
- 后缀判断
```java
"hello".endsWith("o");   // true 
```
- 包含判断
```java
"hello".contains("ll");  // true
```

**查找**
- indexOf 从前面查找
- lastIndexOf 从后面查找

示例：
```java
String str = "hello, world";
System.out.println(str.indexOf("e"));   // 返回 索引位置
System.out.println(str.indexOf('e'));   

```
**查找替换**
- replace
- replaceAll 使用正则表达式匹配

示例：
```java
String str = "hello, world";
System.out.println(str.replace("o", "O"));
```
**去空格**
```java
System.out.println("hello world".trim());   // 去除两边的空格
```

**大小写转换**
```java
System.out.println("Hello, world".toUpperCase());   // 转大写
System.out.println("Hello, world".toLowerCase());   // 转小写
```

**空串和 Null 串**
- 空串是一个长度为0且内容为空的 String 对象。
- String 存放 null，表示没有任何对象与该变量关联。    

## String / StringBuilder / StringBuffer
&emsp;&emsp;String 在拼接过程中或操作不当时，可能会产生大量的中间对象。而 StringBuffer 就是
为了解决这个问题而提供的一个类，StringBuffer 是线程安全的，如果没有线程安全的需要则使用
StringBuilder（Java 1.5 中新增）。

&emsp;&emsp;`StringBuffer` 和 `StringBuilder` 都继承自 AbstractStringBuilder 类，而
 StringBuffer 类的所有方法都使用关键字 synchronized 来保证线程安全的。它们的底层都是通过可
 修改的 char 数组（java 9 以后改为 byte 数组实现）来实现修改。以下内容没有特别说明则均基于
 Java 8
 
 &emsp;&emsp;StringBuffer, StringBuilder 在创建时，如果未指定容量，默认容量为 16。如果容量
 可预估，则最好在创建时指定合适的大小，这样可以避免多次扩容。扩容会产生多重开销：抛弃原数组、创建
 新的数组、进行arraycopy(数组拷贝)。
 
 &emsp;&emsp;StringBuffer, StringBuilder 常用方法：
 - append 在字符串结尾追加
 - length 返回当前的长度
 - setLength 设置字符串长度
 
 示例：
 ```java
StringBuffer sb = new StringBuffer();
sb.append("hello");
sb.append(",");
sb.append("world");
System.out.println(sb.toString());
```

## JVM 对字符串的优化
&emsp;&emsp;现代 JVM 的实现是很智能的，编译时 JVM 对 String 操作进行一些优化以提高程序的运行
效率

示例1:
```java
String str = "hello" + "," + "world";
System.out.println(str);
```

JVM 优化后
```java
String str = "hello,world";
System.out.prnitln(str);
```

示例2:
```java
String str1 = "hello";
String str2 = str1 + " world";
```
JVM 优化后
```java
String str1 = "hello";
StringBuilder str2 = new StringBulider();
str2.append(str1);
str2.append(" world");
```

示例3:
```java
long start = System.currentTimeMillis();
String str = "";
for (int i = 0; i < 50000; i++) {
    str += i;
}
System.out.println(str.length());
System.out.println("耗时:" + (System.currentTimeMillis() - start) + "ms");
```

## 应用练习
**1 去掉字符串开头/结尾/中间的空格（不使用trim）方法**
```java
// 源程序 StringUtils.java
public static String tirmAll(String str) {
    StringBulider sb = new StringBulider();
    char[] chars = str.toCharArray();
    for(int index = 0; index < chars.length; index++) {
        if (chars[index] == ' ') {
            continue;
        }       
        sb.append(chars[index]);
    }
    return sb.toString();
}

// 测试程序 StringUtilsTest.java
@Test
public void testTirmAll() {
    String str = "hello";
    Assert.assertEquals(StringUtils.tirmAll(" hello"), hello);
    Assert.assertEquals(StringUtils.tirmAll("    hello"), hello);
    Assert.assertEquals(StringUtils.tirmAll("hel lo"), hello);
    Assert.assertEquals(StringUtils.tirmAll("hello "), hello);
    Assert.assertEquals(StringUtils.tirmAll("hello   "), hello);
    Assert.assertEquals(StringUtils.tirmAll("   he llo   "), hello);
}
```

**2 反转字符串**
```java
// 源程序 StringUtils.java
public static String reverse(String str) {
    StringBuilder sb = new StringBuilder();
    char[] chars = str.toCharArray();
    for(int index = chars.length - 1;index >= 0; index--) {
        sb.append(chars[index]);
    }
    return sb.toString();
}

// 测试程序 StringUtilsTest.java
@Test
public void testReverse() {
    Assert.assertEquals(StringUtils.reverse("321"), "123");
    Assert.assertEquals(StringUtils.reverse("hello"), "olleh");
}
```

## 常见面试问题
**== 和 equals 的区别**
1. == 对于基本数据类型来说是值比较；而对于引用类型来说是比较引用，是否是指向同一个对象的引用。
2. equals 默认是引用比较，而 Integer、String 等包装类都重写了 equals 方法，改为了值比较

所以对象都可以看作是继承 Object ，我们来看一下 Object 的 equals 实现，如果自定义类未覆写 
equal ，调用对象实例的 equals 方法默认是引用比较。
```java
public boolean equals (Object obj) {
    return (this == obj);
}
```
我们来看一下 Integer 类的 equals 方法
```java
public boolean equals(Object obj) {
    if (obj instanceof Integer) {
        return value == ((Integer)obj).intValue();
    }
    return false;
}
```

**下面代码执行结果**
```java
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
```

**String / StringBuffer / StringBuilder 的区别**
- String 为不可变字符串；StringBuffer 和 StringBuilder 为字符串可变对象。
- String 的 substring 等修改操作每次都会产生一个新的 String 对象；字符串拼接性能 String 低于
StringBuffer， 而 StringBuffer 低于 StringBuilder。
- StringBuffer 是线程安全的，StringBuilder 而是线程不安全的。二者都继承子 AbstracStringBuilder,
它们唯一区别是 StringBuffer 所有方法都使用了 synchronized 修饰符来保证线程安全。

**String 对象的 intern的作用**

&emsp;&emsp;String 对象的 intern 方法用于字符串的显示排重。调用此方法时，JVM 去字符串常量池查找池中是否已经
存在该字符串，如果已存在则直接返回它的引用；如果不存在则在池中创建然后返回其引用。

**String 不可变的优点**
- 字符串不可变，因此可以通过字符串常量池来实现，共享对象，从而节省空间，提高性能。
- 多线程安全，因为字符串不可变，所以当字符串被多个线程共享时不会存在线程安全问题。
- 适合做缓存的 key，因为字符串不可变，因此它的哈希值也就不变；创建时它的哈希值就被缓存了，不需要
重新计算，速度更快。

**String 是否可以被继承？**

&emsp;&emsp;String 不能被继承。因为 String 被声明为 final，所以不能被继承。

