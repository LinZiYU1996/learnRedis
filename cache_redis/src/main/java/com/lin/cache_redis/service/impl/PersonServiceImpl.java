package com.lin.cache_redis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.lin.cache_redis.entity.Person;
import com.lin.cache_redis.mapper.PersonMapper;
import com.lin.cache_redis.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lin
 * @since 2020-08-04
 */
@Service
@Transactional(readOnly = true)
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements IPersonService {

    @Autowired
    private PersonMapper personMapper;


    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    @CachePut(value = "people", key = "#person.id")
    public void saves(Person person) {
        int p = personMapper.insert(person);
        System.out.println("为id、key为:" + person.getId() + "数据做了缓存");
//        return person;
    }

    @Override
    @CacheEvict(value = "people")//2
    public void remove(Long id) {
        System.out.println("删除了id、key为" + id + "的数据缓存");
        //这里不做实际删除操作
    }

    @Override
    @Cacheable(value = "people#${select.cache.timeout:1800}#${select.cache.refresh:600}", key = "#person.id", sync = true)

    public Person findOne(Person person, String a, String[] b, List<Long> c) {
        Person p = personMapper.selectById(person.getId());
        System.out.println("为id、key为:" + p.getId() + "数据做了缓存");
        System.out.println(redisTemplate);
        return p;
    }


    /**
     * Cacheable
     * value：缓存key的前缀。
     * key：缓存key的后缀。
     * sync：设置如果缓存过期是不是只放一个请求去请求数据库，其他请求阻塞，默认是false。
     */
    @Override
    @Cacheable(value = "people#120#120")//3
    public Person findOne1(Person person, String a, String[] b, List<Long> c) {
        Person p = personMapper.selectById(2L);
        System.out.println("为id、key为:" + p.getId() + "数据做了缓存");
        return p;
    }

    @Override
    @Cacheable(value = "people2")//3
    public Person findOne2(Person person) {
        Person p = personMapper.selectById(person.getId());
        System.out.println("为id、key为:" + p.getId() + "数据做了缓存");
        return p;
    }
}
