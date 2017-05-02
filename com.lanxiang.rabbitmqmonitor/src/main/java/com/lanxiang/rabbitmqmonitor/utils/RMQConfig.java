package com.lanxiang.rabbitmqmonitor.utils;


import java.io.IOException;
import java.util.Properties;

/**
 * Created by lanxiang on 2017/4/20.
 */
public class RMQConfig {

    private final String host;

    private final int port;

    private final String username;

    private final String password;

    private final String rmqUrl;

    private RMQConfig() throws IOException {
        Properties properties = new Properties();
        //读取resources下的properties文件
        properties.load(getClass().getClassLoader().getResourceAsStream("rabbitmq-cfg.properties"));
        host = properties.getProperty("host");
        port = Integer.valueOf(properties.getProperty("port"));
        username = properties.getProperty("username");
        password = properties.getProperty("password");
        rmqUrl = properties.getProperty("rmq_url");
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRmqUrl() {
        return rmqUrl;
    }

    public enum Singleton {

        INSTANCE;

        private RMQConfig rmqConfig;

        Singleton() {
            try {
                rmqConfig = new RMQConfig();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        public RMQConfig getRmqConfig() {
            return rmqConfig;
        }
    }
}