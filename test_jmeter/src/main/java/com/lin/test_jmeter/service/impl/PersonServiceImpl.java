package com.lin.test_jmeter.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.lin.test_jmeter.entity.Person;
import com.lin.test_jmeter.mapper.PersonMapper;
import com.lin.test_jmeter.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public List<Person> findAll() {
        return personMapper.findAll();
    }


    @Override
    @Transactional
    public void insert(Person person) {
        personMapper.insert(person);
    }
}
