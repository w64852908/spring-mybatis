package com.lanxiang.rabbitmqmonitor.remote.model.common;


import lombok.Data;

/**
 * Created by lanxiang on 2017/4/24.
 */

@Data
public class ChannelDetails {

    private String peer_host;

    private Long peer_port;

    private String connection_name;

    private String user;

    private Long number;

    private String node;

    private String name;
}
