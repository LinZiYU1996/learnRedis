package com.lin.learnaopblogdemo.controller;

import com.lin.learnaopblogdemo.annotation.ControllerWebLog;
import com.lin.learnaopblogdemo.annotation.DistributeLock;
import com.lin.learnaopblogdemo.common.BaseRequest;
import com.lin.learnaopblogdemo.common.BaseResponse;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/18
 * \* Time: 21:26
 * \* Description:
 * \
 */

@RestController
@RequestMapping("/weblog")
public class Test {

    @GetMapping("/get-test")
//    @ApiOperation("接口日志GET请求测试")
    @ControllerWebLog(name = "GET请求测试接口", intoDb = true)
    public String hello(@RequestParam("name") String name){
        return name;
    }

    @PostMapping("/post-test")
//    @ApiOperation("接口日志POST请求测试")
    @ControllerWebLog(name = "接口日志POST请求测试", intoDb = true)
    @DistributeLock(key = "post_test_#{baseRequest.channel}", timeout = 10)
    public BaseResponse postTest(@RequestBody @Valid BaseRequest baseRequest, BindingResult bindingResult) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return BaseResponse.addResult();
    }



}
