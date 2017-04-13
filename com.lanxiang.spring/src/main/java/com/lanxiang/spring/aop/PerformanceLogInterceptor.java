package com.lanxiang.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by lanxiang on 2017/4/13.
 */

@Aspect
@Component
public class PerformanceLogInterceptor {

    @Pointcut("@annotation(com.lanxiang.spring.aop.PerformanceLog)")
    private void logMethod() {

    }

    @Before("logMethod()")
    public void doMethod(JoinPoint joinPoint) throws Exception {
        System.out.println("目标类:" + joinPoint.getTarget());
        System.out.println("目标方法:" + joinPoint.getSignature().getName());
        Object object[] = joinPoint.getArgs();
        for (Object o : object) {
            System.out.println("目标方法参数:" + o);
        }
        Class<?> targetClass = joinPoint.getTarget().getClass();
        Method method = targetClass.getMethod(joinPoint.getSignature().getName(), String.class);
        PerformanceLog log = method.getAnnotation(PerformanceLog.class);
        String name = log.name();
        int age = log.age();
        System.out.println("注解参数name = " + name);
        System.out.println("注解参数value = " + age);
    }

}
