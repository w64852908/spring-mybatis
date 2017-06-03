package com.lanxiang.springrabbit.instance;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Random;

/**
 * Created by lanxiang on 2017/4/24.
 */
public class Consumer {

    private final static Random random = new Random();

    public void listen(String message) throws Exception {
        String id = message.split("_")[0];
        String option = message.split("_")[1];
        System.out.println(" [x] received '" + id + "_" + option + "'");
//        long sleepSeconds = (random.nextInt(3)) * 1000;
        long sleepSeconds = (random.nextInt(3)) * 10;
        Thread.sleep(sleepSeconds);
        boolean res = handleOption(id, option);
        if (res) {
            System.out.println(" [x] finish '" + id + "' ," + " cost " + (double) sleepSeconds / 1000 + " seconds");
        } else {
            System.out.println(" [x] failed handle '" + id + "'");
        }
        Thread.sleep(1);
    }

    private boolean handleOption(String id, String option) {
        return true;
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-rabbit-comsumer.xml");
        RabbitTemplate template = ctx.getBean(RabbitTemplate.class);

    }
}
