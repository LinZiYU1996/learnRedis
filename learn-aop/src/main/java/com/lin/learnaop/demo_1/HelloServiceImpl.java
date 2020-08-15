package com.lin.learnaop.demo_1;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/14
 * \* Time: 22:43
 * \* Description:
 * \
 */
public class HelloServiceImpl implements HelloService{

    @Override
    public void sayHello(String name) {
        if (name == null || name.trim() == "") {
            throw new RuntimeException("null");
        }
        System.out.println("hello --- " + name);

    }
}
