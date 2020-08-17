package com.lin.learnaop;

import com.lin.learnaop.demo_2.User;
import com.lin.learnaop.demo_2.UserService;
import com.lin.learnaop.demo_2.UserValidator;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/16
 * \* Time: 9:29
 * \* Description:
 * \
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class Test {

    @Autowired
    private UserService userService;

    @org.junit.Test
    public void  t1() {

        User user = new User();

        user.setId(1);
        user.setName("a");

        userService.printUser(user);



    }

    @org.junit.Test
    public void  t2() {
        User user = new User();

        user.setId(1);
        user.setName("a");

        UserValidator validator = (UserValidator) userService;

        if (validator.validate(user)) {
            userService.printUser(user);
        }


    }
}
