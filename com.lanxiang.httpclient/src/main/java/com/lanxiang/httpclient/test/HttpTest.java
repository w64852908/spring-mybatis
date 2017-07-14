package com.lanxiang.httpclient.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.lanxiang.httpclient.utils.HTTPHelper;
import com.lanxiang.httpclient.utils.IHTTPResponse;

/**
 * Created by lanxiang on 2017/6/20.
 */
public class HttpTest {

    private HTTPHelper helper = new HTTPHelper();


    @Test
    public void test1() {
        String url = "http://0.0.0.0:8082/admin/channels/1000015/switch";
        Map<String, Object> param = new HashMap<>();
        param.put("option", 1);
        IHTTPResponse response = helper.putJson(url, param);
        Assert.assertTrue(response != null);
        String meg = response.getResponseAsString();
        System.out.println(meg);
    }
}
