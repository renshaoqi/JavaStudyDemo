package com.zeroten.javales.innerclass;

import com.zeroten.javales.innerClass.exercise.ArraySequence;
import com.zeroten.javales.innerClass.exercise.Selector;
import org.testng.annotations.Test;

public class ArraySequenceTest {
    @Test
    public void testPrint() {
        ArraySequence as = new ArraySequence(5);
        as.add(1);
        as.add(2);
        as.add(3);
        as.add(4);
        as.add('a');
        as.print();

        Selector bl = as.selector();
        while(!bl.end()) {
            System.out.println(">" + bl.current());
            bl.next();
        }
    }
}
