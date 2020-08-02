//package com.lin.publish_subscribe_demo.redis;
//
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.cache.interceptor.KeyGenerator;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.RedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//import java.lang.reflect.Method;
//
///**
// * \* Created with IntelliJ IDEA.
// * \* User: LinZiYu
// * \* Date: 2020/8/1
// * \* Time: 15:48
// * \* Description:
// * \
// */
//@EnableCaching
//@Configuration
//@Slf4j
//public class RedisConfig {
//
//    /**
//     * 缓存管理，支持方法级注解
//     */
//    @Bean
//    public RedisCacheManager cacheManager(RedisTemplate<String, Object> template) {
//        RedisCacheManager redisCacheManager = new RedisCacheManager(template);
//        // 默认过期时间
//        redisCacheManager.setDefaultExpiration(30 * 60 * 1000);
//        return redisCacheManager;
//    }
//
//    /**序列化定制
//     *
//     */
//
//    @Bean
//    public Jackson2JsonRedisSerializer<Object> jackson2JsonSerializer() {
//        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(
//                Object.class);
//
//        // 初始化objectmapper
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(mapper);
//        return jackson2JsonRedisSerializer;
//    }
//
//    /**
//     *  操作模板
//     */
//    @Bean
//    public RedisTemplate<String, Object> redisTemplate(JedisConnectionFactory connectionFactory,
//                                                       Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer) {
//
//        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
//        template.setConnectionFactory(connectionFactory);
//
//        // 设置key/hashkey序列化
//        RedisSerializer<String> stringSerializer = new StringRedisSerializer();
//        template.setKeySerializer(stringSerializer);
//        template.setHashKeySerializer(stringSerializer);
//
//        // 设置值序列化
//        template.setValueSerializer(jackson2JsonRedisSerializer);
//        template.setHashValueSerializer(jackson2JsonRedisSerializer);
//        template.afterPropertiesSet();
//
//        return template;
//    }
//
//
//    /**
//     * 定制方法缓存的key生成策略
//     */
//
//    @Bean
//    public KeyGenerator keyGenerator() {
//        return new KeyGenerator() {
//            @Override
//            public Object generate(Object target, Method method, Object... args) {
//                StringBuilder sb = new StringBuilder();
//                sb.append(target.getClass().getName());
//                sb.append(method.getName());
//
//                for (Object arg : args) {
//                    sb.append(arg.toString());
//                }
//                return sb.toString();
//            }
//        };
//    }
//
//
//}
