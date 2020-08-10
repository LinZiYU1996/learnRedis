package com.lin.redisdistributedlock3.controller;

import com.alibaba.fastjson.JSONObject;
import com.lin.redisdistributedlock3.annotation.RedisLockTestAnnotation;
import com.lin.redisdistributedlock3.config.RedisConfig;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/9
 * \* Time: 15:55
 * \* Description:
 * \
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @PostMapping("update")
    @RedisLockTestAnnotation(redisKey = RedisConfig.REDIS_TEST + "#0")
    public JSONObject sutdentInfoUpdate(@RequestParam("studentId") String studentId,
                                        @RequestParam("age") int age){
        JSONObject result = new JSONObject();
        result.put("update","success");
        return result;
    }
}
