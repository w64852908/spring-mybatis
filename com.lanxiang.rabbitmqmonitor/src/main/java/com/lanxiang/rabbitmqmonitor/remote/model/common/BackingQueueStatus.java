package com.lanxiang.rabbitmqmonitor.remote.model.common;

import lombok.Data;

import java.util.Arrays;

/**
 * Created by lanxiang on 2017/4/25.
 */

@Data
public class BackingQueueStatus {

    private String mode;

    private Object[] delta;

    private Long q1;

    private Long q2;

    private Long q3;

    private Long q4;

    private Long len;

    private String target_ram_count;

    private Long next_seq_id;

    private Long avg_ingress_rate;

    private Long avg_egress_rate;

    private Long avg_ack_ingress_rate;

    private Long avg_ack_egress_rate;
}
