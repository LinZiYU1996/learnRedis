package com.lin.publish_subscribe_demo.redis;

import com.lin.publish_subscribe_demo.entity.RedisPet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/1
 * \* Time: 15:34
 * \* Description:
 * \
 */

// 方法级缓存样例
@Service
@Slf4j
public class RedisCacheOperation {

    public static final String PREFIX = "pets:";
    public static final String WRAP_PREFIX = "'pets:'";


    /**
     * 当结果不为空时缓存
     */
    @Cacheable(value = "petCache", key = WRAP_PREFIX + "+#name", unless = "#result==null")
    public RedisPet getPet(String name) {
        log.info("get pet {}", name);
        return new RedisPet(name, "Bird");
    }


    /**
     * 当结果不为空时淘汰缓存
     */
    @CacheEvict(value = "petCache", key = WRAP_PREFIX + "+#pet.name", condition = "#result!=null")
    public RedisPet updatePet(RedisPet pet) {
        log.info("update pet {}", pet.getName());
        return new RedisPet(pet.getName(), "Bird1");
    }

    /**
     * 当结果为true时淘汰缓存
     */
    @CacheEvict(value = "petCache", key = WRAP_PREFIX + "+#name", condition = "#result==true")
    public boolean deletePet(String name) {
        log.info("delete pet {}", name);
        return true;
    }

}
