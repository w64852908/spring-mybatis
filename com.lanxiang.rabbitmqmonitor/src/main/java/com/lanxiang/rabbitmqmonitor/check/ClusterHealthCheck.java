package com.lanxiang.rabbitmqmonitor.check;

import com.lanxiang.rabbitmqmonitor.api.RMQApi;
import com.lanxiang.rabbitmqmonitor.remote.resource.RMQResource;
import com.lanxiang.rabbitmqmonitor.terminate.ExitType;
import com.lanxiang.rabbitmqmonitor.terminate.ExitUtil;
import com.lanxiang.rabbitmqmonitor.utils.RMQConfig;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.core.Response;

/**
 * Created by lanxiang on 2017/4/26.
 */

@Slf4j
public class ClusterHealthCheck {

    private final static RMQResource rmqResource = RMQApi.getService(RMQResource.class);

    public static void checkClusterHealth() {
        RMQConfig config = RMQConfig.Singleton.INSTANCE.getRmqConfig();
        String host = config.getHost();
        Response response = null;
        try {
            response = rmqResource.getNodes();
        } catch (Exception e) {
            log.error("CRITICAL: Could not connect to {}, cause {}", host, e.getMessage());
            ExitUtil.exit(ExitType.CRITICAL.getValue());
        }
        if (response == null || response.getStatus() > 299) {
            log.error("UNKNOWN: Unexpected API error : {}", response);
            ExitUtil.exit(ExitType.UNKNOWN.getValue());
        }

    }
}
