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
* equals 判断值是否相等
* equalsIgnoreCase 不区分大小写，判断值是否相等。
- 前缀判断

