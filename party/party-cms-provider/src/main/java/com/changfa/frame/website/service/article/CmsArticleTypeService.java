package com.changfa.frame.website.service.article;


import com.changfa.frame.data.entity.article.CmsArticleType;
import com.changfa.frame.data.repository.article.CmsArticleTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CmsArticleTypeService {

    private static Logger log = LoggerFactory.getLogger(CmsArticleType.class);

    @Autowired
    private CmsArticleTypeRepository cmsArticleTypeRepository;

    public CmsArticleType findById(Integer id) {
        return cmsArticleTypeRepository.findOne(id);
    }
}
