package com.lanxiang.kafka.simpledemo;

import org.junit.Test;

/**
 * Created by lanxiang on 2017/5/11.
 */
public class KafkaClient {

    @Test
    public void runCon() {
        JConsumer consumer = new JConsumer(KafkaProperties.topic);
        consumer.start();

        while(Thread.activeCount() > 2){

        }
    }

    @Test
    public void runPro(){
        JProducer producer = new JProducer(KafkaProperties.topic);
        producer.start();

        while(Thread.activeCount() > 2){

        }
    }
}
