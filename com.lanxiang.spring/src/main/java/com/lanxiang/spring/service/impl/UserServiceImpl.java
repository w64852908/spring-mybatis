package com.lanxiang.spring.service.impl;

import com.lanxiang.spring.service.UserService;

import java.util.Date;

/**
 * Created by lanxiang on 2017/3/24.
 */
public class UserServiceImpl implements UserService {
    @Override
    public String getName() {
        return "lanxiang learn spring";
    }

    @Override
    public Date getTime() {
        return new Date();
    }
}
