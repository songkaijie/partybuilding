package com.changfa.frame.data.repository.article;

import com.changfa.frame.data.entity.article.CmsArticleData;
import com.changfa.frame.data.repository.AdvancedJpaRepository;

public interface CmsArticleDateRepository extends AdvancedJpaRepository<CmsArticleData, Integer> {

    CmsArticleData findByArticleId(Integer articleId);
}
