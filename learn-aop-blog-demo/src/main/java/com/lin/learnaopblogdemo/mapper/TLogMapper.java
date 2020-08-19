package com.lin.learnaopblogdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lin.learnaopblogdemo.entity.TLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Lin
 * @since 2020-08-18
 */

@Mapper
@Repository
public interface TLogMapper extends BaseMapper<TLog> {

}
