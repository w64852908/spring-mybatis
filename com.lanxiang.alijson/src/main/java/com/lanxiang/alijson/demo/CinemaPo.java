package com.lanxiang.alijson.demo;

import java.util.Date;

/**
 * Created by lanxiang on 2017/5/17.
 */
public class CinemaPo {

    private String id;

    private String cinemaId;

    private String cinemaName;

    private String sourceId;

    private String outCinemaId;

    private String cityId;

    private String cityName;

    private String ticketStatus;//选座状态1：上线中，2：已下线， 4：待上线

    private Date createTime;

    private Date modifyTime;

    private String infoJ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(String cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getOutCinemaId() {
        return outCinemaId;
    }

    public void setOutCinemaId(String outCinemaId) {
        this.outCinemaId = outCinemaId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getInfoJ() {
        return infoJ;
    }

    public void setInfoJ(String infoJ) {
        this.infoJ = infoJ;
    }

    @Override
    public String toString() {
        return "CinemaPo{" +
                "id='" + id + '\'' +
                ", cinemaId='" + cinemaId + '\'' +
                ", cinemaName='" + cinemaName + '\'' +
                ", sourceId='" + sourceId + '\'' +
                ", outCinemaId='" + outCinemaId + '\'' +
                ", cityId='" + cityId + '\'' +
                ", cityName='" + cityName + '\'' +
                ", ticketStatus='" + ticketStatus + '\'' +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", infoJ='" + infoJ + '\'' +
                '}';
    }
}
