package com.lin.redisblogarticle.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lin.redisblogarticle.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Lin
 * @since 2020-08-12
 */

@Mapper
@Repository
public interface ArticleMapper extends BaseMapper<Article> {

    List<Long> getAllArticleId();




}
