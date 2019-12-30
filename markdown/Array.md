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
1. for 循环使用数组下标
2. for each 循环
3. Java 8 中新增的 Lambda 表达式

示例：分别使用上述三种方式遍历数组 Integer[] arr = {1, 2 ,3, 4, 5};

# 数组拷贝
**Java 中数组拷贝常用的两种方式:**
1. 使用工具类 Arrays.copyOf 或 Arrays.copyOfRange
2. 使用底层方法 System.arraycopy

示例:
```java
Integer[] arr1 = {1, 2, 3, 4, 5};
Integer[] arr2 = {6, 7, 8, 9, 10};

// 拷贝数组 arr1 的前 3 个元素
Integer[] arr3 = Arrays.copyOf(arr1, 3);

// 拷贝数组 arr1 的第 1 位到第 3 位的元素（不包括第 3 位）
Integer[] arr4 = Arrays.copyOfRange(arr1, 0, 3);

// 拷贝数组 arr2 的后 3 位到 arr1 的后 3 位
System.arraycopy(arr2, arr1.length - 3, arr1, arr1.length - 3, 3)
```

# 数组填充
&emsp;&emsp;使用工具类提供的方法 Arrays.fill 可以对数组全部或指定范围内的元素赋值为指定的值。

示例:定义一个大小为 10 的 int 数组，并将数组全部初始化为指定的值 5，打印数组；然后将数组后 3 位赋值为 3
再次打印数组。
```java
int[] arr = new int[10];
Arrays.fill(arr, 5);
System.out.println(Arrays.toString(arr));

Arrays.fill(arr, arr.length - 3, 3);
System.out.println(Arrays.toString(arr));
```

# 数组排序
&emsp;&emsp;可以使用 Arrays.sort 方法对数组进行排序。

示例: 定义一个大小为 100 的 int 数组，随机给每一位赋值一个 0 ~ 100 之间的数值，然后对该数组进行排序并打印
排序结果。
```java
int[] arr = new int[100];
for(int index = 0; index < arr.length; index++) {
    arr[index] = new Random().nextInt(100);
}
System.out.println(String.format("排序前:%s", Arrays.toString(arr)));
Arrays.sort(arr);
System.out.println(String.format("排序后:%s", Arrays.toString(arr)));
```

# 多维数组和不规则数组
&emsp;&emsp;前边介绍出现的数组，都是一维数组，Java 实际上没有多维数组的，只有一维数组。多维数组可以被理解
为“数组的数组”。多维数组的同一个维可以有不同的长度，因此也可以称为不规则数组。声明时使用多个 [] 标识来表明。

示例: 定义一个二维数组，第一维表示用户，第二维表示用户的具体信息（1.编码,2.姓名,3.性别,4.年龄）。定义
赋值并打印。
```java
String[][] users = new String[3][];
users[0] = new String[4];
users[0][0] = "001";
users[0][1] = "R先生";
users[0][2] = "男";
users[0][3] = "22";

```

# 应用练习
&emsp;&emsp;给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的拿两个整数，并返回
它们的数组下标。
```java
public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        for(int index = 0; index < nums.length - 1; index++) {
            if (nums[index] > target) {
                return null;
            }
            for(int twoIndex = index + 1; twoIndex < nums.length; twoIndex++) {
                if (nums[index] + nums[twoIndex] == target) {
                    return new int[] {index, twoIndex};
                }
            }
        }
        return null;
    }

@Test
public void test应用练习() {
    int[] nums = {2, 7, 11, 15};
    int target = 9;
    System.out.println(Arrays.toString(twoSum(nums, target)));
}
```

# 常见面试问题
**下列代码的执行结果**
```java
int[] n = new int[3]{1, 2, 3};
System.out.println(n[1]);
```
*答:编译时报错，数组声明时如果使用大括号赋值，不能在 [] 内指定数组的长度，数组的长度为大括号内元素的个数。*

```java
private static void push1ForEvenIndex(int[] arr) {
    for(int index = 0; index < arr.length; index++) {
        if((index + 1) % 2 == 0 ) {
            arr[index] = arr[index] + 1;
        }
    }
}

public static void main(String[] args) {
    int[] n = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    push1ForEvenIndex(n);
    System.out.println(Arrays.toString(n));
}
```
*答: 执行结果 [1, 3, 3, 5, 5, 7, 7, 9, 9, 11]。Java 方法参数是值传递，方法得到是参数的拷贝，所以内代码*
*不会改变所传参数的值。但对于引用类型，虽然不能改变引用类型的引用，却可以修改引用类型指向的对象的值。*

```java
int[] n = new int[3];
String[] s = new String[3];
System.out.println(n[1]);
System.out.println(s[1]);
```
*答: 执行结果: 0 和 null。数组声明未进行赋值时，对于基本数据类型，会将每一个元素赋值为二进制0；而对于*
*引用类型，则会将每一个元素赋值为 null。*

**数组的遍历方式有哪些**
- for 循环使用数组小标 从 0 开始
- for each 循环
- Java 8 新增的 Lambda 表达式

**举例说明 Arrays 工具类的常用方法**
- copyOf    数组拷贝
- copyOfRange   数组拷贝
- fll   数组填充
- sort  数组排序
- toString
- equals    比较
- asList
- binarySearch
