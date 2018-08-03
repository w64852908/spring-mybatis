package com.lanxiang.alijson.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

/**
 * Created by lanxiang on 2018/3/28.
 */
public class Jinyi {


    private String checkJSON;

    @Before
    public void init() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("/Users/lanxiang/Documents/work/IdeaProject/spring-mybatis/com.lanxiang.alijson/src/main/resources/jinyi.json"));
        checkJSON = br.readLine();
    }

    @Test
    public void test1() {
        List<JinyiCheck> checkList = JSON.parseArray(checkJSON, JinyiCheck.class);
        System.out.println("orderId,expireDate");
        for (JinyiCheck check : checkList) {
            System.out.println(check.getFirstCardOrderId() + "," + check.getRightExpireDate());
        }
    }

    @Test
    public void test2() {
        DateTime dateTime = new DateTime(1530843530000L);
        System.out.println(dateTime.toString("yyyyMMdd hh:MM:ss"));
    }

    @Test
    public void test3() {
        DateTime dateTime = new DateTime(2018, 1, 7, 10, 18, 50);
        dateTime = dateTime.plusDays(180);
        System.out.println(dateTime.toString("yyyyMMdd hh:MM:ss"));
    }
}
