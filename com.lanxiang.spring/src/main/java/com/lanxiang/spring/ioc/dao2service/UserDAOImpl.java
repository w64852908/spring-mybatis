package com.lanxiang.spring.ioc.dao2service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by lanjing on 2017/4/16.
 */
public class UserDAOImpl implements UserDAO {
    @Override
    public List<String> getUserNameList() {
        return Arrays.asList("lanxiang", "lishixuan", "pengzechengs");
    }
}
