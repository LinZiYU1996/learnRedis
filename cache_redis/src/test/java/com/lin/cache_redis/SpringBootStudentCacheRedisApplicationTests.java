package com.lin.cache_redis;

import net.minidev.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/5
 * \* Time: 10:27
 * \* Description:
 * \
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootStudentCacheRedisApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(SpringBootStudentCacheRedisApplicationTests.class);

    @Test
    public void contextLoads() {
    }

    private MockMvc mockMvc; // 模拟MVC对象，通过MockMvcBuilders.webAppContextSetup(this.wac).build()初始化。

    @Autowired
    private WebApplicationContext wac; // 注入WebApplicationContext

//    @Autowired
//    private MockHttpSession session;// 注入模拟的http session
//
//    @Autowired
//    private MockHttpServletRequest request;// 注入模拟的http request\


    @Autowired
    PropertySourcesPlaceholderConfigurer configurer;

    @Autowired
    DefaultListableBeanFactory beanFactory;

    @Autowired
    private RedisTemplate redisTemplate;;

    @Before // 在测试开始前初始化工作
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testAble() throws Exception {
        for (int i = 0; i < 2; i++) {
            MvcResult result = mockMvc.perform(post("/able").param("id", "2"))
                    .andExpect(status().isOk())// 模拟向testRest发送get请求
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))// 预期返回值的媒体类型text/plain;
                    // charset=UTF-8
                    .andReturn();// 返回执行请求的结果

            System.out.println(result.getResponse().getContentAsString());
        }
    }

    @Test
    public void testPut() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("address", "合肥");
        map.put("name", "测试");
        map.put("age", 50);

        MvcResult result = mockMvc.perform(post("/put").contentType(MediaType.APPLICATION_JSON).content(JSONObject
                .toJSONString(map)))
                .andExpect(status().isOk())// 模拟向testRest发送get请求
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))// 预期返回值的媒体类型text/plain;
                // charset=UTF-8
                .andReturn();// 返回执行请求的结果

        System.out.println(result.getResponse().getContentAsString());

        MvcResult result1 = mockMvc.perform(post("/able").param("id", result.getResponse().getContentAsString()))
                .andExpect(status().isOk())// 模拟向testRest发送get请求
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))// 预期返回值的媒体类型text/plain;
                // charset=UTF-8
                .andReturn();// 返回执行请求的结果

        System.out.println(result1.getResponse().getContentAsString());
    }



    @Test
    public void testEvit() throws Exception {
        MvcResult result1 = mockMvc.perform(post("/able").param("id", "2"))
                .andExpect(status().isOk())// 模拟向testRest发送get请求
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))// 预期返回值的媒体类型text/plain;
                // charset=UTF-8
                .andReturn();// 返回执行请求的结果
        System.out.println(result1.getResponse().getContentAsString());

        MvcResult result2 = mockMvc.perform(post("/evit").param("id", "2"))
                .andExpect(status().isOk())// 模拟向testRest发送get请求
                .andReturn();// 返回执行请求的结果
        System.out.println(result2.getResponse().getContentAsString());

        MvcResult result3 = mockMvc.perform(post("/able").param("id", "2"))
                .andExpect(status().isOk())// 模拟向testRest发送get请求
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))// 预期返回值的媒体类型text/plain;
                // charset=UTF-8
                .andReturn();// 返回执行请求的结果
        System.out.println(result3.getResponse().getContentAsString());
    }


}
