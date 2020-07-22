package com.xyg.learn.spring.ioc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author 97994
 * @since 2020-07-15
 */
public class TestXmlReader {
	public static void main(String[] args) {
		BeanFactory container =
		new XmlBeanFactory(new ClassPathResource("/beans/newsSystem.xml"));
		FXNewsProvider newsProvider1 = (FXNewsProvider) container.getBean("djNewsProvider");
		FXNewsProvider newsProvider2 = (FXNewsProvider) container.getBean("djNewsProvider");
		FXNewsProvider newsProvider3 = (FXNewsProvider) container.getBean("djNewsProvider");
		System.out.println(newsProvider1);
		System.out.println(newsProvider2);
		System.out.println(newsProvider3);
	}
}
