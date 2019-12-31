package com.zeroten.javales.innerClass;

public class OuterClass {
    // 内部类：定义在其它类中的类
    // 内部类前边的修饰符可以是 public、protected、private，也可以不写
    // class InnerClass {}
    // public class InnerClass {}
    // protected class InnerClass {}
    // private class InnerClass {}
    public int num = 1;

    class Inner {
        public int num = 2;

        public void show() {
            int num = 3;
            System.out.println(num);
            System.out.println(this.num);
            System.out.println(OuterClass.this.num);
        }
    }



    private static int a = 1;
    private Integer index;
    private String name;

//    public static class Inner {
//        public void test() {
//            System.out.println(a);
//        }
//    }

    public void outerWay() {
//        int a = 2;
        final int b = 3;
        class Inner {
            public void test1() {
                System.out.println(a);
            }
        }

        // 创建局部内部类的实例并调用方法
        new Inner().test1();
    }

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
//            StringBuilder tmp = new StringBuilder();
//            tmp.append("外围类的index=");
//            tmp.append(index);
//            tmp.append("，外围类的name=");
//            tmp.append(OuterClass.this.name);
//            System.out.println(tmp.toString());
            String name = "print方法";

            /* 局部内部类
            class printClass {
                void println() {
                    StringBuilder tmp = new StringBuilder();
                    tmp.append("外围类的index=");
                    tmp.append(index);
                    tmp.append("，外围类的name=");
                    tmp.append(name);
                    System.out.println(tmp.toString());
                }
            }
            new printClass().println();
             */

            // 匿名内部类
            /* 1 使用接口 interface
            new PrintInterface() {
                @Override
                public void print() {
                    StringBuilder tmp = new StringBuilder();
                    tmp.append("外围类的index=");
                    tmp.append(index);
                    tmp.append("，外围类的name=");
                    tmp.append(name);
                    System.out.println(tmp.toString());
                }
            }.print();
             */
            /* 2 使用 抽象类 abstract
            new PrintAbstract() {
                @Override
                public void print() {
                    StringBuilder tmp = new StringBuilder();
                    tmp.append("外围类的index=");
                    tmp.append(index);
                    tmp.append("，外围类的name=");
                    tmp.append(name);
                    System.out.println(tmp.toString());
                }
            }.print();
             */

            new PrintClass("父类的name") {
                @Override
                public void print() {
                    StringBuilder tmp = new StringBuilder();
                    tmp.append("外围类的index=");
                    tmp.append(index);
                    tmp.append("，外围类的name=");
                    tmp.append(super.name);
                    System.out.println(tmp.toString());
                }
            }.print();
        }
    }

    public static void main(String[] args) {
//        OuterClass outerClass = new OuterClass(1, "我是外围类");
//        OuterClass.InnerClass innerClass = outerClass.new InnerClass("我是内部类");
//        innerClass.print();

        OuterClass outer = new OuterClass(1, "my");
        outer.outerWay();
        OuterClass.Inner inner = outer.new Inner();
        inner.show();
    }
}
