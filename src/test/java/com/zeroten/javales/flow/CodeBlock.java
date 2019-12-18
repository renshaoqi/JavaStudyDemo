package com.zeroten.javales.flow;

import org.junit.Assert;
import org.junit.Test;

public class CodeBlock {
    @Test
    public void testAgeCheck1() {
        Assert.assertEquals(AgeCheck.getAgeName(6), "儿童");
        Assert.assertEquals(AgeCheck.getAgeName(7), "少年");
        Assert.assertEquals(AgeCheck.getAgeName(20), "青年");
    }

    @Test
    public void testAgeCheck2() {
        Assert.assertEquals(AgeCheck.getAgeName(45), "中年");
        Assert.assertEquals(AgeCheck.getAgeName(60), "老年");
        Assert.assertEquals(AgeCheck.getAgeName(80), "老年");
        Integer str1 = 3;
    }
}
