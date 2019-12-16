package com.zeroten.javales.flow;

public class AgeCheck {
    public static String getAgeName(int age) {
        if (age < 7) {
            return "儿童";
        }
        if (age < 17) {
            return "少年";
        }
        if (age < 40) {
            return "青年";
        }
        if (age < 60) {
            return "中年";
        }
        return "老年";
    }
}
