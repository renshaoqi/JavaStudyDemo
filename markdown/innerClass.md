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

```java
// CalcMinMax.java
public class CalcMinMax {
    pulbic int[] calc(int... numbs) {
        Integer min = null;
        Integer max = null;
        
        for(int numb : numbs) {
            if (min == null || min > numb) {
                min = numb;
            }
            if (max == null || max < numb) {
                max = numb;
            }
        }

        return new int[]{min, max};
    }
}

// CalcMinMaxTest.java
import org.testng.annotations.Test;
public class CalcMinMaxTest {
    @Test
    public void testCalc() {
        int[] params = {1, 3, 2, 66, 30 ,8};
        int[] result = new CalcMinMax().calc(params);
        System.out.println("最小值：" + result[0]);
        System.out.println("最大值：" + result[1]);
    }
}
```

上述代码中，我们使用了一个二维数组来表示返回值的最大值和最小值，在没有说明的情况下，如果
我们不去查看实现代码，我们是不知道到底返回数组中哪个表示最大值、最小债。因此我们可以创建
一个类 Pair 类来容纳最大值和最小值，而 Pair 名字比较大众，其它程序员也可能使用这个名字，
这样就会造成混乱冲突。因此我们可以把它放到类 CalcMinMax 的内部作为它的内部静态类。这样
我们改造上述代码如下：

```java
// CalcMinMax.java
public class CalcMinMax{
    public Pair calc(int... numbs) {
        Integer min = null;
        Integer max = null;
        
        for(int numb : numbs) {
            if (min == null || min > numb) {
                min = numb;
            }
            if (max == null || max < numb) {
                max = numb;
            }
        }
        
        return new Pair(min, max);
    }
    
    public static class Pair{
        private int min;
        private int max;
        
        public Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }

        public int getMin() {
            return min;
        }
        
        public int getMax() {
            return max;
        }      
    }
}

// CalcMinMaxTest.java
int[] params = {1, 3, 2, 66, 30 ,8};
CalcMinMax.Pair pair = new CalcMinMax().calc(params);
System.out.println("最大值: " + pair.getMax());
System.out.println("最小值: " + pair.getMin());

```

如上所示，代码的可读性就更好，直接通过返回对象的方法名就知道值的确切的意思而不用
再去翻看代码。

对于静态内部类，我们可以直接使用 OuterClass.StaticInnerClass 的方式来访问。

## 内部类本质

内部类其实是一种编译器现象，与虚拟机无关，编译器将会把内部类编译成文件名
【外围类名 + $ + 内部类名】形式的单独的常规文件，而虚拟机则对此一无所知；而对于匿名内部类，
编译器会产生一个数字作为其标识符，因此“内部类”部分会是一个数字。

我们可以打开前边示例生成的 class 文件目录，看一下这些文件名

## 闭包

闭包（closure）是一个可调用的对象，它记录了一些信息，而这些信息来自于创建它的作用域。因此
我们可以把内部类看作是面向对象的闭包。

# 应用练习

我们来看一下内部类应用示例：有一个固定大小的 Object 数组，以类的形式包装起来；通过数组方法
add 向序列末尾添加新的 Object 。要获取数组中的每一个元素对象，使用 Selector 接口。
Selector 接口有如下 3 个方法：
1. end() 检查序列是否到末尾
2. current() 返回当前对象
3. next() 移动到序列的下一个对象

```java
public interface Selector {
    boolean end();
    Object current();
    void next();
}

```

```java
public calss ArraySequence {
    private Object[] data;
    private int next = 0;
    
    public ArraySenquence(int size) {
        data = new Object[size];
    }    

    public void add(Object object) {
        if (next < data.length) {
            data[next++] = object;
        }
    }

    public SequenceSelector selector() {
        return new SequenceSelector();
    }

    public SequenceSelectorReverse selectorReverse() {
        return new SequenceSelectorReverse();
    }
    // 遍历
    private class SequenceSelector implements Selector {
        private int next = 0;

        @Override
        public boolean end() {
            return index == data.length;
        }
    
        @Override
        public Object current() {
            if (index < data.length) {
                return data[index];
            }
            return null;
        }

        @Override
        public void next() {
            if (index < data.length) {
                index++;
            }
        }
    }

    // 倒序打印
    private class SequenceSelectorReverse implements Selector {
        private int index;

        public SequenceSelectorReverse() {
            this.index = data.length - 1;
        }

        @Override
        public boolean end() {
            return index < 0;
        }

        @Override
        public Object current() {
            if (index > 1) {
                return data[index];
            }
            return null;
        } 

        @Override
        public void next() {
            if (index > -1) {
                index--;
            }
        }  
    }

    public static void main(String[] args) {
        ArraySequence as = new ArraySequence(5);
        for (int i = 0; i < 10; i++) {
            as.add("numb-" + (i + 1));
        }
    
        Selector selector = as.selector();
        while (!selector.end()) {
            System.out.println(selector.current());
            selector.next();
        } 
    
        Selector selectorReverse = as.selectorReverse();
        while (!selectorReverse.end()) {
            System.out.println(selectorReverse.current());
            selectorReverse.next();
        } 
    }   
}
```

# 常见面试问题

## 内部类有哪些种类？

1. 静态内部类 static inner class 
    - 最简单的内部类形式
    - 类定义时加上 `static` 关键字
    - 不能和外部类有相同的名字
    - 只可以访问外部类的静态成员和静态方法，包括私有的静态成员和方法。
    - 生成静态内部类对象的方式：OuterClass.InnerClass inner = new OuterClass.InnerClass();
    - 静态内部类使用代码：
    ```java
    public class OuterClass {
        private static int a;
        // 静态内部类 使用 static 来修饰
        public static class InnerClass {
            public void test() {
                // 静态内部类中 只能访问 外部类的 静态成员和静态方法
                System.out.println(a);
            }
        }
    
        public static void main(String[] args) {
            // 生成内部类对象方式
            OuterClass.InnerClass inner = new OuterClass.InnerClass();
            inner.test();
        }
    }
    ```
2. 成员内部类 member inner class
    - 成员内部类也是定义在另一个类中，但是定义时不用 `static` 修饰
    - 成员内部类和静态内部类可以类比为非静态的成员变量和静态的成员变量
    - 成员内部类就像一个实例变量。
    - 它可以访问它的外部类的所有成员变量和方法，不管是静态的还是非静态的。
    - 在外部类里面创建成员内部类的实例：this.new InnerClass();
    - 在外部类之外创建内部类的实例：(new OuterClass()).new InnerClass();
    - 在内部类里访问外部类的成员：OuterClass.this.成员名
    - 示例代码如下：
    ```java
    class MemberOuter {
       private int a = 1;
       private int b = 2;
       // 定义一个成员内部类
       public class Inner{
           private b = 8;
           // 实例方法
           public void test() {
               // 直接访问外部类变量
               System.out.println(a);
               System.out.println(b);  // 直接访问 b , 则访问的是内部类里的 b
               
               // 如何访问外部类的 a 呢?
               System.out.println(MemberOuter.this.a);
           }
       }
   
       public static void main(String[] args) {
           // 创建成员内部类的对象
           // 需先创建外部类的实例
           MemberOuter outer = new MemberOuter();
           Inner inner = outer.new Inner();
           inner.test();
       }
   }
    ```

3. 局部内部类 local inner class

    - 局部内部类定义在方法中，比方法的范围还小。是内部类中最少用到的一种类型
    - 像局部变量一，不能被 public、protected、private 和 static 修饰。
    - 只能访问方法中定义的 `final` 修饰的局部变量
    - 局部内部类在方法中定义，所有只能在方法中使用，即只能在方法中生成局部内部类的实例并且调用其方法。
    - 示例代码：
    ```java
    class LocalOuter {
       int a = 1;
       public void outerWay() {
           int b = 2;
           final int c = 3;
           // 定义一个局部内部类
           class LocalInner {
               public void test() {
                   System.out.println("Hello World");
                   System.out.println(a);  // 
               }   
           }
       }
   }
    ```

4. 匿名内部类 anonymous inner class 

    - 匿名内部类就是没有名字的局部内部类，不使用关键字 class、extend、implements,没有构造方法
    - 匿名内部类隐式地继承了一个父类或实现了一个接口。
    - 匿名内部类使用得比较多，通常是作为一个方法的参数来使用。
    - 匿名内部类必须实现某个接口或者是继承某个类，继承这个类可以是抽象类、普通的类，
      但是不能是 final 修饰的类

## 内部类和局部内部类的区别？

内部类可以分为 成员内部类、局部内部类、静态内部类和匿名内部类；内部类和局部内部类是父子的关系

## 内部类的作用？

- 内部类的方法可以访问该类定义的作用域的数据，包括私有数据。
- 内部类对同一个包中的其它类不可见。
- 当要定义一个回调函数而不想编写大量代码时，可以使用匿名内部类。

## 内部类可以被继承吗？

## 匿名内部类可以有静态成员变量和静态⽅法吗？为什么？

## 下边代码执行结果
```java
public class Outer {
    public int num = 1;
    class Inner {
    public int num = 2;
    public void show() {
        int num = 3;
        System.out.println(num);
        System.out.println(this.num);
        System.out.println(Outer.this.num);
    }
}

public static void main(String[] args) {
    Outer.Inner inner = new Outer().new Inner();
    inner.show();
    }
}
```
执行结果为：3 2 1

## 补全代码，执⾏结果要求打印出字符串 helloworld
```java
public class Outer {
    interface Inter {
        void show();
    }
    // TODO: 补全代码
    public static void main(String[] args) {
        Outer.create().show();
    }
}
```