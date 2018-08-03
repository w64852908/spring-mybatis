package com.lanxiang.spring.service;

/**
 * Created by lanxiang on 2018/2/6.
 */

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.google.common.collect.Maps;

/**
 * Created by xiaozhiping on 17/4/7.
 */
public class OpenRefundController {


    //接入渠道方的秘钥
    private static final String SIGN_KEY = "A013F70DB97834C0A5492378BD76C53A";

    @Test
    public void refund() {
        request request = new request();
        request.setOrderId("70667215");
        request.setOrderCode("15178859237");
        request.setReason("买错票了");
        request.setResponsibility(0);
        request.setTimestamp("1517886820");
        getRefundSignMsg(request);
    }

    private void getRefundSignMsg(request request) {
        TreeMap<String, Object> params = Maps.newTreeMap();
        params.put("orderId", request.getOrderId());
        params.put("orderCode", request.getOrderCode());
        if (StringUtils.isNotBlank(request.getReason())) {
            params.put("reason", request.getReason());
        }
        params.put("responsibility", request.getResponsibility());
        params.put("timestamp", request.getTimestamp());
        StringBuilder str = new StringBuilder();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            if (null != entry.getValue()) {
                if (org.apache.commons.lang3.StringUtils.isNotBlank(entry.getValue().toString()))
                    str.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
        }
        str.append("key=").append(SIGN_KEY);
        System.out.println(str.toString());
        String sign = md5(str.toString(), "UTF-8").toLowerCase();
        System.out.println(sign);
    }

    private static String md5(String plainText, String encoding) {
        try {
            return DigestUtils.md5Hex(plainText.getBytes(encoding));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("不支持的编码", e);
        }
    }

}

class request {

    private String orderId;

    private String orderCode;

    private String reason;

    private Integer responsibility;

    private String timestamp;

    private String signMsg;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(Integer responsibility) {
        this.responsibility = responsibility;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSignMsg() {
        return signMsg;
    }

    public void setSignMsg(String signMsg) {
        this.signMsg = signMsg;
    }
}