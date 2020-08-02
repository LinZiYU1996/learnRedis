//package com.lin.affairs_demo;
//
//import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.StringRedisTemplate;
//
///**
// * \* Created with IntelliJ IDEA.
// * \* User: LinZiYu
// * \* Date: 2020/8/1
// * \* Time: 19:37
// * \* Description:
// * \
// */
//
//@Configuration
//@EnableConfigurationProperties({RedisProperties.class})
//public class RedisConfig {
//
//    /**
//     * 实例化 RedisTemplate 对象
//     *
//     * @return
//     */
//    @Bean
//    public StringRedisTemplate customStringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
//        StringRedisTemplate template = new StringRedisTemplate();
//        template.setConnectionFactory(redisConnectionFactory);
//        template.setEnableTransactionSupport(true);
//        return template;
//    }
//
//
//}
