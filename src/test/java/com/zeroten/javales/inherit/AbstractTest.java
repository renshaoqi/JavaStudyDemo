package com.zeroten.javales.inherit;

import org.testng.annotations.Test;

public class AbstractTest {
    @Test
    public void testAbstract() {
        Teacher t1 = new Teacher();
        System.out.println(t1.getDescribe());
    }
}
