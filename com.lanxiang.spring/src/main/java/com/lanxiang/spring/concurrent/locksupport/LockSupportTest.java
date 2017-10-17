package com.lanxiang.spring.concurrent.locksupport;

import java.util.concurrent.locks.LockSupport;

import org.junit.Test;

/**
 * Created by lanxiang on 2017/10/16.
 */
public class LockSupportTest {

    @Test
    public void parkTest() {
        LockSupport.park();
        System.out.println("block....");
    }

    @Test
    public void unparkTest() {
        Thread curr = Thread.currentThread();

        LockSupport.unpark(curr);

        System.out.println("a");
        LockSupport.park();
        System.out.println("b");
        LockSupport.park();
        System.out.println("c");
    }

    @Test
    public void interruptTest() throws InterruptedException {

        Thread t = new Thread(new Runnable() {

            private int count = 0;

            @Override
            public void run() {
                long start = System.currentTimeMillis();
                long end = 0;

                while ((end - start) <= 1000) {
                    count++;
                    end = System.currentTimeMillis();
                }

                System.out.println("after 1 second.count = " + count);

                LockSupport.park();

                System.out.println("Thread over. " + Thread.currentThread().getName() + ", interrupted : " + Thread.currentThread().isInterrupted());
            }
        }, "LockSupport Interrupt Test");

        t.start();

        Thread.sleep(2000);

        t.interrupt();

        System.out.println("main over");


    }
}
