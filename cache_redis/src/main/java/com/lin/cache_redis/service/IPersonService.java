package com.lin.cache_redis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lin.cache_redis.entity.Person;


import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Lin
 * @since 2020-08-04
 */
public interface IPersonService extends IService<Person> {

    void saves(Person person);

    void remove(Long id);

    Person findOne(Person person, String a, String[] b, List<Long> c);

    Person findOne1(Person person, String a, String[] b, List<Long> c);

    Person findOne2(Person person);
}
