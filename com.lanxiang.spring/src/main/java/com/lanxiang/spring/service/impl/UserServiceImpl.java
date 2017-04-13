package com.lanxiang.spring.service.impl;

import com.lanxiang.spring.dao.UserDAO;
import com.lanxiang.spring.model.User;
import com.lanxiang.spring.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by lanxiang on 2017/3/24.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDAO userDAO;

    @Override
    public String getName() {
        return "lanxiang learn spring";
    }

    @Override
    public Date getTime() {
        return new Date();
    }

    @Override
    public List<User> getUserList() {
        return userDAO.getUserList();
    }
}
