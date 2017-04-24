package com.lanxiang.rabbitmqmonitor.remote.model.common;


/**
 * Created by lanxiang on 2017/4/24.
 */
public class ConsumerDetails {

    private ChannelDetails channel_details;

    /**
     * unknown type
     */
//    private Arguments arguments;

    private Integer prefetch_count;

    private Boolean ack_required;

    private Boolean exclusive;

    private String consumer_tag;

    private Queue queue;
}
