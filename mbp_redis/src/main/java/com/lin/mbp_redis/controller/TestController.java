package com.lin.mbp_redis.controller;

import com.lin.mbp_redis.entity.Person;
import com.lin.mbp_redis.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/7
 * \* Time: 15:56
 * \* Description:
 * \
 */

@Controller
public class TestController {


    @Autowired
    private IPersonService personService;
    @RequestMapping("/test")
    @ResponseBody
    @Cacheable(value = "persons")
    public List<Person> t() {
        List<Person> people = personService.findAll();
        return people;

    }
}
