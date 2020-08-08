package com.lin.mbp_redis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.lin.mbp_redis.entity.Person;
import com.lin.mbp_redis.mapper.PersonMapper;
import com.lin.mbp_redis.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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
//    @Cacheable(value="persons",key="'userLists'")
    public List<Person> findAll() {
        return personMapper.findAll();
    }


    @Override
    @Cacheable(value = "ps", key = "'singleP'")
    public Person getPerson(Long id) {
        return personMapper.selectById(id);
    }

    @Override
    @Transactional
    public void insert(Person person) {
        personMapper.insert(person);
    }
}
