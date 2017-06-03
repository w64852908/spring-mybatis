package com.lanxiang.rabbitmqmonitor.remote.model.common;


/**
 * Created by lanxiang on 2017/4/24.
 */
public class MessageStats {

    private Integer publish;

    private Details publish_details;

    private Integer confirm;

    private Details confirm_details;

    private Integer return_unroutable;

    private Details return_unroutable_details;

    private Integer get;

    private Details get_details;

    private Integer get_no_ack;

    private Details get_no_ack_details;

    private Integer deliver;

    private Details deliver_details;

    private Integer deliver_no_ack;

    private Details deliver_no_ack_details;

    private Integer redeliver;

    private Details redeliver_details;

    private Integer ack;

    private Details ack_details;

    private Integer deliver_get;

    private Details deliver_get_details;


    public Integer getPublish() {
        return publish;
    }

    public void setPublish(Integer publish) {
        this.publish = publish;
    }

    public Details getPublish_details() {
        return publish_details;
    }

    public void setPublish_details(Details publish_details) {
        this.publish_details = publish_details;
    }

    public Integer getConfirm() {
        return confirm;
    }

    public void setConfirm(Integer confirm) {
        this.confirm = confirm;
    }

    public Details getConfirm_details() {
        return confirm_details;
    }

    public void setConfirm_details(Details confirm_details) {
        this.confirm_details = confirm_details;
    }

    public Integer getReturn_unroutable() {
        return return_unroutable;
    }

    public void setReturn_unroutable(Integer return_unroutable) {
        this.return_unroutable = return_unroutable;
    }

    public Details getReturn_unroutable_details() {
        return return_unroutable_details;
    }

    public void setReturn_unroutable_details(Details return_unroutable_details) {
        this.return_unroutable_details = return_unroutable_details;
    }

    public Integer getGet() {
        return get;
    }

    public void setGet(Integer get) {
        this.get = get;
    }

    public Details getGet_details() {
        return get_details;
    }

    public void setGet_details(Details get_details) {
        this.get_details = get_details;
    }

    public Integer getDeliver() {
        return deliver;
    }

    public void setDeliver(Integer deliver) {
        this.deliver = deliver;
    }

    public Details getDeliver_details() {
        return deliver_details;
    }

    public void setDeliver_details(Details deliver_details) {
        this.deliver_details = deliver_details;
    }

    public Integer getDeliver_no_ack() {
        return deliver_no_ack;
    }

    public void setDeliver_no_ack(Integer deliver_no_ack) {
        this.deliver_no_ack = deliver_no_ack;
    }

    public Details getDeliver_no_ack_details() {
        return deliver_no_ack_details;
    }

    public void setDeliver_no_ack_details(Details deliver_no_ack_details) {
        this.deliver_no_ack_details = deliver_no_ack_details;
    }

    public Integer getRedeliver() {
        return redeliver;
    }

    public void setRedeliver(Integer redeliver) {
        this.redeliver = redeliver;
    }

    public Details getRedeliver_details() {
        return redeliver_details;
    }

    public void setRedeliver_details(Details redeliver_details) {
        this.redeliver_details = redeliver_details;
    }

    public Integer getAck() {
        return ack;
    }

    public void setAck(Integer ack) {
        this.ack = ack;
    }

    public Details getAck_details() {
        return ack_details;
    }

    public void setAck_details(Details ack_details) {
        this.ack_details = ack_details;
    }

    public Integer getDeliver_get() {
        return deliver_get;
    }

    public void setDeliver_get(Integer deliver_get) {
        this.deliver_get = deliver_get;
    }

    public Details getDeliver_get_details() {
        return deliver_get_details;
    }

    public void setDeliver_get_details(Details deliver_get_details) {
        this.deliver_get_details = deliver_get_details;
    }

    public Integer getGet_no_ack() {
        return get_no_ack;
    }

    public void setGet_no_ack(Integer get_no_ack) {
        this.get_no_ack = get_no_ack;
    }

    public Details getGet_no_ack_details() {
        return get_no_ack_details;
    }

    public void setGet_no_ack_details(Details get_no_ack_details) {
        this.get_no_ack_details = get_no_ack_details;
    }

    @Override
    public String toString() {
        return "MessageStats{" +
                "publish=" + publish +
                ", publish_details=" + publish_details +
                ", confirm=" + confirm +
                ", confirm_details=" + confirm_details +
                ", return_unroutable=" + return_unroutable +
                ", return_unroutable_details=" + return_unroutable_details +
                ", get=" + get +
                ", get_details=" + get_details +
                ", get_no_ack=" + get_no_ack +
                ", get_no_ack_details=" + get_no_ack_details +
                ", deliver=" + deliver +
                ", deliver_details=" + deliver_details +
                ", deliver_no_ack=" + deliver_no_ack +
                ", deliver_no_ack_details=" + deliver_no_ack_details +
                ", redeliver=" + redeliver +
                ", redeliver_details=" + redeliver_details +
                ", ack=" + ack +
                ", ack_details=" + ack_details +
                ", deliver_get=" + deliver_get +
                ", deliver_get_details=" + deliver_get_details +
                '}';
    }
}
