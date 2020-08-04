package com.lin.mybatis_redis;

import com.alibaba.fastjson.JSON;
import com.lin.mybatis_redis.entity.Person;
import com.lin.mybatis_redis.service.IPersonService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/4
 * \* Time: 11:08
 * \* Description:
 * \
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PersonMapperTests {

    @Autowired
    private IPersonService personService;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    Person person = null;

    @Before
    public void testInsert() {
        person = new Person();
        person.setName("测试");
        person.setAddress("address");
        person.setAge(10);
        personService.insert(person);

        Assert.assertNotNull(person.getId());
        log.debug(JSON.toJSONString(person));
    }


    @Test
    public void testFindAll() {
        List<Person> persons = personService.findAll();

        Assert.assertNotNull(persons);
        log.debug(JSON.toJSONString(persons));
    }






}
