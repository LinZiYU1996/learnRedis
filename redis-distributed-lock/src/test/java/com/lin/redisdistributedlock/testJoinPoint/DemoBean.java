package com.lin.redisdistributedlock.testJoinPoint;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/9
 * \* Time: 10:50
 * \* Description:
 * \
 */
@Component
public class DemoBean {

    /**
     * 返回随机的字符串
     *
     * @param time
     * @return
     */
    public String randUUID(long time) {
        try {
            System.out.println("in randUUID before process!");
            return UUID.randomUUID() + "|" + time;
        } finally {
            System.out.println("in randUUID finally!");
        }
    }
}
