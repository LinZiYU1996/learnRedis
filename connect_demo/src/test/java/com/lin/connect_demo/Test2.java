package com.lin.connect_demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/7/31
 * \* Time: 10:44
 * \* Description:
 * \
 */

@SpringBootTest
@Slf4j
public class Test2 {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @org.junit.jupiter.api.Test
    public void hashPutResitTest(){
        // map的key值相同，后添加的覆盖原有的
//        stringRedisTemplate.opsForHash().put("banks:12600000", "a", "b");
        for (int i = 0; i < 55; i++) {
            stringRedisTemplate.opsForHash().put("banks:12600000", "a"+i, "b"+i);
        }
    }

    @org.junit.jupiter.api.Test
    public void hashGetEntiresResitTest(){
        // 获取map对象
        Map<Object, Object> map = stringRedisTemplate.opsForHash().entries("banks:12600000");
        log.info("objects:{}", map);
        //2020-07-31 10:46:21.668  INFO 24600 --- [           main] com.lin.connect_demo.Test2               : objects:{a=b}


    }


    @org.junit.jupiter.api.Test
    public void hashGeDeleteResitTest(){
        // 根据map的key删除这个元素
        stringRedisTemplate.opsForHash().delete("banks:12600000", "c");
    }


    @org.junit.jupiter.api.Test
    public void hashGetKeysResitTest(){
        // 获得map的key集合
        Set<Object> objects =  stringRedisTemplate.opsForHash().keys("banks:12600000");
        log.info("objects:{}", objects);
        //2020-07-31 10:47:16.278  INFO 20704 --- [           main] com.lin.connect_demo.Test2               : objects:[a]

    }


    @org.junit.jupiter.api.Test
    public void hashGetValueListResitTest(){
        // 获得map的value列表
        List<Object> objects = stringRedisTemplate.opsForHash().values("banks:12600000");
        log.info("objects:{}", objects);
    }
//2020-07-31 10:48:00.065  INFO 23120 --- [           main] com.lin.connect_demo.Test2               : objects:[b]

    @org.junit.jupiter.api.Test
    public void hashSize() {
        // 获取map对象大小
        long size =  stringRedisTemplate.opsForHash().size("banks:12600000");
        log.info("size:{}", size);
    }
//2020-07-31 10:54:25.372  INFO 22856 --- [           main] com.lin.connect_demo.Test2               : size:1

//2020-07-31 11:33:01.196  INFO 20348 --- [           main] com.lin.connect_demo.Test2               : size:56  55 + 1





}
