package com.lanxiang.mybatis.analysis.definemapper;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by lanxiang on 2017/3/25.
 */
public class MapperProxy implements InvocationHandler {

    @SuppressWarnings("unchecked")
    public <T> T newInstance(Class<T> clz) {
        return (T) Proxy.newProxyInstance(clz.getClassLoader(), new Class[]{clz}, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) {
            try {
                return method.invoke(this, args);
            } catch (Throwable t) {
            }
        }
        return new User((Integer) args[0], "lanxiang", 23);
    }

    @Test
    public void run() {
        MapperProxy proxy = new MapperProxy();
        UserMapper mapper = proxy.newInstance(UserMapper.class);
        User user = mapper.getUserById(1002);

        System.out.println(user);
        System.out.println(mapper.toString());
    }
}
