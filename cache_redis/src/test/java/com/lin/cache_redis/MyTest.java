package com.lin.cache_redis;

import com.lin.cache_redis.entity.Person;
import com.lin.cache_redis.service.IPersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/5
 * \* Time: 11:19
 * \* Description:
 * \
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {

    @Autowired
    IPersonService personService;


    @Test
    public void t1() {

        Person person = new Person();

        person.setAddress("tianjian");
        person.setAge(100);
        person.setName("hello");

        personService.saves(person);

    }
}
