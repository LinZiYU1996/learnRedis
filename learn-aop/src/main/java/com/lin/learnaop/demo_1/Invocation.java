package com.lin.learnaop.demo_1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/14
 * \* Time: 22:45
 * \* Description:
 * \
 */
public class Invocation {


    private Object[] params;

    private Method method;

    private Object target;


    public Invocation(Object[] params, Method method, Object target) {
        this.params = params;
        this.method = method;
        this.target = target;
    }


    public Object proceed() throws InvocationTargetException, IllegalAccessException {
        return method.invoke(target, params);
    }
}
