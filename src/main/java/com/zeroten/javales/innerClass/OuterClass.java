package com.zeroten.javales.innerClass;

public class OuterClass {
    // 内部类：定义在其它类中的类
    // 内部类前边的修饰符可以是 public、protected、private，也可以不写
    // class InnerClass {}
    // public class InnerClass {}
    // protected class InnerClass {}
    // private class InnerClass {}
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
        OuterClass outerClass = new OuterClass(1, "我是外围类");
        OuterClass.InnerClass innerClass = outerClass.new InnerClass("我是内部类");
        innerClass.print();
    }
}
