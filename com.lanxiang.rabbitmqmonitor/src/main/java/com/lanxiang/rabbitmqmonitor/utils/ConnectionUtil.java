package com.lanxiang.rabbitmqmonitor.utils;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by lanxiang on 2017/4/20.
 */

/**
 * 获取RabbitMQ连接
 */
public class ConnectionUtil {

    public static Connection getConnection() throws IOException, TimeoutException {
        RMQConfig config = RMQConfig.Singleton.INSTANCE.getRmqConfig();
        String host = config.getHost();
        int port = config.getPort();
        String username = config.getUsername();
        String password = config.getPassword();
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(host);
        factory.setPort(port);
        factory.setUsername(username);
        factory.setPassword(password);
        return factory.newConnection();
    }

    public static Connection getConnection(String host, int port, String username, String password) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(host);
        factory.setPort(port);
        factory.setUsername(username);
        factory.setPassword(password);
        return factory.newConnection();
    }
}