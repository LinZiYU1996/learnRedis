package com.lin.redisblogarticle.annotation;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PageView {
    /**
     * 描述
     */
    String description()  default "";
}