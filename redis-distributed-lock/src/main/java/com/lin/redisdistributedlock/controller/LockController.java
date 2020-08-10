package com.lin.redisdistributedlock.controller;

import com.lin.redisdistributedlock.distributed.annotation.CacheLock;
import com.lin.redisdistributedlock.distributed.annotation.CacheParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/9
 * \* Time: 9:44
 * \* Description:
 * \
 */
@RestController
@RequestMapping("/lock")
@Slf4j
public class LockController {

    @CacheLock(prefix = "test")
    @GetMapping("/test")
    public String query(@CacheParam(name = "token") @RequestParam String token) {
        return "success - " + token;
    }

}
