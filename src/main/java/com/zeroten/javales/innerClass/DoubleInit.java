package com.zeroten.javales.innerClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DoubleInit {
    public static void main(String[] args) {
        // 双括号初始化
        List<Integer> nums = new ArrayList();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        System.out.println(nums);

//        class ArrayListNew extends ArrayList {
//            {
//                // 初始化代码块
//                add(1);
//                add(2);
//                add(3);
//                add(4);
//                add(5);
//            }
//        }
//        ArrayListNew nums2 = new ArrayListNew();
//        System.out.println(nums2);

        List<Integer> nums3 = new ArrayList () {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
        }};
        System.out.println(nums3);
    }
}
