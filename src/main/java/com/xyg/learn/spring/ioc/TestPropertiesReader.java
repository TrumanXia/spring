package com.xyg.learn.spring.ioc;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;

/**
 * @author 97994
 * @since 2020-07-18
 */
public class TestPropertiesReader {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
//        PropertiesBeanDefinitionReader可以实现自己的reader，根据自己的规则来解析
        PropertiesBeanDefinitionReader reader =
            new PropertiesBeanDefinitionReader(beanRegistry);
//        reader.loadBeanDefinitions("classpath:beans/beans.properties");
        reader.loadBeanDefinitions("/beans/beans.properties");
        beanRegistry.getBean("djNewsProvider");
    }
}
