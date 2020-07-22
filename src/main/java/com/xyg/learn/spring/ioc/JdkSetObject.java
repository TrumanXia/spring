package com.xyg.learn.spring.ioc;

import org.junit.Assert;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @author 97994
 * @since 2020-07-19
 */
public class JdkSetObject {
    public static void main(String[] args) throws Exception{
        Class<?> aClass = Class.forName("com.xyg.learn.spring.ioc.FXNewsProvider");
        Constructor<?> declaredConstructor =
            aClass.getDeclaredConstructor(IFXNewsListener.class, IFXNewsPersister.class);
        Object listener = Class.forName("com.xyg.learn.spring.ioc.DowJonesNewsListener").newInstance();
        Object persister = Class.forName("com.xyg.learn.spring.ioc.DowJonesNewsPersister").newInstance();
        Object provider = declaredConstructor.newInstance(listener, persister);


        Field newsListener = aClass.getDeclaredField("newsListener");
        newsListener.setAccessible(true);
        Field newPersistener = aClass.getDeclaredField("newPersistener");
        newPersistener.setAccessible(true);
        Assert.assertSame(listener, newsListener.get(provider));
        Assert.assertSame(persister, newPersistener.get(provider));
    }
}
