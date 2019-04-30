package com.changfa.frame.data.repository.article;

import com.changfa.frame.data.entity.article.CmsArticleData;
import com.changfa.frame.data.entity.article.CmsSubjectArticleData;
import com.changfa.frame.data.repository.AdvancedJpaRepository;

public interface CmsSubjectArticleDataRepository extends AdvancedJpaRepository<CmsSubjectArticleData, Integer> {

    CmsSubjectArticleData findBySubjectArticleId(Integer subjectArticleId);

}
