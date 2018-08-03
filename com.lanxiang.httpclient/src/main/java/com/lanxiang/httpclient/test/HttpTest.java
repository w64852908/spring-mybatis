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

    @Test
    public void test2() {
        String url = "http://localhost:8080/api/test/b";
        IHTTPResponse response = helper.postJSON(url, "{\"name\":\"lanxiang\",\"age\":24}");
        System.out.println(response.getResponseAsString());
    }
}
