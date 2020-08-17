package com.lin.productredis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lin.productredis.entity.TPurchaseRecord;
import org.apache.ibatis.annotations.Mapper;
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
public interface TPurchaseRecordMapper extends BaseMapper<TPurchaseRecord> {

}
