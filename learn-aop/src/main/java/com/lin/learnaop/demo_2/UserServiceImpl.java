package com.lin.learnaop.demo_2;

import org.springframework.stereotype.Service;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/16
 * \* Time: 9:16
 * \* Description:
 * \
 */
//  @Service 在实现类中标识
@Service
public class UserServiceImpl implements UserService{

    @Override
    public void printUser(User user) {
        if (user == null) {
            throw  new RuntimeException("检测用户参数是否为空..............");
        }
        System.out.println("id = : " + user.getId());
        System.out.println("name = : " + user.getName() );
    }
}
