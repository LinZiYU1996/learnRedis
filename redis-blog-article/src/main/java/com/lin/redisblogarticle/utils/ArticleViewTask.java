package com.lin.redisblogarticle.utils;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/12
 * \* Time: 17:03
 * \* Description:
 * \
 */

import com.lin.redisblogarticle.entity.Article;
import com.lin.redisblogarticle.service.IArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

//
//* Description: 定时将缓存的访问量更新到数据库
//        * Version： V1.0
//        */
@Component
@Slf4j
public class ArticleViewTask {

    @Resource
    private RedisUtils redisUtil;
    @Resource
    IArticleService articleService;

//示例
//每隔5秒执行一次：*/5 * * * * ?
//
//每隔1分钟执行一次：0 */1 * * * ?
//
//每天23点执行一次：0 0 23 * * ?
//
//每天凌晨1点执行一次：0 0 1 * * ?
//
//每月1号凌晨1点执行一次：0 0 1 1 * ?
//
//每月最后一天23点执行一次：0 0 23 L * ?
//
//每周星期六凌晨1点实行一次：0 0 1 ? * L
//
//在26分、29分、33分执行一次：0 26,29,33 * * * ?
//
//每天的0点、13点、18点、21点都执行一次：0 0 0,13,18,21 * * ?
//


    @Scheduled(cron = "0 */1 * * * ? ")
    @Transactional(rollbackFor=Exception.class)
    public void createHyperLog() {
        log.info("浏览量入库开始");

        List<Long> list = articleService.getAllArticleId();
        log.info(list.toString());
        list.forEach(articleId ->{
            // 获取每一篇文章在redis中的浏览量，存入到数据库中
            String key  = "articleId_"+articleId;
            Long view = redisUtil.size(key);
            if(view>0){
                Article articleDO = articleService.getById(articleId);
                Long views = view + articleDO.getViews();
                articleDO.setViews(views);
                int num = articleService.updateArticleById(articleDO);
                if (num != 0) {
                    log.info("数据库更新后的浏览量为：{}", views);
                    redisUtil.del(key);
                }
            }
        });
        log.info("浏览量入库结束");
    }

}