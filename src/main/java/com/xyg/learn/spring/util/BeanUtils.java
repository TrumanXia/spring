package com.xyg.learn.spring.util;

import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.Set;

public class BeanUtils implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public BeanUtils() {
        Reflections reflections = new Reflections(this.getClass(), new FieldAnnotationsScanner());

        Set<Field> fieldsAnnotatedWith = reflections.getFieldsAnnotatedWith(Resource.class);

        for (Field field : fieldsAnnotatedWith) {
            String simpleName = field.getType().getSimpleName();
// spring 里面管理的bean的name都是小写的，需要把首字母转为小写
            String beanName = simpleName.toLowerCase();

            Object bean = applicationContext.getBean(beanName);

            if (bean == null)
                return;

            field.setAccessible(true);
            try {
                field.set(this, bean);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }


    }
}
