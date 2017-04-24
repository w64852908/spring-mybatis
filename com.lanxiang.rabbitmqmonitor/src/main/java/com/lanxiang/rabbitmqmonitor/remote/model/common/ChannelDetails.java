package com.lanxiang.rabbitmqmonitor.remote.model.common;


/**
 * Created by lanxiang on 2017/4/24.
 */
public class ChannelDetails {

    private String peer_host;

    private Long peer_port;

    private String connection_name;

    private String user;

    private Long number;

    private String node;

    private String name;

    public String getPeer_host() {
        return peer_host;
    }

    public void setPeer_host(String peer_host) {
        this.peer_host = peer_host;
    }

    public Long getPeer_port() {
        return peer_port;
    }

    public void setPeer_port(Long peer_port) {
        this.peer_port = peer_port;
    }

    public String getConnection_name() {
        return connection_name;
    }

    public void setConnection_name(String connection_name) {
        this.connection_name = connection_name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ChannelDetails{" +
                "peer_host='" + peer_host + '\'' +
                ", peer_port=" + peer_port +
                ", connection_name='" + connection_name + '\'' +
                ", user='" + user + '\'' +
                ", number=" + number +
                ", node='" + node + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
