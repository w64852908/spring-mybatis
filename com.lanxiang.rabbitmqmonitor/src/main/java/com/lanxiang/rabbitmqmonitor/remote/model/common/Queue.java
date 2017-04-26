package com.lanxiang.rabbitmqmonitor.remote.model.common;

import lombok.Data;

/**
 * Created by lanxiang on 2017/4/24.
 */

@Data
public class Queue {

    private String vhost;

    private String name;
}
