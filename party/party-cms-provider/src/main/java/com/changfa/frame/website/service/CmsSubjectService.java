package com.changfa.frame.website.service;


import com.changfa.frame.data.entity.article.CmsSubject;
import com.changfa.frame.data.repository.article.CmsSubjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CmsSubjectService {

    private static Logger log = LoggerFactory.getLogger(CmsSubjectService.class);

    @Autowired
    private CmsSubjectRepository cmsSubjectRepository;

    public List<CmsSubject> findCmsSubjectByCategoryId(Integer categoryId) {
        return cmsSubjectRepository.findByCategoryId(categoryId);
    }
}
