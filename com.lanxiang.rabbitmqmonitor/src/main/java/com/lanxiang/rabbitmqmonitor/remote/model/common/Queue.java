package com.lanxiang.rabbitmqmonitor.remote.model.common;

/**
 * Created by lanxiang on 2017/4/24.
 */
public class Queue {

    private String vhost;

    private String name;

    public String getVhost() {
        return vhost;
    }

    public void setVhost(String vhost) {
        this.vhost = vhost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Queue{" +
                "vhost='" + vhost + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
