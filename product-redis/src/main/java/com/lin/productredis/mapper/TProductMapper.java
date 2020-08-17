package com.lin.productredis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lin.productredis.entity.TProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
public interface TProductMapper extends BaseMapper<TProduct> {


    public void decreaseProduct(@Param("id") Integer id, @Param("quantity") int quantity);

    public int decreaseProductOptimistic(@Param("id") Integer id,
                                          @Param("quantity") int quantity,
    @Param("version") int version);


}
