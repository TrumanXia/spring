package com.xyg.learn.spring.aop;

/**
 * @author 97994
 * @since 2020-08-01
 */
public class AppleWithMethodAnnotation implements Fruit {
    @FruitAspect
    @Override
    public void eat() {
        System.out.println("Apple.eat method invoked.");
    }
}
