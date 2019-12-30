package com.zeroten.javales.array;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

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
        for (int val : arr) {
            System.out.println(val);
        }
        System.out.println();
        // Lambda 表达式
        Arrays.asList(arr).forEach(val -> {
            System.out.println(val);
        });
    }

    @Test
    public void test数组拷贝() {
        Integer[] arr1 = {1, 2, 3, 4, 5};
        Integer[] arr2 = {6, 7, 8, 9, 10};
        // 拷贝数组 arr1 的前 3 个元素
        Integer[] arr3 = Arrays.copyOf(arr1, 3);
        // 拷贝数组 arr1 的第 1 位到第 3 位的元素（不包括第 3 位）
        // 拷贝数组 arr2 的后 3 位到 arr1 的后 3 位
    }

    @Test
    public void test数组填充() {
        // 示例:定义一个大小为 10 的 int 数组，并将数组全部初始化为指定的值 5，打印数组；
        // 然后将数组后 3 位赋值为 3 再次打印数组。
        int[] arr = new int[10];
        Arrays.fill(arr, 5);
        System.out.println(Arrays.toString(arr));
        Arrays.fill(arr, arr.length - 3, arr.length, 3);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test数组排序() {
        // 示例: 定义一个大小为 100 的 int 数组，随机给每一位赋值一个 0 ~ 100 之间的数值
        // 然后对该数组进行排序 并打印排序结果。
        int[] arr = new int[100];
        for (int index = 0; index < arr.length; index++) {
            arr[index] = new Random().nextInt(100);
        }
        System.out.println(String.format("排序前:%s", Arrays.toString(arr)));
        Arrays.sort(arr);
        System.out.println(String.format("排序后:%s", Arrays.toString(arr)));
    }

    @Test
    public void test多维数组() {
        // 示例:定义一个二维数组，第一维表示用户，第二维表示用户的具体信息（1.编码,2.姓名,3.性别,4.年龄）。
        // 定义赋值并打印。
        String[][] users = new String[3][];
        users[0] = new String[4];
        users[0][0] = "001";
        users[0][1] = "R先生";
        users[0][2] = "男";
        users[0][3] = "22";
        // for 循环
        for (int index = 0; index < users.length; index++) {
            System.out.println(Arrays.toString(users[index]));
        }
        // for each 循环
        for (String[] user : users) {
            System.out.println(Arrays.toString(user));
        }
        // lambda 表达式
        Arrays.asList(users).forEach(user -> {
            System.out.println(Arrays.toString(user));
        });
    }

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
        // 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的拿两个整数，
        // 并返回它们的数组下标。
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
