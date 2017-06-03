package com.lanxiang.rabbitmqmonitor.remote.model.response;

import com.lanxiang.rabbitmqmonitor.remote.model.common.Details;
import com.lanxiang.rabbitmqmonitor.remote.model.common.MessageStats;
import lombok.Data;

/**
 * Created by lanxiang on 2017/4/21.
 */

@Data
public class Vhost {

    private String name;

    private boolean tracing;

    private Integer send_oct;

    private Details send_oct_details;

    private Integer recv_oct;

    private Details recv_oct_details;

    private Integer messages_ready;

    private Details messages_ready_details;

    private Integer messages_unacknowledged;

    private Details messages_unacknowledged_details;

    private Integer messages;

    private Details messages_details;

    private MessageStats message_stats;
}
