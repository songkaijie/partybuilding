package com.changfa.frame.website.service.article;

import com.changfa.frame.data.entity.article.CmsSubjectArticle;
import com.changfa.frame.data.repository.article.CmsSubjectArticleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CmsSubjectArticleService {

    private static Logger log = LoggerFactory.getLogger(CmsSubjectArticleService.class);

    @Autowired
    private CmsSubjectArticleRepository cmsSubjectArticleRepository;


    public List<CmsSubjectArticle> findCmsSubjectArticleBySubjectId(Integer subjectId) {
        return cmsSubjectArticleRepository.findBySubjectId(subjectId);
    }

    public CmsSubjectArticle findCmsSubjectArticleById(Integer subjectArticleId) {
        return cmsSubjectArticleRepository.findOne(subjectArticleId);
    }

}
