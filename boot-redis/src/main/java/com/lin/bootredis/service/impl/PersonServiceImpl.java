package com.lin.bootredis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.lin.bootredis.entity.Person;
import com.lin.bootredis.mapper.PersonMapper;
import com.lin.bootredis.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
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
@CacheConfig(cacheNames = "person")
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements IPersonService {

    @Autowired
    private PersonMapper personMapper;


    @Override
//    @Cacheable(value="persons",key="'userLists'")
    public List<Person> findAll() {
        return personMapper.findAll();
    }


    @Override
    @Cacheable(key = "#id")
    public Person getPersonByID(Long id) {
        return personMapper.selectById(id);
    }

    @Override
    @CachePut(key = "#person.id")
    public Person updatePerosn(Person person){

        Person new_person = getPersonByID(person.getId());
        new_person.setAddress(person.getAddress());
        new_person.setName(person.getName());
        new_person.setAge(person.getAge());
        personMapper.updateById(new_person);
        return new_person;


    }

    @Override
    @Transactional
    public void insert(Person person) {
        personMapper.insert(person);
    }

    @Override
    @CacheEvict(key = "#id")
    public void deleteById(Long id) {
        personMapper.deleteById(id);

    }
}
