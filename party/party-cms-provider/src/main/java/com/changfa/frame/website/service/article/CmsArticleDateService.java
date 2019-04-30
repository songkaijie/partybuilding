package com.changfa.frame.website.service.article;


import com.changfa.frame.data.repository.article.CmsArticleDateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CmsArticleDateService {

    private static Logger log = LoggerFactory.getLogger(CmsArticleDateService.class);

    @Autowired
    private CmsArticleDateRepository cmsArticleDateRepository;
}
