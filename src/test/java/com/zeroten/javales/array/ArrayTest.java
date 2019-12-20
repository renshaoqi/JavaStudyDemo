package com.zeroten.javales.array;

import org.junit.Test;

import java.util.Arrays;

public class ArrayTest {
    @Test
    public void testArrayDeclare() {
        // 数组定义
        int[] arr1;
        int arr2[];
        String[] arr3;
        String arr4[];
    }

    @Test
    public void test数组初始化() {
        // 数组初始化，如果为基本数据类型，其值为 0，boolean值为 true ; 如果为 引用类型，其值为 null
        int[] arr1 = new int[5];
        System.out.println(Arrays.toString(arr1));    // [0, 0, 0, 0, 0]
        boolean[] arr2 = new boolean[5];
        System.out.println(Arrays.toString(arr2));    // [false, false, false, false, false]
        String[] arr3 = new String[3];
        System.out.println(Arrays.toString(arr3));    // [null, null, null]
    }

    @Test
    public void test数组遍历() {
        Integer[] arr = {1, 2, 3, 4, 5};
        // 1 for 循环
        for (int index = 0; index < arr.length; index++) {
            System.out.println(arr[index]);
        }
        System.out.println();
        // 2 for each 循环
        for(int val : arr) {
            System.out.println(val);
        }
        System.out.println();
        // Lambda 表达式
        Arrays.asList(arr).forEach(val -> {
            System.out.println(val);
        });
    }
}
