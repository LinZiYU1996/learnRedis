package com.lin.productredis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.lin.productredis.entity.TProduct;
import com.lin.productredis.entity.TPurchaseRecord;
import com.lin.productredis.mapper.TProductMapper;
import com.lin.productredis.mapper.TPurchaseRecordMapper;
import com.lin.productredis.service.ITPurchaseRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lin
 * @since 2020-08-16
 */
@Service
public class TPurchaseRecordServiceImpl extends ServiceImpl<TPurchaseRecordMapper, TPurchaseRecord> implements ITPurchaseRecordService {

    @Autowired
    private TProductMapper productMapper;


    @Autowired
    private  TPurchaseRecordMapper purchaseRecordMapper;

    @Override
    public boolean purchase(Integer userId, Integer productId, int quantity) {

        TProduct product = productMapper.selectById(productId);

        if (product.getStock() < quantity) {
            return false;
        }

        productMapper.decreaseProduct(productId, quantity);

        TPurchaseRecord purchaseRecord = this.init(userId, product, quantity);

        purchaseRecordMapper.insert(purchaseRecord);

        return true;

    }


    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public boolean purchaseOptimstic(Integer userId, Integer productId, int quantity) {
        TProduct product = productMapper.selectById(productId);
        if (product.getStock() < quantity) {
            return false;
        }
        int version = product.getVersion();

        int res = productMapper.decreaseProductOptimistic(productId, quantity, version);

        if (res == 0) {
            return false;
        }

        TPurchaseRecord purchaseRecord = this.init(userId, product, quantity);

        purchaseRecordMapper.insert(purchaseRecord);

        return true;



    }

    private TPurchaseRecord init(Integer userId, TProduct product, int quantity) {

        TPurchaseRecord pr = new TPurchaseRecord();

        pr.setNote("购买时间" + System.currentTimeMillis());

        pr.setPrice(product.getPrice());

        pr.setProductId(product.getId());

        pr.setQuantity(quantity);

        BigDecimal tt = new BigDecimal(String.valueOf(quantity));
        BigDecimal sum = product.getPrice().multiply(tt);

        pr.setSum(sum);

        pr.setUserId(userId);

        return pr;


    }
}
