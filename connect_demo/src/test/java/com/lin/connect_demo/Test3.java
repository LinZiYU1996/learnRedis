package com.lin.connect_demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Set;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/7/31
 * \* Time: 11:33
 * \* Description:
 * \
 */

@SpringBootTest
@Slf4j
public class Test3 {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @org.junit.jupiter.api.Test
    public void t1() {

//        stringRedisTemplate.opsForSet().add("s1", "asasa", "12356");

//        stringRedisTemplate.opsForSet().add("s1", "asasa", "12356","ass","asdkkd","sjjfjfj");
        stringRedisTemplate.opsForSet().add("s2", "asasa", "12356","ass","asdkkd","sjjfjfj", "1234785","589614");

    }

    @org.junit.jupiter.api.Test
    public void t2() {

//        log.info(stringRedisTemplate.opsForSet().pop("s1"));

        //2020-07-31 11:36:24.713  INFO 15336 --- [           main] com.lin.connect_demo.Test3               : asasa


//        log.info(stringRedisTemplate.opsForSet().pop("s1",1).toString());

        Set<String> s = stringRedisTemplate.opsForSet().members("s1");

        log.info(s.toString());

//2020-07-31 11:39:31.286  INFO 12364 --- [           main] com.lin.connect_demo.Test3               : [asdkkd, ass, 12356, asasa, sjjfjfj]






    }

    @org.junit.jupiter.api.Test
    public void t3() {


        Set<String> s = stringRedisTemplate.opsForSet().union("s1", "s2");
        log.info(s.toString());
//2020-07-31 11:41:30.929  INFO 4868 --- [           main] com.lin.connect_demo.Test3               : [asdkkd, 589614, sjjfjfj, 1234785, ass, 12356, asasa]

        

    }


    @org.junit.jupiter.api.Test
    public void t4() {


    }


    @org.junit.jupiter.api.Test
    public void t5() {


    }

}
