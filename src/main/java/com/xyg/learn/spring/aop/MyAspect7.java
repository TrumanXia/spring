package com.xyg.learn.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 代理类
 *
 * @author 97994
 * @since 2020-08-01
 */
// perthis/pertarget

@Aspect("perthis(this(com.xyg.learn.spring.aop.Apple))")
public class MyAspect7 {
    // 当代理的类实现接口，jdk的方式，以接口说话 在spring中this匹配代理对象为其指定的类型
//    而target匹配业务对象为其指定的类型
//     @Around("this(com.xyg.learn.spring.aop.AppleWithInterface)")
//    @Around("target(com.xyg.learn.spring.aop.AppleWithInterface)")
//    @Around("target(com.xyg.learn.spring.aop.Fruit)")
//    @Around("this(com.xyg.learn.spring.aop.Fruit)")
//    execution的使用
//    @Around("execution(void com.xyg..*.eat())")
//    @within的使用 针对的是注解
//    @Around("@within(com.xyg.learn.spring.aop.FruitAspect)")
//    within的使用 针对的是类
//    @Around("within(com.xyg.learn.spring.aop.AppleWithAspectAnnotation)")
//    @annotation的使用 针对的是 方法 上的注解
//    @Around("@annotation(com.xyg.learn.spring.aop.FruitAspect)")
//    @args的使用 针对的是 方法 上的注解
//    @Around("@args(com.xyg.learn.spring.aop.FruitAspect)")

    // DeclareParents 相当于 Introduction 引入新的属性
     @DeclareParents(value="com.xyg.learn.spring.aop.Apple", defaultImpl = DescriberImpl.class)
     private IDescriber describer;

    @Around("this(com.xyg.learn.spring.aop.Apple)")
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
        IDescriber apple1 = ((IDescriber) context.getBean("apple"));
        System.out.println(apple1);
        apple1.desc();
        IDescriber apple2 = ((IDescriber) context.getBean("apple"));
        System.out.println(apple2);
        apple1.desc();
//        FruitBucket apple = (FruitBucket)context.getBean("appleArgs");
//        apple.putIntoBucket(apple1);
    }
}
