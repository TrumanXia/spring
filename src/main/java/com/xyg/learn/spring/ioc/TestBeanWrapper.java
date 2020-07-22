package com.xyg.learn.spring.ioc;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;

/**
 * @author 97994
 * @since 2020-07-19
 */
public class TestBeanWrapper {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> aClass = Class.forName("com.xyg.learn.spring.ioc.FXNewsProvider");
        Constructor<?> declaredConstructor =
            aClass.getDeclaredConstructor(IFXNewsListener.class, IFXNewsPersister.class);
        Object listener = Class.forName("com.xyg.learn.spring.ioc.DowJonesNewsListener").newInstance();
        Object persister = Class.forName("com.xyg.learn.spring.ioc.DowJonesNewsPersister").newInstance();
        Object provider = declaredConstructor.newInstance(listener, persister);

        BeanWrapper newsProvider = new BeanWrapperImpl(provider);
        newsProvider.setPropertyValue("newsListener", listener);
        newsProvider.setPropertyValue("newPersistener", persister);

        assertTrue(newsProvider.getWrappedInstance() instanceof FXNewsProvider);
        assertSame(provider, newsProvider.getWrappedInstance());
        assertSame(listener, newsProvider.getPropertyValue("newsListener"));
        assertSame(persister, newsProvider.getPropertyValue("newPersistener"));
    }
}
