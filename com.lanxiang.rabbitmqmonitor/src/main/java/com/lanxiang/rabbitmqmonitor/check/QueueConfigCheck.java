package com.lanxiang.rabbitmqmonitor.check;

/**
 * Created by lanxiang on 2017/4/24.
 */

import com.lanxiang.rabbitmqmonitor.api.RMQApi;
import com.lanxiang.rabbitmqmonitor.model.CheckQueue;
import com.lanxiang.rabbitmqmonitor.remote.model.response.QueueInfo;
import com.lanxiang.rabbitmqmonitor.remote.resource.RMQResource;
import com.lanxiang.rabbitmqmonitor.terminate.ExitType;
import com.lanxiang.rabbitmqmonitor.terminate.ExitUtil;
import com.lanxiang.rabbitmqmonitor.utils.RMQConfig;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.core.Response;

/**
 * 检测队列配置
 */

@Slf4j
public class QueueConfigCheck {

    private final static RMQResource rmqResource = RMQApi.getService(RMQResource.class);

    public static void checkQueueConfig(String vhost, CheckQueue queue) {
        RMQConfig config = RMQConfig.Singleton.INSTANCE.getRmqConfig();
        String host = config.getHost();
        Response response = null;
        try {
            response = rmqResource.getQueueInfo(vhost, queue.getQueue_name());
        } catch (Exception e) {
            log.error("UNKNOWN: Could not connect to {}, cause {}", host, e.getMessage());
            ExitUtil.exit(ExitType.UNKNOWN.getValue());
        }
        if (response == null || response.getStatus() == 404) {
            log.error("CRITICAL: Queue {} does not exist.", queue.getQueue_name());
            ExitUtil.exit(ExitType.CRITICAL.getValue());
        } else if (response.getStatus() > 299) {
            log.error("UNKNOWN: Unexpected API error : {}", response);
            ExitUtil.exit(ExitType.UNKNOWN.getValue());
        } else {
            QueueInfo info = response.readEntity(QueueInfo.class);
            if (!info.getAuto_delete().equals(queue.getAuto_delete())) {
                log.warn("WARN: Queue {} - auto_delete flag is NOT {}", queue.getQueue_name(), info.getAuto_delete());
                ExitUtil.exit(ExitType.WARN.getValue());
            }
            if (!info.getDurable().equals(queue.getDurable())) {
                log.warn("WARN: Queue {} - durable flag is NOT {}", queue.getQueue_name(), info.getDurable());
                ExitUtil.exit(ExitType.WARN.getValue());
            }
        }
        log.info("OK: Queue {} configured correctly.", queue.getQueue_name());
        ExitUtil.exit(ExitType.OK.getValue());
    }
}
