**类和对象**
- 类的对象定义/如何识别类/类之间的关系
- 类的组成
    - 域变量
    - 构造器
    - 方法
    - 修饰符：访问权限控制/static 修饰符/final 修饰符
    - 代码块
    - 包
- 创建对戏
- 应用练习
- 常见面试问题

**课后练习**

# 类和对象定义
&emsp;&emsp;Java 是一门面试对象的程序设计语言，它把一切都看作是对象， Java 源码都是以类的形式来组织。
- 类

    类是构造对象的模板或者蓝图，它定义了一类对象的状态和行为，从形式来看是将数据和行为封装放在一个类里。
    类中的数据称为实例域（instance field）, 操作数据的过程称为 方法（method）。
- 对象

    对象是类的一个实例，有状态和行为。每个类实例(对象)都有一组特定的实例域值，这些值的集合就是这个对象
    的当前状态（state）。
  
例如：人是一个类，他的状态有：姓名、性别、年龄、体重等；行为有：走路、吃饭、睡觉、工作、学习等。而具体
的每一个人则为该类的对象（object）。

根据上述分析，定义人这个类：
```java
// Person.java
public class Person {
    // 状态
    private String name;
    private Integer sex;
    private Integer age;
    private Integer height;

    // 行为
    public void walking() {}
    public void eat () {}
    public void gotoBed() {}
    public void work() {}
    public void study() {}
}

// PersonTest.java 测试
public void testCreate() {
    Person person1 = new Person();  // 类的对象
    Person person2 = new Person();
}
```

# 如何识别类 
如何进行面向对象（OOP），我们通常是从设计类开始，然后再向类中添加属性和方法。

那么怎么来识别类? 有一个简单的规则：在分析问题的过程中寻找名称，而方法对应这动词。

例如：我们来分析订单处理系统，有这样一些名词：

- 商品(Item)
- 订单(Order)
- 送货地址(Shipping address)
- 付款(Payment)
- 账户(Account)

接下来分析一下有哪些动词:

- 添加购物车
- 提交订单
= 支付订单
- 取消订单

对于这些动词：添加、提交、支付、取消，我们还要标识出完成这些动作相对应的对象。

# 类之间的关系

类之间最常见的关系有：

- 依赖（uses-a）
    
    一个类 A 的方法操作了另一个类 B 的对象，我们就说 A 依赖与 B。例如：订单对象 Order 需要访问账户 Account 对象来看
    该客户是否参与活动、是否有会员折扣等。因此 Order 依赖于 Account 。而商品(Item) 对象和客户账户无关。
    
- 聚合（has-a）

    类 A 的对象包含类 B 的对象，我们称之为聚合。例如：一个 Order 订单对象包含一个或多个 Item 商品对象，因此它们是聚合关系。
    
- 继承（is-a）

    继承关系表示：类 A 从类 B 扩展而来，类 A 不但包含从类 B 继承的属性额方法，还拥有一些额外的属性和方法。
    
# 类的组成

Java 类主要由一下 7 部分组成：

- 包定义
- 包导入
- 域（field）/成员变量（Member variable）
    - 实例变量，不以 static 修饰的变量
    - 类变量，以 static 修饰的变量
- 方法（method）：对象的行为
    - 实例方法，不使用 static 修饰符
    - 静态方法，使用 static 修饰符
- 构造方法：用于对象的实例化
    - 必须和类同名
    - 没有返回值
- 内部类（inner class）：在类中声明的其它类
- 代码块
    - 实例块
    - 静态块

下面我们来定义一个类，包含上述的 5 个组成部分：
```java
package com.zeroten.javales.classObject;    // 1 包定义
import org.junit.Test;  // 2 包导入
public class ClassZucheng {
    // 3 实例变量或域变量
    private String name;
    // 3 类变量、静态变量
    private static String count;
    {
        // 7 初始化代码块 或 实例代码块
        System.out.println("类、方法之外用大括号扩起来的代码");
    }
    static {
        // 7 静态代码块 或 静态初始化代码块
        System.out.println("类、方法之外用大括号扩起来且前边有 static 修饰的代码");
    }
    // 4 实例方法
    public void print() {}
    // 4 静态方法
    public static void print1() {}
    // 5 构造器 或 构造方法
    public ClassZucheng() {}
    // 5 内部类
    class InnerClass {}
    @Test
    public void name() {
    }
}
```

## 域变量

在类中，方法之外定义的变量我们成为域变量，也叫成员变量，它分为两种：

- 实例变量，不以 static 修饰的变量
- 类变量，也可以称为静态变量或静态域，以 static 修饰的变量

而方法中的变量我们称为局部变量。
```java
public class VarTest {
    // 没有使用 static 修饰的是 实例变量，每个实例有单独的拷贝
    // index 用于存放当前是类的第几个实例
    public int index;

    // 使用 static 修饰的是类变量，所有实例共享
    // 用于记录创建的该类的实例个数
    public static int count = 0;

    public static void main(String[] args) {
        VarTest v1 = new VarTest();
        v1.index = 1;
        VarTest.count++;
        System.out.println("当前创建第" + v1.index + "个实例，共" + VarTest.count + "个");

        VarTest v2 = new VarTest();
        v2.index = 2;
        VarTest.count++;
        System.out.println("当前创建第" + v2.index + "个实例，共" + VarTest.count + "个");
        System.out.println("v1看得的count=" + v1.count);   // 2
        System.out.println("v2看得的count=" + v2.count);   // 2

        System.out.println("v1看得的index=" + v1.index);   // 1
        System.out.println("v2看得的index=" + v2.index);   // 2
    }
}
```

## 构造器

要使用对象，就必须先构造对象，并指定其初始化状态。Java 使用构造器（constructor）构造新实例。

构造器是一中特殊的方法，用来构造并初始化对象。构造器的名字和类名相同，并且没有返回值。构造器是伴随 new 操作符的执行而被调用。

一个类可以有一个或多个构造器，它们的名字都和类名相同，但是参数个数或类型不一样（这种特征叫做重载 overloading）。

我们在编写一个类时，如果没有编写构造器，那么系统会提供一个无参数的构造器；而如果编写了构造器，则系统就不会提供无参数的构造器。

通过 new 定义赋值的变量也叫对象变量，一个对象变量并没有实际包含一个对象，而仅仅引用一个对象。（Java 中所有变量的值都是存储在
另一个地方的一个对象的引用，所有 Java 对象存储在堆中）。 

当有多个构造器时，可以使用 this 来调用另一个构造器，并且调用语句只能出现在第一句。

```java
public class VarTest{
    public int index;
    public static int count = 0;
    
    public VarTest() {}
    public VarTest(int index, int count) {
        this.index = index;
        this.count = count;
    }
    
    public static void main(String[] args) {
        VarTest v = new VarTest(3, 3);
        System.out.println("index:" + v.index);
        System.out.println("count:" + v.count);
    }
}
```

综合所述，Java 的类构造器有如下一些特征：

- 构造器和类同名
- 每个类可以有 1 个或多个构造器，但是参数个数或类型不一样（重载）
- 构造器没有返回值
- 构造器总是伴随 new 操作一起被调用
- 编写类时未编写构造器，系统会默认提供一个无参数的构造器。

## 方法

方法即对象的行为，用于操作对象以及存取它们的实例域。方法也可以称为函数，一个方法的定义如下：

```java
(访问权限修饰符) (修饰符) 返回值数据类型 方法名(形式参数列表) {
    语句;
    return (返回值);
}
```
如果方法没有返回值则使用 void 来定义返回值类型。

### 方法参数

Java 语言总是采用按值调用（call by value），方法得到都是所有参数值的一个拷贝，方法是不能修改传递给他的任何参数变量的内容。
方法参数总共有两种类型：

1. 基本数据类型
2. 对象引用

一个方法不能修改一个基本数据类型的参数，也不能修改引用类型参数的指向，但是却可以修改引用类型参数指向的对象的值。

```java
import org.testng.annotations.Test;
public class ClassMethodParamTest {

    private void changePrimitive(int numb) {
        System.out.println("传入：" + numb);
        numb = 20;
        System.out.println("修改：" + numb);
    }

    private void changeReference(StringBuilder sb) {
        System.out.println("传入：" + sb.toString());
        sb.append("-追加");
        System.out.println("修改：" + sb.toString());

        sb = new StringBuilder();
        sb.append("新字符串");
    }

    @Test
    public void testModifyMethodParam() {
        int numb = 10;
        changePrimitive(numb);
        System.out.println("numb=" + numb);

        StringBuilder sb = new StringBuilder();
        sb.append("字符串");

        changeReference(sb);
        System.out.println("sb=" + sb.toString());
    }
}
```

隐式参数 this，Java 编译器在编译时会将对象自己放在第一个参数上，我们称之为隐式参数；第二个参数开始才是位于方法
名后边括号中的参数，这些是显示参数。使用关键字 this 来表示第一个隐式参数，因此可以在方法内使用 this 来访问对象
自己的其它成员变量或方法。

当没有使用 this ，前缀来访问一个变量时，首先看是否存在该名字的局部变量，如果不存在则再去看该对象是否存在该名字
的成员变量。

```java
import org.testng.annotations.Test;

public class ClassThisTest {
    private int index;
    // 构造器
    public ClassThisTest () {}
    // 实例方法
    public void println(String name) {
        System.out.println(this.index + ".hello" + name);
    }

    @Test
    public void testThis() {
        ClassThisTest obj = new ClassThisTest();
        obj.println("work");
    }
}
```

### 可变参数

当我们需要传同类型的一组参数，但是却不知道参数个数，这是可以使用可变参数语法： 参数类型... 变量名

一个方法只能有一个可变参数，并且可变参数只能是最后一个。可变参数变量我们可以当成是一个数组来使用。

```java
// 可变参数
public class ClassThisTest {
    public void println(int... nums) {
        if (nums == null) {
            System.out.println("si null");
        }
        if (nums.length == 0) {
            System.out.println("param length is zero");
        }
        System.out.println("...............");
        for (int n = 0; n < nums.length; n++) {
            System.out.println(nums[n]);
        }
    }
    
    @Test
    public void test() {
        ClassThisTest obj = new ClassThisTest();
        obj.println();
        obj.println(1);
        obj.println(1, 3, 5, 7);
    }
}
```

### 方法重载

类构造器可以重载普通方法一样可以重载。重载（overloading）值的是方法名相同，但是方法的参数类型或个数不同。
不能根据返回值类型来区分重载，为什么？看如下代码定义了 2 个返回值类型不同，方法名和参数个数/类型相同的方法，
如果调用的时候直接调用而没有将结果赋值给一个变量，那么编译器就不知道该调用哪一个方法了。

```java
int max(int n1, int n2);
long max(int n1, int n2);
max(1, 3);  // 会报错 程序不知道执行哪一个
```

方法名和参数个数/类型，我们称为方法的签名（signature）。方法的签名必须唯一，方法返回值类型不是方法签名的一部分。

## 修饰符

Java 语言提供了一些修饰符，用来定义成员变量和方法，它放在语句的最前端，主要分为一下两类：

- 访问修饰符
- 非访问修饰符

### 访问权限控制

在 Java 中，通过访问控制修饰符来限定对类、成员变量和方法的访问，Java 支持 4 中访问权限：


| 修饰符 | 说明 | 当前类 | 同包 | 子类 | 不同包 | 备注 |
|:----:|:----:|:----:|:----:|:----:|:----:|:----:|
| public | 公开 | √ | √ | √ | √ | 可用于类、接口、成员变量、方法 |
| protected | 保护 | √ | √ | √ | × | 可用于成员变量、方法 |
| default | 默认 | √ | √ | × | × | 可用于类、接口、成员变量、方法 |
| private | 私有 | √ | × | × | × | 可用于类、接口、成员变量、方法 |

### static 修饰符

使用 static 修饰符定义的成员变量和方法称为静态域或静态方法，使用类来访问，也可以使用类的实例
变量名来访问。

类的所有实例对象共享一个变量，在静态方法中可以访问访问静态域变量，但是不能访问非静态的域变量。

```java
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

```
