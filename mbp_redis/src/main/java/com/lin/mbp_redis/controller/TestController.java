package com.lin.mbp_redis.controller;

import com.lin.mbp_redis.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String t() {


        personService.findAll();
        return "hello";

    }
}
