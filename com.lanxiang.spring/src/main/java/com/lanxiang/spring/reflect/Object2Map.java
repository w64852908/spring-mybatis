package com.lanxiang.spring.reflect;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by lanxiang on 2017/11/29.
 */
public class Object2Map {

    @Test
    public void test1() throws Exception {
        User user = new User();
        user.setName("lanxiang");
        user.setAge(18);
        Address address = new Address();
        user.setAddress(address);
        address.setCity("chengdu");
        address.setProvince("sichuan");

        Map<String, Object> map = Obj2Map(user);

        System.out.println(JSON.toJSONString(map));
    }

    private Map<String, Object> Obj2Map(Object obj) throws Exception {
        Map<String, Object> map = new HashMap<>();
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String key = field.getName();
            Object value = field.get(obj);
            if (null == key || key.equals("") || null == value) {
                continue;
            }
            System.out.println(field.getGenericType());
            map.put(field.getName(), field.get(obj));
        }
        return map;
    }

    private void recursivePutAll() {

    }

    @Test
    public void test2() throws Exception {
        User user = new User();
        user.setName("lanxiang");
        Address address = new Address();
        user.setAddress(address);
        address.setProvince("sichuan");
        JSONObject userJson = JSON.parseObject(JSON.toJSONString(user));
        System.out.println(userJson);

        User addUser = new User();
        addUser.setAge(18);
        Address addAddress = new Address();
        addUser.setAddress(addAddress);
        addAddress.setCity("chengdu");
        userJson.putAll(Obj2Map(addUser));
        System.out.println(userJson);
    }

    @Test
    public void test3() throws Exception {
        User user = new User();
        user.setName("lanxiang");
        Address address = new Address();
        user.setAddress(address);
        address.setProvince("sichuan");
        JSONObject userJson = JSON.parseObject(JSON.toJSONString(user));
        System.out.println(userJson);

        User addUser = new User();
        addUser.setAge(18);
        Address addAddress = new Address();
        addUser.setAddress(addAddress);
        addAddress.setCity("chengdu");
        userJson.putAll(JSON.parseObject(JSON.toJSONString(addUser)));
        System.out.println(userJson);
    }
}
