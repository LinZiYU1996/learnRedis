package com.lin.publish_subscribe_demo.redis;

import com.lin.publish_subscribe_demo.entity.RedisPet;
import com.lin.publish_subscribe_demo.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/1
 * \* Time: 15:38
 * \* Description:
 * \
 */

@Service
@Slf4j
public class RedisDataOperation {

    @Autowired
    private PetRepository petRepo;

    @PostConstruct
    public void start() {

        RedisPet pet1 = new RedisPet("Polly", "Bird");
        RedisPet pet2 = new RedisPet("Tom", "Cat");

        //写入宠物信息
        petRepo.add(pet1);
        petRepo.add(pet2);

        //打印宠物信息
        log.info("polly {}", JsonUtil.toJson(petRepo.find("Polly")));
        log.info("pets  {}", JsonUtil.toJson(petRepo.findAll()));

        //清空
        petRepo.clear();
    }

    @Repository
    public static class PetRepository {

        private static final String KEY = "Pets";

        @Autowired
        private RedisTemplate<String, Object> redisTemplate;
        private HashOperations<String, String, Object> hashOperations;

        @PostConstruct
        private void init() {
            hashOperations = redisTemplate.opsForHash();
        }

        /**
         * 添加宠物
         *
         * @param pet
         */
        public void add(RedisPet pet) {
            hashOperations.put(KEY, pet.getName(), pet);
        }

        /**
         * 查找宠物
         *
         * @param name
         * @return
         */
        public RedisPet find(String name) {
            return (RedisPet) hashOperations.get(KEY, name);
        }

        public Map<String, Object> findAll() {
            return hashOperations.entries(KEY);
        }

        public void clear() {
            hashOperations.getOperations().delete(KEY);
        }
    }

}
