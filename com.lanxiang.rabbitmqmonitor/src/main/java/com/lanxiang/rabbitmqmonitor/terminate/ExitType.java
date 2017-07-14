package com.lanxiang.rabbitmqmonitor.terminate;

/**
 * Created by lanxiang on 2017/4/21.
 */

/**
 * 健康检测程序的几种状态
 */
public enum ExitType {

    WARN("warning"),

    CRITICAL("critical"),

    UNKNOWN("unknown"),

    OK("ok");

    private String value;

    ExitType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}