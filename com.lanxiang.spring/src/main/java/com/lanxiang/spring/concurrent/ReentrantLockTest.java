package com.lanxiang.spring.concurrent;

import java.util.concurrent.TimeUnit;
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

        while (Thread.activeCount() > 2){

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
}
