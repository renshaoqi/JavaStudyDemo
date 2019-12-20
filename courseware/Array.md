**数组**
- 数组定义及声明
- 数组初始化
- 数组遍历
- 数组拷贝
- 数组填充
- 数组排序
- 多维数组和不规则数组
- 引用练习
- 常见面试问题

**课后练习**

# 数组
&emsp;&emsp;数组是一种数据结构，用来存放同一类型的值的集合。通过整数下标来访问数组中的值，数组
下标从 0 开始；当下标越界，不在范围之内时，程序会报错 java.lang.ArrayIndexOutOfBoundsException

&emsp;&emsp;数组是一种引用类型，只能用来存储固定大小的同类型数据。在 Java 中很多集合的内部都是使用
数组来实现的，比如 ArrayList 和 HashMap 等。

&emsp;&emsp;数组常用排序：冒泡排序、选择排序。

&emsp;&emsp;声明数组变量时，必须指明数组类型，类型后面紧跟 [] 或者将 [] 放在数组变量之后，数组类型
可以是基本数据类型或引用类型。例如：
```java
int[] arr1;
int arr2[];
String[] arr3;
String arr4[];
```

# 数组初始化
**数组有以下几种初始化方法:**
- 使用 new 操作符创建的数组，基本数据类型每个值会初始化为二进制的0；而引用类型会初始化为null;
```java
int[] arr1 = new int[3];
String[] arr2 = new String[3];
```
- 使用 new 操作符创建数组，直接使用大括号方法赋值，数组的长度为大括号内元素的个数，不能在 [] 内指定长度，
否则编译器会报错
```java
int[] arr1 = new int[] {1, 2, 3};
String[] arr2 = new String[] {"1", "2", "3"};
```
- 使用第二种方式创建数组时，可以省略前边的 new 操作符而直接使用大括号。
```java
int[] arr1 = {1, 2, 3};
String[] arr2 = {"1", "2", "3"};
```

# 数组遍历
**Java 中对数组的遍历主要有以下三种方式:
- 