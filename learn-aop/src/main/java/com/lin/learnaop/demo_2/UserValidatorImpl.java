package com.lin.learnaop.demo_2;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/16
 * \* Time: 10:19
 * \* Description:
 * \
 */
public class UserValidatorImpl implements UserValidator{

    @Override
    public boolean validate(User user) {
        System.out.println(" 引入新的接口 " + UserValidator.class
        .getSimpleName());

        return user != null;
    }
}
