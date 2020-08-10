package com.lin.redisdistributedlock.testAnnonation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/9
 * \* Time: 11:42
 * \* Description:
 * \
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class Main {

    @Autowired
    AxinService axinService;

    @Test
    public void test() {
        User user = new User();
        user.setAge(10);
        user.setName("张三");
        String res = axinService.axinRun("Test:", user);
    }
}
//环绕通知：
//print
//打印
//******拦截前的逻辑******
//目标方法名为:axinRun
//目标方法所属类的简单类名:AxinServiceImpl
//目标方法所属类的类名:com.lin.redisdistributedlock.testAnnonation.AxinServiceImpl
//目标方法声明类型:public
//第1个参数为:Test:
//第2个参数为:User(name=张三, age=10)
//被代理的对象:com.lin.redisdistributedlock.testAnnonation.AxinServiceImpl@1c628f6a
//代理对象自己:com.lin.redisdistributedlock.testAnnonation.AxinServiceImpl@1c628f6a
//拦截的注解的参数：
//print
//打印
//******拦截后的逻辑******

