package com.lanxiang.spring.ioc;

import com.lanxiang.spring.ioc.dao2service.UserDAO;
import com.lanxiang.spring.ioc.dao2service.UserDAOImpl;
import com.lanxiang.spring.ioc.dao2service.UserService;
import com.lanxiang.spring.ioc.dao2service.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * Created by lanjing on 2017/4/16.
 */
public class IOCTest {

    private Container container;

    @Before
    public void init() {
        container = Container.getInstance();
        UserDAO userDAO = new UserDAOImpl();
        UserService userService = new UserServiceImpl();
        container.put(userDAO.getClass(), userDAO);
        container.put(userService.getClass(), userService);
    }

    @Test
    public void run() throws IllegalAccessException {
        UserService userService = (UserService) container.get(UserServiceImpl.class);
        UserDAO userDAO = (UserDAO) container.get(UserDAOImpl.class);
        System.out.println(userDAO.getUserNameList());
        setUserDAO2UserService(userService, userDAO);
        System.out.println(userService.getUserNameList());
    }


    private void setUserDAO2UserService(UserService userService, UserDAO userDAO) throws IllegalAccessException {
        Class<?> clazz = userService.getClass();
        //获取UserServiceImpl的所有成员属性
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            //这里的field.getType()返回的是UserDAO的class,因此需要判断userDAO是不是实现了其接口
            if (field.getType().isAssignableFrom(userDAO.getClass())) {
                field.set(userService, userDAO);
            }
        }
    }
}
