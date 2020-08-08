package com.lin.mbp_redis;

import com.lin.mbp_redis.service.IPersonService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class MbpRedisApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private IPersonService personService;


    @Test
    public void t() {

        personService.findAll();
    }



}
