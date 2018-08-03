package com.lanxiang.alijson;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by lanxiang on 2017/8/4.
 */
public class SpeedTest {

    private static final String orderJson = "{\"beginTime\":1501833463540,\"channelId\":1,\"cinemaId\":980,\"createDate\":0,\"createTime\":0,\"endTime\":1501833463596,\"ip\":168048330,\"mobile\":\"18630829418\",\"movieId\":344264,\"orderId\":1416299121,\"outCinemaId\":\"12130901\",\"outMovieId\":\"001204512017\",\"outOrderId\":\"20170804155703893380244398952448\",\"outShowId\":\"25458\",\"request\":\"POST http://tspapi.dadicinema.com:8000/trade/confirmorder?callbackUrl=callbackUrl&seatDetail=%5B%7B%22priceId%22%3A%222774%22%2C%22seatCode%22%3A%2212130901%2305%2305%22%2C%22serviceFee%22%3A200%2C%22ticketMoney%22%3A3400%7D%2C%7B%22priceId%22%3A%222774%22%2C%22seatCode%22%3A%2212130901%2305%2304%22%2C%22serviceFee%22%3A200%2C%22ticketMoney%22%3A3400%7D%5D&orderId=20170804155703893380244398952448 HTTP/1.1\",\"response\":\"{\\\"data\\\":\\\"OK\\\"}\",\"serverFlag\":0,\"showDate\":20170804,\"showId\":102668,\"source\":40,\"type\":\"FIX_ORDER\",\"userId\":0}";

    private static final int transTime = 5000000;

    @Test
    public void run() {

//        transToJSONObject();
//        transToObject();
        long a = 10000000L;
        trans(a);
    }

    private void transToJSONObject() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < transTime; i++) {
            JSONObject jsonObject = JSON.parseObject(orderJson);
        }
        long end = System.currentTimeMillis();
        System.out.println("transToJSONObject : " + (end - start));

    }

    private void transToObject() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < transTime; i++) {
            Order order = JSON.parseObject(orderJson, Order.class);
        }
        long end = System.currentTimeMillis();
        System.out.println("transToObject : " + (end - start));
    }

    private void trans(double a) {
        System.out.println(a);
        System.out.println((long) a);
    }




    static class Order {


        public int source; // required
        public int serverFlag; // required
        public int userId; // required
        public String mobile; // required
        public int cinemaId; // required
        public int movieId; // required
        public int showDate; // required
        public int showId; // required
        public int orderId; // required
        public String outCinemaId; // required
        public String outMovieId; // required
        public String outShowId; // required
        public String outOrderId; // required
        public String request; // required
        public String response; // required
        public long createDate; // required
        public long createTime; // required
        public int ip; // required
        public long beginTime; // required
        public long endTime; // required
        public int channelId; // required

        public long getBeginTime() {
            return beginTime;
        }

        public void setBeginTime(long beginTime) {
            this.beginTime = beginTime;
        }

        public int getChannelId() {
            return channelId;
        }

        public void setChannelId(int channelId) {
            this.channelId = channelId;
        }

        public int getCinemaId() {
            return cinemaId;
        }

        public void setCinemaId(int cinemaId) {
            this.cinemaId = cinemaId;
        }

        public long getCreateDate() {
            return createDate;
        }

        public void setCreateDate(long createDate) {
            this.createDate = createDate;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public long getEndTime() {
            return endTime;
        }

        public void setEndTime(long endTime) {
            this.endTime = endTime;
        }

        public int getIp() {
            return ip;
        }

        public void setIp(int ip) {
            this.ip = ip;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public int getMovieId() {
            return movieId;
        }

        public void setMovieId(int movieId) {
            this.movieId = movieId;
        }

        public int getOrderId() {
            return orderId;
        }

        public void setOrderId(int orderId) {
            this.orderId = orderId;
        }

        public String getOutCinemaId() {
            return outCinemaId;
        }

        public void setOutCinemaId(String outCinemaId) {
            this.outCinemaId = outCinemaId;
        }

        public String getOutMovieId() {
            return outMovieId;
        }

        public void setOutMovieId(String outMovieId) {
            this.outMovieId = outMovieId;
        }

        public String getOutOrderId() {
            return outOrderId;
        }

        public void setOutOrderId(String outOrderId) {
            this.outOrderId = outOrderId;
        }

        public String getOutShowId() {
            return outShowId;
        }

        public void setOutShowId(String outShowId) {
            this.outShowId = outShowId;
        }

        public String getRequest() {
            return request;
        }

        public void setRequest(String request) {
            this.request = request;
        }

        public String getResponse() {
            return response;
        }

        public void setResponse(String response) {
            this.response = response;
        }

        public int getServerFlag() {
            return serverFlag;
        }

        public void setServerFlag(int serverFlag) {
            this.serverFlag = serverFlag;
        }

        public int getShowDate() {
            return showDate;
        }

        public void setShowDate(int showDate) {
            this.showDate = showDate;
        }

        public int getShowId() {
            return showId;
        }

        public void setShowId(int showId) {
            this.showId = showId;
        }

        public int getSource() {
            return source;
        }

        public void setSource(int source) {
            this.source = source;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }
    }
}
