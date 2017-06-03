package com.lanxiang.spring.ioc.dao2service;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by lanjing on 2017/4/16.
 */
public class UserServiceImpl implements UserService {

    public UserDAO userDAO;

    @Override
    public List<String> getUserNameList() {
        List<String> userNameList = userDAO.getUserNameList();
        List<String> result = new ArrayList<>(userNameList.size());
        for (String content : userNameList) {
            result.add(content + "/" + "handsome");
        }
        return result;
    }
}
