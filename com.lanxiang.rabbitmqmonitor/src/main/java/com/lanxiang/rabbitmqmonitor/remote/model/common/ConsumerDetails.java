package com.lanxiang.rabbitmqmonitor.remote.model.common;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * Created by lanxiang on 2017/4/24.
 */

@Data
public class ConsumerDetails {

    private ChannelDetails channel_details;

    /**
     * unknown class
     */
    @JsonIgnore
    private Object arguments;

    private Integer prefetch_count;

    private Boolean ack_required;

    private Boolean exclusive;

    private String consumer_tag;

    private Queue queue;
}
