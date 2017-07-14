package com.lanxiang.springmvc.model;

import java.util.Date;

/**
 * Created by lanxiang on 2017/7/5.
 */
public class Movie {

    private Integer id;

    private String name;

    private Date showDate;

    private String showId;

    public Movie() {
    }

    public Movie(Integer id, String name, Date showDate, String showId) {
        this.id = id;
        this.name = name;
        this.showDate = showDate;
        this.showId = showId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getShowDate() {
        return showDate;
    }

    public void setShowDate(Date showDate) {
        this.showDate = showDate;
    }

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }
}
