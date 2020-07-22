package com.xyg.learn.spring.ioc;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author 97994
 * @since 2020-07-18
 */
public class TestPropertyPlaceholderConfigurer {
    public static void main(String[] args) {
// 声明将被后处理的BeanFactory实例
        ConfigurableListableBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("..."));
// 声明要使用的BeanFactoryPostProcessor
        PropertyPlaceholderConfigurer propertyPostProcessor = new PropertyPlaceholderConfigurer();
        propertyPostProcessor.setLocation(new ClassPathResource("..."));
// 执行后处理操作
        propertyPostProcessor.postProcessBeanFactory(beanFactory);
    }
}
