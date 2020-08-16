package com.lin.learnaop.demo_1;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/15
 * \* Time: 9:57
 * \* Description:
 * \
 */
public class Main {


    public static void main(String[] args) {

        HelloService helloService = new HelloServiceImpl();

        HelloService proxy = (HelloService) ProxyBean.getProxyBean(helloService,
                new MyInterceptor());

        proxy.sayHello("asasasasa");


    }
}
