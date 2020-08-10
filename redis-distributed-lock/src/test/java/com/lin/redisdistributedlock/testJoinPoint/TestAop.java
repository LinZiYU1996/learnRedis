package com.lin.redisdistributedlock.testJoinPoint;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/9
 * \* Time: 10:45
 * \* Description:
 * \
 */

public class TestAop {
    @Test
    public void testAOP() {
        //1、创建Spring的IOC的容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:bean.xml");

        //2、从IOC容器中获取bean的实例
        TargetClass targetClass = (TargetClass) ctx.getBean("targetClass");

        //3、使用bean
        String result = targetClass.joint("spring","aop");
        System.out.println("result:" + result);
    }
}
