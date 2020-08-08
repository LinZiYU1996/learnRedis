package com.lin.mbp_redis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lin.mbp_redis.entity.Person;


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
    List<Person> findAll();



    void insert(Person person);


    Person getPerson(Long id);
}
