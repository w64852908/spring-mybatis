package com.lanxiang.spring.concurrent.reentrantlock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

/**
 * Created by lanjing on 2017/10/11.
 */
public class ConditionTest {

    @Test
    public void run() {
        Model model = new Model(10);
        Producer producer = new Producer(model);
        Consumer consumer = new Consumer(model);
        for (int i = 0; i < 3; i++) {
            new Thread(producer, "producer-" + i).start();
        }
        for (int i = 0; i < 3; i++) {
            new Thread(consumer, "consumer-" + i).start();
        }
        while (Thread.activeCount() > 2) {

        }
    }

}

class Producer implements Runnable {

    private Model model;

    Producer(Model model) {
        this.model = model;
    }

    @Override
    public void run() {
        while (true) {
            model.put();
        }
    }
}

class Consumer implements Runnable {

    private Model model;

    Consumer(Model model) {
        this.model = model;
    }

    @Override
    public void run() {
        while (true) {
            model.take();
        }
    }
}

class Model {

    private final Lock lock;

    private final Condition notFull;

    private final Condition notEmpty;

    private int maxSize;

    private LinkedList<Date> container;

    private final static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");

    public Model(int maxSize) {
        lock = new ReentrantLock();
        notFull = lock.newCondition();
        notEmpty = lock.newCondition();
        this.maxSize = maxSize;
        container = new LinkedList<>();
    }

    public void put() {
        lock.lock();
        try {
            while (container.size() == maxSize) {
                System.out.print(Thread.currentThread().getName() + ": wait \n");
                notFull.await();//阻塞生产线程
            }
            container.add(new Date());
            System.out.println(Thread.currentThread().getName() + ": put:" + container.size());
            Thread.sleep(200);
            notEmpty.signalAll();//唤醒消费线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void take() {
        lock.lock();
        try {
            while (container.size() == 0) {
                System.out.print(Thread.currentThread().getName() + ": wait \n");
                notEmpty.await();//阻塞生产线程
            }
            container.poll();
            System.out.println(Thread.currentThread().getName() + ": take:" + container.size());
            Thread.sleep(200);
            notFull.signalAll();//唤醒消费线程
            notFull.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
