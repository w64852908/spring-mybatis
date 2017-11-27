package com.lanxiang.spring.run;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Test;

/**
 * Created by lanxiang on 2017/10/24.
 */
public class ResourceTest {

    @Test
    public void test() throws Exception {

        System.out.println(this.getClass().getClassLoader().getResource("hz-orderId.txt").getPath());
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("hz-orderId.txt");

        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        String content;

        while ((content = br.readLine()) !=null){
            System.out.println(content);
        }

    }

}
