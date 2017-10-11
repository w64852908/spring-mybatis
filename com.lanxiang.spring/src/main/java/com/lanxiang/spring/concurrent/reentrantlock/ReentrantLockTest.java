package com.lanxiang.spring.concurrent.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

/**
 * Created by lanxiang on 2017/10/10.
 */
public class ReentrantLockTest {

    private ReentrantLock lock = new ReentrantLock();

    @Test
    public void testTrylock() throws InterruptedException {
        for (int i = 0; i < 4; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    tryLock(lock);
                }
            }).start();
        }
    }

    private void tryLock(ReentrantLock lock) {
        if (lock.tryLock()) {
            System.out.println(Thread.currentThread().getName() + " get lock success.");
            try {
                System.out.println("do something");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + "　get lock failed.");
        }
    }


    @Test
    public void testLock() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    lock(lock);
                }
            }).start();
        }

        while (Thread.activeCount() > 2) {

        }
    }

    private void lock(ReentrantLock lock) {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " get lock success.");
            System.out.println("do something");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            lock.unlock();
        }
    }

    @Test
    public void testTryLockExpire() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    TimeUnit.SECONDS.sleep(6);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
        }).start();

        tryLockExpire(lock);

        while (Thread.activeCount() > 2) {

        }
    }

    private void tryLockExpire(ReentrantLock lock) {
        try {
            if (lock.tryLock(5, TimeUnit.SECONDS)) {
                try {
                    System.out.println(Thread.currentThread().getName() + " get lock success.");
                    System.out.println("do something");
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + "　get lock expired.");
            }
        } catch (InterruptedException e) {

        }
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

        Thread.sleep(1000000);
    }

    @Test
    public void testConditionAwait() throws InterruptedException {
        final Lock lock = new ReentrantLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    lock.lock();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.unlock();
                }
            }
        }, "sleep thread").start();

        Condition leftTime = lock.newCondition();
        long awaitTime = TimeUnit.SECONDS.toNanos(1);
        lock.lockInterruptibly();
        while (true) {
            awaitTime = leftTime.awaitNanos(awaitTime);
            System.out.println("left time : " + awaitTime);
            if (awaitTime <= 0) {
                return;
            }
        }
    }
}
