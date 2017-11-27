package com.lanxiang.spring.run;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lanxiang.spring.service.PerformanceService;
import com.lanxiang.spring.service.UserService;

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

    @Test
    public void run1() {
        UserService userService = context.getBean(UserService.class);
        System.out.println(userService.getUserList());
    }

    @Test
    public void run2() {
        PerformanceService service = context.getBean(PerformanceService.class);
        service.doSomething("hahahha");
    }

    @Test
    public void getRange() {
    }
}
