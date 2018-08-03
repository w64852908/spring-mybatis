package com.lanxiang.localcache;

import java.util.Date;

/**
 * Created by lanxiang on 2018/1/9.
 */
public class SpecialHall {

    private int id;
    private String name;//特效厅名称
    private String company;//公司名称
    private String logourl;//logo 链接
    private String introduce;//说明
    private int status;//状态0删除1未删除
    private int visible;//c端是否可以显示1显示0未显示
    private int sort;//排序
    private Date created;       //
    private Date modified;      //

    public SpecialHall(int id, String name, String company, String logourl, String introduce, int status, int visible, int sort) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.logourl = logourl;
        this.introduce = introduce;
        this.status = status;
        this.visible = visible;
        this.sort = sort;
        this.created = new Date();
        this.modified = created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLogourl() {
        return logourl;
    }

    public void setLogourl(String logourl) {
        this.logourl = logourl;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }
}
