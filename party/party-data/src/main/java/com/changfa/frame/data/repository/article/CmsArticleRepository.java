package com.changfa.frame.data.repository.article;

import com.changfa.frame.data.entity.article.CmsArticle;
import com.changfa.frame.data.repository.AdvancedJpaRepository;

import java.util.List;

public interface CmsArticleRepository extends AdvancedJpaRepository<CmsArticle, Integer> {

    List<CmsArticle> findByCategoryId(Integer categoryId);

    CmsArticle findOne(Integer id);
}
