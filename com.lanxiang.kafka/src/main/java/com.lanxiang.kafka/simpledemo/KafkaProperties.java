package com.lanxiang.kafka.simpledemo;

/**
 * Created by lanxiang on 2017/5/11.
 */
public interface KafkaProperties {

    String zkConnect = "127.0.0.1:2181";

    String groupId = "group1";

    String topic = "TEST-TOPIC";

    String kafkaServerURL = "127.0.0.1";

    int kafkaServerPort = 9092;

    int kafkaProducerBufferSize = 64 * 1024;

    int connectionTimeOut = 20000;

    int reconnectInterval = 10000;
}
