package com.lin.cache_redis.controller;

import com.lin.cache_redis.entity.Person;
import com.lin.cache_redis.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/5
 * \* Time: 10:28
 * \* Description:
 * \
 */
@RestController
public class CacheController {

    @Autowired
    IPersonService personService;

    @Autowired
    CacheManager cacheManager;

    @RequestMapping("/put")
    public long put(@RequestBody Person person) {
        personService.saves(person);
        return person.getId();
    }

    @RequestMapping("/able")
    public Person cacheable(Person person) {
        String a = "a";
        String[] b = {"1", "2"};
        List<Long> c = new ArrayList<>();
        c.add(3L);
        c.add(4L);
        return personService.findOne(person, a, b, c);
    }



//    @RequestMapping("/able1")
//    public Person cacheable1(Person person) {
//
//        return personService.findOne1();
//    }

    @RequestMapping("/able2")
    public Person cacheable2(Person person) {

        return personService.findOne2(person);
    }

    @RequestMapping("/evit")
    public String evit(Long id) {

        personService.remove(id);
        return "ok";
    }
}
