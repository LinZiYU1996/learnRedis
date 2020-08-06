package com.lin.test_jmeter.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.lin.test_jmeter.entity.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Lin
 * @since 2020-08-04
 */

@Repository
public interface PersonMapper extends BaseMapper<Person> {

    int deleteByPrimaryKey(Long id);

    int insert(Person record);

    int insertSelective(Person record);

    Person selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Person record);

    int updateByPrimaryKey(Person record);

    /**
     * 获取所有数据
     * @return
     */
    List<Person> findAll();

    /**
     * 分页查询数据
     * @return
     */
//    Page<Person> findByPage();



}
