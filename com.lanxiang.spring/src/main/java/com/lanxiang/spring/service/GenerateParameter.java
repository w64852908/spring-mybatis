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

    private static final Channel TEST_CHANNEL = new Channel(1000014, "");

    private static final Channel TEST_INTELLI_CHANNEL = new Channel(1000015, "");


    private Channel using;

    @Before
    public void init() {
        using = TEST_CHANNEL;
    }

    @Test
    public void run() {
        TreeMap<String, Object> params = mmdbHotMovies();
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

    private TreeMap<String, Object> syncCinemas() {
        TreeMap<String, Object> params = new TreeMap<>();
        params.put("api", "gateway.sync.cinemas");
        params.put("merCode", using.getMerId());
        params.put("signType", "MD5");
        params.put("timestamp", "2690258952");
        params.put("version", "1.0");
        return params;
    }

    private TreeMap<String, Object> syncHalls() {
        TreeMap<String, Object> params = new TreeMap<>();
        params.put("api", "gateway.sync.halls");
        params.put("bizData", "{\"cinemaId\":2}");
        params.put("merCode", using.getMerId());
        params.put("signType", "MD5");
        params.put("timestamp", "2690258952");
        params.put("version", "1.0");
        return params;
    }

    private TreeMap<String, Object> syncSeats() {
        TreeMap<String, Object> params = new TreeMap<>();
        params.put("api", "gateway.sync.seats");
        params.put("bizData", "{\"cinemaId\":2,\"hallId\":281}");
        params.put("merCode", using.getMerId());
        params.put("signType", "MD5");
        params.put("timestamp", "2690258952");
        params.put("version", "1.0");
        return params;
    }

    private TreeMap<String, Object> dymaicSeats() {
        TreeMap<String, Object> params = new TreeMap<>();
        params.put("api", "gateway.trade.seat");
        params.put("bizData", "{\"showId\":\"201712210000057\"}");
        params.put("merCode", using.getMerId());
        params.put("signType", "MD5");
        params.put("timestamp", "2690258952");
        params.put("version", "1.0");
        return params;
    }

    private TreeMap<String, Object> lockSeat() {
        TreeMap<String, Object> params = new TreeMap<>();
        params.put("api", "gateway.trade.lock");
        params.put("bizData", "{\n" +
                "    \"sellPrice\": \"3300\",\n" +
                "    \"settlePrice\": \"3300\",\n" +
                "    \"cinemaId\": \"11\",\n" +
                "    \"orderCode\": \"MHIGUTEST001\",\n" +
                "    \"showId\": \"201712210000057\",\n" +
                "    \"mobile\": \"13166067065\",\n" +
                "    \"seatsJSON\": \"{\\\"count\\\":\\\"1\\\",\\\"list\\\":[{\\\"sectionId\\\":\\\"0000000000000001\\\",\\\"seatNo\\\":\\\"20585200\\\",\\\"rowId\\\":\\\"1\\\",\\\"columnId\\\":\\\"05\\\"}]}\"\n" +
                "}");
        params.put("merCode", using.getMerId());
        params.put("signType", "MD5");
        params.put("timestamp", "2690258952");
        params.put("version", "1.0");
        return params;
    }

    private TreeMap<String, Object> fixOrder() {
        TreeMap<String, Object> params = new TreeMap<>();
        params.put("api", "gateway.trade.fixOrder");
        params.put("bizData", "{\"orderId\":4437473,\"orderCode\":\"DD-1031-CA271DCD7566E28689D9D119\"}");
        params.put("merCode", using.getMerId());
        params.put("signType", "MD5");
        params.put("timestamp", "2690258952");
        params.put("version", "1.0");
        return params;
    }

    private TreeMap<String, Object> queryOrder() {
        TreeMap<String, Object> params = new TreeMap<>();
        params.put("api", "gateway.trade.queryOrder");
        params.put("bizData", "{\"orderId\":4437473}");
        params.put("merCode", using.getMerId());
        params.put("signType", "MD5");
        params.put("timestamp", "2690258952");
        params.put("version", "1.0");
        return params;
    }

    private TreeMap<String, Object> intelliCinemas() {
        TreeMap<String, Object> params = new TreeMap<>();
        params.put("api", "intelli.sync.cinemas");
        params.put("merCode", using.getMerId());
        params.put("signType", "MD5");
        params.put("timestamp", "2690258952");
        params.put("version", "1.0");
        return params;
    }

    private TreeMap<String, Object> intelliHalls() {
        TreeMap<String, Object> params = new TreeMap<>();
        params.put("api", "intelli.sync.halls");
        params.put("bizData", "{\"cinemaId\":\"16588\"}");
        params.put("merCode", using.getMerId());
        params.put("signType", "MD5");
        params.put("timestamp", "2690258952");
        params.put("version", "1.0");
        return params;
    }

    private TreeMap<String, Object> intelliSeats() {
        TreeMap<String, Object> params = new TreeMap<>();
        params.put("api", "intelli.sync.seats");
        params.put("bizData", "{\"cinemaId\":\"16588\",\"hallId\":\"0000000000000001\"}");
        params.put("merCode", using.getMerId());
        params.put("signType", "MD5");
        params.put("timestamp", "2690258952");
        params.put("version", "1.0");
        return params;
    }

    private TreeMap<String, Object> intelliShow() {
        TreeMap<String, Object> params = new TreeMap<>();
        params.put("api", "intelli.sync.show");
        params.put("bizData", "{\"cinemaId\":\"2507\",\"startDate\":\"2017-11-14\",\"endDate\":\"2017-11-15\"}");
        params.put("merCode", using.getMerId());
        params.put("signType", "MD5");
        params.put("timestamp", "2690258952");
        params.put("version", "1.0");
        return params;
    }

    private TreeMap<String, Object> intelliLockSeat() {
        TreeMap<String, Object> params = new TreeMap<>();
        params.put("api", "intelli.lock.seat");
        params.put("bizData", "{\n" +
                "    \"orderId\": \"17112211504048152\",\n" +
                "    \"showUniqueSeqNo\": \"201711146\",\n" +
                "    \"mobilePhone\": \"18618185437\",\n" +
                "    \"totalMoney\": 7800,\n" +
                "    \"originalTicketMoney\": 7800,\n" +
                "    \"seatModelList\": [\n" +
                "        {\n" +
                "            \"seatCode\": \"0000000000001849\",\n" +
                "            \"seatNumber\": \"A:1\",\n" +
                "            \"sectionId\": \"1\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"seatCode\": \"0000000000001850\",\n" +
                "            \"seatNumber\": \"A:2\",\n" +
                "            \"sectionId\": \"1\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"sourceId\": \"201711146\"\n" +
                "}");
        params.put("merCode", using.getMerId());
        params.put("signType", "MD5");
        params.put("timestamp", "2690258952");
        params.put("version", "1.0");
        return params;
    }

    private TreeMap<String, Object> mmdbMovieInfo() {
        TreeMap<String, Object> params = new TreeMap<>();
        params.put("api", "mmdb.movieInfo");
        params.put("bizData", "{\"movieId\":\"1190680\"}");
        params.put("merCode", using.getMerId());
        params.put("signType", "MD5");
        params.put("timestamp", "2690258952");
        params.put("version", "1.0");
        return params;
    }

    private TreeMap<String, Object> mmdbHotMovies() {
        TreeMap<String, Object> params = new TreeMap<>();
        params.put("api", "mmdb.hotMovies");
        params.put("bizData", "{\"cityId\":\"55\"}");
        params.put("merCode", using.getMerId());
        params.put("signType", "MD5");
        params.put("timestamp", "2690258952");
        params.put("version", "1.0");
        return params;
    }


    private TreeMap<String, Object> cmMovieInfo() {
        TreeMap<String, Object> params = new TreeMap<>();
        params.put("api", "cmdata.movieInfo");
        params.put("bizData", "{\"movieId\":11}");
        params.put("merCode", using.getMerId());
        params.put("signType", "MD5");
        params.put("timestamp", "2690258952");
        params.put("version", "1.0");
        return params;
    }

    private TreeMap<String, Object> cityList() {
        TreeMap<String, Object> params = new TreeMap<>();
        params.put("api", "base.city");
        params.put("merCode", using.getMerId());
        params.put("signType", "MD5");
        params.put("timestamp", "2690258952");
        params.put("version", "1.0");
        return params;
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
