package com.lin.redisdistributedlock.repository;

import com.lin.redisdistributedlock.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/8
 * \* Time: 9:48
 * \* Description:
 * \
 */
@Repository
public class PersonRepository {

    @Autowired
    StringRedisTemplate stringRedisTemplate; //1

    @Autowired
    RedisTemplate<String, Object> redisTemplate; //2

    public void stringRedisTemplateDemo(){ //5
        stringRedisTemplate.opsForValue().set("xx", "yy");
    }


    public void save(Person person){ //6
        redisTemplate.opsForValue().set(person.getId(), person);
    }

    public String getString(){//7
        return stringRedisTemplate.opsForValue().get("xx");
    }

    public Person getPerson(){//8
        return (Person) redisTemplate.opsForValue().get("1");
    }

}