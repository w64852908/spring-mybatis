package com.lanxiang.spring.run;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by lanxiang on 2017/10/20.
 */
public class OceanFix {

    private List<String> filePaths;

    @Before
    public void init() {
        filePaths = Arrays.asList("hz-orderId.txt", "sz-orderId.txt", "xian-orderId.txt");
    }

    @Test
    public void run() throws Exception {

        StringBuilder sb = new StringBuilder();
        for (String filePath : filePaths) {
            File file = new File("/Users/lanxiang/Documents/work/IdeaProject/spring-mybatis/com.lanxiang.spring/src/main/resources/" + filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append(",");
            }
        }
        List<String> orderIds = new ArrayList<>();
        orderIds.addAll(Arrays.asList(sb.toString().split(",")));
        System.out.println(orderIds.size());

        int counter = 0;
        StringBuilder inList = new StringBuilder();
        for (String orderId : orderIds) {
            inList.append("\'").append(orderId).append("\'").append(",");
            if (++counter % 200 == 0) {
                System.out.println("delete from gateway_card_order where channel_card_order_id in (" + inList.toString() + ")");
                inList = new StringBuilder();
            }
        }
        System.out.println("delete from gateway_card_order where channel_card_order_id in (" + inList.toString() + ")");
        System.out.println(counter);
    }

}
