package com.lin.mybatis_redis.controller;

import com.alibaba.fastjson.JSON;
import com.lin.mybatis_redis.entity.Person;
import com.lin.mybatis_redis.service.IPersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/5
 * \* Time: 20:15
 * \* Description:
 * \
 */

@Controller
@Slf4j
public class Test {

    @Autowired
    private IPersonService personService;

    @RequestMapping("/t1")
    public void t1() {
        long begin = System.currentTimeMillis();
        List<Person> persons = personService.findAll();
        long ing = System.currentTimeMillis();
        personService.findAll();
        long end = System.currentTimeMillis();
        log.info("第一次请求时间：" + (ing - begin) + "ms");
        log.info("第二次请求时间:" + (end - ing) + "ms");

//        Assert.assertNotNull(persons);
        log.info(JSON.toJSONString(persons));

    }


}
