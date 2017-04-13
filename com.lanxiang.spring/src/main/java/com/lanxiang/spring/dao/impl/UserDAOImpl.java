package com.lanxiang.spring.dao.impl;

import com.lanxiang.spring.dao.UserDAO;
import com.lanxiang.spring.model.User;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

/**
 * Created by lanxiang on 2017/4/13.
 */

@Repository
public class UserDAOImpl implements UserDAO {

    @Override
    public List<User> getUserList() {
        User user1 = new User(1, "lanxiang", 1);
        User user2 = new User(2, "liju", 2);
        User user3 = new User(3, "bamei", 3);
        return Arrays.asList(user1, user2, user3);
    }
}