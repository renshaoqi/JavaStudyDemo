package com.zeroten.javales.innerClass;

public class CalcMinMax {
    public static int[] calc(int... numbs) {
        Integer min = null;
        Integer max = null;

        for (int numb : numbs) {
            if (min == null || min > numb) {
                min = numb;
            }
            if (max == null || max < numb) {
                max = numb;
            }
        }
        return new int[]{min, max};
    }

    public static Pair calc2(int... numbs) {
        Integer min = null;
        Integer max = null;

        for (int numb : numbs) {
            if (min == null || min > numb) {
                min = numb;
            }
            if (max == null || max < numb) {
                max = numb;
            }
        }
        return new Pair(min, max);
    }

    public static class Pair {
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
