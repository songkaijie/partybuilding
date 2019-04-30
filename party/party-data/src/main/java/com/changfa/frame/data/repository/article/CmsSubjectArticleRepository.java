package com.changfa.frame.data.repository.article;

import com.changfa.frame.data.entity.article.CmsSubjectArticle;
import com.changfa.frame.data.repository.AdvancedJpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CmsSubjectArticleRepository extends AdvancedJpaRepository<CmsSubjectArticle, Integer> {


    List<CmsSubjectArticle> findBySubjectId(Integer subjectId);


    @Query(value = "select * from cms_subject_article where subject_id = ?1 limit 1", nativeQuery = true)
    CmsSubjectArticle findBySubjectIdLimitOne(Integer subjectId);

    CmsSubjectArticle findOne(Integer id);
}
