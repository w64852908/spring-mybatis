package com.lanxiang.alijson;

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
}
