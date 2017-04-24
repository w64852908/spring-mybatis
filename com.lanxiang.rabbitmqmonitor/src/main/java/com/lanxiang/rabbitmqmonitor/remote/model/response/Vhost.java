package com.lanxiang.rabbitmqmonitor.remote.model.response;

import com.lanxiang.rabbitmqmonitor.remote.model.common.Details;
import com.lanxiang.rabbitmqmonitor.remote.model.common.Stats;

/**
 * Created by lanxiang on 2017/4/21.
 */
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

    private Stats message_stats;

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

    public Details getMessages_ready_details() {
        return messages_ready_details;
    }

    public void setMessages_ready_details(Details messages_ready_details) {
        this.messages_ready_details = messages_ready_details;
    }

    public Integer getMessages_unacknowledged() {
        return messages_unacknowledged;
    }

    public void setMessages_unacknowledged(Integer messages_unacknowledged) {
        this.messages_unacknowledged = messages_unacknowledged;
    }

    public Details getMessages_unacknowledged_details() {
        return messages_unacknowledged_details;
    }

    public void setMessages_unacknowledged_details(Details messages_unacknowledged_details) {
        this.messages_unacknowledged_details = messages_unacknowledged_details;
    }

    public Integer getMessages() {
        return messages;
    }

    public void setMessages(Integer messages) {
        this.messages = messages;
    }

    public Details getMessages_details() {
        return messages_details;
    }

    public void setMessages_details(Details messages_details) {
        this.messages_details = messages_details;
    }

    public Stats getMessage_stats() {
        return message_stats;
    }

    public void setMessage_stats(Stats message_stats) {
        this.message_stats = message_stats;
    }

    public Integer getSend_oct() {
        return send_oct;
    }

    public void setSend_oct(Integer send_oct) {
        this.send_oct = send_oct;
    }

    public Details getSend_oct_details() {
        return send_oct_details;
    }

    public void setSend_oct_details(Details send_oct_details) {
        this.send_oct_details = send_oct_details;
    }

    public Integer getRecv_oct() {
        return recv_oct;
    }

    public void setRecv_oct(Integer recv_oct) {
        this.recv_oct = recv_oct;
    }

    public Details getRecv_oct_details() {
        return recv_oct_details;
    }

    public void setRecv_oct_details(Details recv_oct_details) {
        this.recv_oct_details = recv_oct_details;
    }

    @Override
    public String toString() {
        return "Vhost{" +
                "name='" + name + '\'' +
                ", tracing=" + tracing +
                ", send_oct=" + send_oct +
                ", send_oct_details=" + send_oct_details +
                ", recv_oct=" + recv_oct +
                ", recv_oct_details=" + recv_oct_details +
                ", messages_ready=" + messages_ready +
                ", messages_ready_details=" + messages_ready_details +
                ", messages_unacknowledged=" + messages_unacknowledged +
                ", messages_unacknowledged_details=" + messages_unacknowledged_details +
                ", messages=" + messages +
                ", messages_details=" + messages_details +
                ", message_stats=" + message_stats +
                '}';
    }
}
