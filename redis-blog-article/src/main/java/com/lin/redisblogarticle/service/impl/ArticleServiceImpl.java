package com.lin.redisblogarticle.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.lin.redisblogarticle.entity.Article;
import com.lin.redisblogarticle.mapper.ArticleMapper;
import com.lin.redisblogarticle.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lin
 * @since 2020-08-12
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public Article getById(Long id) {
        return articleMapper.selectById(id);
    }

    @Override
    public List<Long> getAllArticleId() {
        return null;
    }

    @Override
    public int updateArticleById(Article articleDO) {
        return articleMapper.updateById(articleDO);
    }
}
