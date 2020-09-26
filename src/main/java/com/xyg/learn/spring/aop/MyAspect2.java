package com.xyg.learn.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 代理类
 *
 * @author 97994
 * @since 2020-08-01
 */
@Aspect
public class MyAspect2 {
    // 当代理的类实现接口，jdk的方式，以接口说话 在spring中this匹配代理对象为其指定的类型
//    而target匹配业务对象为其指定的类型
//     @Around("this(com.xyg.learn.spring.aop.AppleWithInterface)")
//    @Around("target(com.xyg.learn.spring.aop.AppleWithInterface)")
//    @Around("target(com.xyg.learn.spring.aop.Fruit)")
//    @Around("this(com.xyg.learn.spring.aop.Fruit)")
//    execution的使用
//    @Around("execution(void com.xyg..*.eat())")
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
        Fruit apple = (Fruit)context.getBean("appleI");
        apple.eat();
    }
}
