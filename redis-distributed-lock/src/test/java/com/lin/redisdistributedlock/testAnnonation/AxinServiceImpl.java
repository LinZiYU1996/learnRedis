package com.lin.redisdistributedlock.testAnnonation;

import com.lin.redisdistributedlock.entity.Person;
import org.springframework.stereotype.Component;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/9
 * \* Time: 11:42
 * \* Description:
 * \
 */
@Component
public class AxinServiceImpl implements AxinService {

    @Axin(module = "print",desc = "打印")
    @Override
    public String axinRun(String arg1, User user) {
        String res = arg1 + user.getName() + user.getAge();
        return res;
    }

    public String axinRun(String arg1, Person person) {
        String res = arg1 + person.getName() + person.getAge();
        return res;
    }
}
