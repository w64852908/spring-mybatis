package com.lanxiang.spring.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

/**
 * Created by lanxiang on 2017/10/10.
 */
public class ReentrantLockTest {

    private ReentrantLock lock = new ReentrantLock(false);

    @Test
    public void testTrylock() throws InterruptedException {
        for (int i = 0; i < 4; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    trylock(lock);
                }
            }).start();
        }
    }

    private void trylock(ReentrantLock lock) {
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
}
