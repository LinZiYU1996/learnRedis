package com.lin.productredis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lin.productredis.entity.TPurchaseRecord;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Lin
 * @since 2020-08-16
 */
public interface ITPurchaseRecordService extends IService<TPurchaseRecord> {


    boolean purchase(Integer userId, Integer productId, int quantity);

    boolean purchaseOptimstic(Integer userId, Integer productId, int quantity);
}
