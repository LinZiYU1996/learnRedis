package com.lin.mybatis_redis.controller;

import com.alibaba.fastjson.JSON;
import com.lin.mybatis_redis.entity.Person;
import com.lin.mybatis_redis.service.IPersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

        List<Person> persons = personService.findAll();

        personService.findAll();



//        Assert.assertNotNull(persons);
        log.info(JSON.toJSONString(persons));

    }

    @RequestMapping("/t2")
    @ResponseBody
    public String t2() {
        personService.findAll();
        return "hello";

    }


}
