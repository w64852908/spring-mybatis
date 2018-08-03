package com.lanxiang.spring.calculate;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * Created by lanxiang on 2018/1/4.
 */
public class CalculateTest {

    @Test
    public void testDivide() {
        float i = 10f;
        int j = 3;
        System.out.println(new BigDecimal(i / j));
    }

    @Test
    public void testDivide2() {
        BigDecimal up = new BigDecimal(10);
        BigDecimal down = new BigDecimal(3);
        System.out.println(up.divide(down, 2, BigDecimal.ROUND_FLOOR).floatValue());
    }
}
