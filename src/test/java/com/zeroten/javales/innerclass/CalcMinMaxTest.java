package com.zeroten.javales.innerclass;

import com.zeroten.javales.innerClass.CalcMinMax;
import com.zeroten.javales.innerClass.Pair;
import org.testng.annotations.Test;

import java.util.Arrays;

public class CalcMinMaxTest {

    @Test
    public void testCalc() {
//        int[] result = CalcMinMax.calc(1, 5, 10, 3, 20, 36, 66);
//        System.out.println(Arrays.toString(result));
        int[] params = {1, 5, 10, 3, 20, 36, 66};
        CalcMinMax.Pair pair = CalcMinMax.calc2(params);
        System.out.println("最小值：" + pair.getMin());
        System.out.println("最大值：" + pair.getMax());
    }
}
