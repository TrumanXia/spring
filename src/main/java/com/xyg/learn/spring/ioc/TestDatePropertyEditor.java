package com.xyg.learn.spring.ioc;

import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 97994
 * @since 2020-07-18
 * 这个程序有问题 spring揭秘 4.4.2
 */
public class TestDatePropertyEditor {
    public static void main(String[] args) {
        XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("/beans/datepojo.xml"));

        CustomEditorConfigurer ceConfigurer = new CustomEditorConfigurer();
        Map customerEditors = new HashMap();
        customerEditors.put(java.util.Date.class, com.xyg.learn.spring.ioc.DatePropertyEditor.class);
        ceConfigurer.setCustomEditors(customerEditors);
        DateFoo dateFoo = (DateFoo)beanFactory.getBean("dateFoo");
        System.out.println(dateFoo.getDate());
        ceConfigurer.postProcessBeanFactory(beanFactory);
        System.out.println(dateFoo.getDate());
    }
}
