package com.lanxiang.alijson.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

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
    public void test2() {
        String info = "";
        Map<String, Object> infos = JSON.parseObject(info) == null ? new HashMap<String, Object>() : JSON.parseObject(info);
        infos.put("test", 233);
        System.out.println(infos);
    }

    @Test
    public void test3() {
        BigDecimal i = BigDecimal.TEN;
        System.out.println(i.intValue());
        i = i.negate();

        System.out.println(i);
    }

    @Test
    public void test4() {
        String empty = "";
        CinemaPo po = JSON.parseObject(empty, CinemaPo.class);
        System.out.println(JSON.toJSONString(po));
    }

    @Test
    public void test5() {
        String url = "http://baidu.com/%s";
        System.out.println(String.format(url, "lanxiang"));
    }

    @Test
    public void test6() {
        int fee = 3;
        float ratio = 0.33434f;
        System.out.println(fee * ratio);

        BigDecimal decimal = new BigDecimal(ratio);
        decimal = decimal.multiply(new BigDecimal(fee));
        System.out.println(decimal.floatValue());
    }

    @Test
    public void test7() {
        analysisList(Arrays.asList("lanxiang", "cool"));
    }

    private void analysisList(List<?> list) {
        for (int i = 0; i < list.size(); i++) {
            String str = (String) getGenericType(list, i);
            System.out.println(identity(list.get(i)));
        }
    }

    private <V> V getGenericType(List<V> list, int index) {
        return list.get(index);
    }

    private static <T> T identity(T arg) {
        return arg;
    }

    @Test
    public void test8() {
        int startId = 74716351;
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            set.add(startId);
            list.add(startId);
            startId++;
        }
        System.out.println(set);
        System.out.println(list);
    }

    @Test
    public void test9() {
        Set<Integer> set = Collections.singleton(1);
        System.out.println(set);
    }

    @Test
    public void test10() {
        String format = "yyyyMMdd";
        String sql = "delete from show%s where cinema_id = 11;";
        DateTime start = new DateTime(2018, 5, 8, 0, 0, 0);
        DateTime end = new DateTime(2018, 6, 6, 0, 0, 0);
        while (!start.isAfter(end)) {
            String date = start.toString(format);
            System.out.println(String.format(sql, date));
            start = start.plusDays(1);
        }
    }

    @Test
    public void test11() {
        String str = "[{\"startDate\":\"2018-05-11\",\"endDate\":\"2018-06-11\",\"startTime\":\"00:00:00\",\"endTime\":\"23:59:00\"}]";
        JSONArray jsonArray = JSON.parseArray(str);
        System.out.println(jsonArray.getJSONObject(0).getString("startDate"));
    }

    @Test
    public void test12() {
        String str = "2018-05-11 00:00:00";
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(formatter.parseDateTime(str));
    }

    @Test
    public void test13() {
        String str = "lan,xiang,233";
        List<String> list = Arrays.asList(str.split(","));
        System.out.println(list.contains("xiang"));
    }

    @Test
    public void test14() {
        TreeMap<Integer, Integer> map1 = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -1 * o1.compareTo(o2);
            }
        });

        map1.put(100, 233);
        map1.put(99, 234);
        map1.put(60, 235);

        System.out.println(map1);
    }

    @Test
    public void test15() throws Exception {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("lanjing02_movie_pluto_2018-06-08-15-08-48_sql1.csv");
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        int timeLength = String.valueOf(System.currentTimeMillis()).length();
        StringBuilder res = new StringBuilder(br.readLine()).append("\r\n");
        String content;
        while ((content = br.readLine()) != null) {
            String[] pieces = content.split(",");
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < pieces.length; i++) {
                if (pieces[i].length() == timeLength) {
                    try {
                        Long timestamp = Long.valueOf(pieces[i]);
                        String format = new DateTime(timestamp, DateTimeZone.forID("Asia/Shanghai")).toString("yyyyMMdd HH:mm:ss");
                        pieces[i] = format;
                    } catch (NumberFormatException e) {

                    }
                }

                temp.append(pieces[i]);
                if (i != pieces.length - 1) {
                    temp.append(",");
                }
            }
            res.append(temp).append("\r\n");
        }
        System.out.println(res.toString());
    }
}
