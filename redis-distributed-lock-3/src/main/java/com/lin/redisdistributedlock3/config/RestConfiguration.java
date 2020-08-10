package com.lin.redisdistributedlock3.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/9
 * \* Time: 15:55
 * \* Description:
 * \
 */
@Configuration
public class RestConfiguration {

    @Autowired
    private RedisTemplate redisTemplate;

    @Bean
    public RedisTemplate redisKeyValueSerializer() {
        //redis key和value值序列化，不序列话发现查到的key和value乱码
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return redisTemplate;
    }
}
