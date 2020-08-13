package com.lin.redisblogarticle.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lin.redisblogarticle.entity.Article;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Lin
 * @since 2020-08-12
 */
public interface IArticleService extends IService<Article> {


    /**
     * 获取某篇文章
     * @param id
     * @return
     */
    Article getById(Long id);

    /**
     * 获取全部文章的id
     * @return
     */
    List<Long> getAllArticleId();


    /**
     * 更新某篇文章的浏览量
     * @param articleDO
     * @return
     */
    int updateArticleById(Article articleDO);



}
