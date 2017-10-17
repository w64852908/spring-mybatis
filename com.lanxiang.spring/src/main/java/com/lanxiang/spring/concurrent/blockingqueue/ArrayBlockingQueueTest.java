package com.lanxiang.spring.concurrent.blockingqueue;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import org.junit.Test;

/**
 * Created by lanxiang on 2017/10/11.
 */
public class ArrayBlockingQueueTest {

    @Test
    public void testOffer() {
        final Queue<Integer> queue = new ArrayBlockingQueue<>(3);
        for (int i = 0; i < 5; i++) {
            final int val = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    boolean offered = queue.offer(val);
                    if (offered) {
                        System.out.println(Thread.currentThread().getName() + " offered");
                    } else {
                        System.out.println(Thread.currentThread().getName() + " offer failed");
                    }
                }
            }).start();
        }
    }

    @Test
    public void testPut() {
        final ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);
        for (int i = 0; i < 5; i++) {
            final int val = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        queue.put(val);
                        System.out.println(Thread.currentThread().getName() + " put success");
                    } catch (InterruptedException e) {
                        System.out.println(Thread.currentThread().getName() + " has been interrupted.");
                    }
                }
            }).start();
        }
    }
}
