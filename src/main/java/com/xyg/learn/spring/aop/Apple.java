package com.xyg.learn.spring.aop;

/**
 * aop 业务类
 *
 * @author 97994
 * @since 2020-08-01
 */
@FruitAspect
public class Apple {
    public void eat() {
        System.out.println("Apple.eat method invoked.");
    }
}
