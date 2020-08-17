package com.lin.learnaop.demo_3.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lin.learnaop.demo_3.entity.Person;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Lin
 * @since 2020-08-16
 */

@Mapper
@Repository
public interface PersonMapper extends BaseMapper<Person> {

}
