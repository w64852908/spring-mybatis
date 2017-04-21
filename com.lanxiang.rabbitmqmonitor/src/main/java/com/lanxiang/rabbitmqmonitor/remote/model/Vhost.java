package com.lanxiang.rabbitmqmonitor.remote.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lanxiang.rabbitmqmonitor.remote.model.common.BasicDetails;

/**
 * Created by lanxiang on 2017/4/21.
 */
public class Vhost {

    private String name;

    private boolean tracing;

    @JsonProperty
    private Integer messages_ready;

    @JsonProperty
    private BasicDetails messages_ready_details;

    @JsonProperty
    private Integer messages_unacknowledged;

    @JsonProperty
    private BasicDetails messages_unacknowledged_details;

    @JsonProperty
    private Integer messages;

    @JsonProperty
    private BasicDetails messages_details;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTracing() {
        return tracing;
    }

    public void setTracing(boolean tracing) {
        this.tracing = tracing;
    }

    public Integer getMessages_ready() {
        return messages_ready;
    }

    public void setMessages_ready(Integer messages_ready) {
        this.messages_ready = messages_ready;
    }

    public BasicDetails getMessages_ready_details() {
        return messages_ready_details;
    }

    public void setMessages_ready_details(BasicDetails messages_ready_details) {
        this.messages_ready_details = messages_ready_details;
    }

    public Integer getMessages_unacknowledged() {
        return messages_unacknowledged;
    }

    public void setMessages_unacknowledged(Integer messages_unacknowledged) {
        this.messages_unacknowledged = messages_unacknowledged;
    }

    public BasicDetails getMessages_unacknowledged_details() {
        return messages_unacknowledged_details;
    }

    public void setMessages_unacknowledged_details(BasicDetails messages_unacknowledged_details) {
        this.messages_unacknowledged_details = messages_unacknowledged_details;
    }

    public Integer getMessages() {
        return messages;
    }

    public void setMessages(Integer messages) {
        this.messages = messages;
    }

    public BasicDetails getMessages_details() {
        return messages_details;
    }

    public void setMessages_details(BasicDetails messages_details) {
        this.messages_details = messages_details;
    }

    @Override
    public String toString() {
        return "Vhost{" +
                "name='" + name + '\'' +
                ", tracing=" + tracing +
                ", messages_ready=" + messages_ready +
                ", messages_ready_details=" + messages_ready_details +
                ", messages_unacknowledged=" + messages_unacknowledged +
                ", messages_unacknowledged_details=" + messages_unacknowledged_details +
                ", messages=" + messages +
                ", messages_details=" + messages_details +
                '}';
    }
}
