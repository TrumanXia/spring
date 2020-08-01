package com.xyg.learn.spring.aop;

/**
 * @author 97994
 * @since 2020-08-01
 */
// 要织入接口的默认实现
public class DescriberImpl implements IDescriber {
    @Override
    public void desc() {
        System.out.println("this is an introduction describer.");
    }
}