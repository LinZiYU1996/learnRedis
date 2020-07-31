package com.lin.connect_demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
@Slf4j
class ConnectDemoApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    private RedisTemplate<String, String> strRedisTemplate;

    @Test
    public void testString() {
        strRedisTemplate.opsForValue().set("strKey", "zwqh");
        System.out.println(strRedisTemplate.opsForValue().get("strKey"));
    }


    @Test
    public void t1() {
        strRedisTemplate.opsForValue().set("a", "1");
        strRedisTemplate.opsForValue().increment("a", 100L);
        log.info(strRedisTemplate.opsForValue().get("a"));

    }


    @Test
    public void t2() {
        strRedisTemplate.opsForValue().append("b", "123");
        log.info(strRedisTemplate.opsForValue().get("b"));
        strRedisTemplate.opsForValue().getBit("c",12);
        log.info(strRedisTemplate.opsForValue().get("c"));
    }

    @Test
    public void t3() {

        strRedisTemplate.opsForValue().set("a1","abc",20);
        log.info(strRedisTemplate.opsForValue().get("a1"));


    }

    @Test
    public void t4() {

        strRedisTemplate.opsForValue().set("a2", "456");
        Long s = strRedisTemplate.opsForValue().size("a2");
//        log.info(s);

        System.out.println(s);
        // 3
        


    }




}
