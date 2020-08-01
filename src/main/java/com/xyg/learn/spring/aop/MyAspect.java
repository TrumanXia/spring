package com.xyg.learn.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 代理类
 *
 * @author 97994
 * @since 2020-08-01
 */
@Aspect
public class MyAspect {
    // 当代理的类没有实现接口，this和target没有区别
    // @Around("this(com.xyg.learn.spring.aop.Apple)")
//    @Around("target(com.xyg.learn.spring.aop.Apple)")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("this is before around advice");
        Object result = pjp.proceed();
        System.out.println("this is after around advice");
        return result;
    }

    public static void main(String[] args) {
        // 直接这样写，没有通过spring管理，是没有效果的
        // new Apple().eat();
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aop/forAop.xml");
        Apple apple = (Apple)context.getBean("apple");
        apple.eat();
    }
}
