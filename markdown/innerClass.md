- 内部类
    - 内部类定义及作用
    - 内部类的创建
    - 局部内部类
    - 匿名内部类
    - 静态内部类
    - 应用练习
    - 常见面试问题
- 课后练习

# 内部类

内部类（inner class），顾名思义就是定义在另一个类中的类。如下所示

```java
public class OuterClass {   // 外围类/外部类
    public class InnerClass {   // 内部类
    }
}
```

相对于的，包含了其它类的类，我们称之为外部类或外围类（Outer class）

为什么需要使用内部类？它主要有如下一些作用和特性：

- 内部类和包含它的外围类的方法在同一个层次，因此也可以称为成员内部类，它可以使用public、
protected、private 修饰符。
- 成员内部类中不能存在任何 static 修饰的变量和方法，但可以定义常量。
- 内部类的方法可以访问该类定义所在的作用域中的数据，包括私有数据。
- 内部类对同一个包中的其它类不可见。
- 当要定义一个回调函数而不想编写大量代码时，可以使用匿名内部类（anonymous inner class）

内部类之所以可以访问包含它的外围类的属性和方法，实际上是因为每一个内部类对象都持有一个指向
包含它的外围类对象的引用。这个外围类的引用是在内部类的构造器中设置。编译器修改了所有内部类
的构造器，添加了一个外围类引用的参数，和之前对类实例方法调用时的 this 隐藏参数类似。

在内部类中使用外围类引用的正确语法：OuterClass.this 表示外围类引用；如果未使用此前缀时，
默认访问内部类定义的属性和方法，内部类不存在相同的属性和方法时则访问外围类的属性和方法。
如下代码所示：

```java
// OuterClass.java
public class OuterClass {
    private Integer index;
    private String name;
    public OuterClass(int index, String name) {
        this.index = index;
        this.name = name;    
    }

    public class InnerClass {
        private String name;
        public InnerClass(String name) {
            this.name = name;
        }
    
        public void print() {
            StringBuilder temp = new StringBuilder();
            temp.append("外围类的index=");
            temp.append(index);
            temp.append(", 外围类的name=");
            temp.append(name);
            System.out.println(temp.toString());
        }   
    }

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass(1, "我是外围类");
        OuterClass.InnerClass innerClass = outerClass.new InnerClass("我是内部类");
        innerClass.print();
    }
}
```

## 内部类的创建

定义了内部类后，我们怎么来创建一个内部类的实例？通常有两种方式：

1. 在包含它的作用域范围内，直接使用 new 操作符来构造一个实例，和普通类的构造方式一样。
2. 在包含它的作用域范围外，使用 `外围类对象.new 内部类类名()` 语法来创建；在作用域范围
外，我们这样来引用内部类：OuterClass.InnerClass

```java
public class OuterClass {
    public class InnerClass{
    }

    public InnerClass createInnerClass {
        return new InnerClass();
    }

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        // 创建内部类的实例
        // 方法一
        OuterClass.InnerClass innerClass1 = outerClass.createInnerClass();
        // 方法二
        OuterClass.InnerClass innerClass2 = outerClass.new InnerClass();
    }
}
```

## 局部内部类

类方法里面定义的变量不能是访问控制符（public、protected、private）

除了在类里定义其它类，我们还可以在方法内，或者代码块内等地方来定义一个类。这些地方定义的类
我们称为局部内部类。局部内部类有如下一些特征：

- 不能使用 public、protected 或 private 访问修饰符进行声明，它的作用域被限定在声明这个局部
类的块中。
- 和其它内部类相比，局部内部类除了可以访问包含它的外围类外，还可以访问作用域范围内局部变量。
但是，这些局部变量必须被声明为 final。
- Java 8 版本开始，局部内部类访问方法中的局部变量，可以不声明为 final ，这是因为 Java 8 增加
了 effectively final 特性，它会对相关局部变量自动声明为 final。

下面我们使用局部内部类来改写下前面示例中内部 InnerClass 的 print 方法：

```java
public void print() {
    String name = "方法的局部变量";
    
    Class printClass {
        void println() {
            StringBuilder temp = new StringBuilder();
            temp.append(", 外围类的name=");
            temp.append(name);
            System.out.println(temp.toString());
        }
    }
    new printClass().println();
}
```

## 匿名内部类

对于局部内部类，如果我们只创建这个类的一个实例对象，那么我们就没必要给它命名了。这种没有名字的
内部类，我们称为匿名内部类（anonymous inner class）。

下面我们再来改写一下上面的 print 方法：

```java
// 1 使用接口
pulbic interface PrintInterface {
    void println();
}

public void print() {
    String name = "print";
    
    new PrintInterface() {
        @Override
        public void println() {
            StringBuilder temp = new StringBuilder();
            temp.append(", 外围类的name=");
            temp.append(name);
            System.out.println(temp.toString());
        }
    }.println()

// 2 使用抽象类
pulbic abstract class PrintAbstract {
    abstract void println();
}

public void print() {
    String name = "print";

    new PrintAbstract() {
        @Override
        public void println() {
            StringBuilder temp = new StringBuilder();
            temp.append(", 外围类的name=");
            temp.append(name);
            System.out.println(temp.toString());
        }
    }.println()

// 3 使用普通类
pulbic class PrintClass {
    poulbic void println();
}

public void print() {
    String name = "print";

    new PrintClass() {
        @Override
        public void println() {
            StringBuilder temp = new StringBuilder();
            temp.append(", 外围类的name=");
            temp.append(name);
            System.out.println(temp.toString());
        }
    }.println()
}

```
`注：匿名内部类必须实现某个接口或者是继承某个类，继承这个类可以是抽象类、普通的类，
但是不能是 final 修饰的类`


## 静态内部类

有时我们仅仅只需要把一个类隐藏在另一个类中，而并不需要内部类引用外围类对象，这是只需要将内部类
声明为 static 即可。

使用 static 声明的内部类称为静态内部类或嵌套类。

例如：我们有一个方法，它返回指定的一组数据中的最大值和最小值。代码我们可以这样写，如下所示：
