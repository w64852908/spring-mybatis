package com.lanxiang.rabbitmqmonitor.check;

import com.lanxiang.rabbitmqmonitor.utils.RMQConfig;


/**
 * Created by lanxiang on 2017/4/21.
 */
public class APIPingCheck {

    public static void checkAPIPing() {
        RMQConfig config = RMQConfig.Singleton.INSTANCE.getRmqConfig();
        String host = config.getHost();
        String username = config.getUsername();
        String password = config.getPassword();

    }
}
