package com.lin.redisdistributedlock.testJoinPoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/9
 * \* Time: 10:50
 * \* Description:
 * \
 */
@SpringBootApplication
public class Application {

    public Application(DemoBean demoBean) {
        String ans = demoBean.randUUID(System.currentTimeMillis());
        System.out.println("----- ans: " + ans + "---------");
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
