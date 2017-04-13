package com.lanxiang.spring.dao;

import com.lanxiang.spring.model.User;

import java.util.List;

/**
 * Created by lanxiang on 2017/4/13.
 */
public interface UserDAO {

    List<User> getUserList();
}
