package com.lanxiang.spring.service;

import com.lanxiang.spring.model.User;

import java.util.Date;
import java.util.List;

/**
 * Created by lanxiang on 2017/3/24.
 */
public interface UserService {

    String getName();

    Date getTime();

    List<User> getUserList();
}
