package com.lanxiang.esper.order;

/**
 * Created by lanxiang on 2017/9/19.
 */
public class Order {

    private Integer id;

    private Integer isVip;

    private Integer discountCardId;

    private Integer price;

    private Integer cinemaId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsVip() {
        return isVip;
    }

    public void setIsVip(Integer isVip) {
        this.isVip = isVip;
    }

    public Integer getDiscountCardId() {
        return discountCardId;
    }

    public void setDiscountCardId(Integer discountCardId) {
        this.discountCardId = discountCardId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Integer cinemaId) {
        this.cinemaId = cinemaId;
    }

    public Order(Integer id, Integer isVip, Integer discountCardId, Integer price, Integer cinemaId) {
        this.id = id;
        this.isVip = isVip;
        this.discountCardId = discountCardId;
        this.price = price;
        this.cinemaId = cinemaId;
    }
}
