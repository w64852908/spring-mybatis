package com.lanxiang.spring.ioc;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lanjing on 2017/4/16.
 */
public class Container {

    //双重检查来实现单例
    private volatile static Container instance;

    //保存类的class和其对象的map(本来是应该由工厂来newInstance(),这里直接new好所有的类)
    private Map<Class<?>, Object> instanceMap;

    private Container() {
        instanceMap = new HashMap<>();
    }

    public static Container getInstance() {
        if (instance == null) {
            synchronized (Container.class) {
                if (instance == null) {
                    instance = new Container();
                }
            }
        }
        return instance;
    }

    public void put(Class<?> key, Object value) {
        instanceMap.put(key, value);
    }

    public Object get(Class<?> key) {
        return instanceMap.get(key);
    }
}
