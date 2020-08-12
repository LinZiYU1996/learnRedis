package com.lin.bootredis;

import com.lin.bootredis.entity.Person;
import com.lin.bootredis.service.IPersonService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/11
 * \* Time: 17:12
 * \* Description:
 * \
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RedisTest {


    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    IPersonService personService;

    @Test
    public void t1() {
        Person person = personService.getPersonByID(1L);
        redisTemplate.opsForValue().set("p", person.toString());


    }


}
