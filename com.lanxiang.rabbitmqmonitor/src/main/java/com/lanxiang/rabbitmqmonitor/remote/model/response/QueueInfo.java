package com.lanxiang.rabbitmqmonitor.remote.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lanxiang.rabbitmqmonitor.remote.model.common.*;
import lombok.Data;

import java.util.Date;


/**
 * Created by lanxiang on 2017/4/25.
 */

@Data
public class QueueInfo {

    private ConsumerDetails[] consumer_details;

    /**
     * unknown class
     */
    @JsonIgnore
    private Object[] incoming;

    /**
     * unknown class
     */
    @JsonIgnore
    private Object[] deliveries;

    private Long messages;

    private Details messages_details;

    private Long messages_unacknowledged;

    private Details messages_unacknowledged_details;

    private Long messages_ready;

    private Details messages_ready_details;

    private Long reductions;

    private Details reductions_details;

    private MessageStats message_stats;

    private String node;

    /**
     * unknown class
     */
    @JsonIgnore
    private Object arguments;

    private Boolean exclusive;

    private Boolean auto_delete;

    private Boolean durable;

    private String vhost;

    private String name;

    private Long message_bytes_paged_out;

    private Long messages_paged_out;

    private BackingQueueStatus backing_queue_status;

    /**
     * unknown class
     */
    @JsonIgnore
    private Object head_message_timestamp;

    private Long message_bytes_persistent;

    private Long message_bytes_ram;

    private Long message_bytes_unacknowledged;

    private Long message_bytes_ready;

    private Long message_bytes;

    private Long messages_persistent;

    private Long messages_unacknowledged_ram;

    private Long messages_ready_ram;

    private Long messages_ram;

    private GarbageCollection garbage_collection;

    private String state;

    /**
     * unknown class
     */
    @JsonIgnore
    private Object recoverable_slaves;

    private Long memory;

    private Double consumer_utilisation;

    private Integer consumers;

    /**
     * unknown class
     */
    @JsonIgnore
    private Object exclusive_consumer_tag;

    /**
     * unknown class
     */
    @JsonIgnore
    private Object policy;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date idle_since;
}
