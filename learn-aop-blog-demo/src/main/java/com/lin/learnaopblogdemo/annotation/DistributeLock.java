package com.lin.learnaopblogdemo.annotation;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DistributeLock {
    //其中， key 为分布式所的 key 值， timeout 为锁的超时时间，默认为 5， timeUnit 为超时时间的单位，默认为秒。


    String key();
    long timeout() default 5;
    TimeUnit timeUnit() default TimeUnit.SECONDS;
}
