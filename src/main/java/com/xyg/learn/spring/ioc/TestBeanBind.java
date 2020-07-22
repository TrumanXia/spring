package com.xyg.learn.spring.ioc;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @author 97994
 * @since 2020-07-18
 */
public class TestBeanBind {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
// InstanceSupplier
        AbstractBeanDefinition newsProvider =
            new RootBeanDefinition(FXNewsProvider.class, null);
        AbstractBeanDefinition newsListener =
            new RootBeanDefinition(DowJonesNewsListener.class, null);
        AbstractBeanDefinition newsPersister =
            new RootBeanDefinition(DowJonesNewsPersister.class, null);

        // 将bean定义注册到容器中
        beanRegistry.registerBeanDefinition("djNewsProvider", newsProvider);
        beanRegistry.registerBeanDefinition("djListener", newsListener);
        beanRegistry.registerBeanDefinition("djPersister", newsPersister);

        // 指定依赖关系
        // 1. 可以通过构造方法注入方式
//        ConstructorArgumentValues argValues = new ConstructorArgumentValues();
//        argValues.addIndexedArgumentValue(0, newsListener);
//        argValues.addIndexedArgumentValue(1, newsPersister);
//        newsProvider.setConstructorArgumentValues(argValues);
        // 2. 或者通过setter方法注入方式
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("newsListener",newsListener));
        propertyValues.addPropertyValue(new PropertyValue("newPersistener",newsPersister));
        newsProvider.setPropertyValues(propertyValues);
        FXNewsProvider newsProvider3 = (FXNewsProvider) beanRegistry.getBean("djNewsProvider");
        System.out.println(newsProvider3);
    }
}
