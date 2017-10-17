package com.lanxiang.spring.concurrent.countdownlatch;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

/**
 * Created by lanjing on 2017/10/12.
 */
public class CountDownLatchTest {

    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");

    private static final Random random = new Random();

    @Test
    public void run() {
        int taskNum = 11;
        final CountDownLatch latch = new CountDownLatch(taskNum);

        ExecutorService executors = Executors.newFixedThreadPool(5);

        for (int i = 0; i < taskNum; i++) {

            executors.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        String start = format.format(new Date());
                        TimeUnit.SECONDS.sleep(random.nextInt(2) + 1);
                        String end = format.format(new Date());
                        System.out.println(Thread.currentThread().getName() + " start job at " + start + " finish at " + end);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        latch.countDown();
                    }
                }
            });
        }

//        try {
//            latch.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " await finished");
                }
            }, "Main thread-" + i).start();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All job finished.");
    }
}
