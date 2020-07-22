package com.xyg.learn.spring.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 97994
 * @since 2020-07-18
 */
public class TestComponentScanner {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext
            = new ClassPathXmlApplicationContext("/beans/componentScanning.xml");
        FXNewsProvider fxNewsProvider = (FXNewsProvider)classPathXmlApplicationContext.getBean("FXNewsProvider");
    }
}
