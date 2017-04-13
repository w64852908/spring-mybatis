package com.lanxiang.spring.service.impl;

import com.lanxiang.spring.aop.PerformanceLog;
import com.lanxiang.spring.service.PerformanceService;
import org.springframework.stereotype.Service;

/**
 * Created by lanxiang on 2017/4/13.
 */


@Service
public class PerformanceServiceImpl implements PerformanceService {

    @Override
    @PerformanceLog(name = "lanxiang", age = 23)
    public void doSomething(String thing) {
        System.out.println("do some" + thing);
    }
}
