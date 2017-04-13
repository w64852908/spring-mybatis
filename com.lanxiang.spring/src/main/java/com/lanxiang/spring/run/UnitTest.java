package com.lanxiang.spring.run;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lanxiang.spring.model.User;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by lanxiang on 2017/4/13.
 */
public class UnitTest {

    private ObjectMapper objectMapper;

    @Before
    public void init() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void run() throws IOException {
        String userStr = "{\"name\":\"lanxiang\"}";
        System.out.println(objectMapper.readValue(userStr, User.class));
    }
}
