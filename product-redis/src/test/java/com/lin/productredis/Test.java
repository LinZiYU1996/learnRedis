package com.lin.productredis;

import com.lin.productredis.entity.TProduct;
import com.lin.productredis.mapper.TProductMapper;
import com.lin.productredis.service.ITPurchaseRecordService;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/16
 * \* Time: 20:11
 * \* Description:
 * \
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class Test {

    @Autowired
    private TProductMapper productMapper;

    @Autowired
    private ITPurchaseRecordService purchaseRecordService;
    @org.junit.Test
    public void t1() {

        TProduct tProduct = new TProduct();

        tProduct.setNote("a");

        BigDecimal b = new BigDecimal(100);
        tProduct.setPrice(b);

        tProduct.setProductName("牛肉");

        tProduct.setVersion(1);

        tProduct.setStock(100);

        productMapper.insert(tProduct);



    }

    @org.junit.Test
    public void t2() {

        purchaseRecordService.purchase(1,1,10);



    }



    }
