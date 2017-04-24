package com.lanxiang.springrabbit.instance;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lanxiang on 2017/4/24.
 */
public class Producer {

    private static final String option = "add";

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-rabbit-producer.xml");
        RabbitTemplate template = ctx.getBean(RabbitTemplate.class);
        int n = 1;
        for (int j = 0; j < 10000; j++) {
            for (int i = 1; i <= 100; i++) {
                String id = String.valueOf(n);
                String message = id + "_" + option;
                template.convertAndSend(message);
                n++;
            }
            System.out.println(" [x] Sent 100 messages " + j + "/" + 10000);
        }
    }
}
