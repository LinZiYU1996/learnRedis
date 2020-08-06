package com.lin.test_jmeter.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lin.test_jmeter.entity.Person;


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
}
