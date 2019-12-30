package com.zeroten.javales.innerClass;

public class CalcMinMax {
    public int[] calc(int... numbs) {
        int min = 0;
        int max = 0;

        for (int numb : numbs) {
            if (min > numb) {
                min = numb;
            }
            if (max < numb) {
                 max = numb;
            }
        }
        return new int[]{min, max};
    }
}
