package com.lanxiang.kafka.simpledemo;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import java.util.Properties;

/**
 * Created by lanxiang on 2017/5/11.
 */
public class JProducer extends Thread {

    private final Producer<Integer, String> producer;

    private final String topic;

    private final Properties props = new Properties();

    public JProducer(String topic) {
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("metadata.broker.list", "127.0.0.1:9092");
        producer = new kafka.javaapi.producer.Producer<>(new ProducerConfig(props));
        this.topic = topic;
        System.out.println("Construct JProducer");
    }

    @Override
    public void run() {
        int messageNo = 1;
        while (true) {
            String msg = new String("Message_" + messageNo++);
            System.out.println("Send->[" + msg + "]");
            producer.send(new KeyedMessage<Integer, String>(topic, msg));
            try {
                sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
