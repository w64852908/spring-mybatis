package com.lanxiang.alijson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by lanxiang on 2017/11/14.
 */
public class Test1905 {

    private String seatJson = "{\"time\":1510628186,\"errno\":0,\"error\":\"\",\"data\":[{\"seat_no\":\"48834\",\"session_seat_no\":0,\"seat_row\":\"2\",\"seat_col\":\"7\",\"group_no\":\"151\",\"seat_status\":0},{\"seat_no\":\"48836\",\"session_seat_no\":0,\"seat_row\":\"3\",\"seat_col\":\"2\",\"group_no\":\"151\",\"seat_status\":0},{\"seat_no\":\"48837\",\"session_seat_no\":0,\"seat_row\":\"3\",\"seat_col\":\"3\",\"group_no\":\"151\",\"seat_status\":0},{\"seat_no\":\"48833\",\"session_seat_no\":0,\"seat_row\":\"2\",\"seat_col\":\"6\",\"group_no\":\"151\",\"seat_status\":0},{\"seat_no\":\"48835\",\"session_seat_no\":0,\"seat_row\":\"3\",\"seat_col\":\"1\",\"group_no\":\"151\",\"seat_status\":0},{\"seat_no\":\"48823\",\"session_seat_no\":0,\"seat_row\":\"1\",\"seat_col\":\"3\",\"group_no\":\"151\",\"seat_status\":0},{\"seat_no\":\"48844\",\"session_seat_no\":0,\"seat_row\":\"4\",\"seat_col\":\"5\",\"group_no\":\"151\",\"seat_status\":0},{\"seat_no\":\"48843\",\"session_seat_no\":0,\"seat_row\":\"4\",\"seat_col\":\"4\",\"group_no\":\"151\",\"seat_status\":0},{\"seat_no\":\"48821\",\"session_seat_no\":0,\"seat_row\":\"1\",\"seat_col\":\"1\",\"group_no\":\"151\",\"seat_status\":0},{\"seat_no\":\"48831\",\"session_seat_no\":0,\"seat_row\":\"2\",\"seat_col\":\"4\",\"group_no\":\"151\",\"seat_status\":0},{\"seat_no\":\"48841\",\"session_seat_no\":0,\"seat_row\":\"4\",\"seat_col\":\"2\",\"group_no\":\"151\",\"seat_status\":0},{\"seat_no\":\"48830\",\"session_seat_no\":0,\"seat_row\":\"2\",\"seat_col\":\"3\",\"group_no\":\"151\",\"seat_status\":0},{\"seat_no\":\"48822\",\"session_seat_no\":0,\"seat_row\":\"1\",\"seat_col\":\"2\",\"group_no\":\"151\",\"seat_status\":0},{\"seat_no\":\"48832\",\"session_seat_no\":0,\"seat_row\":\"2\",\"seat_col\":\"5\",\"group_no\":\"151\",\"seat_status\":0},{\"seat_no\":\"48845\",\"session_seat_no\":0,\"seat_row\":\"5\",\"seat_col\":\"1\",\"group_no\":\"151\",\"seat_status\":0},{\"seat_no\":\"48850\",\"session_seat_no\":0,\"seat_row\":\"5\",\"seat_col\":\"6\",\"group_no\":\"151\",\"seat_status\":0},{\"seat_no\":\"48824\",\"session_seat_no\":0,\"seat_row\":\"1\",\"seat_col\":\"4\",\"group_no\":\"151\",\"seat_status\":0},{\"seat_no\":\"48840\",\"session_seat_no\":0,\"seat_row\":\"4\",\"seat_col\":\"1\",\"group_no\":\"151\",\"seat_status\":0},{\"seat_no\":\"48847\",\"session_seat_no\":0,\"seat_row\":\"5\",\"seat_col\":\"3\",\"group_no\":\"151\",\"seat_status\":0},{\"seat_no\":\"48828\",\"session_seat_no\":0,\"seat_row\":\"2\",\"seat_col\":\"1\",\"group_no\":\"151\",\"seat_status\":0},{\"seat_no\":\"48827\",\"session_seat_no\":0,\"seat_row\":\"1\",\"seat_col\":\"7\",\"group_no\":\"151\",\"seat_status\":0},{\"seat_no\":\"48825\",\"session_seat_no\":0,\"seat_row\":\"1\",\"seat_col\":\"5\",\"group_no\":\"151\",\"seat_status\":0},{\"seat_no\":\"48842\",\"session_seat_no\":0,\"seat_row\":\"4\",\"seat_col\":\"3\",\"group_no\":\"151\",\"seat_status\":0},{\"seat_no\":\"48849\",\"session_seat_no\":0,\"seat_row\":\"5\",\"seat_col\":\"5\",\"group_no\":\"151\",\"seat_status\":0},{\"seat_no\":\"48839\",\"session_seat_no\":0,\"seat_row\":\"3\",\"seat_col\":\"5\",\"group_no\":\"151\",\"seat_status\":0},{\"seat_no\":\"48826\",\"session_seat_no\":0,\"seat_row\":\"1\",\"seat_col\":\"6\",\"group_no\":\"151\",\"seat_status\":0},{\"seat_no\":\"48838\",\"session_seat_no\":0,\"seat_row\":\"3\",\"seat_col\":\"4\",\"group_no\":\"151\",\"seat_status\":0},{\"seat_no\":\"48846\",\"session_seat_no\":0,\"seat_row\":\"5\",\"seat_col\":\"2\",\"group_no\":\"151\",\"seat_status\":0},{\"seat_no\":\"48848\",\"session_seat_no\":0,\"seat_row\":\"5\",\"seat_col\":\"4\",\"group_no\":\"151\",\"seat_status\":0},{\"seat_no\":\"48829\",\"session_seat_no\":0,\"seat_row\":\"2\",\"seat_col\":\"2\",\"group_no\":\"151\",\"seat_status\":0}]}";

    @Test
    public void trans() {
        JSONArray jsonArray = JSON.parseArray(JSON.parseObject(seatJson).getString("data"));
        JSONObject seatJSON = jsonArray.getJSONObject(0);
        System.out.println(seatJSON.toJSONString());
    }

    @Test
    public void testFormat() {
        String url = "/RESTData.svc/cinemas/%s/sessions/%s/tickets";

        System.out.println(String.format(url, "lan", "xiang"));
    }

    @Test
    public void testTrans() {
        String str1 = "{\n" +
                "    \"ticket_type\": 3,\n" +
                "    \"preferential_activity_id\": 0,\n" +
                "    \"show_time\": 1466940000000,\n" +
                "    \"fix_status\": 0,\n" +
                "    \"fee_money\": 6,\n" +
                "    \"ticket_money\": 110,\n" +
                "    \"client_type\": 2,\n" +
                "    \"order_time\": 1466936400000,\n" +
                "    \"movie_id\": 246333,\n" +
                "    \"pay_money\": 116,\n" +
                "    \"pay_status\": 0,\n" +
                "    \"mobile_phone\": \"13917869482\",\n" +
                "    \"modified\": 1466936441000,\n" +
                "    \"id\": 624186592,\n" +
                "    \"seat_num\": 2,\n" +
                "    \"lock_status\": 1,\n" +
                "    \"refund_status\": 0,\n" +
                "    \"show_id\": 4337,\n" +
                "    \"version\": 0,\n" +
                "    \"print_tags\": \"N|N\",\n" +
                "    \"cinema_id\": 12,\n" +
                "    \"user_id\": 304060029,\n" +
                "    \"dp_user_id\": 0,\n" +
                "    \"order_source\": 1,\n" +
                "    \"total_money\": 116,\n" +
                "    \"sell_source\": 38,\n" +
                "    \"status\": 1,\n" +
                "    \"exchange_status\": 0\n" +
                "}";
        String str2 = "{\n" +
                "        \"fees\": \"3.0|3.0\",\n" +
                "        \"releaseTime\": 15,\n" +
                "        \"lockSeatPriceType\": 0,\n" +
                "        \"outCinemaId\": \"371\",\n" +
                "        \"language\": \"英语\",\n" +
                "        \"seats\": \"4:8|4:9\",\n" +
                "        \"showDate\": \"2016-06-26\",\n" +
                "        \"originalTicketMoney\": 110,\n" +
                "        \"sectionName\": \"默认场区\",\n" +
                "        \"normalSellMoney\": 116,\n" +
                "        \"lockTime\": \"2016-06-26 18:20:00\",\n" +
                "        \"normalFees\": \"3.0|3.0\",\n" +
                "        \"cinemaName\": \"万达电影城(江桥店)\",\n" +
                "        \"canUseCodeTags\": \"3|3\",\n" +
                "        \"poiId\": 1219965,\n" +
                "        \"prices\": \"55.0|55.0\",\n" +
                "        \"movieName\": \"惊天魔盗团2\",\n" +
                "        \"showSeqNo\": \"201606260004337\",\n" +
                "        \"outShowId\": \"69329\",\n" +
                "        \"sendpay\": \"0001000000000000000000000000000000000000000000000000000000000000\",\n" +
                "        \"voucherLimit\": 1,\n" +
                "        \"priceType\": 0,\n" +
                "        \"sectionId\": \"01\",\n" +
                "        \"userName\": \"洋洋是个小胖纸\",\n" +
                "        \"durationInMins\": 126,\n" +
                "        \"seatTypes\": \"N|N\",\n" +
                "        \"hallId\": \"6\",\n" +
                "        \"lockSeatOriginalTicketMoney\": 110,\n" +
                "        \"refundProgress\": 0,\n" +
                "        \"originalId\": \"20160626182010014113\",\n" +
                "        \"hallName\": \"6号厅\",\n" +
                "        \"seatsNo\": \"8,18|8,17\",\n" +
                "        \"outMovieId\": \"20160513105313384785\",\n" +
                "        \"ticketId\": \"网购票\"\n" +
                "    }";
        String requestStr = "status\n" +
                "user_id\n" +
                "cinema_name\n" +
                "cinema_id\n" +
                "bd_name\n" +
                "total_money\n" +
                "ticket_money\n" +
                "show_time\n" +
                "show_id\n" +
                "sell_source\n" +
                "seat_num\n" +
                "refund_time\n" +
                "refund_status\n" +
                "preferential_activity_id\n" +
                "pay_time\n" +
                "pay_status\n" +
                "pay_money\n" +
                "order_time\n" +
                "movie_id\n" +
                "mobile_phone\n" +
                "is_real_new\n" +
                "is_new\n" +
                "info_j\n" +
                "fix_time\n" +
                "fix_status\n" +
                "fee_money\n" +
                "exchange_status\n" +
                "client_type\n" +
                "modified\n" +
                "real_status";
        JSONObject json1 = JSON.parseObject(str1);
        JSONObject json2 = JSON.parseObject(str2);

        Set<String> orderKeySet = new HashSet<>();

        orderKeySet.addAll(json1.keySet());
//        orderKeySet.addAll(json2.keySet());

        Set<String> requestSet = new HashSet<>();
        requestSet.addAll(Arrays.asList(requestStr.split("\n")));

        for (String str : requestSet) {
            System.out.print(str + ",");
        }


//        for (String request : requestSet) {
//            if (orderKeySet.contains(request)) {
//                continue;
//            }
//            boolean isCaseMatched = false;
//            for (String orderKey : orderKeySet) {
//                if (request.equalsIgnoreCase(orderKey)) {
//                    isCaseMatched = true;
//                }
//            }
//            if (!isCaseMatched) {
//                System.out.println("miss : " + request);
//            }
//        }
    }

    @Test
    public void test10() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("map.txt")));

        String mapJson = br.readLine();

        JSONObject jsonObject = JSON.parseObject(mapJson);

        System.out.println(jsonObject);
    }

    @Test
    public void test11() {
        String title = "【重要】微信&猫眼 1分钱扫码活动“%s”小程序码发放通知";
        System.out.println(String.format(title,"金逸影城(荟聚IMAX店)"));
    }
}
