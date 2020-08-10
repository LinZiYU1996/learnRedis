package com.lin.redishyperloglog.annonation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Article {

    /**
     * 值为对应HyperLogLog的key
     */
    String value() default "";
}
