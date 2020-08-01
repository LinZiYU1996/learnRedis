package com.lin.connect_demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/7/31
 * \* Time: 10:22
 * \* Description:
 * \
 */
@SpringBootTest
@Slf4j
public class Test {

    @Autowired
    private RedisTemplate<String, String> strRedisTemplate;



    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @org.junit.jupiter.api.Test
    public void t1() {

        stringRedisTemplate.opsForList().leftPush("a","a");
        Long s = stringRedisTemplate.opsForList().size("a");
        System.out.println(s);


    }

    @org.junit.jupiter.api.Test
    public void t2() {
        strRedisTemplate.opsForValue().set("k","a");

    }

    @org.junit.jupiter.api.Test
    public void t3() {

//        strRedisTemplate.opsForHash().put("a","a","a");

        // leftPush依次由右边添加
        stringRedisTemplate.opsForList().rightPush("myList","1");
        stringRedisTemplate.opsForList().rightPush("myList","2");
        stringRedisTemplate.opsForList().rightPush("myList", "A");
        stringRedisTemplate.opsForList().rightPush("myList", "B");



    }

    @org.junit.jupiter.api.Test
    public void listGetListResitTest(){
        // 查询类别所有元素
        List<String> listAll = stringRedisTemplate.opsForList().range( "myList", 0, -1);
        log.info("list all {}", listAll);
        // 查询前3个元素
        List<String> list = stringRedisTemplate.opsForList().range( "myList", 0, 3);
        log.info("list limit {}", list);
        //2020-07-31 10:42:33.201  INFO 22708 --- [           main] com.lin.connect_demo.Test                : list all [1, 2, A, B]
        //2020-07-31 10:42:33.202  INFO 22708 --- [           main] com.lin.connect_demo.Test                : list limit [1, 2, A, B]

    }



}
