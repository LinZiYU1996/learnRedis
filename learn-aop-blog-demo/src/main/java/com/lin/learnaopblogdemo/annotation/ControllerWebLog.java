package com.lin.learnaopblogdemo.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ControllerWebLog {
    //其中 name 为所调用接口的名称， intoDb 则标识该条操作日志是否需要持久化存储

    String name();
    boolean intoDb() default false;

}