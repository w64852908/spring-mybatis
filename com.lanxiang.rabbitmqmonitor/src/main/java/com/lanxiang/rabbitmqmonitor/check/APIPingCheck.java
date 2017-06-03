package com.lanxiang.rabbitmqmonitor.check;


import com.lanxiang.rabbitmqmonitor.api.RMQApi;
import com.lanxiang.rabbitmqmonitor.remote.model.response.CheckResp;
import com.lanxiang.rabbitmqmonitor.remote.resource.RMQResource;
import com.lanxiang.rabbitmqmonitor.terminate.ExitType;
import com.lanxiang.rabbitmqmonitor.terminate.ExitUtil;
import com.lanxiang.rabbitmqmonitor.utils.RMQConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;

/**
 * Created by lanxiang on 2017/4/21.
 */


/**
 * 基于RabbitMQ的REST API的检测
 */
public class APIPingCheck {

    private final static RMQResource rmqResource = RMQApi.getService(RMQResource.class);

    private final static Logger log = LoggerFactory.getLogger(APIPingCheck.class);

    public static void checkAPIPing(String vhost) {
        RMQConfig config = RMQConfig.Singleton.INSTANCE.getRmqConfig();
        String host = config.getHost();
        Response response = null;
        try {
            response = rmqResource.testAliveness(vhost);
        } catch (Exception e) {
            log.error("CRITICAL: Could not connect to {}, cause {}", host, e.getMessage());
            ExitUtil.exit(ExitType.CRITICAL.getValue());
        }
        if (response == null || response.getStatus() > 299) {
            log.error("CRITICAL: Broker not alive : {}", response);
            ExitUtil.exit(ExitType.CRITICAL.getValue());
        } else {
            log.info("OK: Broker alive: {}", response.readEntity(CheckResp.class));
            ExitUtil.exit(ExitType.OK.getValue());
        }
    }
}