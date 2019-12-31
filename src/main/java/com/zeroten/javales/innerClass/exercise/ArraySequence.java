package com.zeroten.javales.innerClass.exercise;

import java.util.Arrays;

public class ArraySequence {

    private Object[] data;
    private int next = 0;

    public ArraySequence(int size) {
        data = new Object[size];
    }

    public void add(Object object) {
        if (next < data.length) {
            data[next++] = object;
        }
    }

    public void print() {
        System.out.println(Arrays.toString(data));
    }

    public Selector selector() {
        return new SequenceImpl();
    }

    private class SequenceImpl implements Selector {
        private int index = 0;
        @Override
        public boolean end() {
            return index >= next;
        }

        @Override
        public Object current() {
            if (index < next) {
                return data[index];
            }
            return null;
        }

        @Override
        public void next() {
            index++;
        }
    }
}
