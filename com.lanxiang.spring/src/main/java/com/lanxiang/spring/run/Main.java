package com.lanxiang.spring.run;

import com.lanxiang.spring.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lanxiang on 2017/3/24.
 */
public class Main {

    private ApplicationContext context;

    @Before
    public void init() {
        context = new ClassPathXmlApplicationContext("spring-context.xml");
    }

    @Test
    public void run() {
        UserService userService = context.getBean(UserService.class);
        System.out.println(userService.getName());
        System.out.println(userService.getTime());
    }
}
