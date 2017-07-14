package com.lanxiang.alijson.feature;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by lanxiang on 2017/5/27.
 */
public class JSONObjectTest {

    @Test
    public void testToJsonString() {
        Map<String, String> param = new HashMap<>();
        param.put("name", "lanxiang");
        param.put("sex", "female");
        JSONObject jsonObject = new JSONObject();
        jsonObject.putAll(param);
        System.out.println(jsonObject.toString());
        System.out.println(jsonObject.toJSONString());
    }

    @Test
    public void testReplaceKV() {
        String userJson = "{\"name\":\"lanxiang\",\"uid\":1}";
        JSONObject jsonObject = JSONObject.parseObject(userJson);
        Map<String, Object> param = new HashMap<>();
        param.put("name", "lanjing");
        param.put("uid", 66666);
        jsonObject.putAll(param);
        System.out.println(jsonObject.toJSONString());
    }

    @Test
    public void testReference() {
        String userJson = "{\"name\":\"lanxiang\",\"uid\":1}";
        JSONObject jsonObject = JSONObject.parseObject(userJson);
        System.out.println(jsonObject.toJSONString());
        addAttribute(jsonObject);
        System.out.println(jsonObject.toJSONString());
    }

    private void addAttribute(JSONObject jsonObject) {
        jsonObject.put("handsome", "yes");
    }

    @Test
    public void testNullValue() {
        String str = null;
        JSONObject jsonObject = JSONObject.parseObject(str);
        System.out.println(jsonObject);
    }

    @Test
    public void testMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("ecardNo", "2333666");
        String jsonStr = JSON.toJSONString(map);
        System.out.println(jsonStr);
        System.out.println(JSON.parseObject(jsonStr).getString("ecardNo"));
    }

    @Test
    public void testMap2() {
        String s1 = "{\"specialCapitalShowId\":\"1920\"}";
        JSONObject jsonObject = JSONObject.parseObject(s1);
        System.out.println(jsonObject.getString("specialCapitalShowId"));
    }
}

class User {

    private String name;

    private int uid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
