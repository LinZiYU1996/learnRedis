package com.lin.redisblogarticle;

import com.lin.redisblogarticle.mapper.ArticleMapper;
import com.lin.redisblogarticle.service.IArticleService;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/12
 * \* Time: 17:25
 * \* Description:
 * \
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class Test {


    @Autowired
    private ArticleMapper articleMapper;


    @Autowired
    IArticleService articleService;


    @org.junit.Test
    public void t1() {
        List<Long> list = articleService.getAllArticleId();
        log.info(list.toString());
    }
}
