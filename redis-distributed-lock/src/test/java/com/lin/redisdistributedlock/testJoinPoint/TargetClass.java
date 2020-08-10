package com.lin.redisdistributedlock.testJoinPoint;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/9
 * \* Time: 10:45
 * \* Description:
 * \
 */

import org.springframework.stereotype.Component;

/**
 * 被代理对象
 */
@Component
public class TargetClass {
    /**
     * 拼接两个字符串
     */
    public String joint(String str1, String str2) {
        return str1 + "+" + str2;
    }
}