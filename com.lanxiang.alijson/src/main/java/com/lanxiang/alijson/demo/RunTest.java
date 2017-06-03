package com.lanxiang.alijson.demo;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

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
}
