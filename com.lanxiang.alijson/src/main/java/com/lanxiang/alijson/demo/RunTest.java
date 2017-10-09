package com.lanxiang.alijson.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

/**
 * Created by lanxiang on 2017/5/17.
 */
public class RunTest {

    private static final String filePath = "/Users/lanxiang/Desktop/cinema.json";

    @Test
    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        StringBuilder content = new StringBuilder();
        String temp;
        while ((temp = br.readLine()) != null) {
            if (temp.contains("None")) {
                continue;
            }
            content.append(temp);
        }

        List<CinemaPo> cinemaPos = JSON.parseArray(content.toString(), CinemaPo.class);
        for (CinemaPo po : cinemaPos) {
            if (po.getCinemaId() == null) {
                continue;
            }
            System.out.print(po.getCinemaId() + ",");
        }
    }

    @Test
    public void test2(){
        String info = "";
        Map<String, Object> infos = JSON.parseObject(info) == null ?new HashMap<String, Object>() : JSON.parseObject(info);
        infos.put("test",233);
        System.out.println(infos);
    }

    @Test
    public void test3(){
        BigDecimal i = BigDecimal.TEN;
        System.out.println(i.intValue());
        i = i.negate();

        System.out.println(i);
    }
}
