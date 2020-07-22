package com.xyg.learn.spring.ioc;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 97994
 * @since 2020-07-18
 */
public class ThreadScope implements Scope {

    private final ThreadLocal threadScope = new ThreadLocal() {
        protected Object initialValue() {
            return new HashMap();
        }
    };
    public Object get(String name, ObjectFactory objectFactory) {
        Map scope = (Map) threadScope.get();
        Object object = scope.get(name);
        if(object==null) {
            object = objectFactory.getObject();
            scope.put(name, object);
        }
        return object;
    }
    public Object remove(String name) {
        Map scope = (Map) threadScope.get();
        return scope.remove(name);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
