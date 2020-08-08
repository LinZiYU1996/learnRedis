package com.lin.mbp_redis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.lin.mbp_redis.entity.Person;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
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
@Mapper
public interface PersonMapper extends BaseMapper<Person> {

//    int deleteByPrimaryKey(Long id);
//
//    int insert(Person record);
//
//    int insertSelective(Person record);
//
//    Person selectByPrimaryKey(Long id);
//
//    int updateByPrimaryKeySelective(Person record);
//
//    int updateByPrimaryKey(Person record);

    /**
     * 获取所有数据
     * @return
     */
    List<Person> findAll();





}
