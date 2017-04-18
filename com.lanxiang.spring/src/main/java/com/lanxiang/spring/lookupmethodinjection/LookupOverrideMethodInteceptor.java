package com.lanxiang.spring.lookupmethodinjection;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by lanxiang on 2017/4/14.
 */
public class LookupOverrideMethodInteceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if ("createCommand".equals(method.getName())) {
            return new AsyncCommand();
        }
        return methodProxy.invokeSuper(o, objects);
    }

    @Test
    public void run() {
        Enhancer en = new Enhancer();
        en.setSuperclass(CommandManager.class);
        en.setCallback(new LookupOverrideMethodInteceptor());

        CommandManager cm = (CommandManager) en.create();
        for (int i = 0; i < 5; i++) {
            cm.process();
        }
    }
}
