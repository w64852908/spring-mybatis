package com.lanxiang.alijson.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

/**
 * Created by lanxiang on 2017/10/30.
 */
public class CinemaCompare {

    private List<PartnerCinema> maoyanCinemas;

    private List<IntelliCinema> intelliCinemas;

    @Before
    public void init() throws Exception{
        initMaoyanCinemas();
        initIntelliCinemas();
    }

    private void initMaoyanCinemas() throws IOException{
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("partnerCinema.json");
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuilder jsonBuilder = new StringBuilder();
        String content;
        while ( (content = br.readLine()) != null){
            jsonBuilder.append(content);
        }
        maoyanCinemas = JSON.parseArray(jsonBuilder.toString(), PartnerCinema.class);
    }

    private void initIntelliCinemas() throws IOException {
        intelliCinemas = new ArrayList<>();
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("cinema_list-20171027.csv");

        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        int count = 0;

        String content;

        while ((content = br.readLine()) != null) {
            if (count++ == 0) {
                continue;
            }
            String[] params = content.split(",");
            int length = params.length;
            IntelliCinema cinema = new IntelliCinema();
            if (length >= 1) {
                cinema.setName(params[0]);
            }
            if (length >= 2) {
                cinema.setSpecialCode(params[1]);
            }
            if (length >= 4) {
                cinema.setSourceName(params[3]);
            }
            intelliCinemas.add(cinema);
        }
    }

    @Test
    public void compare(){
        Map<String, PartnerCinema> maoyanMap = new HashMap<>(maoyanCinemas.size());
        for (PartnerCinema partnerCinema : maoyanCinemas){
            maoyanMap.put(partnerCinema.getSpecialCapitalCinemaCode(), partnerCinema);
        }
        int count = 0;
        for (IntelliCinema cinema : intelliCinemas){
            String key = cinema.getSpecialCode();
            if (!maoyanMap.containsKey(key)){
                count++;
                System.out.println(cinema.getName() + "," + cinema.getSpecialCode()+"," + cinema.getSourceName());
            }
        }
        System.out.println(count);
    }
}
