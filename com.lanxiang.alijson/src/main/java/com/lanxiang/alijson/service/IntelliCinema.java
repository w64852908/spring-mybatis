package com.lanxiang.alijson.service;

/**
 * Created by lanxiang on 2017/10/31.
 */
public class IntelliCinema {

    private String name;

    private String specialCode;

    private String sourceName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialCode() {
        return specialCode;
    }

    public void setSpecialCode(String specialCode) {
        this.specialCode = specialCode;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public IntelliCinema(String name, String specialCode, String sourceName) {
        this.name = name;
        this.specialCode = specialCode;
        this.sourceName = sourceName;
    }

    public IntelliCinema() {
    }
}
