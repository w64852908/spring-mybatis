package com.lanxiang.spring.concurrent.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

/**
 * Created by lanxiang on 2017/10/12.
 */
public class InterruptTest {

    @Test
    public void testLock() throws InterruptedException {

        final Lock lock = new ReentrantLock();
        lock.lock();


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " interrupted.");
            }
        }, "child thread -1");

        t1.start();
        Thread.sleep(1000);

        t1.interrupt();

        Thread.sleep(5000);

    }

    @Test
    public void testLockInterruptibly() throws InterruptedException {
        final Lock lock = new ReentrantLock();
        lock.lock();


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lockInterruptibly();
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " interrupted.");
                }
            }
        }, "child thread -1");

        t1.start();
        Thread.sleep(1000);

        t1.interrupt();


        Thread.sleep(5000);
    }
}
