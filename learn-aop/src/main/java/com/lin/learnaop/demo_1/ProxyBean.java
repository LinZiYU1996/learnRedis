package com.lin.learnaop.demo_1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/14
 * \* Time: 22:50
 * \* Description:
 * \
 */
public class ProxyBean implements InvocationHandler {

    private Object target = null;

    private Interceptor interceptor = null;


    public static Object getProxyBean(Object target, Interceptor interceptor) {
        ProxyBean proxyBean = new ProxyBean();

        proxyBean.target = target;

        proxyBean.interceptor = interceptor;

        Object proxy = Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                proxyBean
        );

        return proxy;    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        boolean exceptionFlag = false;

        Invocation invocation = new Invocation(target, method, args);

        Object retObj = null;




    }



}
