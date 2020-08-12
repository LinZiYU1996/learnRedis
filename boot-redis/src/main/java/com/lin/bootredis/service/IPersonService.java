package com.lin.bootredis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lin.bootredis.entity.Person;

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


    Person getPersonByID(Long id);

    public Person updatePerosn(Person person);

    void deleteById(Long id);
}

