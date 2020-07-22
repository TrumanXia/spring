package com.xyg.learn.spring.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author 97994
 * @since 2020-07-18
 */
public class TestBeanFactoryAware implements BeanFactoryAware {
    private BeanFactory beanFactory;
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public static void main(String[] args) {
//        BeanFactory container =
//            new XmlBeanFactory(new ClassPathResource("/beans/newsSystemFactory.xml"));
//        System.out.println(container.getBean("djNewsProvider"));
//        System.out.println(container.getBean("djNewsProvider"));

//        this.beanFactory.getBean("")
    }
}
