package com.lin.affairs_demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@SpringBootTest
class AffairsDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @Transactional(rollbackFor = Exception.class)
    @Test
    public void mutiTest(Map<String,String> datas) throws Exception {
        redisTemplate.opsForValue().multiSet(datas);
        throw new Exception("custom exception");
    }



}
