package com.zeroten.javales.flow;

public class StringUtils {
    public static String trimAll (String str) {
        StringBuilder sb = new StringBuilder();

        char[] chars = str.toCharArray();
        for (int index = 0; index < chars.length; index++) {
            if (chars[index] == ' ') {
                continue;
            }
            sb.append(chars[index]);
        }
        return sb.toString();
    }

    public static String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        for (int index = chars.length - 1; index >= 0; index--) {
            sb.append(chars[index]);
        }
        return sb.toString();
    }
}
