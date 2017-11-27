package com.lanxiang.esper.simpledemo;

/**
 * Created by lanxiang on 2017/11/27.
 */
public class PriceEvent {

    private double price;

    private String itemName;

    public PriceEvent(double price, String itemName) {
        this.price = price;
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public String getItemName() {
        return itemName;
    }

}
