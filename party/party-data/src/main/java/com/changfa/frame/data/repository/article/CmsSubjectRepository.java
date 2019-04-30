package com.changfa.frame.data.repository.article;

import com.changfa.frame.data.entity.article.CmsSubject;
import com.changfa.frame.data.repository.AdvancedJpaRepository;

import java.util.List;

public interface CmsSubjectRepository extends AdvancedJpaRepository<CmsSubject, Integer> {

    List<CmsSubject> findByCategoryId(Integer categoryId);
}
