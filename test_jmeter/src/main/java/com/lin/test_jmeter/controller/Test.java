package com.lin.test_jmeter.controller;

import com.lin.test_jmeter.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/5
 * \* Time: 16:03
 * \* Description:
 * \
 */

@Controller
public class Test {


    @Autowired
    private IPersonService personService;

    @RequestMapping("/he")
    public String t() {
        long begin = System.currentTimeMillis();

        personService.findAll();

        long end = System.currentTimeMillis();

        System.out.println((end - begin));

        return "done";


    }

}
