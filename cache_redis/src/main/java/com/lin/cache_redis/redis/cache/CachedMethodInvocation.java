package com.lin.cache_redis.redis.cache;

import lombok.Data;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/5
 * \* Time: 9:28
 * \* Description:
 * \
 */

//标记了缓存注解的方法类信息
// * 用于主动刷新缓存时调用原始方法加载数据
@Data
public class CachedMethodInvocation implements Serializable {

    private Object key;
    private String targetBean;
    private String targetMethod;
    private List<Object> arguments;
    private List<String> parameterTypes = new ArrayList<>();

    public CachedMethodInvocation() {
    }

    public CachedMethodInvocation(Object key, Object targetBean, Method targetMethod, Class[] parameterTypes, Object[] arguments) {
        this.key = key;
        this.targetBean = targetBean.getClass().getName();
        this.targetMethod = targetMethod.getName();
        if (arguments != null && arguments.length != 0) {
            this.arguments = Arrays.asList(arguments);
        }
        if (parameterTypes != null && parameterTypes.length != 0) {
            for (Class clazz : parameterTypes) {
                this.parameterTypes.add(clazz.getName());
            }
        }
    }



    /**
     * 必须重写equals和hashCode方法，否则放到set集合里没法去重
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CachedMethodInvocation that = (CachedMethodInvocation) o;

        return key.equals(that.key);
    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }


}
