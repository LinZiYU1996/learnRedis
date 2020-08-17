package com.lin.learnaop.demo_2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/16
 * \* Time: 9:19
 * \* Description:
 * \
 */

@Aspect
public class MyAspect {

    /**
     * execution 表示在执行的时候， 拦截里面的正则匹配的方法
     * * 表示任意返回类型的方法
     * com.lin.learnaop.demo_2.UserServiceImpl 指定目标对象的全局限定名称
     * printUser 指定目标对象的方法
     */
    @Before("execution(* com.lin.learnaop.demo_2.UserServiceImpl.printUser(..))")
    public void before() {
        System.out.println("before .....................");
    }

    @After("execution(* com.lin.learnaop.demo_2.UserServiceImpl.printUser(..))")
    public void after() {
        System.out.println("after .........................");
    }

    @AfterReturning("execution(* com.lin.learnaop.demo_2.UserServiceImpl.printUser(..))")
    public void afterReturning() {
        System.out.println("afterreturning ................");
    }

    @AfterThrowing("execution(* com.lin.learnaop.demo_2.UserServiceImpl.printUser(..))")
    public void afterThrowing() {
        System.out.println("afterThrowing ..............................");
    }


//    @Around("execution(* com.lin.learnaop.demo_2.UserServiceImpl.printUser(..))")
//    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
//
//        System.out.println("around before ....................");
//
//        joinPoint.proceed();
//
//        System.out.println("around after .........................");
//
//    }


    /**
     *  value 要增强功能的目标对象
     *
     *  defaultImpl 引入增强功能的类
     */
    @DeclareParents(
            value = "com.lin.learnaop.demo_2.UserServiceImpl",
            defaultImpl = UserValidatorImpl.class
    )
    public UserValidator userValidator;

}
