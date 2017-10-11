package com.lanxiang.spring.concurrent.atomic;

import org.junit.Test;

/**
 * Created by lanxiang on 2017/10/11.
 */
public class CASTest {


    @Test
    public void run() {
        final CasCounter counter = new CasCounter(0);
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 5; j++) {
                        int val = counter.increment();
                        System.out.println(Thread.currentThread().getName() + " increment value : " + val);
                    }
                }
            }).start();
        }
        while (Thread.activeCount() > 1) {

        }
        System.out.println(counter.getValue());
    }
}

class CasCounter {

    private SimulateCAS count;

    public CasCounter(int initialValue) {
        this.count = new SimulateCAS(initialValue);
    }

    public int getValue() {
        return count.getValue();
    }

    public int increment() {
        int oldValue = count.getValue();
        //如果swap返回值与oldValue值不一致，说明已经有别的线程进行过了increment操作，需要重新赋值oldValue。直到本线程成功执行swap操作
        while (count.compareAndSwap(oldValue, oldValue + 1) != oldValue) {
            oldValue = count.getValue();
        }
        return oldValue + 1;
    }

}

class SimulateCAS {

    private int value;

    public SimulateCAS(int value) {
        this.value = value;
    }

    public synchronized int getValue() {
        return value;
    }


    /**
     * 如果预期值和CAS当前值相等，则赋其新值。
     *
     * @return 返回CAS原有值
     */
    public synchronized int compareAndSwap(int expectedValue, int newValue) {
        int oldValue = value;
        if (value == expectedValue) {
            value = newValue;
        }
        return oldValue;
    }
}

