package com.lin.mbp_redis;

import com.lin.mbp_redis.mapper.PersonMapper;
import com.lin.mbp_redis.service.IPersonService;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/7
 * \* Time: 10:27
 * \* Description:
 * \
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class Test {

    @Autowired
    private IPersonService personService;

    @Autowired
    private PersonMapper personMapper;
    @org.junit.Test
    public void t1() {
        personService.findAll();
    }

    @org.junit.Test
    public void t2() {
        personMapper.selectById(1);

    }

    @org.junit.Test
    public void t3() {

        log.info(personService.getPerson(1L).toString());


    }


}
