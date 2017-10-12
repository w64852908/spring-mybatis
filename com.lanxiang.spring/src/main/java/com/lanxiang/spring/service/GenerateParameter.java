package com.lanxiang.spring.service;

import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by lanxiang on 2017/10/9.
 */
public class GenerateParameter {

    private static final Channel TEST_CHANNEL = new Channel(1000014, "A013F70DB97834C0A5492378BD76C53A");

    private static final Channel PROD_MY = new Channel(1000003, "");

    private static final Channel PROD_DFFLW = new Channel(1000007, "");

    private Channel using;

    @Before
    public void init() {
        using = TEST_CHANNEL;
    }

    @Test
    public void run() {
        TreeMap<String, Object> params = new TreeMap<>();
        params.put("api", "gateway.trade.lock");
        params.put("bizData", "{\n" +
                "    \"cinemaId\": 11,\n" +
                "    \"showId\": \"201710310000057\",\n" +
                "    \"seatsJSON\": {\n" +
                "        \"count\": \"1\",\n" +
                "        \"list\": [\n" +
                "            {\n" +
                "                \"sectionId\": \"0000000000000001\",\n" +
                "                \"seatNo\": \"18979276\",\n" +
                "                \"columnId\": \"01\",\n" +
                "                \"rowId\": \"4\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"orderCode\": \"691062026437013\",\n" +
                "    \"mobile\": \"13263297337\",\n" +
                "    \"settlePrice\": 3300,\n" +
                "    \"sellPrice\": 3300\n" +
                "}");
        params.put("merCode", using.getMerId());
        params.put("signType", "MD5");
        params.put("timestamp", "2690258952");
        params.put("version", "1.0");
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            if (null != entry.getValue()) {
                if (null != entry.getValue().toString() && !entry.getValue().toString().equals("")) {
                    sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
                }
            }
        }
        String s = sb.toString() + "key=" + using.getKey();
        System.out.println(s);
        String sign = DigestUtils.md5Hex(s).toUpperCase();
        System.out.println(sign);
    }
}

class Channel {

    private int merId;

    private String key;

    public Channel(int merId, String key) {
        this.merId = merId;
        this.key = key;
    }

    public int getMerId() {
        return merId;
    }

    public String getKey() {
        return key;
    }
}
