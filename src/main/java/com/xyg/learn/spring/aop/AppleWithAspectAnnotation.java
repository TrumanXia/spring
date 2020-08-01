package com.xyg.learn.spring.aop;

/**
 * @author 97994
 * @since 2020-08-01
 */
@FruitAspect
public class AppleWithAspectAnnotation implements Fruit {

    @Override
    public void eat() {
        System.out.println("Apple.eat method invoked.");
    }
}
