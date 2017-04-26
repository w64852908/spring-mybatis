package com.lanxiang.rabbitmqmonitor.model;

import lombok.Data;

/**
 * Created by lanxiang on 2017/4/25.
 */

@Data
public class CheckQueue {

    private final String queue_name;

    private final Boolean auto_delete;

    private final Boolean durable;

    public CheckQueue(String queue_name, Boolean auto_delete, Boolean durable) {
        this.queue_name = queue_name;
        this.auto_delete = auto_delete;
        this.durable = durable;
    }
}
