package com.lanxiang.alijson.service;

/**
 * Created by lanxiang on 2017/10/31.
 */
public class PartnerCinema {

    private int id;

    private int source;

    private String partnerId;

    private String name;

    private long created;

    private long modified;

    private String info;

    private int serverFlag;

    private int syncDays;

    private int cutTime;

    private int lockTime;

    private String specialCapitalCinemaCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public long getModified() {
        return modified;
    }

    public void setModified(long modified) {
        this.modified = modified;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getServerFlag() {
        return serverFlag;
    }

    public void setServerFlag(int serverFlag) {
        this.serverFlag = serverFlag;
    }

    public int getSyncDays() {
        return syncDays;
    }

    public void setSyncDays(int syncDays) {
        this.syncDays = syncDays;
    }

    public int getCutTime() {
        return cutTime;
    }

    public void setCutTime(int cutTime) {
        this.cutTime = cutTime;
    }

    public int getLockTime() {
        return lockTime;
    }

    public void setLockTime(int lockTime) {
        this.lockTime = lockTime;
    }

    public String getSpecialCapitalCinemaCode() {
        return specialCapitalCinemaCode;
    }

    public void setSpecialCapitalCinemaCode(String specialCapitalCinemaCode) {
        this.specialCapitalCinemaCode = specialCapitalCinemaCode;
    }
}
