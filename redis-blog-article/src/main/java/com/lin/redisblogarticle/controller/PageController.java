package com.lin.redisblogarticle.controller;

import com.lin.redisblogarticle.annotation.PageView;
import com.lin.redisblogarticle.entity.Article;
import com.lin.redisblogarticle.service.IArticleService;
import com.lin.redisblogarticle.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/12
 * \* Time: 16:46
 * \* Description:
 * \
 */
@RestController
@Slf4j
public class PageController {

    @Autowired
    private IArticleService articleService;

    @Autowired
    private RedisUtils redisUtil;

    /**
     * 访问一篇文章时，增加其浏览量:重点在的注解
     * @param articleId：文章id
     * @return
     */
    @PageView
    @RequestMapping("/{articleId}")
    public String getArticle(@PathVariable("articleId") Long articleId) {
        try{
            Article blog = articleService.getById(articleId);
            log.info("articleId = {}", articleId);
            String key = "articleId_"+articleId;
            Long view = redisUtil.size(key);
            log.info("redis 缓存中浏览数：{}", view);
            //直接从缓存中获取并与之前的数量相加
            Long views = view + blog.getViews();
            log.info("文章总浏览数：{}", views);
        } catch (Throwable e) {
            return  "error";
        }
        return  "success";
    }
}