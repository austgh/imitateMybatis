package com.ahzx.luban;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author think
 * FactoryBean的getObject可以手动的向容器中注入bean
 */
//@Component
public class LubanFactoryBean implements FactoryBean {
    private Class mapperInterface;

    public LubanFactoryBean(Class mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object getObject() throws Exception {
        Object proxyInstance = Proxy.newProxyInstance(LubanFactoryBean.class.getClassLoader(),
                new Class[]{mapperInterface}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("123");
                        return method.invoke(this, args);
                    }
                });
        return proxyInstance;
    }

    @Override
    public Class<?> getObjectType() {
        return mapperInterface;
    }
}
