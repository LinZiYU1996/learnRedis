//package com.lin.redisblogarticle.utils;
//
//import com.lin.redisblogarticle.entity.Article;
//import com.lin.redisblogarticle.service.IArticleService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.annotation.Resource;
//import java.util.List;
//
///**
// * \* Created with IntelliJ IDEA.
// * \* User: LinZiYu
// * \* Date: 2020/8/12
// * \* Time: 16:46
// * \* Description:
// * \
// */
//@Component
//@Slf4j
//public class ArticleViewTask {
//
//    @Resource
//    private RedisUtils redisUtil;
//    @Resource
//    IArticleService articleService;
//
//    // 每天凌晨一点执行
//    @Scheduled(cron = "0 0 1 * * ? ")
//    @Transactional(rollbackFor=Exception.class)
//    public void createHyperLog() {
//        log.info("浏览量入库开始");
//
//        List<Long> list = articleService.getAllArticleId();
//        list.forEach(articleId ->{
//            // 获取每一篇文章在redis中的浏览量，存入到数据库中
//            String key  = "articleId_"+articleId;
//            Long view = redisUtil.size(key);
//            if(view>0){
//                Article articleDO = articleService.getById(articleId);
//                Long views = view + articleDO.getViews();
//                articleDO.setViews(views);
//                int num = articleService.updateArticleById(articleDO);
//                if (num != 0) {
//                    log.info("数据库更新后的浏览量为：{}", views);
//                    redisUtil.del(key);
//                }
//            }
//        });
//        log.info("浏览量入库结束");
//    }
//
//}
