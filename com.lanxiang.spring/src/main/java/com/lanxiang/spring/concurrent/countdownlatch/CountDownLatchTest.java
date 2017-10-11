package com.lanxiang.spring.concurrent.countdownlatch;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by lanjing on 2017/10/12.
 */
public class CountDownLatchTest {

    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");

    private static final Random random = new Random();

    @Test
    public void run() {
        int threadNum = 10;
        final CountDownLatch latch = new CountDownLatch(threadNum);
        for (int i = 0; i < threadNum; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String start = format.format(new Date());
                    try {
                        TimeUnit.SECONDS.sleep(random.nextInt(20) + 1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    String end = format.format(new Date());
                    System.out.println(Thread.currentThread().getName() + " start job at " + start + " finish at " + end);
                    latch.countDown();
                }
            }).start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All job finished.");
    }
}
