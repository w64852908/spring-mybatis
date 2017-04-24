package com.lanxiang.rabbitmqmonitor.check;

import com.lanxiang.rabbitmqmonitor.terminate.ExitType;
import com.lanxiang.rabbitmqmonitor.terminate.ExitUtil;
import com.lanxiang.rabbitmqmonitor.utils.ConnectionUtil;
import com.lanxiang.rabbitmqmonitor.utils.RMQConfig;
import com.rabbitmq.client.Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by lanxiang on 2017/4/20.
 */

/**
 * 检测能否创建RabbitMQ连接
 */
public class AMQPPingCheck {

    private final static Logger log = LoggerFactory.getLogger(AMQPPingCheck.class);

    public static void checkAMQPPing() {
        RMQConfig config = RMQConfig.Singleton.INSTANCE.getRmqConfig();
        String host = config.getHost();
        String username = config.getUsername();
        String password = config.getPassword();
        Connection connection = null;
        try {
            connection = ConnectionUtil.getConnection(host, username, password);
        } catch (IOException | TimeoutException e) {
            log.error("Critical : Could not connect to {}, cause {}", host, e.getMessage());
            ExitUtil.exit(ExitType.CRITICAL.getValue());
        }
        log.info("OK: Connect to {} successful.", host);
        ExitUtil.exit(ExitType.OK.getValue());
    }
}
